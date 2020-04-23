package SearchAndOrder;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;


public class SearchAndOrderPage {

    // Driver declaration
    private static WebDriver driver;
    public String orderNumber;

    // Method constructor with PageFactory initialization
    public SearchAndOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "product-description")
    List<WebElement> productsFound;

    @FindBy(xpath = "//span[@class = 'discount discount-percentage']")
    WebElement discountInfo;

    @FindBy(name = "s")
    WebElement searchInput;

    @FindBy(id = "group_1")
    WebElement sizeInput;

    @FindBy(name = "qty")
    WebElement quantityInput;

    @FindBy(xpath = "//button[@data-button-action = 'add-to-cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@class = 'btn btn-primary']")
    WebElement goToCheckoutButton;


    @FindBy(className = "radio-block")
    List<WebElement> addressList;

    @FindBy(xpath = "//div[@class = 'row delivery-option']")
    List<WebElement> shippingMethodList;

    @FindBy(name = "confirm-addresses")
    WebElement addressConfirm;

    @FindBy(name = "confirmDeliveryOption")
    WebElement deliveryConfirm;

    @FindBy(id = "payment-option-1")
    WebElement paymentOption;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement conditionsTerms;

    @FindBy(xpath = "//button[@class='btn btn-primary center-block']")
    WebElement orderConfirm;

    @FindBy(xpath = "//h3[@class = 'h1 card-title']")
    WebElement orderSuccessMessage;

    @FindBy(xpath = "//div[@id='order-details']/ul/li[contains(text(),'Order reference')]")
    WebElement orderDetails;

    @FindBy(id = "history-link")
    WebElement orderHistoryAndDetails;

    // Look for the product with the values given
    public void searchProduct(String productName) {
        searchInput.sendKeys(productName);
        searchInput.submit();
    }

    // Choose demanded product
    public void productChoose(String productElementName) {

        // Iterate through found products
        for (int i = 0; i < productsFound.size(); i++) {

            //Get information about every product
            WebElement productFound = productsFound.get(i);
            String productFoundText = productFound.getText();

            // Compare product name with the one delivered
            if (productFoundText.contains(productElementName)) {
                productFound.click();
                break;
            }
        }

        //Check whether discount is added and print proper message
        if (discountInfo.isDisplayed()){
            System.out.println("Discount added");
        }
        else {
            System.out.println("No such discount");
        }


    }

    // Select proper size
    public void sizeSelection(String size){
        Select getSize = new Select(sizeInput);
        getSize.selectByVisibleText(size);
    }

    // Insert quantity
    public void quantitySelection(String quantity){
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    // Add product to cart
    public void addToCart(){
        addToCartButton.click();
    }

    // Go instantly to checkout
    public void goToCheckout(){
        goToCheckoutButton.click();
    }

    // Choose address from Alias
    public void addressChoose(String addressAlias) {

        // Iterate through displayed addresses
        for (int i = 0; i < addressList.size(); i++) {

            // Get information about address in the iteration
            WebElement addressFound = addressList.get(i);
            String addressFoundText = addressFound.getText();

            // Compare Alias in the address iterated with the one delivered
            if (addressFoundText.contains(addressAlias)) {
                addressFound.click();
                break;
            }
        }
        addressConfirm.click();
    }

    // Choose shipping method
    public void shippingMethodChoose(String shippingMethod){

        // Iterate through displayed shipping methods
        for (int i = 0; i < shippingMethodList.size(); i++) {

            // Take information about iterated element
            WebElement shippingMethodRadio = shippingMethodList.get(i);
            String shippingMethodText = shippingMethodRadio.getText();

            //Compare element with the one delivered
            if (shippingMethodText.contains(shippingMethod)) {
                shippingMethodRadio.click();
                break;
            }
        }
        deliveryConfirm.click();
    }

    // Choose payment option
    public void paymentChoose(){
        paymentOption.click();

        // Check is the terms and conditions are selected  - if no - click
        if(!conditionsTerms.isSelected()){
            conditionsTerms.click();
        }
    }

    // Confirm order
    public void orderConfirmation(){
        orderConfirm.click();
    }

    // Get order success message
    public String getOrderSuccessMessage(){
        return orderSuccessMessage.getText();
    }

    // Make a screenshot
    public void screenshotMake() throws Exception {

        //Method to make a screenshot
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        // Save to the location
        FileUtils.copyFile(scrFile, new File("/home/wojtekk/Obrazy/orderConfirmedImage.png"));

    }

    // Get order number
    public void getOrderNumber(){

        //Get text from order details element
        String orderDetailsText = orderDetails.getText();

        // Substring from delivered text to leave only order number
        orderNumber = StringUtils.remove(orderDetailsText,"Order reference: ");
    }


    // Click order history and details
    public void clickOrderHistoryAndDetails(){
        orderHistoryAndDetails.click();
    }

    // Validate order number status
    public String validateOrderNumber (){

        //  List available orders
        List<WebElement> orderHeaderList = driver.findElements(By.xpath("//tr"));

        // Create String with orderheader
        String orderHeaderText = "";

        //Iterate through listed orders;

        for(int i = 0; i < orderHeaderList.size(); i++){

            // Get information about listed element
            WebElement orderHeader = orderHeaderList.get(i);
            orderHeaderText = orderHeader.getText();

            // Check if the listed elementn contains ordernumber from last order
            // if so - break iteration with remembered header;
            if(orderHeaderText.contains(orderNumber)){
                break;
            }
        }

        return orderHeaderText;

    }

}


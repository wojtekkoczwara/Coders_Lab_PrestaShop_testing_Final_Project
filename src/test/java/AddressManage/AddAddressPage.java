package AddressManage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddAddressPage {

    // Driver declaration;
    private static WebDriver driver;

    @FindBy(id = "addresses-link")
    WebElement addressButton;

    @FindBy(name = "alias")
    WebElement aliasInput;

    @FindBy(name = "company")
    WebElement companyInput;

    @FindBy(name = "address1")
    WebElement addressInput;

    @FindBy(name = "postcode")
    WebElement postCodeinput;

    @FindBy(name = "city")
    WebElement cityinput;

    @FindBy(name = "phone")
    WebElement phoneInput;

    @FindBy(css = ".btn.btn-primary.float-xs-right")
    WebElement submitButton;

    @FindBy(xpath = "//article[@role = 'alert']")
    WebElement successInformation;

    @FindBy(name = "id_country")
    WebElement selectCountry;

    @FindBy(xpath = "//a[@title = 'View my customer account']")
    WebElement customerPage;

    /*
        tutaj cos dzwinego z tym selectorem jest, z add-address.feature nie dzialalo - BB
        a dlaczego ma działać z add address.feature? to tylko odniesienie do konkretnego elementu na stronie :) - WK
         */
    @FindBy(xpath = "//a[@data-link-action = 'add-address']")
    WebElement createAddressButton;

    // Method constructor with PageFactory initialization
    public AddAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Click address button in the account
    public void clickAddress(){
        addressButton.click();
    }

    // Click new address creation
    public void clickNewAddress(){
        createAddressButton.click();
    }

    // Click user account
    public void clickUserAccount() {
        customerPage.click();
    }


//    // Insert alias to the proper field
//    public void typeAlias(String alias){
//        operationOnAddressField(aliasInput, alias);
//    }
//
//    // Insert company to the proper field
//    public void typeCompany(String company){
//        operationOnAddressField(companyInput, company);
//    }
//
//    // Insert address to the proper field
//    public void typeAddress(String address){
//        operationOnAddressField(addressInput, address);
//    }
//
//    // Insert postcode to the proper field
//    public void typePostcode(String postCode){
//        operationOnAddressField(postCodeinput, postCode);
//    }
//
//    // Insert city to the proper field
//    public void typeCity(String city){
//        operationOnAddressField(cityinput, city);
//    }
//
//    // Insert phone to the proper field
//    public void typePhone(String phone){
//        operationOnAddressField(phoneInput, phone);
//    }
    // Repeatable operations on every address field
    public void operationOnAddressField(WebElement addressField, String addressData){
        addressField.clear();
        addressField.click();
        addressField.sendKeys(addressData);
    }

    // Fulfill fields in address
    public void typeAddressData(String alias, String company, String address, String postCode, String city, String phone){
        operationOnAddressField(aliasInput, alias);
        operationOnAddressField(companyInput, company);
        operationOnAddressField(addressInput, address);
        operationOnAddressField(postCodeinput, postCode);
        operationOnAddressField(cityinput, city);
        operationOnAddressField(phoneInput, phone);
    }

    // Submit your address (confirm changes)
    public void submitAddress(){
        submitButton.click();
    }

    // Get success message
    public String getSuccessInfo(){
        return successInformation.getText();
    }

    // Select proper country
    public void chooseCountry(String country){
        Select getCountry = new Select(selectCountry);
        getCountry.selectByValue(country);
    }

    //Adress assertion preparation
    public String findCreatedAddress(String alias) {
        // List available addresses
        List<WebElement> AddressesCreated = driver.findElements(By.className("address"));
        String textFromAddress = "";

        //Iterate every address
        for (int i = 0; i < AddressesCreated.size(); i++) {
            // Get text from address
            WebElement AddressFromList = AddressesCreated.get(i);
            textFromAddress = AddressFromList.getText();

            // check condition - address alias must containg given alias
            if (textFromAddress.contains(alias)) {
                break;
            }
            // Return string with full address text
        }
        return textFromAddress;
    }

    // Assertion command
    public void assertGeneral(String alias, String company, String address, String postcode, String city, String phone, String country){
        Assert.assertTrue(findCreatedAddress(alias).contains(alias));
        Assert.assertTrue(findCreatedAddress(alias).contains(company));
        Assert.assertTrue(findCreatedAddress(alias).contains(address));
        Assert.assertTrue(findCreatedAddress(alias).contains(postcode));
        Assert.assertTrue(findCreatedAddress(alias).contains(city));
        Assert.assertTrue(findCreatedAddress(alias).contains(phone));
        Assert.assertTrue(findCreatedAddress(alias).contains(country));
    }

}

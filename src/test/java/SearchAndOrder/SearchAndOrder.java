package SearchAndOrder;

import Login.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SearchAndOrder {

    private static WebDriver driver;
    private LoginPage loginPage;
    private SearchAndOrderPage searchAndOrderPage;
    private String shopWebsite = "https://prod-kurs.coderslab.pl/index.php?controller=authentication";
    private String loginEmail = "wojciechkawu@gmail.com";
    private String loginPassword = "CodersLab";

    @Given("User go to the main page and log in")
    public void userGoToTheMainPageAndLogIn() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        driver = new ChromeDriver();

        // Zmaksymalizuj okno przeglądarki
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(shopWebsite);

        // login to the page and initialize global variables of classes used in test
        loginPage = new LoginPage(driver);
        loginPage.loginAs(loginEmail, loginPassword);
        searchAndOrderPage = new SearchAndOrderPage(driver);
    }

    // insert name of the searched product
    @When("Search for the product")
    public void searchForTheProduct() {
        searchAndOrderPage.searchProduct("Hummingbird");
    }

    // choose the demanded product and check if the discount is added
    @And("Choose product and validate discount")
    public void chooseProduct() {
        searchAndOrderPage.productChoose("Hummingbird Printed Sweater");

    }


    // Select demanded size and quaintity (values delivered in cucumber script)
    @And("Choose keyword (.*) and keyword (.*)")
    public void chooseSizeAndQuantity(String size, String quantity) throws InterruptedException {
        searchAndOrderPage.sizeSelection(size);
        searchAndOrderPage.quantitySelection(quantity);
    }

    // add product to cart and go to checkout
    @And("Add to cart and go to checkout")
    public void addToCartAndGoToCheckout() throws InterruptedException {
        searchAndOrderPage.addToCart();
        searchAndOrderPage.goToCheckout();
        searchAndOrderPage.goToCheckout();
    }

    // Confirm address and go further in process
    @And("Confirm Address")
    public void confirmAddress() {
        searchAndOrderPage.addressChoose("Your teddyBear Company");
    }

    // Choose shipping method and go further in process
    @And("Choose shipping method")
    public void chooseShippingMethod() {
        searchAndOrderPage.shippingMethodChoose("Pick up in-store");
    }

    // Choose payment method and go further in process
    @And("Choose payment")
    public void choosePayment() {
        searchAndOrderPage.paymentChoose();
    }

    // Confirm order
    @And("Confirm transaction")
    public void confirmTransaction() {
        searchAndOrderPage.orderConfirmation();
    }

    // Success message is displayed (assertion) and screenshot is taken
    @Then("See success message \"([^\"]*)\" and get screenshot")
    public void seeSuccessMessage(String orderSuccessMessage) throws Exception {
        // Write code here that turns the phrase above into concrete action
        Assert.assertTrue(searchAndOrderPage.getOrderSuccessMessage().contains(orderSuccessMessage));
        searchAndOrderPage.screenshotMake();
    }

    // Validate order - take string with order number from transaction confirmation
    // and compare with the o in order history and details. Compare payment status for this transaction
    // with the one demanded
    @And("Validate order with payment status message \"([^\"]*)\"")
    public void validateOrderWithPaymentStatusMessage(String paymentStatusMessage) {
        // Get order number from the order lastly confirmed
        searchAndOrderPage.getOrderNumber();

        // Go to orders
        loginPage.clickUserAccount();
        searchAndOrderPage.clickOrderHistoryAndDetails();

        // Check last order payment status - run function validating order
        // with the number provided in getOrderNumber
        Assert.assertTrue(searchAndOrderPage.validateOrderNumber().contains(paymentStatusMessage));
    }
}

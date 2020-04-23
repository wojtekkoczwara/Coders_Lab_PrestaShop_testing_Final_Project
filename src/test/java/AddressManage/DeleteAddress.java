package AddressManage;

import Login.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class DeleteAddress {

    // create attributes with classes, that will be used
    private static WebDriver driver;
    private LoginPage loginPage;
    private DeleteAddressPage deleteAddressPage;
    private String shopWebsite = "https://prod-kurs.coderslab.pl/index.php?controller=authentication";
    private String loginEmail = "wojciechkawu@gmail.com";
    private String loginPassword = "CodersLab";

    // Login to the PrestaShop with given credentials
    @Given("User is looged In")
    public void userIsLoogedIn() {

        // Set driver
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        driver = new ChromeDriver();

        // Get full screen of browser and set max wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(shopWebsite);

        // login to the page and initialize global variables of classes used in test
        loginPage = new LoginPage(driver);
        loginPage.loginAs(loginEmail, loginPassword);
        deleteAddressPage = new DeleteAddressPage(driver);
    }

    // Go to addresses page
    @When("Go to addresses page to delete one")
    public void goToAddressesPageToDeleteOne() {
        deleteAddressPage.clickUserAccount();
        deleteAddressPage.clickAddress();
    }

    // Find address and delete chosen one
    @And("Find address keyword (.*) and click delete button")
    public void findAddressKeywordAddressAliasAndClickDeleteButton(String addressAlias) {
        deleteAddressPage.deleteAddressButton(addressAlias);
    }

    // Confirm address deletion (Assertion)
    @Then("User will see \"([^\"]*)\"")
    public void userWillSee(String deleteMessage) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(deleteMessage, deleteAddressPage.getDeleteInformation());
    }

    // End test - quit browser
    @And("Browser is closed after deletion")
    public void browserIsClosedAfterDeletion() {
        driver.quit();
    }

}

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

public class AddAddress {

    // create attributes with classes, that will be used
    private static WebDriver driver;
    private LoginPage loginPage;
    private AddAddressPage addAddressPage;
    private String shopWebsite = "https://prod-kurs.coderslab.pl/index.php?controller=authentication";
    private String loginEmail = "wojciechkawu@gmail.com";
    private String loginPassword = "CodersLab";

    // Login to the PrestaShop with given credentials
    @Given("User is logged in to PrestaShop")
    public void userIsLoggedInToPrestaShop() {

        // Set driver
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        driver = new ChromeDriver();

        // Get full screen of browser and set max wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(shopWebsite);

        // login to the page and create global variables of classes used in test
        loginPage = new LoginPage(driver);
        loginPage.loginAs(loginEmail, loginPassword);
        addAddressPage = new AddAddressPage(driver);
    }

    // Go to addresses page and open new address creation
    @When("User goes to Address Page")
    public void userGoesToAddressPage() {
        addAddressPage.clickUserAccount();
        addAddressPage.clickAddress();
        addAddressPage.clickNewAddress();

    }

    // Send information given at Cucumber Script - Alias, Company, Address, PostCode, Country and Phone; Confirm, that information are entered properly (Assertion)
    @And("User fulfills necessary pages, keyword (.*), keyword (.*), keyword (.*), keyword (.*), keyword (.*), keyword (.*), keyword (.*)")
    public void userFulfillsNecessaryPagesKeywordAliasKeywordCompanyKeywordAddressKeywordPostcodeKeywordCityKeywordPhoneKeywordCountryvalue(String alias, String company, String address, String postcode, String city, String phone, String countryValue) {
//        addAddressPage.typeAlias(alias);
//        addAddressPage.typeCompany(company);
//        addAddressPage.typeAddress(address);
//        addAddressPage.typePostcode(postcode);
//        addAddressPage.typeCity(city);
//        addAddressPage.typePhone(phone);
        addAddressPage.typeAddressData(alias, company, address, postcode, city, phone);
        addAddressPage.chooseCountry(countryValue);
    }

    // Submit new address and confirm creation (Assertion)
    @And("User submits changes")
    public void userSubmitsChanges() {
        addAddressPage.submitAddress();

    }

    //to specjalna składnia na tekst?? - spytać koniecznie i dlaczego wyrzuca wyjątek?
    @Then("User see \"([^\"]*)\"")
    public void userSee(String creationMessage){ //throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    Assert.assertEquals(creationMessage, addAddressPage.getSuccessInfo());
    }

    // Assert inserted values
    @And("Validate address data, keyword (.*), keyword (.*), keyword (.*), keyword (.*), keyword (.*), keyword (.*), keyword (.*)")
    public void validateAddressDataKeywordAliasKeywordCompanyKeywordAddressKeywordPostcodeKeywordCityKeywordPhoneKeywordCountryvalue(String alias, String company, String address, String postcode, String city, String phone, String country) {
//        Assert.assertTrue(addAddressPage.findCreatedAddress(alias).contains(alias));
//        Assert.assertTrue(addAddressPage.findCreatedAddress(alias).contains(company));
//        Assert.assertTrue(addAddressPage.findCreatedAddress(alias).contains(address));
//        Assert.assertTrue(addAddressPage.findCreatedAddress(alias).contains(postcode));
//        Assert.assertTrue(addAddressPage.findCreatedAddress(alias).contains(city));
//        Assert.assertTrue(addAddressPage.findCreatedAddress(alias).contains(phone));
//        Assert.assertTrue(addAddressPage.findCreatedAddress(alias).contains(country));
        addAddressPage.assertGeneral(alias, company, address, postcode, city, phone, country);
    }

    // End test - quit browser
    @And("Quit browser")
    public void quitBrowser() {
        driver.quit();
    }


    @And("Validate inserted values in fields")
    public void validateInsertedValuesInFields() {
    }
}

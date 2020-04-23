package AccountCreation;

import AddressManage.AddAddressPage;
import Login.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AccountCreation {

    // create attributes with classes, that will be used
    private static WebDriver driver;
    private AccountCreationPage accountCreationPage;
    private LoginPage loginPage;
    private String shopWebsite = "https://prod-kurs.coderslab.pl/index.php?controller=authentication";

    @Given("An open browser with prestaShop")
    public void anOpenBrowserWithPrestaShop() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        driver = new ChromeDriver();

        // Get full screen of browser and set max wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(shopWebsite);

        // initialize global variables of classes used in test
        loginPage = new LoginPage(driver);
        accountCreationPage = new AccountCreationPage(driver);
    }

    // Open website, where you can create account
    @When("Open the AccCreation Website")
    public void openTheAccCreationWebsite() {
        accountCreationPage.getAccountCreationWebsite();
    }

    // Enter your credentials
    @And("Choose keyword (.*), keyword (.*), keyword (.*), keyword (.*)")
    public void chooseKeywordGenderKeywordFirstNameKeywordLastNameKeywordEmailAddress(String gender, String firstName, String lastName, String emailAddress) {
        accountCreationPage.chooseGender(gender);
        accountCreationPage.getFirstName(firstName);
        accountCreationPage.getLastName(lastName);
        accountCreationPage.getEmail(emailAddress);
    }

    // Enter your credentials continuation and submit
    @And("Keyword (.*), keyword (.*) and clicks Create an account button")
    public void keywordPasswordKeywordBirthDateAndClicksCreateAnAccountButton(String password, String birthDate) {
        accountCreationPage.getPassword(password);
        accountCreationPage.getBirthdate(birthDate);
        accountCreationPage.clickSaveButton();
    }

    // Sign out get confirmation message (information, that you're signed out)
    @Then("User redirected to the main page as logged and then logged out")
    public void userRedirectedToTheMainPageAsLoggedAndThenLoggedOut() {
        Assert.assertTrue(accountCreationPage.getSignOutMessage().contains("Sign out"));
        accountCreationPage.signOut();
    }

    // Validate your newly created account buy logging in and get confirmation ("My account" text)
    @And("Validate account by logging in with keyword (.*) and keyword (.*)")
    public void validateAccountByLoggingInWithKeywordEmailAddressAndKeywordPassword(String emailAddress, String password) {
        loginPage.clickLoginButton();
        loginPage.loginAs(emailAddress, password);
        Assert.assertTrue("Brak poprawnego logowania na konto", driver.getTitle().contains("My account"));
    }
}

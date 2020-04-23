package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // driver declaration;
    private static WebDriver driver;

    @FindBy(name ="email")
    WebElement loginInput;

    @FindBy(name ="password")
    WebElement passwordInput;

    @FindBy(id ="submit-login")
    WebElement signInButton;

    @FindBy(xpath = "//a[@class='logout hidden-sm-down']")
    WebElement signOutButton;

    @FindBy(xpath = "//div[@class='user-info']")
    WebElement logInButton;

    // Contructor for the class with PageFactory initialization
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Login button click
    public void clickLoginButton(){
        logInButton.click();
    }

    // Send login credentials and confirm
    public void loginAs (String email, String password){
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(email);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        signInButton.click();
    }

    // Confirm, that you're logged on the proper account
    public String getLoggedUsername() {
        WebElement userName = driver.findElement(By.xpath("//a[@class='account']"));
        return userName.getText();
    }

    // Get to the page of your account
    public void clickUserAccount() {
        driver.findElement(By.xpath("//a[@title = 'View my customer account']")).click();
    }

    // Log out
    public void logOut(){
        signOutButton.click();
    }

}

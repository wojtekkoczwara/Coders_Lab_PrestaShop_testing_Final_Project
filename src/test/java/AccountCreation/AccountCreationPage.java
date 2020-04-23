package AccountCreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountCreationPage {

    // Driver declaration
    private static WebDriver driver;

    // Method constructor with PageFactory initialization
    public AccountCreationPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='user-info']")
    WebElement signIn;

    @FindBy(xpath = "//a[@data-link-action='display-register-form']")
    WebElement noAccount;

    @FindBy(className = "radio-inline")
    List<WebElement> genderChoose;

    @FindBy(name = "firstname")
    WebElement firstNameInput;

    @FindBy(name = "lastname")
    WebElement lastNameInput;

    @FindBy(name = "email")
    WebElement emailInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(name = "birthday")
    WebElement birthdateInput;

    @FindBy(xpath = "//button[@data-link-action='save-customer']")
    WebElement saveButton;

    @FindBy(xpath = "//a[@class='logout hidden-sm-down']")
    WebElement logOutButton;

    // Go to create account
    public void getAccountCreationWebsite(){
        signIn.click();
        noAccount.click();
    }

    // Gender choose by switching radio-buttons
    public void chooseGender(String gender){
        // iterate radio-buttons listed
        for (int i = 0; i < genderChoose.size(); i++){
            //Get one element and ecstract text
            WebElement genderCandidate = genderChoose.get(i);
            String genderText = genderCandidate.getText();
            //check if text contains gender send to the method and click if confirmed
            if (genderText.contains(gender)){
                genderCandidate.click();
            }
        }
    }

    // Enter firstname
    public void getFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    // Enter lastname
    public void getLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    // Enter email
    public void getEmail(String email){
        emailInput.sendKeys(email);
    }

    // Enter password
    public void getPassword(String password){
        passwordInput.sendKeys(password);
    }

    // Enter birth date
    public void getBirthdate(String birthday){
        birthdateInput.sendKeys(birthday);
    }

    // Choose save button and click - submit account creation
    public void clickSaveButton(){
        saveButton.click();
    }

    // Get message, that you're signed out
    public String getSignOutMessage(){
        return logOutButton.getText();
    }

    // Sign out from website
    public void signOut(){
        logOutButton.click();
    }


}

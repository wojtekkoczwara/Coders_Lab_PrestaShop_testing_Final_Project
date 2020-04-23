package AddressManage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeleteAddressPage {

    // Driver declaration
    private static WebDriver driver;

    // Method constructor with PageFactory initialization
    public DeleteAddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title = 'View my customer account']")
    WebElement customerPage;

    @FindBy(id = "addresses-link")
    WebElement addressButton;

    // Click user account
    public void clickUserAccount() {
        customerPage.click();
    }

    // Click address
    public void clickAddress(){
        addressButton.click();
    }

    // Delete address
    public void deleteAddressButton(String addressAlias){
        // List available addresses
        List<WebElement> AddressesCreated = driver.findElements(By.className("address"));

        //Iterate every address
        for(int i = 0; i < AddressesCreated.size(); i++){
            // Get text from address
            WebElement AddressFromList = AddressesCreated.get(i);
            String textAliasFromAddress = AddressFromList.getText();

            // Get address id
            String idAliasFromAddress = AddressFromList.getAttribute("id");

            // check condition - address alias must containg given alias
            if (textAliasFromAddress.contains(addressAlias)){
                // find element with given (proper) alias, then find delete button in this address, then click delete button;
              driver.findElement(By.xpath("//article[@id = '" + idAliasFromAddress + "']//*//a[@data-link-action='delete-address']")).click();
              break;
            }
        }
    }

    // Get delete information
    public String getDeleteInformation() {
        WebElement deleteInformation = driver.findElement(By.xpath("//article[@role = 'alert']"));
        return deleteInformation.getText();
    }

}

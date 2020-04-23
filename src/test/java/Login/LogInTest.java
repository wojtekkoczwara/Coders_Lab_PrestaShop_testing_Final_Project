package Login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LogInTest {

    // Create driver atrribute
    private static WebDriver driver;

    @Before
    public void setUp() {

        // Drive set

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        driver = new ChromeDriver();

        // Get full screen of browser and set max wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
    }

    @Test
    // Login with given credentials and receive confirmation message (check the name, that you're logged for)
    public void testLoginWithProperCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("wojciechkawu@gmail.com", "CodersLab");
        Assert.assertEquals("Automated Tester", loginPage.getLoggedUsername());
    }

    @After
    // End test - quit browser
    public void tearDown() {
        driver.quit();
    }
}
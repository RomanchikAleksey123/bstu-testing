package pageobjectModel.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjectModel.page.ShopHomePage;

public class RegistrationTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public  void browserSetup() throws InterruptedException {
        driver = new ChromeDriver();
    }

    @Test
    public  void userRegistrationNotCorrectCode() throws InterruptedException {
        String registrationMessage = new ShopHomePage(driver)
                .openPage()
                .openUserRegistrationFrame()
                .inputPhoneForRegistration("337775533")
                .inputCodeForRegistration("abc")
                .getRegistrationMessage();

        Assert.assertEquals(registrationMessage, "Укажите корректный код подверждения");
    }

    @AfterMethod(alwaysRun = true)
    public  void browserShutdown(){
        driver.quit();
    }
}

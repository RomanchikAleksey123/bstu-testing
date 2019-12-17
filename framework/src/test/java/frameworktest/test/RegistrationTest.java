package frameworktest.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import frameworktest.page.*;

public class RegistrationTest extends CommonConditions{
    @Test
    public  void userRegistrationNotCorrectCode() throws InterruptedException {
        String registrationMessage = new ShopHomePage(driver)
                .openPage()
                .openUserAuthorizationFrame()
                .openUserRegistrationFrame()
                .inputPhoneForRegistration("337775533")
                .getCodeForRegistration()
                .inputCodeForRegistration("abc")
                .getRegistrationMessage();

        Assert.assertEquals(registrationMessage, "Укажите корректный код подверждения");
    }
}
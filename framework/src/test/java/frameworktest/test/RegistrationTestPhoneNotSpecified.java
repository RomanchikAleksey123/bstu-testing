package frameworktest.test;

import frameworktest.page.ShopHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTestPhoneNotSpecified extends CommonConditions {
    @Test
    public  void userRegistrationPhoneNumberNotSpecified() throws InterruptedException {
        String registrationMessage = new ShopHomePage(driver)
                .openPage()
                .openUserAuthorizationFrame()
                .openUserRegistrationFrame()
                .getCodeForRegistration()
                .getMessegeAfterCodeWrite();

        Assert.assertEquals(registrationMessage, "Укажите номер телефона");
    }
}

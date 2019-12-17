package frameworktest.test;

import frameworktest.page.ShopHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class JoinFacebookTest extends  CommonConditions {
    @Test
    public  void joinFacebook() throws InterruptedException {
        String faceBookLogo = new ShopHomePage(driver)
                .openPage()
                .openFaceBook()
                .getLogo();
        Assert.assertEquals(faceBookLogo, "Facebook");
    }
}

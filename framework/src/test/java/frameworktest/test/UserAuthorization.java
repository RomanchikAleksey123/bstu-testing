package frameworktest.test;

import frameworktest.model.User;
import frameworktest.page.ShopHomePage;

public class UserAuthorization extends CommonConditions {
    public static ShopHomePage LogIn(User user){
        return new ShopHomePage(driver)
                .openPage()
                .openUserAuthorizationFrame()
                .inputUserInfoForAuthorization(user);
    }
}

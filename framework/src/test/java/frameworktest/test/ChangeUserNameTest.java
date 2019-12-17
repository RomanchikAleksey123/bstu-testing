package frameworktest.test;

import frameworktest.model.User;
import frameworktest.service.UserCreator;
import frameworktest.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeUserNameTest extends CommonConditions {
    @Test
    public  void changeUserName() throws InterruptedException {
        String newUserName = StringUtils.getRandomUserName();
        User testUser = UserCreator.createUserFromProperties();
        String changeSettingsMassage = UserAuthorization.LogIn(testUser)
                .openSettingsPage()
                .inputNewUserName(newUserName)
                .SaveChanges()
                .getSaveChangesMessage();
        Assert.assertEquals(changeSettingsMassage, "Личные данные сохранены");
    }
}

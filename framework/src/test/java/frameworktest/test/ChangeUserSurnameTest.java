package frameworktest.test;

import frameworktest.model.User;
import frameworktest.service.UserCreator;
import frameworktest.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeUserSurnameTest extends CommonConditions{
    @Test
    public  void changeUserSurname() throws InterruptedException {
        String newUserSurname = StringUtils.getRandomUserName();
        User testUser = UserCreator.createUserFromProperties();
        String changeSettingsMassage = UserAuthorization.LogIn(testUser)
                .openSettingsPage()
                .inputNewSurname(newUserSurname)
                .SaveChanges()
                .getSaveChangesMessage();
        Assert.assertEquals(changeSettingsMassage, "Личные данные сохранены");
    }
}

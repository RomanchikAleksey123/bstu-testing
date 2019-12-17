package frameworktest.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import frameworktest.page.*;

public class SearchProductsTest extends CommonConditions {
    @Test
    public  void searchProduct() {
        int resultSearchCount = new ShopHomePage(driver)
                .openPage()
                .searchProducts("Компьютер")
                .getSearchedElementsCount();
        Assert.assertTrue(resultSearchCount > 0);
    }
}
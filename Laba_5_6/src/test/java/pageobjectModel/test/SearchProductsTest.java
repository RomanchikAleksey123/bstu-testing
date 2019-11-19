package pageobjectModel.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjectModel.page.ShopHomePage;

public class SearchProductsTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public  void browserSetup() {
        driver = new ChromeDriver();
    }

    @Test
    public  void searchProduct() {
        int resultSearch = new ShopHomePage(driver)
                .openPage()
                .searchProducts("Компьютер")
                .getSearchedElementsCount();
        Assert.assertTrue(resultSearch > 0);
    }

    @AfterMethod(alwaysRun = true)
    public  void browserShutdown(){
        driver.quit();
    }
}

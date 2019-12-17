package frameworktest.test;

import frameworktest.page.ShopHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

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
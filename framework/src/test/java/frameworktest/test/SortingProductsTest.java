package frameworktest.test;

import frameworktest.page.ShopHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortingProductsTest extends CommonConditions {
    @Test
    public  void sortProductsByFilter() throws InterruptedException {
        String sortTitle = new ShopHomePage(driver)
                .openPage()
                .getSledProducts()
                .sortProductsWithHaft()
                .getSortingTitle();

        Assert.assertEquals(sortTitle, "Есть");
    }
}

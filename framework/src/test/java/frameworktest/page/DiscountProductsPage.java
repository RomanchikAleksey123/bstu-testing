package frameworktest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiscountProductsPage extends BasePage {
    protected DiscountProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        throw  new RuntimeException("Discount page is available from main page!");
    }

    public DiscountProductsPage getDiscountComputers(){
        WebElement discountComputersLink = waitForElementLocatedBy(By.xpath("//*[@id='cataloglink-736']/a"));
        discountComputersLink.click();
        return this;
    }

    public  String getPageTitle(){
        return waitForElementLocatedBy(By.xpath("//*[@class='PagePromotions__TitleActivePage Page__TitleActivePage']")).getText();
    }

}

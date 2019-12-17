package frameworktest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SledProductsPage extends BasePage {


    protected SledProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        return null;
    }

    public  SledProductsPage sortProductsWithHaft(){
        WebElement sortButton = waitForElementLocatedBy(By.xpath("//*[@data-ga='Со спинкой и ручкой']"));
        sortButton.click();
        return this;
    }

    public String getSortingTitle(){
        return  waitForElementLocatedBy(By.xpath("//*[@for='prof_4292_1029']")).getText();
    }

    public SledProductInfoPage getFirstProduct(){
        WebElement firstProductLink = waitForElementLocatedBy(By.xpath("//*[@ title='Санки-коляска Ника Наши детки']"));
        firstProductLink.click();
        return new SledProductInfoPage(driver);
    }


}

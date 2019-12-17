package frameworktest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected WebDriver driver;
    protected final String HOMEPAGE_URL = "https://shop.by";
    protected final  int WAIT_TIMEOUT_SECONDS = 40;


    protected BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected  abstract  BasePage openPage();

    protected WebElement waitForElementLocatedBy(By by) {
        return (WebElement) new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(by));
    }
}

package frameworktest.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceBookPage extends  BasePage  {

    protected final String FACEBOOK_URL = "https://www.facebook.com/shopby/";

    protected FaceBookPage(WebDriver driver) {
        super(driver);
        driver.get(FACEBOOK_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

    @Override
    protected BasePage openPage() {
        driver.get(FACEBOOK_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return  this;
    }

    public String getLogo(){
        return waitForElementLocatedBy(By.xpath("//*[@class='fb_logo img sp_33iNLw2SSTv sx_f51271']/u")).getText();
    }
}

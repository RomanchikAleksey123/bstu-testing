package unitTestingStoreSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UnitTests {

    private  WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public  void browserSetup(){
        driver = new ChromeDriver();
        driver.get("https://shop.by");
    }

    @Test
    public  void sendingEmptyPhoneFieldResultNotAccepted() {

        WebElement userProfileButton = waitForElementLocatedBy(By.xpath("//*[@id='Header__Authentication']/div/span"));
        userProfileButton.click();

        WebElement registrationButton = waitForElementLocatedBy(By.xpath("//*[@id='yt3']"));
        registrationButton.click();

        WebElement submitButton =  waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm-form_ajax_sumbit']"));
        submitButton.click();

        WebElement messageErrorTitle = waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm-form']/div[1]/div"));

        Assert.assertEquals(messageErrorTitle.getText(), "Укажите номер телефона", "Phone Number Text Box is empty!");
    }

    @Test
    public  void getStockProductsPageResultTrue() {

        WebElement promotionMenuOption = waitForElementLocatedBy(By.xpath("//*[@title='Товары со скидками']"));
        promotionMenuOption.click();

        WebElement promotionTitle = waitForElementLocatedBy(By.xpath("//div[2]/div/div[2]/h1"));

        Assert.assertEquals(promotionTitle.getText(), "Товары со скидками", "Discount page is not available");
    }

    private WebElement waitForElementLocatedBy(By by) {
        return (WebElement) new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    @AfterMethod (alwaysRun = true)
    public  void browserShutdown(){
        driver.quit();
    }

}

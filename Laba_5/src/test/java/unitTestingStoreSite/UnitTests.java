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

public class UnitTests {

    private  WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public  void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public  void sendingEmptyPhoneFieldResultNotAccepted() {
        driver.get("https://shop.by");
        WebElement userProfileButton = waitForElementLocatedBy(By.xpath("//*[@id='Header__Authentication']/div/span"));
        userProfileButton.click();

        WebElement registrationButton = waitForElementLocatedBy(By.xpath("//*[@id='yt3']"));
        registrationButton.click();

        WebElement submitButton =  waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm-form_ajax_sumbit']"));
        submitButton.click();

        WebElement messageErrorTitle = waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm-form']/div[1]/div"));

        Assert.assertTrue(messageErrorTitle.getText().equals("Укажите номер телефона"),"Phone Number Text Box is empty!");
    }

    @Test
    public  void getStockProductsResultTrue() {
        driver.get("https://shop.by");
;
        WebElement promotionMenuOption = waitForElementLocatedBy(By.xpath("/html/body/div[2]/div/div[1]/div/div/div[2]/a[2]"));
        promotionMenuOption.click();

        WebElement promotionTitle = waitForElementLocatedBy(By.xpath("/html/body/div[2]/div/div[2]/h1"));

        Assert.assertTrue(promotionTitle.getText().equals("Товары со скидками"),"Discount page is not available");
    }

    private WebElement waitForElementLocatedBy(By by) {
        return (WebElement) new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    @AfterMethod (alwaysRun = true)
    public  void browserShutdown(){
        driver.quit();
    }

}

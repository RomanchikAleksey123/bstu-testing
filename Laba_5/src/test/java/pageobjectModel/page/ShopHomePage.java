package pageobjectModel.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopHomePage extends BasePage{

    @FindBy(xpath = "//*[@class='Header__FindTxtInput']")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='Header__Logo']/div[2]/div/div[3]/form/div/div/input")
    private  WebElement searchButton;

    @FindBy(xpath = "//*[@class='Header__LoginLinkAuth Header__LinkShowWapper']")
    private  WebElement profileButton;


    public  ShopHomePage(WebDriver driver){
        super(driver);
    }

    public  ShopHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return  this;
    }

    public  SearchResultPage searchProducts(String searchRequest){
        searchInput.sendKeys(searchRequest);
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public ShopHomePage inputPhoneForRegistration(String phoneNumber){
        profileButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        WebElement registrationButton = waitForElementLocatedBy(By.xpath("//*[@id='yt3']"));
        registrationButton.click();
        WebElement inputPhone = waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm_phone']"));
        inputPhone.sendKeys(phoneNumber);
        return  this;
    }

    public  ShopHomePage inputCodeForRegistration(String code){
        WebElement getCodeButton = waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm-form_ajax_sumbit']"));
        getCodeButton.click();
        WebElement codeInput = waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm_code']"));
        codeInput.sendKeys(code);
        return  this;
    }

    public  String getRegistrationMessage(){
        WebElement registerSubmitButton = waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm-form_ajax_sumbit']"));
        registerSubmitButton.click();
        return  waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm-form']/div[2]/div")).getText();
    }

}

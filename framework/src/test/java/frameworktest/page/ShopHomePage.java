package frameworktest.page;

import frameworktest.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShopHomePage extends BasePage{

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@class='Header__FindTxtInput']")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@class='promotion TypeMenuBlocksLine__BlockContent']")
    private  WebElement DiscountProductsLink;

    @FindBy(xpath = "//*[@class='Header__SearchButLink glyphicon visible-md visible-lg']")
    private  WebElement searchButton;

    @FindBy(xpath = "//*[@class='Header__LoginLinkAuth Header__LinkShowWapper']")
    private  WebElement profileButton;


    public  ShopHomePage(WebDriver driver){
        super(driver);
    }

    public  ShopHomePage openPage(){
        logger.info("Open home page!");
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return  this;
    }

    public  SearchResultPage searchProducts(String searchRequest){
        searchInput.sendKeys(searchRequest);
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public  ShopHomePage openUserAuthorizationFrame(){
        profileButton.click();
        return  this;
    }

    public  ShopHomePage inputUserInfoForAuthorization(User user){
        WebElement inputPhone = waitForElementLocatedBy(By.xpath("//*[@id='LLoginForm_phone']"));
        WebElement inputPassword = waitForElementLocatedBy(By.xpath("//*[@id='LLoginForm_password']"));

        inputPhone.sendKeys(user.getUserPhoneNumber());
        inputPassword.sendKeys(user.getUserPassword());
        WebElement buttonSubmit =
                waitForElementLocatedBy(By.xpath("//*[@class='Page__ActiveButtonBg Header__ButtonLogIn']"));
        buttonSubmit.click();
        return  this;
    }

    public  WebElement getUserHeaderPhoto(){
        return waitForElementLocatedBy(By.xpath("//*[@id='header-photo']/div/img"));
    }

    public  DiscountProductsPage openDiscountProductsPage(){
        DiscountProductsLink.click();
        return new DiscountProductsPage(driver);
    }

    public  ShopHomePage openUserRegistrationFrame(){
        logger.info("Open user registration frame!");
        WebElement registrationButton = waitForElementLocatedBy(By.xpath("//*[@id='yt3']"));
        registrationButton.click();
        return this;
    }

    public ShopHomePage inputPhoneForRegistration(String phoneNumber){
        WebElement inputPhone = waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm_phone']"));
        inputPhone.sendKeys(phoneNumber);
        return  this;
    }

    public  ShopHomePage getCodeForRegistration(){
        WebElement getCodeButton = waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm-form_ajax_sumbit']"));
        getCodeButton.click();
        return  this;
    }

    public  ShopHomePage inputCodeForRegistration(String code){
        WebElement codeInput = waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm_code']"));
        codeInput.sendKeys(code);
        return  this;
    }

    public  String getRegistrationMessage(){
        WebElement registerSubmitButton = waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm-form_ajax_sumbit']"));
        registerSubmitButton.click();
        return  waitForElementLocatedBy(By.xpath("//*[@id='LRegisterForm-form']/div[2]/div")).getText();
    }

    public  SettingsPage openSettingsPage(){
        logger.info("Open settings page!");
        WebElement profileButton = waitForElementLocatedBy(By.xpath("//*[@id='header-photo']/div"));
        profileButton.click();
        WebElement settingsButton = waitForElementLocatedBy(By.xpath("//*[@href='/management/settings/update/']"));
        settingsButton.click();
        return  new SettingsPage(driver);
    }

    public  String getMessegeAfterCodeWrite(){
        return  waitForElementLocatedBy(By.xpath("//*[@class='errorMessage']")).getText();
    }

    public FaceBookPage openFaceBook(){
        logger.info("Open facebook page frame!");
        WebElement faceBookLink = waitForElementLocatedBy(By.xpath("//*[@href='https://www.facebook.com/shopby/']"));
        faceBookLink.click();
        return new FaceBookPage(driver);
    }
    public SledProductsPage getSledProducts(){
        try {
            Thread.sleep(2000);
            WebElement sledProductsButton = waitForElementLocatedBy(By.xpath("//*[@title='Санки и снегокаты']"));
            sledProductsButton.click();
            Thread.sleep(2000);
        }
        catch (Exception exp){

        }
        return new SledProductsPage(driver);
    }

}

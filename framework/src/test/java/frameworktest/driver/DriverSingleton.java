package frameworktest.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverSingleton {
    private static WebDriver driver;
    private static final String RESOURCES_PATH = "src\\test\\resources\\";

    private  DriverSingleton(){}

    public  static  WebDriver getDriver(){
        if(driver == null){
            switch (System.getProperty("browser")){
                case "firefox":{
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default:{
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public  static  void closeDriver(){
        driver.quit();
        driver = null;
    }
}

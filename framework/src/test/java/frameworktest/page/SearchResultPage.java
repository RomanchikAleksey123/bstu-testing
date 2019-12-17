package frameworktest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends  BasePage {

    public  SearchResultPage(WebDriver driver){
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        throw  new RuntimeException("Results page is available only for searching request!");
    }

    public  int getSearchedElementsCount(){
        return  driver.findElements(By.
                xpath("//*[@class='ShopItemList__ItemBlockRow ModelList__ModelBlockRow Page__EcommerceGA']")).size();
    }

}

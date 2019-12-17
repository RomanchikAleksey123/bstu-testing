package frameworktest.page;

import frameworktest.model.Review;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SledProductInfoPage extends BasePage {

    @FindBy(xpath = "//*[@id='Review_positive']")
    private WebElement positiveReviewInput;

    @FindBy(xpath = "//*[@id='Review_negative']")
    private WebElement negativeReviewInput;

    @FindBy(xpath = "//*[@id='Review_content']")
    private WebElement reviewContent;


    protected SledProductInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        return null;
    }

    public  SledProductInfoPage addNewReview(Review review){
        WebElement listReviewButton = waitForElementLocatedBy(By.xpath("//*[@title='Отзывы покупателей о модели']"));
        listReviewButton.click();
        WebElement assessmentInput = waitForElementLocatedBy(By.xpath("//*[@id='cont_Review_mark']/span[5]"));
        assessmentInput.click();
        positiveReviewInput.sendKeys(review.getPositiveReview());
        negativeReviewInput.sendKeys(review.getPositiveReview());
        reviewContent.sendKeys(review.getContentReview());
        WebElement submitButton = waitForElementLocatedBy(By.xpath("//*[@class='ModelReviews__ButtonCreate Page__ActiveButtonBg Page__GALinkBlock']"));
        submitButton.click();
        return  this;
    }

    public String getReviewAddingMesage(){
        return waitForElementLocatedBy(By.xpath("//*[@id='Review_positive_em_']")).getText();
    }
}

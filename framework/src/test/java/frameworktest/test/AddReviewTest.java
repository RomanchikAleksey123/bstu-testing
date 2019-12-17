package frameworktest.test;

import frameworktest.model.Review;
import frameworktest.model.User;
import frameworktest.service.ReviewCreator;
import frameworktest.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddReviewTest extends CommonConditions {
    @Test
    public  void addNewReviewForProduct() {
        Review emptyReview = ReviewCreator.createReviewFromProperty();
            User testUser = UserCreator.createUserFromProperties();
            String reviewMessage = UserAuthorization.LogIn(testUser)
                    .getSledProducts()
                    .getFirstProduct()
                    .addNewReview(emptyReview)
                    .getReviewAddingMesage();

            Assert.assertEquals(reviewMessage,"Пожалуйста, заполните поле «Достоинства»");
    }
}

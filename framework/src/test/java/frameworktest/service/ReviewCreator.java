package frameworktest.service;

import frameworktest.model.Review;
import frameworktest.model.User;
import org.omg.CORBA.PUBLIC_MEMBER;

public class ReviewCreator {
    public static final String TESTDATA_REVIEW_POSITIVE_REVIEW = "testdata.review.positiveReview";
    public static final String TESTDATA_REVIEW_NEGATIVE_REVIEW = "testdata.review.negativeReview";
    public static final String TESTDATA_REVIEW_CONTENT_REVIEW = "testdata.review.contentReview";

    public  static Review createReviewFromProperty(){
        return  new Review(TestDataReader.getTest(TESTDATA_REVIEW_POSITIVE_REVIEW),
                TestDataReader.getTest(TESTDATA_REVIEW_POSITIVE_REVIEW),
                TestDataReader.getTest(TESTDATA_REVIEW_POSITIVE_REVIEW));
    }

    public  static Review createEmptyReview(){
        return  new Review("","","");
    }
}

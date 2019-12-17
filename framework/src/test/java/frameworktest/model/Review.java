package frameworktest.model;

public class Review {
    private String positiveReview;
    private String negativeReview;
    private String contentReview;

    public Review(String positiveReview, String  negativeReview, String contentReview){
        this.positiveReview = positiveReview;
        this.negativeReview = negativeReview;
        this.contentReview = contentReview;

    }

    public String getPositiveReview() { return  positiveReview; };
    public void setPositiveReview(String positiveReview) { this.positiveReview = positiveReview; }

    public String getNegativeReview() { return  negativeReview; };
    public void setNegativeReview(String negativeReview) { this.negativeReview = negativeReview; }

    public String getContentReview() { return  contentReview; };
    public void setContentReview(String contentReview) { this.contentReview = contentReview; }
}

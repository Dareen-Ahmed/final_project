package core;
import java.util.ArrayList;
import java.util.List;

public class PropertyReviews {
    // Observer interface
    public interface PropertyReviewsObserver {
        void onPropertyReviewChanged(PropertyReviews propertyReviews);
    }

    private int review_id; // Primary key
    private int listing_id; // Foreign key, nullable
    private int user_id; // Foreign key, nullable
    private String rating; // Nullable (corresponds to FLOAT)
    private String review_text; // Nullable (corresponds to VARCHAR(45))
    private String review_date; // Nullable (DATE type)
    private List<PropertyReviewsObserver> observers = new ArrayList<>();

    // Default constructor
    public PropertyReviews() {}

    // Parameterized constructor for initialization
    public PropertyReviews(int review_id, int listing_id, int user_id, String rating, String review_text, String review_date) {
        this.review_id = review_id;
        this.listing_id = listing_id;
        this.user_id = user_id;
        this.rating = rating;
        this.review_text = review_text;
        this.review_date = review_date;
    }

    // Getters and setters for encapsulation

    public void addObserver(PropertyReviewsObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PropertyReviewsObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (PropertyReviewsObserver observer : observers) {
            observer.onPropertyReviewChanged(this);
        }
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
        notifyObservers();
    }

    public int getListing_id() {
        return listing_id;
    }

    public void setListing_id(int listing_id) {
        this.listing_id = listing_id;
        notifyObservers();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
        notifyObservers();
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
        notifyObservers();
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
        notifyObservers();
    }

    public String getReview_date() {
        return review_date;
    }

    public void setReview_date(String review_date) {
        this.review_date = review_date;
        notifyObservers();
    }
}

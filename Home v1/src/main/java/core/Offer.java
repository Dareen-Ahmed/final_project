package core;
import java.util.ArrayList;
import java.util.List;

//Observer interface
interface OfferObserver {
 void onOfferChanged(Offer offer);
}
public class Offer {
	private int offer_id; // Primary key
    private String offer_description; // Can be nullable, corresponds to VARCHAR(45)
    private List<OfferObserver> observers = new ArrayList<>();

    // Default constructor
    public Offer() {}

    // Parameterized constructor
    public Offer(int offer_id, String offer_description) {
        this.offer_id = offer_id;
        this.offer_description = offer_description;
    }

    // Getters and setters for the fields
    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
        notifyObservers();
    }

    public String getOffer_description() {
        return offer_description;
    }

    public void setOfferDescription(String offer_description) {
        this.offer_description = offer_description;
        notifyObservers();
    }

    // Observer methods
    public void addObserver(OfferObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OfferObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OfferObserver observer : observers) {
            observer.onOfferChanged(this);
        }
    }
}

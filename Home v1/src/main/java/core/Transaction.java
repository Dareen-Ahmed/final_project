package core;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface TransactionObserver {
    void onTransactionChanged(Transaction transaction);
}

public class Transaction {
    private int transaction_id;
    private int listing_id;
    private int buyer_id;
    private int seller_id;
    private String transaction_date;
    private String transaction_amount;
    private List<TransactionObserver> observers = new ArrayList<>();

    public Transaction(int transaction_id, int listing_id, int buyer_id, int seller_id, String transaction_date, String transaction_amount) {
        this.transaction_id = transaction_id;
        this.listing_id = listing_id;
        this.buyer_id = buyer_id;
        this.seller_id = seller_id;
        this.transaction_date = transaction_date;
        this.transaction_amount = transaction_amount;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
        notifyObservers();
    }

    public int getListing_id() {
        return listing_id;
    }

    public void setListing_id(int listing_id) {
        this.listing_id = listing_id;
        notifyObservers();
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
        notifyObservers();
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
        notifyObservers();
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
        notifyObservers();
    }

    public String getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(String transaction_amount) {
        this.transaction_amount = transaction_amount;
        notifyObservers();
    }

    // Observer methods
    public void addObserver(TransactionObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TransactionObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (TransactionObserver observer : observers) {
            observer.onTransactionChanged(this);
        }
    }
}

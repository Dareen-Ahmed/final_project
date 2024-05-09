package core;

public class User implements OfferObserver, TransactionObserver {
    private int user_id;
    private String username;
    private String email;
    private String password;
    private String registration_date;
    private String phone_number; // Optional attribute
    private String address; // Optional attribute

    public User(int user_id, String username, String email, String password, String registration_date, String phone_number, String address) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.registration_date = registration_date;
        this.phone_number = phone_number;
        this.address = address;
    }

    // Method to handle offer changes
    @Override
    public void onOfferChanged(Offer offer) {
        // Notify user about the offer
        System.out.println("User " + username + " received notification about offer: " + offer.getOffer_description());
    }

    // Method to handle transaction changes
    @Override
    public void onTransactionChanged(Transaction transaction) {
        // Notify user about the transaction
        System.out.println("User " + username + " received notification about transaction: " + transaction.getTransaction_id());
    }

    // Getter methods
    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRegistration_date() {
        return registration_date;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getAddress() {
        return address;
    }

    // Setter methods (if needed)
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
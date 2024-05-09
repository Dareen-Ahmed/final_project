package core;


public class Listing {
    private int listing_id;
    private int city_id;
    private int category_id;
    private int agent_id;
    private int offer_id;
    private int type_id;
    private int document_id;
    private int bedrooms;
    private int bathrooms;
    private String square_footage;
    private String price;
    
    public Listing(int listing_id,int city_id,int category_id,int agent_id,int offer_id,int type_id,int document_id,int bedrooms,int bathrooms,String square_footage,String price) {
        this.listing_id = listing_id;
        this.city_id = city_id;
        this.category_id = category_id;
        this.agent_id = agent_id;
        this.offer_id =offer_id;
        this.type_id = type_id;
        this.document_id =document_id;
        this.bedrooms =bedrooms;
        this.bathrooms =bathrooms;
        this.square_footage =square_footage;
        this.price =price;
    }
 
    // Constructor using builder pattern
    private Listing(Builder builder) {
        this.listing_id = builder.listing_id;
        this.city_id = builder.city_id;
        this.category_id = builder.category_id;
        this.agent_id = builder.agent_id;
        this.offer_id = builder.offer_id;
        this.type_id = builder.type_id;
        this.document_id = builder.document_id;
        this.bedrooms = builder.bedrooms;
        this.bathrooms = builder.bathrooms;
        this.square_footage = builder.square_footage;
        this.price = builder.price;
    }

    // Builder class for Listing
    public static class Builder {
        // Required parameters
        private int listing_id;
        private int city_id;
        private int category_id;
        private int agent_id;

        // Optional parameters with default values
        private int offer_id ;
        private int type_id ;
        private int document_id ;
        private int bedrooms ;
        private int bathrooms;
        private String square_footage;
        private String price;

        public Builder(int listing_id, int city_id, int category_id, int agent_id) {
            this.listing_id = listing_id;
            this.city_id = city_id;
            this.category_id = category_id;
            this.agent_id = agent_id;
        }

        public Builder offerId(int offer_id) {
            this.offer_id = offer_id;
            return this;
        }

        public Builder typeId(int type_id) {
            this.type_id = type_id;
            return this;
        }

        public Builder documentId(int document_id) {
            this.document_id = document_id;
            return this;
        }

        public Builder bedrooms(int bedrooms) {
            this.bedrooms = bedrooms;
            return this;
        }

        public Builder bathrooms(int bathrooms) {
            this.bathrooms = bathrooms;
            return this;
        }

        public Builder squareFootage(String square_footage) {
            this.square_footage = square_footage;
            return this;
        }

        public Builder price(String price) {
            this.price = price;
            return this;
        }

        public Listing build() {
            return new Listing(this);
        }
    }

    // Getters and setters for Listing attributes
    public int getListing_id() {
        return listing_id;
    }

    public void setListing_id(int listing_id) {
        this.listing_id = listing_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getDocument_id() {
        return document_id;
    }

    public void setDocument_id(int document_id) {
        this.document_id = document_id;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getSquare_footage() {
        return square_footage;
    }

    public void setSquare_footage(String square_footage) {
        this.square_footage = square_footage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
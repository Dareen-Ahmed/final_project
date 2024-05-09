package core;

public class PropertyImages implements Cloneable{
	private int image_id;
    private int listing_id;
    private String image_url;

    // Constructor
    public PropertyImages(int image_id, int listing_id, String image_url) {
        this.image_id = image_id;
        this.listing_id = listing_id;
        this.image_url = image_url;
    }

    // Clone method to create a copy of the object
    @Override
    public PropertyImages clone() {
        try {
            return (PropertyImages) super.clone();
        } catch (CloneNotSupportedException e) {
            // This should never happen since Cloneable is implemented
            throw new AssertionError();
        }
    }

    // Getter methods
    public int getImage_id() {
        return image_id;
    }

    public int getListing_id() {
        return listing_id;
    }

    public String getImage_url() {
        return image_url;
    }
}

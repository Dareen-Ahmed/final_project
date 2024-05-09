package core;

public class PropertyFeatures implements Cloneable{
	private int feature_id;
    private int listing_id;
    private String feature_name;
    private String feature_value;

    // Constructor
    public PropertyFeatures(int feature_id, int listing_id, String feature_name, String feature_value) {
        this.feature_id = feature_id;
        this.listing_id = listing_id;
        this.feature_name = feature_name;
        this.feature_value = feature_value;
    }

    // Clone method to create a copy of the object
    @Override
    public PropertyFeatures clone() {
        try {
            return (PropertyFeatures) super.clone();
        } catch (CloneNotSupportedException e) {
            // This should never happen since Cloneable is implemented
            throw new AssertionError();
        }
    }

    // Getter methods
    public int getFeature_id() {
        return feature_id;
    }

    public int getListing_id() {
        return listing_id;
    }

    public String getFeature_name() {
        return feature_name;
    }

    public String getFeature_value() {
        return feature_value;
    }
}

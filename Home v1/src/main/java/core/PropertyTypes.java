package core;

public class PropertyTypes {
    private int type_id; // Primary key
    private String type_name; // Nullable field, corresponds to VARCHAR(45)

    // Default constructor
    public PropertyTypes() {}

    // Parameterized constructor for initialization
    public PropertyTypes(int type_id, String type_name) {
        this.type_id = type_id;
        this.type_name = type_name;
    }

    // Getters and setters for encapsulation
    public int gettype_id() {
        return type_id;
    }

    public void settype_id(int type_id) {
        this.type_id = type_id;
    }

    public String gettype_name() {
        return type_name;
    }

    public void settype_name(String type_name) {
        this.type_name = type_name;
    }
}
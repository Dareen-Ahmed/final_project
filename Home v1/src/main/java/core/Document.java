package core;

public class Document implements Cloneable{
    protected int documents_id;
    protected String documents_name;
    protected String documents_description;
    protected String documents_image;

    public Document(int documents_id, String documents_name, String documents_description, String documents_image) {
        this.documents_id = documents_id;
        this.documents_name = documents_name;
        this.documents_description = documents_description;
        this.documents_image = documents_image;
    }

    public Document clone() throws CloneNotSupportedException {
        return (Document) super.clone();
    }

    // Getter and setter methods
    public int getdocuments_id() {
        return documents_id;
    }

    public void setdocuments_id(int documents_id) {
        this.documents_id = documents_id;
    }

    public String getdocuments_name() {
        return documents_name;
    }

    public void setdocuments_name(String documents_name) {
        this.documents_name = documents_name;
    }

    public String getdocuments_description() {
        return documents_description;
    }

    public void setdocuments_description(String documents_description) {
        this.documents_description = documents_description;
    }

    public String getdocuments_image() {
        return documents_image;
    }

    public void setdocuments_image(String documents_image) {
        this.documents_image = documents_image;
    }
}

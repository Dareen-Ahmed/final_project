package core;

public class Agent implements IContactable, IEmailable {
    private int agentId;
    private String agentName;
    private String contactInformation;
    private String email;

    // Constructor
    public Agent(int agentId, String agentName, String contactInformation, String email) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.contactInformation = contactInformation;
        this.email = email;
    }

    // Getters and Setters
    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

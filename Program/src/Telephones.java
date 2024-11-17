public class Telephones {
    private String phoneNumber;
    private String phoneType;

    // Constructor
    public Telephones(String phoneNumber, String phoneType) {
        this.phoneNumber = phoneNumber; 
        this.phoneType = phoneType;     
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

}

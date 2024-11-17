import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Telephones {
    private int telephone_id;
    private String phoneNumber;
    private String phoneType;
    private int client_id;

   
    public Telephones(int telephone_id, String phoneNumber, String phoneType, int client_id) {
        this.telephone_id = telephone_id;
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
        this.client_id = client_id;
    }

    

    public int getTelephone_id() {
        return telephone_id;
    }


    public void setTelephone_id(int telephone_id) {
        this.telephone_id = telephone_id;
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


    public int getClient_id() {
        return client_id;
    }


    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }


    public void addTelephone(Connection conn) {
        String sql = "INSERT INTO TELEPHONES (TELEPHONE_ID, CLIENT_ID, PHONE_NUMBER, PHONE_TYPE) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,getTelephone_id());
            stmt.setInt(2,getClient_id());
            stmt.setString(3, getPhoneNumber());
            stmt.setString(4, getPhoneType());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Telephone added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error while adding the telephone.");
            e.printStackTrace();
        }
    }

}

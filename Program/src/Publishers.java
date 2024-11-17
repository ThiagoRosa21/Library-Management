import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Publishers {
    private int publisherId;        
    private String name;            
    private Date dateFoundation;    
    private String country;         
    private String website;

    public Publishers(int publisherId, String name, Date dateFoundation, String country, String website) {
        this.publisherId = publisherId;
        this.name = name;
        this.dateFoundation = dateFoundation;
        this.country = country;
        this.website = website;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateFoundation() {
        return dateFoundation;
    }

    public void setDateFoundation(Date dateFoundation) {
        this.dateFoundation = dateFoundation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    public void addPublisher(Connection conn) {
        String sql = "INSERT INTO PUBLISHERS (PUBLISHER_ID, NAME, DATE_FOUNDATION, COUNTRY, WEBSITE) VALUES (?, ?, ?, ?, ?)";
    
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, getPublisherId()); 
            stmt.setString(2, getName()); 
            stmt.setDate(3, new java.sql.Date(getDateFoundation().getTime())); 
            stmt.setString(4, getCountry()); 
            stmt.setString(5, getWebsite()); 
    
            
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Publisher added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error while adding the publisher.");
            e.printStackTrace();
        }
    }
    
    
}
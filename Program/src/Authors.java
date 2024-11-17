import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Authors {
    private int authorId;          
    private String name;          
    private String nationality;    
    private Date birthDate;       
    private Date deathDate;

    
    public Authors(int authorId, String name, String nationality, Date birthDate, Date deathDate) {
        this.authorId = authorId;
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }


    public int getAuthorId() {
        return authorId;
    }
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Date getDeathDate() {
        return deathDate;
    }
    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }    

    public void addAuthors(Connection conn){
        String sql = "INSERT INTO AUTHORS(AUTHOR_ID, NAME, NATIONALITY,BIRTH_DATE,DEATH_DATE) VALUES(?, ?, ?, ?, ?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1,getAuthorId());
            stmt.setString(2,getName());
            stmt.setString(3,getNationality());
            stmt.setDate(4, new java.sql.Date(getBirthDate().getTime()));
        
            if (getDeathDate() != null) {
                stmt.setDate(5, new java.sql.Date(getDeathDate().getTime()));
            } else {
                stmt.setNull(5, java.sql.Types.DATE);
            }
    
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Author added successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error while adding the Author.");
            e.printStackTrace();
        }
    }

    
}
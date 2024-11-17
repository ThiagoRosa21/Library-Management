import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Books {
    private int bookId;             
    private int authorId;          
    private String title;          
    private int yearPublished;     
    private String genre;           
    private int copiesAvailable;   
    private int totalCopies;        
    private String language;        

    // Constructor
    public Books(int bookId, int authorId, String title, int yearPublished, String genre, int copiesAvailable, int totalCopies, String language) {
        this.bookId = bookId;
        this.authorId = authorId;
        this.title = title;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.copiesAvailable = copiesAvailable;
        this.totalCopies = totalCopies;
        this.language = language;
    }

    // Getters and Setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    // Method to add a book record to the database
    public void addBook(Connection conn) {
        String sql = "INSERT INTO BOOKS (BOOK_ID, AUTHOR_ID, TITLE, YEAR_PUBLISHED, GENRE, COPIES_AVAILABLE, TOTAL_COPIES, LANGUAGE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, getBookId());
            stmt.setInt(2, getAuthorId());
            stmt.setString(3, getTitle());
            stmt.setInt(4, getYearPublished());
            stmt.setString(5, getGenre());
            stmt.setInt(6, getCopiesAvailable());
            stmt.setInt(7, getTotalCopies());
            stmt.setString(8, getLanguage());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Book added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error while adding the book.");
            e.printStackTrace();
        }
    }
}

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoanBooks {
    private int loanBookId;  
    private int loanId;      
    private int bookId;      
    private int quantity;

    // Constructor
    public LoanBooks(int loanBookId, int loanId, int bookId, int quantity) {
        this.loanBookId = loanBookId;
        this.loanId = loanId;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getLoanBookId() {
        return loanBookId;
    }

    public void setLoanBookId(int loanBookId) {
        this.loanBookId = loanBookId;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

   
    public void addLoanBook(Connection conn) {
        String sql = "INSERT INTO LOAN_BOOKS (LOAN_BOOK_ID, LOAN_ID, BOOK_ID, QUANTITY) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, getLoanBookId());
            stmt.setInt(2, getLoanId());
            stmt.setInt(3, getBookId());
            stmt.setInt(4, getQuantity());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Loan-Book record added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error while adding the Loan-Book record.");
            e.printStackTrace();
        }
    }
}

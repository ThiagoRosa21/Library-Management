import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Loans {
    private int loanId;             
    private int clientId;           
    private Date loanDate;          
    private Date dueDate;           
    private Date returnDate;        
    private String loanStatus;      
    private double fineAmount;      
    private Date createdAt;         
    private Date updatedAt;


    public Loans(int loanId, int clientId, Date loanDate, Date dueDate, Date returnDate, String loanStatus,
            double fineAmount, Date createdAt, Date updatedAt) {
        this.loanId = loanId;
        this.clientId = clientId;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.loanStatus = loanStatus;
        this.fineAmount = fineAmount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public int getLoanId() {
        return loanId;
    }


    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }


    public int getClientId() {
        return clientId;
    }


    public void setClientId(int clientId) {
        this.clientId = clientId;
    }


    public Date getLoanDate() {
        return loanDate;
    }


    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }


    public Date getDueDate() {
        return dueDate;
    }


    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    public Date getReturnDate() {
        return returnDate;
    }


    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }


    public String getLoanStatus() {
        return loanStatus;
    }


    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }


    public double getFineAmount() {
        return fineAmount;
    }


    public void setFineAmount(double fineAmount) {
        this.fineAmount = fineAmount;
    }


    public Date getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


    public Date getUpdatedAt() {
        return updatedAt;
    }


    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void addLoan(Connection conn) {
        String sql = "INSERT INTO LOANS (LOAN_ID, CLIENT_ID, LOAN_DATE, DUE_DATE, RETURN_DATE, LOAN_STATUS, FINE_AMOUNT, CREATED_AT, UPDATED_AT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, getLoanId());
            stmt.setInt(2, getClientId());
            stmt.setDate(3, new java.sql.Date(getLoanDate().getTime()));
            stmt.setDate(4, new java.sql.Date(getDueDate().getTime()));
            stmt.setDate(5, getReturnDate() != null ? new java.sql.Date(getReturnDate().getTime()) : null);
            stmt.setString(6, getLoanStatus());
            stmt.setDouble(7, getFineAmount());
            stmt.setDate(8, getCreatedAt() != null ? new java.sql.Date(getCreatedAt().getTime()) : new java.sql.Date(System.currentTimeMillis()));
            stmt.setDate(9, getUpdatedAt() != null ? new java.sql.Date(getUpdatedAt().getTime()) : null);
    
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Loan added successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error while adding the loan.");
            e.printStackTrace();
        }
    }
}


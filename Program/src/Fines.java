import java.sql.Date;

public class Fines {
    private int fine_id;
    private int loan_id;
    private int fine_amount;
    private Date fine_Date; 
    private String fine_Status;

    
    public Fines(int fine_id, int loan_id, int fine_amount, Date fine_Date, String fine_Status) {
        this.fine_id = fine_id;
        this.loan_id = loan_id;
        this.fine_amount = fine_amount;
        this.fine_Date = fine_Date;
        this.fine_Status = fine_Status;
    }


    public int getFine_id() {
        return fine_id;
    }


    public void setFine_id(int fine_id) {
        this.fine_id = fine_id;
    }


    public int getLoan_id() {
        return loan_id;
    }


    public void setLoan_id(int loan_id) {
        this.loan_id = loan_id;
    }


    public int getFine_amount() {
        return fine_amount;
    }


    public void setFine_amount(int fine_amount) {
        this.fine_amount = fine_amount;
    }


    public Date getFine_Date() {
        return fine_Date;
    }


    public void setFine_Date(Date fine_Date) {
        this.fine_Date = fine_Date;
    }


    public String getFine_Status() {
        return fine_Status;
    }


    public void setFine_Status(String fine_Status) {
        this.fine_Status = fine_Status;
    }

    


}
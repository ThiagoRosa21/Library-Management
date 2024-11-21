import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Client {

    private String name, email, cpf, address;
    private int totalLoans,client_id;
    private Telephones telephone;
    

    
    public Client(int client_id,String name, String email, String cpf, String address, int totalLoans) {
        this.client_id = client_id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.address = address;
        this.totalLoans = totalLoans;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalLoans() {
        return totalLoans;
    }

    public void setTotalLoans(int totalLoans) {
        this.totalLoans = totalLoans;
    }

  
    public void displayClientInfo(Connection conn, String cpf) {
        String sql = "SELECT CLIENT_ID, NAME, EMAIL, ADDRESS FROM CLIENTS WHERE CPF = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cpf); 
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("Informações do Cliente:");
                System.out.println("ID: " + rs.getInt("CLIENT_ID"));
                System.out.println("Nome: " + rs.getString("NAME"));
                System.out.println("Email: " + rs.getString("EMAIL"));
                System.out.println("Endereço: " + rs.getString("ADDRESS"));
            } else {
                System.out.println("Nenhum cliente encontrado com o CPF: " + cpf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    public boolean addClient(Connection conn) {
        String sql = "INSERT INTO CLIENTS (CLIENT_ID, NAME, EMAIL, CPF, ADDRESS, TOTAL_LOANS) VALUES (?, ?, ?, ?, ?, ?)";
        boolean isAdded = false;
    
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, getClient_id());
            stmt.setString(2, getName());
            stmt.setString(3, getEmail());
            stmt.setString(4, getCpf());
            stmt.setString(5, getAddress());
            stmt.setInt(6, getTotalLoans());
    
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                isAdded = true;
                System.out.println("Client added successfully! ID: " + getClient_id() + ", Name: " + getName());
            }
        } catch (SQLException e) {
            System.out.println("Error while adding the client. SQL Error Code: " + e.getErrorCode());
            e.printStackTrace();
        }
        return isAdded;
    }
    

}

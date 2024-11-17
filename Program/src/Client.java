public class Client {
    private String name, email, cpf, address;
    private int totalLoans;
    private Telephones telephone;
    

    
    public Client(String name, String email, String cpf, String address, int totalLoans) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.address = address;
        this.totalLoans = totalLoans;
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

    // Method to display client information
    public void displayClientInfo() {
        System.out.println("Client: " + getName() + " is registered in the library." );
        System.out.println("Contact: " + telephone);
    }
}

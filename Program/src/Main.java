import java.sql.Connection;
import java.sql.SQLException;
public static void main(String[] args) {
    Connection connection = OracleConnection.getConnection();



    if (connection != null) {
        System.out.println("Connection established successfully!");
        try {
            connection.close();
            System.out.println("Connection closed successfully!");
        } catch (SQLException e) {
            System.out.println("Error while closing the connection!");
            e.printStackTrace();
        }
    } else {
        System.out.println("Failed to establish a connection.");
    }
}

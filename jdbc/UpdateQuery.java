package CURD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateQuery {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USER = "postgres";
        final String PASSWORD = "Ajaygattu@781";

        try{
            Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);
            String query = "UPDATE customers SET name = ?, email = ? WHERE customer_id = ?";
            try(PreparedStatement pre=connection.prepareStatement(query)){
                pre.setString(1,"Gattu");
                pre.setString(2,"gattu78123@gmail.com");
                pre.setInt(3,101);
                int rowsUpdated = pre.executeUpdate();
                if(rowsUpdated>0){
                    System.out.println("Product Updated Successfully!!!");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package CURD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQuery {public static void main(String[] args) {
    final String URL = "jdbc:postgresql://localhost:5432/postgres";
    final String USER = "postgres";
    final String PASSWORD = "Ajaygattu@781";

    Connection connection=null;
    PreparedStatement preparedStatement = null;
    try{
        connection= DriverManager.getConnection(URL,USER,PASSWORD);
        String query = "DELETE FROM customers WHERE customer_id=?";
        preparedStatement=connection.prepareStatement(query);
        preparedStatement.setInt(1,108);
        int rowsDeleted = preparedStatement.executeUpdate();
        if(rowsDeleted>0){
            System.out.println("deleted Successfully");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }
}
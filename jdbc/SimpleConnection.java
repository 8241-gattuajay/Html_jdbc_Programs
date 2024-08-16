package CURD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnection {
    public static void main(String[] args) {
        final String URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USER = "postgres";
        final String PASSWORD = "Ajaygattu@781";

        Connection  connection = null;
        try{
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            if(connection!=null)
                System.out.println("Connection to database established successfully");
        }
        catch (SQLException e) {
            System.out.println("Failed Conection");
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
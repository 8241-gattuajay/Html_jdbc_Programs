package CURD;

import java.sql.*;

public class InsertQuery {
    public static void main(String[] args) throws SQLException {
        final String URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USER = "postgres";
        final String PASSWORD = "Ajaygattu@781";

        Connection conn = null;
        PreparedStatement ps = null;
        try{
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            String query = "INSERT INTO customers(customer_id,name,email) VALUES (?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1,108);
            ps.setString(2,"Ajay");
            ps.setString(3,"ajaygattu781@gmail.com");

            int rowInserted = ps.executeUpdate();
            if(rowInserted>0){
                System.out.println("A new product was inserted!!!!");
            }
        }catch (Exception e){
            System.out.println("An error occured");
            e.printStackTrace();
        }finally {
            try{
                if(conn!=null)
                    conn.close();
                if(ps!=null)
                    ps.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}

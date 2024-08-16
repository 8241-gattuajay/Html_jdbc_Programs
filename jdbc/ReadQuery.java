package CURD;

import java.sql.*;

public class ReadQuery {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Ajaygattu@781";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try{
            //Load the PostgreSQL Driver
            Class.forName("org.postgresql.Driver");

            //Establish Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String query = "select * from customers";
            preparedStatement = conn.prepareStatement(query);
            rs=preparedStatement.executeQuery();

            //Process the data
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String first_name = rs.getString("name");
                String last_name = rs.getString("email");

                System.out.println(id + "\n " + first_name + "\n " + last_name);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(rs != null){
                    rs.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                if(conn != null){
                    conn.close();
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}

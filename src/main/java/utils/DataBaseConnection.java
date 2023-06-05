package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBaseConnection {

    private static String URL = "jdbc:mysql://127.0.0.1:3306/flight_reservation";
    private static String USER = "root";
    private static String PASS = "Mysql123#";


    public static Connection getConnection() throws SQLException {
        Connection connection;
        connection = DriverManager.getConnection(URL, USER, PASS);
        return connection;
    }

    public static void main(String[] args) throws SQLException {

        Connection con = DataBaseConnection.getConnection();

        if (con != null) {
            System.out.println("Connection success");
        }

    }


}

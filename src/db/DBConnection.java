package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;;

public class DBConnection {

    //DB Credentials

    private static final String url = "jdbc:mysql://127.0.0.1:3306/passwordcracker";
    private static final String username = "root";
    private static final String password = "root";

    // its a simple connection object but we converted it into method


        public static Connection getConnection() throws SQLException {

            //Its returning the method of connection class
            return DriverManager.getConnection(url, username, password);
        }
    }



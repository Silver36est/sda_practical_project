package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static String driverJDBC = "com.mysql.cj.jdbc.Driver";
    //Database credentials
    private static String userDB = User.USERNAME.getValue();
    private static String passwordDB = User.PASSWORD.getValue();

    public static void createDatabase() {
        String dbUrl = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
        try(Connection connection = DriverManager.getConnection(dbUrl, userDB, passwordDB);
            Statement stmt = connection.createStatement();
            ) {
            String sql = "CREATE DATABASE IF NOT EXISTS db_sda_practical_project";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getDBConnection() {
        Connection connection = null;
        // JDBC driver name and database URL
        String dbUrl = "jdbc:mysql://localhost:3306/db_sda_practical_project?serverTimezone=UTC";

        try {
            // Register JDBC driver
            Class.forName(driverJDBC);
            // Connect to database
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(dbUrl, userDB, passwordDB);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

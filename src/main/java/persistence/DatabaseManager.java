package persistence;

import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private Connection connection;

    public DatabaseManager() {
        DBUtil.createDatabase();
        connection = DBUtil.getDBConnection();
    }

    //create tables

    private void createTableCustomer() {
        String sql = "CREATE TABLE IF NOT EXISTS customer (\n"
                + " customer_id int NOT NULL AUTO_INCREMENT,\n"
                    + " first_name varchar (50) DEFAULT NULL,\n"
                    + " last_name varchar (50) DEFAULT NULL,\n"
                    + " phone varchar (45) DEFAULT NULL,\n"
                    + " email varchar (100) DEFAULT NULL,\n"
                    + " address varchar (150) DEFAULT NULL,\n"
                    + " PRIMARY KEY (customer_id)\n"
                + ");";
        try {
            Statement stmt = connection.createStatement();
            // Create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableRepairShop() {
        String sql = "CREATE TABLE IF NOT EXISTS repair_shop (\n"
                + " shop_id int NOT NULL AUTO_INCREMENT,\n"
                + " shop_name varchar (100) DEFAULT NULL,\n"
                + " address varchar (100) DEFAULT NULL,\n"
                + " phone varchar (45) DEFAULT NULL,\n"
                + " email varchar (100) DEFAULT NULL,\n"
                + " PRIMARY KEY (shop_id)\n"
                + ");";
        try {
            Statement stmt = connection.createStatement();
            // Create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableService() {
        String sql = "CREATE TABLE IF NOT EXISTS service (\n"
                + " service_id int NOT NULL AUTO_INCREMENT,\n"
                + " name varchar (100) DEFAULT NULL,\n"
                + " description varchar (255) DEFAULT NULL,\n"
                + " price float DEFAULT NULL,\n"
                + " PRIMARY KEY (service_id)\n"
                + ");";
        try {
            Statement stmt = connection.createStatement();
            // Create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableMechanic() {
        String sql = "CREATE TABLE IF NOT EXISTS mechanic (\n"
                + " mechanic_id int NOT NULL AUTO_INCREMENT,\n"
                + " first_name varchar (50) DEFAULT NULL,\n"
                + " last_name varchar (50) DEFAULT NULL,\n"
                + " work_phone varchar (45) DEFAULT NULL,\n"
                + " work_email varchar (100) DEFAULT NULL,\n"
                + " shop_id int,\n"
                + " available tinyint,\n"
                + " PRIMARY KEY (mechanic_id),\n"
                + " FOREIGN KEY (shop_id) REFERENCES repair_shop (shop_id)\n"
                + ");";
        try {
            Statement stmt = connection.createStatement();
            // Create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableManufacturer() {
        String sql = "CREATE TABLE IF NOT EXISTS manufacturer (\n"
                + " manufacturer_id int NOT NULL AUTO_INCREMENT,\n"
                + " name varchar (100) DEFAULT NULL,\n"
                + " warranty int DEFAULT NULL,\n"
                + " PRIMARY KEY (manufacturer_id)\n"
                + ");";
        try {
            Statement stmt = connection.createStatement();
            // Create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableBike() {
        String sql = "CREATE TABLE IF NOT EXISTS bike (\n"
                + " bike_id int NOT NULL AUTO_INCREMENT,\n"
                + " manufacturer_id int,\n"
                + " bike_name varchar (100) DEFAULT NULL,\n"
                + " customer_id int,\n"
                + " PRIMARY KEY (bike_id),\n"
                + " FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id),\n"
                + " FOREIGN KEY (customer_id) REFERENCES customer(customer_id)\n"
                + ");";
        try {
            Statement stmt = connection.createStatement();
            // Create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableServiceOrder() {
        String sql = "CREATE TABLE IF NOT EXISTS service_order (\n"
                + " order_id int NOT NULL AUTO_INCREMENT,\n"
                + " service_id int,\n"
                + " notes varchar (255) DEFAULT NULL,\n"
                + " start_date date DEFAULT NULL,\n"
                + " end_date date DEFAULT NULL,\n"
                + " customer_id int,\n"
                + " bike_id int,\n"
                + " shop_id int,\n"
                + " mechanic_id int,\n"
                + " PRIMARY KEY (order_id),\n"
                + " FOREIGN KEY (service_id) REFERENCES service(service_id),\n"
                + " FOREIGN KEY (customer_id) REFERENCES customer(customer_id),\n"
                + " FOREIGN KEY (bike_id) REFERENCES bike(bike_id),\n"
                + " FOREIGN KEY (shop_id) REFERENCES repair_shop(shop_id),\n"
                + " FOREIGN KEY (mechanic_id) REFERENCES mechanic(mechanic_id)\n"
                + ");";
        try {
            Statement stmt = connection.createStatement();
            // Create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableBilling() {
        String sql = "CREATE TABLE IF NOT EXISTS billing (\n"
                + " billing_id int NOT NULL AUTO_INCREMENT,\n"
                + " customer_id int,\n"
                + " order_id int,\n"
                + " total float DEFAULT NULL,\n"
                + " payment_due_date date DEFAULT NULL,\n"
                + " shop_id int,\n"
                + " PRIMARY KEY (billing_id),\n"
                + " FOREIGN KEY (customer_id) REFERENCES customer(customer_id),\n"
                + " FOREIGN KEY (order_id) REFERENCES service_order(order_id),\n"
                + " FOREIGN KEY (shop_id) REFERENCES repair_shop(shop_id)"
                + ");";
        try {
            Statement stmt = connection.createStatement();
            // Create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void initTables() {
        createTableCustomer();
        createTableRepairShop();
        createTableService();
        createTableMechanic();
        createTableManufacturer();
        createTableBike();
        createTableServiceOrder();
        createTableBilling();
    }
}

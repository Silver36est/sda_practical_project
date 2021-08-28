package persistence;

import java.beans.Customizer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import util.DBUtil;

public class RepositoryCustomer {

    private Connection connection;

    public RepositoryCustomer() {
        connection = DBUtil.getDBConnection();
    }

    public List<Customer> listAllCustomers() {
        List<Customer> customerList = new ArrayList<Customer>();
        String sql = "SELECT * FROM customer";
        try {
            PreparedStatement preparedStatement = DBUtil.getDBConnection().prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Customer customer = new Customer();
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setAddress(resultSet.getString("address"));
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customerList.add(customer);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}

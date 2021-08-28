package persistence;

import model.Mechanic;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryMechanic {

    private Connection connection;
    PreparedStatement preparedStatement;

    public RepositoryMechanic() {
        connection = DBUtil.getDBConnection();
    }

    public Mechanic findById(int mechanicId) {
        String sql = "SELECT * FROM mechanic WHERE mechanic_id = ?";
        Mechanic mechanic = null;
        try {
            preparedStatement = DBUtil.getDBConnection().prepareStatement(sql);
            preparedStatement.setInt(1, mechanicId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                mechanic = new Mechanic();
                mechanic.setMechanicId(resultSet.getInt("mechanic_id"));
                mechanic.setFirstName(resultSet.getString("first_name"));
                mechanic.setLastName(resultSet.getString("last_name"));
                mechanic.setWorkPhone(resultSet.getString("work_phone"));
                mechanic.setWorkEmail(resultSet.getString("work_email"));
                mechanic.setShopId(resultSet.getInt("shop_id"));
                mechanic.setAvailable(resultSet.getBoolean("available"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mechanic;
    }

    public void updateMechanicWorkPhone(int mechanicId, String workPhone) {

        String sql = "UPDATE mechanic SET work_phone = ? WHERE mechanic_id = ?";

        try {
            preparedStatement = DBUtil.getDBConnection().prepareStatement(sql);
            preparedStatement.setString(1, workPhone);
            preparedStatement.setInt(2, mechanicId);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("Mechanic work phone updated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

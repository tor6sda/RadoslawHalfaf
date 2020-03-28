import util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Przyklad3{
    public static void main(String[] args) {
        String sqlUpadate = "UPDATE ADDRESS SET ADD_BUILDING_NO = ? WHERE ADD_POSTAL_CODE = ?";

        String selectQuery = "Select * from address";
        try(PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(sqlUpadate)){
            preparedStatement.setString(1,"10");
            preparedStatement.setString(2,"38600");
            int countUpdatedRecords = preparedStatement.executeUpdate();
            System.out.println("Zaktułalizowano "+countUpdatedRecords+" wierszy");


        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(selectQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ADD_ID");
                String street = resultSet.getString("ADD_STREET");
                String buildingNo = resultSet.getString("ADD_BUILDING_NO");
                String postalCode = resultSet.getString("ADD_POSTAL_CODE");
                System.out.println(id + " " + street + " " + buildingNo + " " + postalCode);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

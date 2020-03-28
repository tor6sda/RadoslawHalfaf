import util.DatabaseConnection;

import java.sql.*;

public class Zadanie1{
    public static void main(String[] args) {

        DatabaseConnection connection = new DatabaseConnection();



            String query = "SELECT * FROM address where add_city like \"%\"?\"%\";";
            try(
                PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(query)) {

                statement.setString(1, "Paris");
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    System.out.println(resultSet.getInt("ADD_ID"));
                    System.out.println(resultSet.getString("ADD_STREET"));
                    System.out.println(resultSet.getString("ADD_CITY"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }



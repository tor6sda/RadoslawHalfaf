import java.sql.*;

public class Main{
    public static void main(String[] args) {



        String url = "jdbc:mysql://localhost:3306/shop?serverTimezone=CET";
        String user = "root";
        String password = "Nirvana88";
        String query = "SELECT*FROM country;";
        try(Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement()) {



            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                System.out.println(resultSet.getInt("CO_ID"));
                System.out.println(resultSet.getString("CO_NAME"));
                System.out.println(resultSet.getString("CO_ALIAS"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

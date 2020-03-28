import util.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Zadanie2{
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("?");
        String questionMark = ",?";
        int[] tablica = new int[]{1, 3, 5};

        for (int i = 1; i < tablica.length; i++) {
            stringBuilder.append(questionMark);

        }

        String query = "update product set PRO_DESCRIPTION " +
                "= CONCAT(PRO_DESCRIPTION, " +
                "?) where pro_id in (" + stringBuilder.toString() + ")";

        try (PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(query)) {
        preparedStatement.setString(1, " - BRAK");
        for (int i = 0; i < tablica.length; i++){
            preparedStatement.setInt(i+2,tablica[i]);
        }
        int count = preparedStatement.executeUpdate();
            System.out.println("Zaktualizowano " + count + " rekordów");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/tp18";
        String user = "tp18user";
        String password = "tp18user";

        try {
            // 1. Charger le driver
            Class.forName("org.postgresql.Driver");

            // 2. Établir la connexion
            Connection conn = DriverManager.getConnection(url, user, password);

            // 3. Créer le statement et exécuter la requête
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clients");

            // 4. Traiter les résultats
            while (rs.next()) {
                System.out.println(rs.getString("colonne_1"));
            }

            // 5. Fermer les ressources
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}   
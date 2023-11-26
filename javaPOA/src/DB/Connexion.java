package DB;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false";

    static {
        try {
      
            connection = DriverManager.getConnection(url, "root", "");
            System.out.println("Connexion établie");
        } catch (Exception e) {
            System.out.println("Erreur de chargement de pilote: " + e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    
    
}

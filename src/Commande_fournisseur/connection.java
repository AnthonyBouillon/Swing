
package Commande_fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * Méthode qui me permet de me connecter à la base de données
 */
public class connection {
        public Connection connection() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/papyrus";
            con = DriverManager.getConnection(url, "root", "leqxd777");
        } catch (Exception e) {
            e.getMessage();
        }
        return con;
    }
}

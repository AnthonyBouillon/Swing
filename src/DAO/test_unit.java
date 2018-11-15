/**
 * *************** TEST UNIT ***************************************************
 * Le CRUD est fonctionnel
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 80010-37-15
 */
public class test_unit {

    public static void main(String[] args) {
      
        ClientDAO clientDAO = new ClientDAO();
        Client client = new Client();

        // INSERTION CLIENT
        client.setNom("JACKY");
        client.setPrenom("DUPONT");
        client.setVille("Noyon");
        clientDAO.Insert(client);

        // AFFICHAGE CLIENTS
        for (Client array : clientDAO.List()) {
            System.out.println(array.getNom());
        }

        // MODIFICATION CLIENT
        client.setId(14);
        client.setNom("Mikeal");
        client.setPrenom("Charle");
        client.setVille("Corbie");
        clientDAO.Update(client);

        // SUPPRIME CLIENT
        client.setId(15);
        clientDAO.Delete(client);

    }

}

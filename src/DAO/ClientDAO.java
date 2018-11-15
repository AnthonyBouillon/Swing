package DAO;

import java.sql.*;
import java.util.*;

public class ClientDAO extends Connexion {

    public void Insert(Client cli) {
        try {
            // INSERTION D'UN CLIENT
            PreparedStatement stm = Connection().prepareStatement("INSERT INTO client (cli_nom, cli_prenom, cli_ville) VALUES (?, ?, ?)");
            stm.setString(1, cli.getNom());
            stm.setString(2, cli.getPrenom());
            stm.setString(3, cli.getVille());
            stm.execute();
            stm.close();
            Connection().close();
        } catch (SQLException e) {
            System.out.println("Error while inserting entity 'client'");
            System.out.println(e.getMessage());
        }
    }

    public void Update(Client cli) {
        try {
            // MODIFICATION NOM + PRENOM + VILLE
            PreparedStatement stm = Connection().prepareStatement("UPDATE client SET cli_nom = ?, cli_prenom = ?, cli_ville = ? WHERE cli_id = ?");
            stm.setInt(4, cli.getId());
            stm.setString(1, cli.getNom());
            stm.setString(2, cli.getPrenom());
            stm.setString(3, cli.getVille());
            stm.execute();
            Connection().close();
        } catch (SQLException e) {
            System.out.println("Error update entity 'client'");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {

            }
        }
    }

    public void Delete(Client cli) {
        try {
            // DELETE VIA ID (CLE ETRANGERE) RESERVATION
            PreparedStatement stm;
            stm = Connection().prepareStatement("DELETE FROM reservation WHERE res_cli_id = ?");
            stm.setInt(1, cli.getId());
            stm.execute();
            // DELETE CLIENT VIA ID
            stm = Connection().prepareStatement("DELETE FROM client WHERE cli_id = ?");
            stm.setInt(1, cli.getId());
            stm.execute();
            Connection().close();
        } catch (SQLException e) {
            System.out.println("Error deleting entity 'client' or 'reservation'");
            System.out.println(e.getMessage());
        }
    }

    public List<Client> List() {
        // AFFICHAGE DE TOUS LES DONNEES DES CLIENTS
        List<Client> resultat = new ArrayList();
        try {
            Statement stm = Connection().createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM client");
            while (result.next()) {
                Client c = new Client();
                c.setId(result.getInt("cli_id"));
                c.setNom(result.getString("cli_nom"));
                c.setPrenom(result.getString("cli_prenom"));
                c.setVille(result.getString("cli_ville"));
                resultat.add(c);
            }
            Connection().close();
        } catch (SQLException e) {
            System.out.println("Error reading 'client'");
            System.out.println(e.getMessage());
        }
        return resultat;
    }

}

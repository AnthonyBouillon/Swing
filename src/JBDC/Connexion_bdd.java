/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JBDC;

import java.sql.*;

/**
 *
 * @author 80010-37-15
 */
public class Connexion_bdd {

    public static void main(String[] args) {
        try {
            // Charge le pilote qui nous permettra d'utiliser JBDC
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // SELECT ET UPDATE
        try {
            // URL de la base de données
            String url = "jdbc:mysql://localhost:3306/papyrus";
            Connection con = DriverManager.getConnection(url, "root", "leqxd777");
            // Envoie requête SQL à la base de données
            Statement stm = con.createStatement();
            ResultSet Result = stm.executeQuery("SELECT * FROM fournis");

            while (Result.next()) {
                System.out.print(Result.getInt("NUMFOU"));
                System.out.print(" ");
                System.out.println(Result.getString("NOMFOU"));
            }
            // Requête préparé (plus rapide)
            PreparedStatement stm2 = con.prepareStatement("UPDATE fournis SET NOMFOU=? WHERE NUMFOU=?");
            // Premier ? => "toto3" (NOMFOU)
            stm2.setString(1, "toto");
            // Dexième ? => 06 (NUMFOU)
            stm2.setInt(2, 06);
            stm2.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // INSERTION
        try {
            String url = "jdbc:mysql://localhost:3306/papyrus";
            Connection con = DriverManager.getConnection(url, "root", "leqxd777");
            PreparedStatement stm = con.prepareStatement("INSERT INTO fournis (numfou, nomfou, ruefou, vilfou, posfou, confou) VALUES (?, ?, ?, ?, ?, ?)");
            stm.setInt(1, 667);
            stm.setString(2, "aa");
            stm.setString(3, "bb");
            stm.setString(4, "cc");
            stm.setString(5, "dd");
            stm.setString(6, "ee");
            stm.execute();
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
    }
}

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
public class Recherche_fournisseur  {

    private String num_fou;
    private String nom;
    private String adresse;
    private String cp;
    private String ville;
    private String contact;

    public String getNum_fou() {
        return num_fou;
    }

    public void setNum_fou(String num_fou) {
        this.num_fou = num_fou;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void bdd(String res) {
        setNum_fou(res);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {  
            String url = "jdbc:mysql://localhost:3306/papyrus";
            Connection con = DriverManager.getConnection(url, "root", "leqxd777");
            PreparedStatement stm = con.prepareStatement("SELECT * FROM fournis WHERE NUMFOU=?");
            stm.setString(1, getNum_fou());
            ResultSet Result = stm.executeQuery();
            setNom(null);
            while (Result.next()) {
                setNom(Result.getString("NOMFOU"));
                setAdresse(Result.getString("RUEFOU"));
                setCp(Result.getString("POSFOU"));
                setVille(Result.getString("VILFOU"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}

package Commande_fournisseur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Gestion_fournisseur extends Fournis {

    String message;
    // RECUPERE TOUS LES NOMS DES FOURNISSEURS QUI ONT PASSE COMMANDE
    public List<String> get_names_fournisseur() {
        // Nouvelle liste
        List<String> resultat = new ArrayList();
        try {
            // Requête
            PreparedStatement stm = connection().prepareStatement("SELECT fournis.numfou, nomfou, numcom, datecom, obscom FROM fournis JOIN entcorn ON fournis.numfou = entcorn.NUMFOU GROUP BY NOMFOU");
            ResultSet Result = stm.executeQuery();
            // Ajoute les noms dans la liste
            while (Result.next()) {
                resultat.add(Result.getString("nomfou"));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        // return la liste de noms
        return resultat;
    }
    // INFORMATION D'UN FOURNISSEUR
    public void get_fournisseur(String name) {
        try {
            // Requête préparé
            PreparedStatement stm = connection().prepareStatement("SELECT fournis.numfou, nomfou, numcom, datecom, obscom FROM fournis JOIN entcorn ON fournis.numfou = entcorn.NUMFOU WHERE fournis.NOMFOU = ?");
            stm.setString(1, name);
            ResultSet Result = stm.executeQuery();
            // On part du principe que le numéro de commande que tape l'utilisateur n'existe pas
            setNum_com(null);
            // Recupere les informations d'un fournisseur
            while (Result.next()) {
                setName(Result.getString("nomfou"));
                setNum_com(Result.getString("numcom"));
                setDate_com(Result.getString("datecom"));
                setComment(Result.getString("obscom"));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    // INFORMATION DE TOUT LES FOURNISSEURS
    public List<String> get_infos_fournisseur() {
        // Création d'une liste
        List<String> result = new ArrayList();
        try {
            // Requête
            PreparedStatement stm = connection().prepareStatement("SELECT fournis.numfou, nomfou, numcom, datecom, obscom FROM fournis JOIN entcorn ON fournis.numfou = entcorn.NUMFOU WHERE NOMFOU != \"\"");
            ResultSet Result = stm.executeQuery();
            // Recupere toutes les informations du même type dans une ligne de la liste
            while (Result.next()) {
                // Ligne 1
                result.add(Result.getString("nomfou") + " ");
                // Ligne 2
                result.add(Result.getString("numcom") + " ");
                // Ligne 3
                result.add(Result.getString("datecom") + " ");
                // Ligne 4
                result.add(Result.getString("obscom") + "\n");
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        // Retourne une liste
        return result;
    }

    // INSERTION D'UN FOURNISSEUR
    public void insert_fournisseur(String nom, String rue, String cp, String ville, String contact) {
        try {
            // Recupere les valeurs pour les mettres dans les setters
            setName(nom);
            setRue(rue);
            setCp(cp);
            setVille(ville);
            setContact(contact);
            // Requete préparé
            PreparedStatement stm = connection().prepareStatement("INSERT INTO fournis (nomfou, ruefou, posfou, vilfou, confou) VALUES (?, ?, ?, ?, ?)");
            // Position, Valeur
            stm.setString(1, getName());
            stm.setString(2, getRue());
            stm.setString(3, getCp());
            stm.setString(4, getVille());
            stm.setString(5, getContact());
            // Execute la requête
            stm.execute();
            message = "Insertion réussi";
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            message = "Insertion échoué";
        }
    }
}

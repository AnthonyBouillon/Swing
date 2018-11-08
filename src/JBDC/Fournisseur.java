/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JBDC;

/**
 *
 * @author 80010-37-15
 */
public class Fournisseur{

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

}

package Commande_fournisseur;

import java.sql.*;
import java.util.*;

public class Fournis extends connection {

    private String name;
    private String num_fou;
    private String num_com;
    private String comment;
    private String date_com;
    private String rue;
    private String cp;
    private String ville;
    private String contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() <= 25) {
            this.name = name;
        }
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        if (rue.length() <= 25) {
            this.rue = rue;
        }
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        if (cp.length() <= 5) {
            this.cp = cp;
        }
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        if (ville.length() <= 30) {
            this.ville = ville;
        }
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        if (contact.length() <= 15) {
            this.contact = contact;
        }
    }

    public String getNum_fou() {
        return num_fou;
    }

    public void setNum_fou(String num_fou) {
        this.num_fou = num_fou;
    }

    public String getNum_com() {
        return num_com;
    }

    public void setNum_com(String num_com) {
        this.num_com = num_com;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate_com() {
        return date_com;
    }

    public void setDate_com(String date_com) {
        this.date_com = date_com;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class Connexion {
Connection con = null;
    public Connection Connection() {
        //Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/hotel";
            con = DriverManager.getConnection(url, "root", "leqxd777");  
        } catch (SQLException e) {
            System.out.println("Error while inserting entity 'client'");
            System.out.println(e.getMessage());
        }
        return con;
    }
    
}

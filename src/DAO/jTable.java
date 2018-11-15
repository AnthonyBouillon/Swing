/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author 80010-37-15
 */
public class jTable extends AbstractTableModel {
    // Entête du tableau
    private final String[] Titres = {"ID", "NOM", "PRENOM", "VILLE"};
    // Instanciation de mes deux classes
    ClientDAO clients = new ClientDAO();

    // Méthode obligatoire
    @Override
    public int getColumnCount() {
        return Titres.length;
    }
    // Méthode obligatoire
    @Override
    public String getColumnName(int column) {
        return Titres[column];
    }
    // Méthode obligatoire
    @Override
    public int getRowCount() {
        return clients.List().size();
    }

    // Méthode obligatoire
    @Override
    public Object getValueAt(int row, int column) {

        switch (column) {
            case 0:
                return clients.List().get(row).getId();
            case 1:
                return clients.List().get(row).getNom();
            case 2:
                return clients.List().get(row).getPrenom();
            case 3:
                return clients.List().get(row).getVille();
            default:
                return null;
        }

    }

    public void AjouteClient(Client j) {
        clients.List().add(j);
        fireTableRowsInserted(clients.List().size() - 1, clients.List().size());
    }

    public void SupprimerClient(int i) {
        fireTableRowsDeleted(i, i);
    }

}

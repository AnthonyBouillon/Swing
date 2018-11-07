/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jTable;
import javax.swing.table.AbstractTableModel;
import java.util.*;
/**
 *
 * @author 80010-37-15
 */
public  class MonModele extends AbstractTableModel{
    
    List<Client> clients = new ArrayList<Client>();
    String[] entetes = {"Prénom", "Nom", "Ville"};
    
    public MonModele() {
        clients.add(new Client("Josh", "Homme", "Joshua Tree"));
        clients.add(new Client("Dave", "Grohl", "Warren"));
        clients.add(new Client("Krist", "Novoselic", "Compton"));
        clients.add(new Client("Robert", "Trujillo", "Santa Monica"));
    }
    @Override
    public String getColumnName(int column) {
        return entetes[column]; 
    }

    @Override
    public int getRowCount() {
        return clients.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return clients.get(rowIndex).nom;
            case 1:
                return clients.get(rowIndex).prenom;
            case 2:
                return clients.get(rowIndex).ville;
            default:
                return null; 
        }
    }
     public void AjouteClient(Client j) {
        clients.add(j);
        fireTableRowsInserted(clients.size()-1, clients.size());
    }
      public void SupprimeClient(int i) {
        clients.remove(i);

        fireTableRowsDeleted(i, i);
    }
}

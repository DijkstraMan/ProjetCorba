/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modEntreesSortiesZones.Utilisateur;

/**
 *
 * @author Fabien
 */
public class UserTableModel extends AbstractTableModel {

    protected static final String[] COLUMN_NAMES = {
        "Matricule",
        "Nom",
        "Prénom",
        "Photo"
    };

    private List<Utilisateur> rowData;

    public UserTableModel() {
        rowData = new ArrayList<>(25);
    }
    
    public UserTableModel(Utilisateur[] utilisateurs) {
        rowData = new ArrayList<>(Arrays.asList(utilisateurs));
    }

    public void add(Utilisateur... usr) {
        add(Arrays.asList(usr));
    }

    public void add(List<Utilisateur> usr) {
        rowData.addAll(usr);
        fireTableDataChanged();
    }
    
    public void majAffichage(Utilisateur usr) {
        int nbUsr = rowData.size();
        boolean trouve = false;
        Utilisateur usrTemp;
        for(int i = 0;!trouve && i < nbUsr; i++) {
            usrTemp = rowData.get(i);
            if(usrTemp.matricule.equals(usr.matricule)){
                usrTemp.nomUsr = usr.nomUsr;
                usrTemp.preUsr = usr.preUsr;
                usrTemp.phoUsr = usr.phoUsr;
                trouve = true;
            }
        }
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return rowData.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    public Utilisateur getUserAt(int row) {
        return rowData.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Utilisateur usr = getUserAt(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = usr.matricule;
                break;
            case 1:
                value = usr.nomUsr;
                break;
            case 2:
                value = usr.preUsr;
                break;
            case 3:
                value = usr.phoUsr;
                break;
        }
        return value;
    }

}
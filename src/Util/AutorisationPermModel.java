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
import modEntreesSortiesZones.AutorisationPerm;


/**
 *
 * @author Fabien
 */
public class AutorisationPermModel extends AbstractTableModel {

    protected static final String[] COLUMN_NAMES = {
        "Matricule",
        "Nom de la zone",
        "Heure de début",
        "Heure de fin"
    };

    private List<AutorisationPerm> rowData;

    public AutorisationPermModel() {
        rowData = new ArrayList<>(25);
    }
    
    public AutorisationPermModel(AutorisationPerm[] utilisateurs) {
        rowData = new ArrayList<>(Arrays.asList(utilisateurs));
    }

    public void add(AutorisationPerm auto) {
        add(Arrays.asList(auto));
    }

    public void add(List<AutorisationPerm> auto) {
        rowData.addAll(auto);
        fireTableDataChanged();
    }
    
    public void delete(int row)
    {
        rowData.remove(getAutoPermAt(row));
        fireTableDataChanged();
    }
    
    public void majAffichage(AutorisationPerm auto) {
        int nbUsr = rowData.size();
        boolean trouve = false;
        AutorisationPerm usrTemp;
        for(int i = 0;!trouve && i < nbUsr; i++) {
            usrTemp = rowData.get(i);
            if(usrTemp.matricule.equals(auto.matricule)){
                usrTemp.nomZone = auto.nomZone;
                usrTemp.hrDebut = auto.hrDebut;
                usrTemp.hrFin = auto.hrFin;
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

    public AutorisationPerm getAutoPermAt(int row) {
        return rowData.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AutorisationPerm usr = getAutoPermAt(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = usr.matricule;
                break;
            case 1:
                value = usr.nomZone;
                break;
            case 2:
                value = usr.hrDebut;
                break;
            case 3:
                value = usr.hrFin;
                break;
        }
        return value;
    }

}
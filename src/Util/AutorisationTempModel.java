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
import modEntreesSortiesZones.AutorisationTemp;


/**
 *
 * @author Fabien
 */
public class AutorisationTempModel extends AbstractTableModel {

    protected static final String[] COLUMN_NAMES = {
        "Matricule",
        "Nom de la zone",
        "Heure de début",
        "Heure de fin",
        "Date de début",
        "Date de fin"
    };

    private List<AutorisationTemp> rowData;

    public AutorisationTempModel() {
        rowData = new ArrayList<>(25);
    }
    
    public AutorisationTempModel(AutorisationTemp[] utilisateurs) {
        rowData = new ArrayList<>(Arrays.asList(utilisateurs));
    }

    public void add(AutorisationTemp auto) {
        add(Arrays.asList(auto));
    }

    public void add(List<AutorisationTemp> auto) {
        rowData.addAll(auto);
        fireTableDataChanged();
    }
    
    public void delete(int row)
    {
        rowData.remove(getAutoTempAt(row));
        fireTableDataChanged();
    }
    
    public void majAffichage(AutorisationTemp auto) {
        int nbUsr = rowData.size();
        boolean trouve = false;
        AutorisationTemp usrTemp;
        for(int i = 0;!trouve && i < nbUsr; i++) {
            usrTemp = rowData.get(i);
            if(usrTemp.matricule.equals(auto.matricule)){
                usrTemp.nomZone = auto.nomZone;
                usrTemp.hrDebut = auto.hrDebut;
                usrTemp.hrFin = auto.hrFin;
                usrTemp.jourDebut = auto.jourDebut;
                usrTemp.jourFin = auto.jourFin;
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

    public AutorisationTemp getAutoTempAt(int row) {
        return rowData.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AutorisationTemp usr = getAutoTempAt(rowIndex);
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
            case 4:
                value = usr.jourDebut;
                break;
            case 5:
                value = usr.jourFin;
                break;
        }
        return value;
    }

}
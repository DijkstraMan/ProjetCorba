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
import modEntreesSortiesZones.LogAcces;

/**
 *
 * @author Fabien
 */
public class LogAccesTableModel extends AbstractTableModel{
    
    protected static final String[] COLUMN_NAMES = {
        "Matricule",
        "Zone",
        "Date et heure",
        "Type d'accès"
    };

    private List<LogAcces> rowData;

    public LogAccesTableModel() {
        rowData = new ArrayList<>(25);
    }
    
    public LogAccesTableModel(LogAcces[] logsAcces) {
        rowData = new ArrayList<>(Arrays.asList(logsAcces));
    }

    public void add(LogAcces... log) {
        add(Arrays.asList(log));
    }

    public void add(List<LogAcces> log) {
        rowData.addAll(log);
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

    public LogAcces getLogAt(int row) {
        return rowData.get(row);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LogAcces log = getLogAt(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = log.matricule;
                break;
            case 1:
                value = log.idZone;
                break;
            case 2:
                value = log.dateAcces;
                break;
            case 3:
                value = log.typeAcces;
                break;
        }
        return value;
    } 
}
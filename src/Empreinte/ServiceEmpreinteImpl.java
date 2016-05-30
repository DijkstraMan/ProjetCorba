/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empreinte;

import modEntreesSortiesZones.EmpreinteExistante;
import modEntreesSortiesZones.EmpreinteInconnue;
import modEntreesSortiesZones.ServiceEmpreintePOA;

/**
 *
 * @author Romain
 */
public class ServiceEmpreinteImpl extends ServiceEmpreintePOA {

    @Override
    public boolean verifierEmpreinte(String eC, String m) throws EmpreinteInconnue {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterEmpreinte(String e, String m) throws EmpreinteExistante {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierEmpreinte(String e, String m) throws EmpreinteInconnue {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

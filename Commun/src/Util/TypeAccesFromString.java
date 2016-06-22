/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import modEntreesSortiesZones.TypeAcces;

/**
 *
 * @author Fabien
 */
public class TypeAccesFromString {
    
    public static TypeAcces parse(String typeAccesStr){
        switch(typeAccesStr){
            case "autorise":
                return TypeAcces.autorise;
            case "nonAutorise":
                return TypeAcces.nonAutorise;
            case "nonAuthentifie":
            default:
                return TypeAcces.nonAuthentifie;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author Nico
 */
public class Fonction {

    public static org.omg.CORBA.Object connexionCorba(String nomServiceCorba) {
        try {
            String[] args = null;
            // Intialisation de l'orb
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

            // Recuperation du naming service
            org.omg.CosNaming.NamingContext nameRoot = Fonction.resolveNamingService(orb);

            // Construction du nom a rechercher
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            nameToFind[0] = new org.omg.CosNaming.NameComponent(nomServiceCorba, "");

            // Recherche aupres du naming service
            return nameRoot.resolve(nameToFind);

        } catch (InvalidName | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static NamingContext resolveNamingService(org.omg.CORBA.ORB orb) throws InvalidName
    {
        //return org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
        return org.omg.CosNaming.NamingContextHelper.narrow(orb.string_to_object("corbaloc:iiop:1.2@172.17.56.88:20017/NameService"));
    }
}

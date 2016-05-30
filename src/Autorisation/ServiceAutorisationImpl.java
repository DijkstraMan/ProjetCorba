/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autorisation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import modEntreesSortiesZones.AutorisationExistante;
import modEntreesSortiesZones.AutorisationInconnue;
import modEntreesSortiesZones.ServiceAutorisationPOA;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;



/**
 *
 * @author Nico
 */
public class ServiceAutorisationImpl extends ServiceAutorisationPOA{

    @Override
    public boolean verifierAutorisation(int m, String n) throws AutorisationInconnue {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterAutorisationTemp(int m, String n, int jD, int jF, int hD, int hF) throws AutorisationExistante {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierAutorisationTemp(int m, String n, int jD, int jF, int hD, int hF) throws AutorisationInconnue {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouterAutorisationPerm(int m, String n, int hD, int hF) throws AutorisationExistante {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifierAutorisationPerm(int m, String n, int hD, int hF) throws AutorisationInconnue {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerAutorisation(int m, String n) throws AutorisationInconnue {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
    try {
            // Intialisation de l'ORB
            //************************
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

            // Gestion du POA
            //****************
            // Recuperation du POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

            // Creation du servant
            //*********************
            ServiceAutorisationImpl serviceAuth = new ServiceAutorisationImpl();

            // Activer le servant au sein du POA et recuperer son ID
            byte[] serviceAuthId = rootPOA.activate_object(serviceAuth);

            // Activer le POA manager
            rootPOA.the_POAManager().activate();


            // Enregistrement dans le service de nommage
            //*******************************************
            // Recuperation du naming service
            NamingContext nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            // Construction du nom a enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            /*System.out.println("Sous quel nom voulez-vous enregistrer l'objet Corba ?");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String nomObj = in.readLine();*/
            String nomObj="SAUTH";
            nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj,"");

            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(serviceAuth));
            System.out.println("==> Nom '"+ nomObj + "' est enregistre dans le service de noms.");

            /*String IORServant = orb.object_to_string(rootPOA.servant_to_reference(monEuro));
            System.out.println("L'objet possede la reference suivante :");
            System.out.println(IORServant);*/

            // Lancement de l'ORB et mise en attente de requete
            //**************************************************
            orb.run();

        }
            catch (Exception e) {
                    e.printStackTrace();
            }
    } // main
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empreinte;

import Util.Fonction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;
import modEntreesSortiesZones.EmpreinteExistante;
import modEntreesSortiesZones.EmpreinteInconnue;
import modEntreesSortiesZones.ServiceEmpreintePOA;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/**
 *
 * @author Romain
 */
public class ServiceEmpreinteImpl extends ServiceEmpreintePOA implements Runnable {

    private byte[] mServiceEmpId;
    private org.omg.CORBA.ORB mOrb;
    private POA mRootPOA;
    private NamingContext mNameRoot;
    private final String mNomObj;
    private final JTextArea mAreaTextEvent;
    private Connection mConn = null;
    private final String mNomDB;

    public ServiceEmpreinteImpl(JTextArea a) {
        mNomObj = "SEMP";
        mAreaTextEvent = a;
        mNomDB = "bdEmpreinte";
    }

    private void connexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        mConn = DriverManager.getConnection("jdbc:h2:./h2_db/" + mNomDB + ";IGNORECASE=TRUE", "sa", "");
    }

    private void closeConnexion() throws SQLException {
        mConn.close();
    }

    /*Méthode générique pour les requêtes de manipulation 
     INSERT, UPDATE, DELETE ne nécessitant pas de récupérer
     un quelconque résultat */
    private boolean lancerManipulation(String query) throws ClassNotFoundException, SQLException {
        boolean res = true;
        //connexion a la bdd
        // on cree un objet Statement qui va permettre l'execution des requetes
        Statement s = mConn.createStatement();
        int cr = s.executeUpdate(query);
        if (cr <= 0) {
            res = false;
        }
        return res;
    }

    /*Méthode générique pour les requêtes d'interrogation 
     SELECT nécessitant de récupérer un résultat */
    private ResultSet lancerInterrogation(String query) throws ClassNotFoundException, SQLException {
        ResultSet res;
        // on cree un objet Statement qui va permettre l'execution des requetes
        Statement s = mConn.createStatement();
        res = s.executeQuery(query);

        return res;
    }
   
    @Override
    public boolean verifierEmpreinte(String empCollab, String matricule) throws EmpreinteInconnue {
        boolean lRes = false;
        try {
            connexion();
            ResultSet lRs;
            String lQuery = "SELECT COUNT(*) AS rowcount FROM empreinte "
                    + "WHERE matricule_utilisateur='" + matricule + "' "
                    + "and empreintecollab ='" + empCollab + "'; ";
            lRs = lancerInterrogation(lQuery);
            lRs.next();
            if (lRs.getInt("rowcount") > 0) {
                lRes = true;
            }
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new EmpreinteInconnue("Erreur vérification empreinte : l'utilisateur n'a pas enregistré d'empreinte");
        }

        return lRes;
    }

    @Override
    public void ajouterEmpreinte(String empCollab, String matricule) throws EmpreinteExistante {
        String lQuery = "insert into empreinte values (null, '"+ empCollab +"','"+ matricule +"')";
        try {
            connexion();
            if(lancerManipulation(lQuery)) {
                mAreaTextEvent.setText(mAreaTextEvent.getText()+"Empreinte ajoutée matricule "+matricule+"\n");
            } else {
                mAreaTextEvent.setText(mAreaTextEvent.getText()+"Impossible d'ajouter l'empreinte matricule "+matricule+"\n");
            }
            closeConnexion();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServiceEmpreinteImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new EmpreinteExistante("Erreur ajout empreinte : l'utilisateur a déjà ajouté une empreinte.");
        }
    }

    @Override
    public void modifierEmpreinte(String empCollab, String matricule) throws EmpreinteInconnue{
        String lQuery = "update empreinte set empreintecollab='"+ empCollab +"' where matricule_utilisateur='"+ matricule +"';";
        try {
            connexion();
            if(lancerManipulation(lQuery)) {
                mAreaTextEvent.setText(mAreaTextEvent.getText()+"Modification empreinte effectuée matricule "+matricule+"\n");
            } else {
                mAreaTextEvent.setText(mAreaTextEvent.getText()+"Impossible de modifier l'empreinte matricule "+matricule+"\n");
            }
            closeConnexion();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServiceEmpreinteImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new EmpreinteInconnue("Erreur modification empreinte : initialement, l'utilisateur ne dispose pas d'empreinte");
        }
    }
    
    @Override
    public void supprimerEmpreinteTemp(String matricule) throws EmpreinteInconnue {
        String lQuery = "delete from empreinte where matricule_utilisateur='"+ matricule +"';";
        try {
            connexion();
            if(lancerManipulation(lQuery)) {
                mAreaTextEvent.setText(mAreaTextEvent.getText()+"Suppression de l'empreinte du collaborateur temporaire matricule "+matricule+" effectuée\n");
            } else {
                mAreaTextEvent.setText(mAreaTextEvent.getText()+"Impossible de supprimer l'empreinte du collaborateur temporaire matricule "+matricule+"\n");
                throw new EmpreinteInconnue("Erreur suppression empreinte collaborateur temporaire : initialement, l'utilisateur ne dispose pas d'empreinte");
            }
            closeConnexion();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new EmpreinteInconnue("Erreur suppression empreinte collaborateur temporaire : initialement, l'utilisateur ne dispose pas d'empreinte");
        }
    }
    
    @Override
    public boolean verifierEmpreinteTempExistante(String matricule) {
        boolean lRes = false;
        ResultSet lRs;
        try {
            connexion();
            String lQuery = "SELECT COUNT(*) AS rowcount FROM empreinte "
                    + "WHERE matricule_utilisateur='" + matricule + "'; ";
            lRs = lancerInterrogation(lQuery);
            lRs.next();
            if (lRs.getInt("rowcount") > 0) {
                lRes = true;
            }
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceEmpreinteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lRes;
    }

    @Override
    public boolean verifierEmpreintePermExistante(String matricule) {
        boolean lRes = false;
           ResultSet lRs;
        try {
            connexion();
                String lQuery = "SELECT COUNT(*) AS rowcount FROM empreinte "
                        + "WHERE matricule_utilisateur='" + matricule + "'; ";
                lRs = lancerInterrogation(lQuery);
                lRs.next();
                if (lRs.getInt("rowcount") > 0) {
                    lRes = true;
                }
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceEmpreinteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lRes;
    }
       
    @Override
    public void run() {
       String[] args = null;
        // Intialisation de l'ORB
        //************************
        mOrb = org.omg.CORBA.ORB.init(args,null);

        // Gestion du POA
        //****************
        // Recuperation du POA
        
        try {
            mAreaTextEvent.setText(mAreaTextEvent.getText()+"Démarrage du service empreinte\n");
            mRootPOA = POAHelper.narrow(mOrb.resolve_initial_references("RootPOA"));
            // Creation du servant
            //*********************
           // ServiceAutorisationImpl serviceAuth = new ServiceAutorisationImpl();
            ServiceEmpreinteImpl mServiceEmp = this;

            // Activer le servant au sein du POA et recuperer son ID
            mServiceEmpId = mRootPOA.activate_object(mServiceEmp);

            // Activer le POA manager
            mRootPOA.the_POAManager().activate();


            // Enregistrement dans le service de nommage
            //*******************************************
            // Recuperation du naming service
            mNameRoot=Fonction.resolveNamingService(mOrb);

            // Construction du nom a enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            /*System.out.println("Sous quel nom voulez-vous enregistrer l'objet Corba ?");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String nomObj = in.readLine();*/
            
            nameToRegister[0] = new org.omg.CosNaming.NameComponent(mNomObj,"");

            // Enregistrement de l'objet CORBA dans le service de noms
            mNameRoot.rebind(nameToRegister,mRootPOA.servant_to_reference(mServiceEmp));
            System.out.println();
            mAreaTextEvent.setText(mAreaTextEvent.getText()+mNomObj+" est enregistre dans le service de noms\n");
            /*String IORServant = orb.object_to_string(rootPOA.servant_to_reference(monEuro));
            System.out.println("L'objet possede la reference suivante :");
            System.out.println(IORServant);*/

            // Lancement de l'ORB et mise en attente de requete
            //**************************************************
            mOrb.run();
            mAreaTextEvent.setText(mAreaTextEvent.getText()+"Fin du service empreinte\n");
        } catch (InvalidName | ServantAlreadyActive | WrongPolicy | AdapterInactive | NotFound | CannotProceed | org.omg.CORBA.ORBPackage.InvalidName | ServantNotActive ex) {
            Logger.getLogger(ServiceEmpreinteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stopServ()
    {
        mOrb.shutdown(true);
    }

    public byte[] getServiceEmpId() {
        return mServiceEmpId;
    }
}

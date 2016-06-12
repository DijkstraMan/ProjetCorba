/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empreinte;

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
import modEntreesSortiesZones.ServiceAuthentification;
import modEntreesSortiesZones.Utilisateur;
import modEntreesSortiesZones.UtilisateurInconnu;
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
    private static Connection mConn = null;
    private final String mNomDB;
    private static ServiceAuthentification mServAuth;

    public ServiceEmpreinteImpl(JTextArea a) {
        mNomObj = "SEMP";
        mAreaTextEvent = a;
        mNomDB = "bdEmpreinte";
    }

    private void connexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        mConn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Documents/ProjetCorba/h2_db/" + mNomDB + ";IGNORECASE=TRUE", "sa", "");
    }

    private void closeConnexion() throws SQLException {
        mConn.close();
    }

    /*Méthode générique pour les requêtes de manipulation 
     INSERT, UPDATE, DELETE ne nécessitant pas de récupérer
     un quelconque résultat */
    private boolean lancerManipulation(String query) throws ClassNotFoundException, SQLException, Exception {
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
            } else {
                throw new EmpreinteInconnue("Erreur: empreinte inconnue");
            }
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceEmpreinteImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                throw new EmpreinteInconnue("Erreur: empreinte déjà existante");
            }
            closeConnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpreinteImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceEmpreinteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierEmpreinte(String empCollab, String matricule) throws UtilisateurInconnu {
        String lQuery = "update empreinte set empreintecollab='"+ empCollab +"' where matricule_utilisateur='"+ matricule +"';";
        try {
            connexion();
            if(lancerManipulation(lQuery)) {
                mAreaTextEvent.setText(mAreaTextEvent.getText()+"Modification empreinte effectuée matricule "+matricule+"\n");
            } else {
                mAreaTextEvent.setText(mAreaTextEvent.getText()+"Impossible de modifier l'empreinte matricule "+matricule+"\n");
                throw new UtilisateurInconnu("Erreur: utilisateur inconnue");
            }
            closeConnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceEmpreinteImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceEmpreinteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void supprimerEmpreinteTemp(String matricule) throws EmpreinteInconnue {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean verifierEmpreinteTempExistante(String matricule) throws UtilisateurInconnu {
        boolean lRes = false;
           ResultSet lRs;
        try {
            connexion();
            if (collaborateurTemporaireExistant(matricule)) {
                String lQuery = "SELECT COUNT(*) AS rowcount FROM empreinte "
                        + "WHERE matricule_utilisateur='" + matricule + "'; ";
                lRs = lancerInterrogation(lQuery);
                lRs.next();
                if (lRs.getInt("rowcount") > 0) {
                    lRes = true;
                } else {
                    lRes = false;
                }
            } else {
                throw new UtilisateurInconnu("Erreur: collaborateur inconnu.");
            }
            closeConnexion();
        } catch (ClassNotFoundException | SQLException | NotFound | CannotProceed | InvalidName ex) {
            Logger.getLogger(ServiceEmpreinteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lRes;
    }

    @Override
    public boolean verifierEmpreintePermExistante(String matricule) throws UtilisateurInconnu {
        boolean lRes = false;
           ResultSet lRs;
        try {
            connexion();
            if (collaborateurPermanentExistant(matricule)) {
                String lQuery = "SELECT COUNT(*) AS rowcount FROM empreinte "
                        + "WHERE matricule_utilisateur='" + matricule + "'; ";
                lRs = lancerInterrogation(lQuery);
                lRs.next();
                if (lRs.getInt("rowcount") > 0) {
                    lRes = true;
                } else {
                    lRes = false;
                }
            } else {
                throw new UtilisateurInconnu("Erreur: collaborateur inconnu.");
            }

            closeConnexion();
        } catch (ClassNotFoundException | SQLException | NotFound | CannotProceed | InvalidName ex) {
            Logger.getLogger(ServiceEmpreinteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lRes;
    }
    
    private boolean collaborateurTemporaireExistant(String pMatriculeTemp) throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, UtilisateurInconnu {
        String idObj = "SAUTH";
        // Construction du nom à rechercher
        org.omg.CosNaming.NameComponent[] lNameToFind = new org.omg.CosNaming.NameComponent[1];
        lNameToFind[0] = new org.omg.CosNaming.NameComponent(idObj, "");
        // Recherche auprès du naming service
        org.omg.CORBA.Object lDistantSAuth = mNameRoot.resolve(lNameToFind);
        mAreaTextEvent.setText(mAreaTextEvent.getText() + "ServiceAuthentification '" + idObj + "' trouvé auprès du service de noms. IOR de l'objet : \n"
                + mOrb.object_to_string(lDistantSAuth) + "\n");
        // Casting de l'objet CORBA au type ServiceJournalisation
        mServAuth = modEntreesSortiesZones.ServiceAuthentificationHelper.narrow(lDistantSAuth);
        Utilisateur[] lLesCollabsTemp = mServAuth.getCollaborateursTemporaires();
        for (Utilisateur usr : lLesCollabsTemp) {
            if (usr.matricule.compareTo(pMatriculeTemp) == 0) {
                return true;
            }
        }
        return false;
    }
    
    private boolean collaborateurPermanentExistant(String pMatriculePerm) throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, UtilisateurInconnu {
        String idObj = "SAUTH";
        // Construction du nom à rechercher
        org.omg.CosNaming.NameComponent[] lNameToFind = new org.omg.CosNaming.NameComponent[1];
        lNameToFind[0] = new org.omg.CosNaming.NameComponent(idObj, "");
        // Recherche auprès du naming service
        org.omg.CORBA.Object lDistantSAuth = mNameRoot.resolve(lNameToFind);
        mAreaTextEvent.setText(mAreaTextEvent.getText() + "ServiceAuthentification '" + idObj + "' trouvé auprès du service de noms. IOR de l'objet : \n"
                + mOrb.object_to_string(lDistantSAuth) + "\n");
        // Casting de l'objet CORBA au type ServiceJournalisation
        mServAuth = modEntreesSortiesZones.ServiceAuthentificationHelper.narrow(lDistantSAuth);
        Utilisateur[] lLesCollabsPerm = mServAuth.getCollaborateursPermanents();
        for (Utilisateur usr : lLesCollabsPerm) {
            if (usr.matricule.compareTo(pMatriculePerm) == 0) {
                return true;
            }
        }
        return false;
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
            mNameRoot=org.omg.CosNaming.NamingContextHelper.narrow(mOrb.resolve_initial_references("NameService"));

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Journalisation;

import Util.Fonction;
import Util.TypeAccesFromString;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import modEntreesSortiesZones.LogAcces;
import modEntreesSortiesZones.ServiceJournalisationPOA;
import modEntreesSortiesZones.TypeAcces;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/**
 *
 * @author Fabien
 */
public class ServiceJournalisationImpl extends ServiceJournalisationPOA implements Runnable{

    private byte[] serviceAuthId;
    private org.omg.CORBA.ORB orb;
    private POA rootPOA;
    private NamingContext nameRoot;
    private final String nomObj;
    private final JTextArea areaTextEvent;
    private static Connection conn = null;
    
    public ServiceJournalisationImpl(JTextArea a) {
        nomObj="SJOUR";
        areaTextEvent=a;
    }
    
    private void connexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        //Connexion sur PC Bureau Fabien :
        //conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/D:/Documents/ProjetCorba/h2_db/bdlogAcces;IGNORECASE=TRUE", "sa", "");
        conn = DriverManager.getConnection("jdbc:h2:./h2_db/bdlogAcces;IGNORECASE=TRUE", "sa", "");
    }

    private void closeConnexion() throws SQLException {
        conn.close();
    }
    
    /*Méthode générique pour les requêtes de manipulation 
    INSERT, UPDATE, DELETE ne nécessitant pas de récupérer
    un quelconque résultat */
    private boolean lancerManipulation(String query) throws ClassNotFoundException, SQLException {
        boolean res = true;
        // on cree un objet Statement qui va permettre l'execution des requetes
        Statement s = conn.createStatement();
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
        Statement s = conn.createStatement();
        res = s.executeQuery(query);

        return res;
    }
    
    @Override
    public void ajouterEntree(String matricule, int idZone, String dateAcces, TypeAcces typeAcces) {
        String typeAccesStr = typeAcces.toString();
        String query = "insert into logAcces values ('"+ matricule +"',"+ idZone +",'"+ dateAcces +"','"+ typeAccesStr +"')";
        try {
            connexion();
            if(lancerManipulation(query))
                areaTextEvent.setText(areaTextEvent.getText()+"Accès ajouté: "+ typeAccesStr +"\n");
            else
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible d'ajouter l'accès: "+typeAccesStr+"\n");
            closeConnexion();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServiceJournalisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public LogAcces[] consulterAcces(int idZone) {
        areaTextEvent.setText(areaTextEvent.getText()+"Demande de la liste des accès\n"); 
        List<LogAcces> tabLogAcces= new ArrayList();
        try {
            String query = "SELECT matricule_utilisateur , dateAcces, acces "
                    + "from logAcces "
                    + "WHERE acces = 'autorise' "
                    + "and idZone_zone='"+idZone+"' "
                    + "order by dateAcces DESC";
            ResultSet rs;
            connexion();
            rs = lancerInterrogation(query);
            while(rs.next())
            {
                tabLogAcces.add(new LogAcces(rs.getString("matricule_utilisateur"), idZone, rs.getDate("dateAcces").toString(), TypeAccesFromString.parse(rs.getString("acces"))));           
            }
            closeConnexion();
            LogAcces[] lesLogAcces = new LogAcces[tabLogAcces.size()];
            lesLogAcces = tabLogAcces.toArray(lesLogAcces);
                    
            areaTextEvent.setText(areaTextEvent.getText()+"Listes des accès envoyée\n");
            return lesLogAcces;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceJournalisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public LogAcces[] consulterTousAcces() {
        areaTextEvent.setText(areaTextEvent.getText()+"Demande de la liste des accès\n"); 
        List<LogAcces> tabLogAcces= new ArrayList();
        try {
            String query = "SELECT matricule_utilisateur, idZone_zone, dateAcces, acces "
                    + "from logAcces "
                    + "WHERE acces = 'autorise' "
                    + "order by dateAcces DESC";
            ResultSet rs;
            connexion();
            rs = lancerInterrogation(query);
            while(rs.next())
            {
                tabLogAcces.add(new LogAcces(rs.getString("matricule_utilisateur"), rs.getInt("idZone_zone"), rs.getDate("dateAcces").toString(), TypeAccesFromString.parse(rs.getString("acces"))));           
            }
            closeConnexion();
            LogAcces[] lesLogAcces = new LogAcces[tabLogAcces.size()];
            lesLogAcces = tabLogAcces.toArray(lesLogAcces);
                    
            areaTextEvent.setText(areaTextEvent.getText()+"Listes des accès envoyée\n");
            return lesLogAcces;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceJournalisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public LogAcces[] consulterRefus(int idZone) {
        areaTextEvent.setText(areaTextEvent.getText()+"Demande de la liste des refus\n"); 
        List<LogAcces> tabLogAcces= new ArrayList();
        try {
            String query = "SELECT matricule_utilisateur, dateAcces, acces "
                    + "from logAcces "
                    + "WHERE acces != 'autorise' "
                    + "and idZone_zone='"+idZone+"' "
                    + "order by dateAcces DESC";
            ResultSet rs;
            connexion();
            rs = lancerInterrogation(query);
            while(rs.next())
            {
                tabLogAcces.add(new LogAcces(rs.getString("matricule_utilisateur"), idZone, rs.getDate("dateAcces").toString(), TypeAccesFromString.parse(rs.getString("acces"))));           
            }
            closeConnexion();
            LogAcces[] lesLogAcces = new LogAcces[tabLogAcces.size()];
            lesLogAcces = tabLogAcces.toArray(lesLogAcces);
                    
            areaTextEvent.setText(areaTextEvent.getText()+"Listes des refus envoyée\n");
            return lesLogAcces;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceJournalisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public LogAcces[] consulterTousRefus() {
        areaTextEvent.setText(areaTextEvent.getText()+"Demande de la liste des refus\n"); 
        List<LogAcces> tabLogAcces= new ArrayList();
        try {
            String query = "SELECT matricule_utilisateur, idZone_zone, dateAcces, acces "
                    + "from logAcces "
                    + "WHERE acces != 'autorise' "
                    + "order by dateAcces DESC";
            ResultSet rs;
            connexion();
            rs = lancerInterrogation(query);
            while(rs.next())
            {
                tabLogAcces.add(new LogAcces(rs.getString("matricule_utilisateur"), rs.getInt("idZone_zone"), rs.getDate("dateAcces").toString(), TypeAccesFromString.parse(rs.getString("acces"))));           
            }
            closeConnexion();
            LogAcces[] lesLogAcces = new LogAcces[tabLogAcces.size()];
            lesLogAcces = tabLogAcces.toArray(lesLogAcces);
                    
            areaTextEvent.setText(areaTextEvent.getText()+"Listes des refus envoyée\n");
            return lesLogAcces;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceJournalisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void run() {
        String[] args = null;
        
        try {
            areaTextEvent.setText(areaTextEvent.getText()+"Démarrage du ServiceJournalisation...\n");
            // Intialisation de l'ORB
            orb = org.omg.CORBA.ORB.init(args,null);
            // Recuperation du POA
            rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            // Creation du servant
            ServiceJournalisationImpl serviceJour = this;
            // Activer le servant au sein du POA et recuperer son ID
            serviceAuthId = rootPOA.activate_object(serviceJour);
            // Activer le POA manager
            rootPOA.the_POAManager().activate();
            // Enregistrement dans le service de nommage
            //*******************************************
            // Recuperation du naming service
            nameRoot=Fonction.resolveNamingService(orb);
           
            // Construction du nom a enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj,"");
            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(serviceJour));
            // Lancement de l'ORB et mise en attente de requete
            areaTextEvent.setText(areaTextEvent.getText()+"Lancement de l'ORB : en attente de requêtes !\n");
            orb.run();
        } catch (InvalidName | ServantAlreadyActive | WrongPolicy | AdapterInactive | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | ServantNotActive ex) {
            Logger.getLogger(ServiceJournalisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stopServ()
    {
        areaTextEvent.setText(areaTextEvent.getText()+"Arrêt de '" + nomObj + "'\n");
        orb.shutdown(true);       
    }

    public byte[] getServiceAuthId() {
        return serviceAuthId;
    } 

   
}

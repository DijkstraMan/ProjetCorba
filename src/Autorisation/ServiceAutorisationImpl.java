/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Autorisation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import modEntreesSortiesZones.AutorisationExistante;
import modEntreesSortiesZones.AutorisationInconnue;
import modEntreesSortiesZones.ServiceAutorisationPOA;
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
 * @author Nico
 */
public class ServiceAutorisationImpl extends ServiceAutorisationPOA implements Runnable{

    private byte[] serviceAuthId;
    private org.omg.CORBA.ORB orb;
    private POA rootPOA;
    private NamingContext nameRoot;
    private final String nomObj;
    private final JTextArea areaTextEvent;
    private static Connection conn = null;
    private final String nomDB;
    
    public ServiceAutorisationImpl(JTextArea a) {
        nomObj="SAUTH";
        areaTextEvent=a;
        nomDB="bdZone";
    }
    
    public void connexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Documents/ProjetCorba/h2_db/"+nomDB+";IGNORECASE=TRUE", "sa", "");
    }

    public void closeConnexion() throws SQLException {
        conn.close();
    }
    
    /*Méthode générique pour les requêtes de manipulation 
    INSERT, UPDATE, DELETE ne nécessitant pas de récupérer
    un quelconque résultat */
    public boolean lancerManipulation(String query) throws ClassNotFoundException, SQLException, Exception {
        boolean res = true;

        //connexion a la bdd
        connexion();
        // on cree un objet Statement qui va permettre l'execution des requetes
        Statement s = conn.createStatement();
        int cr = s.executeUpdate(query);
        if (cr <= 0) {
            res = false;
        }
        closeConnexion();
        return res;
    }

    /*Méthode générique pour les requêtes d'interrogation 
    SELECT nécessitant de récupérer un résultat */
    public ResultSet lancerInterrogation(String query) throws ClassNotFoundException, SQLException {
        ResultSet res;

        //connexion a la bdd
        connexion();
        // on cree un objet Statement qui va permettre l'execution des requetes
        Statement s = conn.createStatement();
        res = s.executeQuery(query);

        return res;
    }
    
    @Override
    public boolean verifierAutorisation(String m, String n) throws AutorisationInconnue {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void ajouterAutorisationTemp(String m, String n, String jD, String jF) throws AutorisationExistante {
        DateFormat formatFR = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        DateFormat formatSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String dateDebut= formatSQL.format(formatFR.parse(jD));
            String dateFin= formatSQL.format(formatFR.parse(jF));
            String query = "insert into autorisationTemp values ('"+ m +"','"+ n +"','"+ dateDebut +"','"+ dateFin +"')";
           
            if(lancerManipulation(query))
                areaTextEvent.setText(areaTextEvent.getText()+"Autorisation temporaire ajouté matricule"+n+"\n");
            else
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible d'ajouté l'autorisation temporaire matricule"+n+"\n");
           
        } catch (ParseException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierAutorisationTemp(String m, String n, String jD, String jF) throws AutorisationInconnue {
        DateFormat formatFR = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        DateFormat formatSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String dateDebut= formatSQL.format(formatFR.parse(jD));
            String dateFin= formatSQL.format(formatFR.parse(jF));
            String query = "update autorisationTemp set jourDebut='"+ jD +"', jourFin='"+ dateDebut +"' where matricule_utilisateur='"+ m +"' and idZone ='"+ n +"'";
           
            if(lancerManipulation(query))
                areaTextEvent.setText(areaTextEvent.getText()+"Modification temporaire ajouté matricule"+m+" zone"+m+"\n");
            else
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible d'ajouté l'autorisation temporaire matricule"+m+" zone"+m+"\n");
           
        } catch (ParseException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ajouterAutorisationPerm(String m, String n, int hD, int hF) throws AutorisationExistante {
        String query = "insert into autorisation values ('"+ m +"','"+ n +"','"+ hD +"','"+ hF +"')";
        try {
            if(lancerManipulation(query))
                areaTextEvent.setText(areaTextEvent.getText()+"Autorisation permanente ajouté matricule"+m+" zone"+n+"\n");
            else
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible d'ajouté l'autorisation permanente matricule"+m+" zone"+m+"\n");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierAutorisationPerm(String m, String n, int hD, int hF) throws AutorisationInconnue {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerAutorisation(String m, String n) throws AutorisationInconnue {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
       String[] args = null;
        // Intialisation de l'ORB
        //************************
        orb = org.omg.CORBA.ORB.init(args,null);

        // Gestion du POA
        //****************
        // Recuperation du POA
        
        try {
            areaTextEvent.setText(areaTextEvent.getText()+"Démarrage du serveur\n");
            rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            // Creation du servant
            //*********************
           // ServiceAutorisationImpl serviceAuth = new ServiceAutorisationImpl();
            ServiceAutorisationImpl serviceAuth = this;

            // Activer le servant au sein du POA et recuperer son ID
            serviceAuthId = rootPOA.activate_object(serviceAuth);

            // Activer le POA manager
            rootPOA.the_POAManager().activate();


            // Enregistrement dans le service de nommage
            //*******************************************
            // Recuperation du naming service
            nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

            // Construction du nom a enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            /*System.out.println("Sous quel nom voulez-vous enregistrer l'objet Corba ?");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String nomObj = in.readLine();*/
            
            nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj,"");

            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(serviceAuth));
            System.out.println();
            areaTextEvent.setText(areaTextEvent.getText()+nomObj+" est enregistre dans le service de noms\n");
            /*String IORServant = orb.object_to_string(rootPOA.servant_to_reference(monEuro));
            System.out.println("L'objet possede la reference suivante :");
            System.out.println(IORServant);*/

            // Lancement de l'ORB et mise en attente de requete
            //**************************************************
            orb.run();
            ajouterAutorisationTemp("mm", "2", "02/04/2006 15:03", "02/04/2007 16h05");
            areaTextEvent.setText(areaTextEvent.getText()+"Fin du serv\n");
        } catch (InvalidName | ServantAlreadyActive | WrongPolicy | AdapterInactive | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | ServantNotActive ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AutorisationExistante ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stopServ()
    {
        orb.shutdown(true);
    }

    public byte[] getServiceAuthId() {
        return serviceAuthId;
    }
}

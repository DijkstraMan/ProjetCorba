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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import modEntreesSortiesZones.AutorisationExistante;
import modEntreesSortiesZones.AutorisationInconnue;
import modEntreesSortiesZones.ServiceAutorisationPOA;
import modEntreesSortiesZones.Zone;
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
        nomObj="SAUTO";
        areaTextEvent=a;
        nomDB="bdZone";
    }
    
    private void connexion() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Documents/ProjetCorba/h2_db/"+nomDB+";IGNORECASE=TRUE", "sa", "");
    }

    private void closeConnexion() throws SQLException {
        conn.close();
    }
    
    /*Méthode générique pour les requêtes de manipulation 
    INSERT, UPDATE, DELETE ne nécessitant pas de récupérer
    un quelconque résultat */
    private boolean lancerManipulation(String query) throws ClassNotFoundException, SQLException {
        boolean res = true;
        //connexion a la bdd
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
    
    private boolean verifierAutorisationPerm(String matricule,int idZone)
    {
        boolean res = false;
        try {
            int hr=(LocalDateTime.now().getHour()*10)+LocalDateTime.now().getMinute();
            String query = "SELECT COUNT(*) AS rowcount FROM autorisation "
                    + "WHERE matricule_utilisateur='"+ matricule +"' "
                    + "and idZone ='"+ idZone +"' "
                    + "and heureDebut>='"+ hr +"'"
                    + "and heureFin<='"+ hr +"'";
            ResultSet rs;
            rs = lancerInterrogation(query);
            rs.next();
            if (rs.getInt("rowcount") > 0) {
                res = true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    private boolean verifierAutorisationTemp(String matricule,int idZone)
    {
               
        boolean res = false;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String query = "SELECT COUNT(*) AS rowcount FROM autorisationTemp "
                    + "WHERE matricule_utilisateur='"+ matricule +"' "
                    + "and idZone ='"+ idZone +"' "
                    + "and jourDebut>='"+ dateFormat +"'"
                    + "and jourFin<='"+ dateFormat +"'";
            ResultSet rs;
            rs = lancerInterrogation(query);
            rs.next();
            if (rs.getInt("rowcount") > 0) {
                res = true;
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    @Override
    public boolean verifierAutorisation(String matricule, int idZone) throws AutorisationInconnue {
        boolean res = false;
        try {
            connexion();
            if(verifierAutorisationPerm(matricule, idZone) || verifierAutorisationTemp(matricule, idZone))
                res = true;
            closeConnexion();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    @Override
    public void ajouterAutorisationTemp(String matricule, int idZone, String jrDebut, String jrFin) throws AutorisationExistante {
        
        DateFormat formatFR = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        DateFormat formatSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String dateDebut= formatSQL.format(formatFR.parse(jrDebut));
            String dateFin= formatSQL.format(formatFR.parse(jrFin));
            String query = "insert into autorisationTemp values ('"+ matricule +"','"+ idZone +"','"+ dateDebut +"','"+ dateFin +"')";
            //connexion à la bd
            connexion();
            if(lancerManipulation(query))
                areaTextEvent.setText(areaTextEvent.getText()+"Autorisation temporaire ajouté matricule "+matricule+" zone "+idZone+"\n");
            else
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible d'ajouté l'autorisation temporaire matricule "+matricule+" zone "+idZone+"\n");
            closeConnexion();
        } catch (ParseException | SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public Zone[] getZone(){
        areaTextEvent.setText(areaTextEvent.getText()+"Demande de la liste des zones\n"); 
        List<Zone> tabZone= new ArrayList();
        try {
            String query = "SELECT idZone, nomZone from gZone order by idZone";
            ResultSet rs;
            connexion();
            rs = lancerInterrogation(query);
            while(rs.next())
            {
                tabZone.add(new Zone(rs.getInt("idZone"), rs.getString("nomZone")));           
            }
            closeConnexion();
            Zone[] lesZones = new Zone[tabZone.size()];
            lesZones = tabZone.toArray(lesZones);
                    
            areaTextEvent.setText(areaTextEvent.getText()+"Listes des zones envoyé\n");
            return lesZones;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void modifierAutorisationTemp(String matricule, int idZone, String jrDebut, String jrFin) throws AutorisationInconnue {
        DateFormat formatFR = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        DateFormat formatSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String dateDebut= formatSQL.format(formatFR.parse(jrDebut));
            String dateFin= formatSQL.format(formatFR.parse(jrFin));
            String query = "update autorisationTemp set jourDebut='"+ dateDebut +"', jourFin='"+ dateFin +"' where matricule_utilisateur='"+ matricule +"' and idZone ='"+ idZone +"'";
            connexion();
            if(lancerManipulation(query))
                areaTextEvent.setText(areaTextEvent.getText()+"Modification temporaire effectué matricule "+matricule+" zone "+idZone+"\n");
            else
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible de modifier l'autorisation temporaire matricule "+matricule+" zone "+idZone+"\n");
            closeConnexion();
        } catch (ParseException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }

    @Override
    public void ajouterAutorisationPerm(String matricule, int idZone, int hrDebut, int hrFin) throws AutorisationExistante {
        String query = "insert into autorisation values ('"+ matricule +"','"+ idZone +"','"+ hrDebut +"','"+ hrFin +"')";
        try {
            connexion();
            if(lancerManipulation(query))
                areaTextEvent.setText(areaTextEvent.getText()+"Autorisation permanente ajouté matricule "+matricule+" zone "+idZone+"\n");
            else
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible d'ajouté l'autorisation permanente matricule "+matricule+" zone "+idZone+"\n");
            closeConnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierAutorisationPerm(String matricule, int idZone, int hrDebut, int hrFin) throws AutorisationInconnue {
        String query = "update autorisationTemp set heureDebut='"+ hrDebut +"', heureFin='"+ hrFin +"' where matricule_utilisateur='"+ matricule +"' and idZone ='"+ idZone +"'";
        try {
            connexion();
            if(lancerManipulation(query))
                areaTextEvent.setText(areaTextEvent.getText()+"Modification permanente ajouté effectué matricule "+matricule+" zone "+idZone+"\n");
            else
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible de modifier l'autorisation permanente matricule "+matricule+" zone "+idZone+"\n");
            closeConnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerAutorisation(String matricule, int idZone) throws AutorisationInconnue {
        String query = "delete from autorisation where matricule_utilisateur='"+ matricule +"' and idZone ='"+ idZone +"'";
        String query2 = "delete from autorisationTemp where matricule_utilisateur='"+ matricule +"' and idZone ='"+ idZone +"'";
        try {
            connexion();
            if(lancerManipulation(query) && lancerManipulation(query2))
                areaTextEvent.setText(areaTextEvent.getText()+"Suppression de l'autorisation effectué matricule "+matricule+" zone "+idZone+"\n");
            else
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible de modifier l'autorisation permanente matricule "+matricule+" zone "+idZone+"\n");
            closeConnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            areaTextEvent.setText(areaTextEvent.getText()+"Fin du serv\n");
        } catch (InvalidName | ServantAlreadyActive | WrongPolicy | AdapterInactive | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | ServantNotActive ex) {
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Journalisation;

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
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;

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
        conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Documents/ProjetCorba/h2_db/bdlogAcces;IGNORECASE=TRUE", "sa", "");
    }

    private void closeConnexion() throws SQLException {
        conn.close();
    }
    
    /*Méthode générique pour les requêtes de manipulation 
    INSERT, UPDATE, DELETE ne nécessitant pas de récupérer
    un quelconque résultat */
    private boolean lancerManipulation(String query) throws ClassNotFoundException, SQLException, Exception {
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
        } catch (SQLException ex) {
            Logger.getLogger(ServiceJournalisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceJournalisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public LogAcces[] consulterAcces() {
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
    public LogAcces[] consulterRefus() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentification;

import Autorisation.ServiceAutorisationImpl;
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
import modEntreesSortiesZones.EmpreinteInconnue;
import modEntreesSortiesZones.ServiceAuthentificationPOA;
import modEntreesSortiesZones.ServiceEmpreinte;
import modEntreesSortiesZones.Utilisateur;
import modEntreesSortiesZones.UtilisateurExistant;
import modEntreesSortiesZones.UtilisateurInconnu;
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
public class ServiceAuthentificationImpl extends ServiceAuthentificationPOA implements Runnable{

    private byte[] serviceAuthId;
    private org.omg.CORBA.ORB orb;
    private POA rootPOA;
    private NamingContext nameRoot;
    private final String nomObj;
    private final JTextArea areaTextEvent;
    private static Connection conn = null;
    private static ServiceEmpreinte monServEmp;
    
    public ServiceAuthentificationImpl(JTextArea a) {
        nomObj="SAUTH";
        areaTextEvent=a;
    }
    
    private void connexion(String typeCollab) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/Documents/ProjetCorba/h2_db/bdcollab"+typeCollab+";IGNORECASE=TRUE", "sa", "");
    }

    private void closeConnexion() throws SQLException {
        conn.close();
    }
    
    /*Méthode générique pour les requêtes de manipulation 
    INSERT, UPDATE, DELETE ne nécessitant pas de récupérer
    un quelconque résultat */
    private boolean lancerManipulation(String query) throws ClassNotFoundException, SQLException, Exception {
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

    //Méthode utilisée pour récupérer l'objet ServiceEmpreinte distant et appeler sa méthode verifierEmpreinte
    private boolean lancerVerifierEmpreinte(String empCollab, String matricule) throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, EmpreinteInconnue {
        String idObj = "SEMP";
        // Construction du nom à rechercher
        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
        nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");
        // Recherche auprès du naming service
        org.omg.CORBA.Object distantSEmp = nameRoot.resolve(nameToFind);
        areaTextEvent.setText(areaTextEvent.getText()+"ServiceEmpreinte '" + idObj + "' trouvé auprès du service de noms. IOR de l'objet : \n"
                                +orb.object_to_string(distantSEmp)+"\n");
        // Casting de l'objet CORBA au type ServiceEmpreinte
        monServEmp = modEntreesSortiesZones.ServiceEmpreinteHelper.narrow(distantSEmp);   
        //Finalement, on vérifie l'empreinte
        return monServEmp.verifierEmpreinte(empCollab, matricule);
    }
    
    @Override
    public Utilisateur getUtilisateur(String matricule) throws UtilisateurInconnu {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilisateur[] getCollaborateursTemporaires() {
        areaTextEvent.setText(areaTextEvent.getText()+"Demande de la liste des collaborateurs temporaires\n"); 
        List<Utilisateur> tabUtilisateurs= new ArrayList();
        try {
            String query = "SELECT u.matricule AS matricule, u.nomUrs AS nomUsr, u.prenomUsr AS prenomUsr, u.photoUsr AS photoUsr "
                    + "from utilisateur u, collaborateurTemp c "
                    + "WHERE u.matricule = c.matricule_utilisateur "
                    + "order by u.matricule";
            ResultSet rs;
            connexion("Temp");
            rs = lancerInterrogation(query);
            while(rs.next())
            {
                tabUtilisateurs.add(new Utilisateur(rs.getString("matricule"), rs.getString("nomUsr"), rs.getString("prenomUsr"), rs.getString("photoUsr")));           
            }
            closeConnexion();
            Utilisateur[] lesUtilisateurs = new Utilisateur[tabUtilisateurs.size()];
            lesUtilisateurs = tabUtilisateurs.toArray(lesUtilisateurs);
                    
            areaTextEvent.setText(areaTextEvent.getText()+"Listes des collaborateurs temporaires envoyée\n");
            return lesUtilisateurs;
        } catch (ClassNotFoundException | SQLException ex) {
            return new Utilisateur[0];
        }
    }

    @Override
    public Utilisateur[] getCollaborateursPermanents() {
        areaTextEvent.setText(areaTextEvent.getText()+"Demande de la liste des collaborateurs permanents\n"); 
        List<Utilisateur> tabUtilisateurs= new ArrayList();
        try {
            String query = "SELECT u.matricule AS matricule, u.nomUrs AS nomUsr, u.prenomUsr AS prenomUsr, u.photoUsr AS photoUsr "
                    + "from utilisateur u, collaborateurPerm c "
                    + "WHERE u.matricule = c.matricule_utilisateur "
                    + "order by u.matricule";
            ResultSet rs;
            connexion("Perm");
            rs = lancerInterrogation(query);
            while(rs.next())
            {
                tabUtilisateurs.add(new Utilisateur(rs.getString("matricule"), rs.getString("nomUsr"), rs.getString("prenomUsr"), rs.getString("photoUsr")));           
            }
            closeConnexion();
            Utilisateur[] lesUtilisateurs = new Utilisateur[tabUtilisateurs.size()];
            lesUtilisateurs = tabUtilisateurs.toArray(lesUtilisateurs);
                    
            areaTextEvent.setText(areaTextEvent.getText()+"Listes des collaborateurs permanents envoyée\n");
            return lesUtilisateurs;
        } catch (ClassNotFoundException | SQLException ex) {
            return new Utilisateur[0];
        } 
    }

    @Override
    public String verifierAuthentificationPorte(String empCollab, String phoUsr) throws UtilisateurInconnu, EmpreinteInconnue {
        String nomUsr = null;
        String matricule = null;
        String query = "SELECT matricule, nomUrs FROM utilisateur "
                    + "WHERE photoUsr='"+ phoUsr +"'";
        ResultSet rs;
        try {
            /*On tente de chercher dans la basePerm 
            (on commence par celle-ci en partant du principe 
            que la plupart des scans d'empreintes/visages sont faits par des collabPerm...)*/
            connexion("Perm");
            rs = lancerInterrogation(query);
            rs.next();
            nomUsr = rs.getString("nomUrs");
            matricule = rs.getString("matricule");
            if (matricule != null ) {
                // Matricule => OK => Vérifier empreinte auprès du serviceEmpreinte : 
                // /!\ DECOMMENTER CETTE LIGNE NECESSITE DE DECOMMENTER LES CATCH !
                //lancerVerifierEmpreinte(empCollab, matricule);
            }
            else {
                //On tente de chercher dans la baseTemp
                closeConnexion();
                connexion("Temp");
                rs = lancerInterrogation(query);
                rs.next();
                nomUsr = rs.getString("nomUrs");
                matricule = rs.getString("matricule");
                if (matricule != null ) {
                    // Matricule => OK => Vérifier empreinte auprès du serviceEmpreinte : 
                    // /!\ DECOMMENTER CETTE LIGNE NECESSITE DE DECOMMENTER LES CATCH !
                    //lancerVerifierEmpreinte(empCollab, matricule);
                }
                else {
                    //TODO : connexion service Journalisation => typeAcces = "nonAthentifie"
                    //Exception à catcher côté client scanneur d'empreinte :
                    throw new UtilisateurInconnu("Erreur: l'utilisateur n'existe pas dans nos bases de données.");
                }    
            }
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } /*catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmpreinteInconnue ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
            //On "retourne" l'exception pour le client :
            throw new EmpreinteInconnue("Erreur: l'utilisateur est reconnu, mais pas son empreinte.");
        }*/
        return nomUsr;
    }

    @Override
    public boolean verifierAuthentificationLogicielResp(String matricule, String pwd) throws UtilisateurInconnu {
        String query = "SELECT COUNT(*) AS rowcount FROM responsableZone "
                        + "WHERE idCollabPerm_collaborateurPerm = "
                        + "(SELECT idCollabPerm FROM collaborateurPerm "
                        + " WHERE matricule_utilisateur='"+ matricule +"' "
                        + " AND passwordPerm='"+ pwd +"' )";
        int rowcount;
        ResultSet rs;
        boolean res = false;
        try {
            connexion("Perm");
            rs = lancerInterrogation(query);
            rs.next();
            rowcount = rs.getInt("rowcount");
            if (rowcount > 0 )
                res = true;
            else 
                throw new UtilisateurInconnu("Erreur: utilisateur inconnu.");
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean verifierAuthentificationLogicielRH(String matricule, String pwd) throws UtilisateurInconnu {
        String query = "SELECT COUNT(*) AS rowcount FROM personnelRH "
                        + "WHERE idGestionCollab_gestionCollaborateur = "
                        + " (SELECT idGestionCollab FROM gestionCollaborateur "
                        + "  WHERE idCollabPerm_collaborateurPerm= "
                        + "     (SELECT idCollabPerm FROM collaborateurPerm "
                        + "      WHERE matricule_utilisateur='"+ matricule +"' "
                        + "      AND passwordPerm='"+ pwd +"' ))";
        int rowcount;
        ResultSet rs;
        boolean res = false;
        try {
            connexion("Perm");
            rs = lancerInterrogation(query);
            rs.next();
            rowcount = rs.getInt("rowcount");
            if (rowcount > 0 )
                res = true;
            else 
                throw new UtilisateurInconnu("Erreur: utilisateur inconnu.");
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new UtilisateurInconnu("Erreur: utilisateur inconnu.\n" + ex.getMessage());
        }
        return res;
    }

    @Override
    public boolean verifierAuthentificationLogicielAccueil(String matricule, String pwd) throws UtilisateurInconnu {
        String query = "SELECT COUNT(*) AS rowcount FROM personnelAccueil "
                        + "WHERE idGestionCollab_gestionCollaborateur = "
                        + " (SELECT idGestionCollab FROM gestionCollaborateur "
                        + "  WHERE idCollabPerm_collaborateurPerm= "
                        + "     (SELECT idCollabPerm FROM collaborateurPerm "
                        + "      WHERE matricule_utilisateur='"+ matricule +"' "
                        + "      AND passwordPerm='"+ pwd +"' ))";
        int rowcount;
        ResultSet rs;
        boolean res = false;
        try {
            connexion("Perm");
            rs = lancerInterrogation(query);
            rs.next();
            rowcount = rs.getInt("rowcount");
            if (rowcount > 0 )
                res = true;
            else 
                throw new UtilisateurInconnu("Erreur: utilisateur inconnu.");
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public void ajouterCollaborateurTemp(String matricule, String nomUsr, String preUsr, String phoUsr) throws UtilisateurExistant {
        String queryUsr = "insert into utilisateur values ('"+ matricule +"','"+ nomUsr +"','"+ preUsr +"','"+ phoUsr +"')";
        String queryCollab = "insert into collaborateurTemp values ('"+ matricule +"')";
        try {
            connexion("Temp");
            if(lancerManipulation(queryUsr)){
                areaTextEvent.setText(areaTextEvent.getText()+"Utilisateur temporaire ajouté avec matricule: "+matricule+"\n");
                if(lancerManipulation(queryCollab))
                    areaTextEvent.setText(areaTextEvent.getText()+"Collaborateur temporaire ajouté avec matricule: "+matricule+"\n");
                else
                    areaTextEvent.setText(areaTextEvent.getText()+"Impossible d'ajouter le collaborateur temporaire avec matricule: "+matricule+"\n");
            }
            else
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible d'ajouter l'utilisateur temporaire avec matricule: "+matricule+"\n");
            closeConnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ajouterCollaborateurPerm(String matricule, String nomUsr, String preUsr, String phoUsr, String pwd) throws UtilisateurExistant {
        String queryUsr = "insert into utilisateur values ('"+ matricule +"','"+ nomUsr +"','"+ preUsr +"','"+ phoUsr +"')";
        String queryCollab = "insert into collaborateurPerm values ('"+ matricule +"','"+ pwd +"')";
        try {
            connexion("Perm");
            if(lancerManipulation(queryUsr)){
                areaTextEvent.setText(areaTextEvent.getText()+"Utilisateur permanent ajouté avec matricule: "+matricule+"\n");
                if(lancerManipulation(queryCollab))
                    areaTextEvent.setText(areaTextEvent.getText()+"Collaborateur permanent ajouté avec matricule: "+matricule+"\n");
                else
                    areaTextEvent.setText(areaTextEvent.getText()+"Impossible d'ajouter le collaborateur permanent avec matricule: "+matricule+"\n");
            }
            else
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible d'ajouter l'utilisateur permanent avec matricule: "+matricule+"\n");
            closeConnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void modifierUtilisateurTemp(String matricule, String nomUsr, String preUsr, String phoUsr) throws UtilisateurInconnu {
        String query = "update utilisateur set nomUrs='"+ nomUsr +"', prenomUsr='"+ preUsr +"', photoUsr='"+ phoUsr +"' where matricule='"+ matricule +"'";
        try {
            connexion("Temp");
            if(lancerManipulation(query))
                areaTextEvent.setText(areaTextEvent.getText()+"Modification effectuée pour l'utilisateur temporaire au matricule: "+matricule+"\n");
            else {
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible de modifier l'utilisateur temporaire au matricule: "+matricule+"\n");
                throw new UtilisateurInconnu("Erreur: ce collaborateur temporaire n'existe pas dans nos bases de données."); 
            }
            closeConnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void modifierUtilisateurPerm(String matricule, String nomUsr, String preUsr, String phoUsr) throws UtilisateurInconnu {
        String query = "update utilisateur set nomUrs='"+ nomUsr +"', prenomUsr='"+ preUsr +"', photoUsr='"+ phoUsr +"' where matricule='"+ matricule +"'";
        try {
            connexion("Perm");
            if(lancerManipulation(query))
                areaTextEvent.setText(areaTextEvent.getText()+"Modification effectuée pour l'utilisateur permanent au matricule: "+matricule+"\n");
            else {
                areaTextEvent.setText(areaTextEvent.getText()+"Impossible de modifier l'utilisateur permanent au matricule: "+matricule+"\n");
                throw new UtilisateurInconnu("Erreur: ce collaborateur permanent n'existe pas dans nos bases de données.");  
            }
            closeConnexion();
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        String[] args = null;
        
        try {
            areaTextEvent.setText(areaTextEvent.getText()+"Démarrage du ServiceAuthentification...\n");
            // Intialisation de l'ORB
            //************************
            areaTextEvent.setText(areaTextEvent.getText()+"Initialisation de l'ORB...\n");
            orb = org.omg.CORBA.ORB.init(args,null);
            areaTextEvent.setText(areaTextEvent.getText()+"ORB initialisé!\n");
            // Gestion du POA
            //****************
            // Recuperation du POA
            areaTextEvent.setText(areaTextEvent.getText()+"Récupération du POA...\n");
            rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            areaTextEvent.setText(areaTextEvent.getText()+"POA récupéré!\n");
            // Creation du servant
            //*********************
            ServiceAuthentificationImpl serviceAuth = this;

            // Activer le servant au sein du POA et recuperer son ID
            areaTextEvent.setText(areaTextEvent.getText()+"Activation du servant au sein du POA et récupération de son ID...\n");
            serviceAuthId = rootPOA.activate_object(serviceAuth);
            areaTextEvent.setText(areaTextEvent.getText()+"Servant activé avec ID : '" + serviceAuthId + "'\n");
            // Activer le POA manager
            areaTextEvent.setText(areaTextEvent.getText()+"Activation du POA manager...\n");
            rootPOA.the_POAManager().activate();
            areaTextEvent.setText(areaTextEvent.getText()+"POA manager activé!\n");

            // Enregistrement dans le service de nommage
            //*******************************************
            // Recuperation du naming service
            areaTextEvent.setText(areaTextEvent.getText()+"Récupération du NamingService...\n");
            nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            areaTextEvent.setText(areaTextEvent.getText()+"NamingService récupéré!\n");
            
            // Construction du nom a enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj,"");

            // Enregistrement de l'objet CORBA dans le service de noms
            areaTextEvent.setText(areaTextEvent.getText()+"Enregistrement de l'objet CORBA dans le service de nom...\n");
            nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(serviceAuth));
            areaTextEvent.setText(areaTextEvent.getText()+nomObj+" est enregistre dans le service de noms\n");
            String IORServant = orb.object_to_string(rootPOA.servant_to_reference(serviceAuth));
            areaTextEvent.setText(areaTextEvent.getText()+"L'objet possede la reference suivante :\n");
            areaTextEvent.setText(areaTextEvent.getText()+IORServant+"\n");

            // Lancement de l'ORB et mise en attente de requete
            //**************************************************
            orb.run();
            
        } catch (InvalidName | ServantAlreadyActive | WrongPolicy | AdapterInactive | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | ServantNotActive ex) {
            Logger.getLogger(ServiceAutorisationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void stopServ()
    {
        areaTextEvent.setText(areaTextEvent.getText()+"Fin de '" + nomObj + "'\n");
        orb.shutdown(true);       
    }

    public byte[] getServiceAuthId() {
        return serviceAuthId;
    }
}
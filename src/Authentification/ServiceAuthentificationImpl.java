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
    public Utilisateur[] getUtilisateurs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            ServiceAuthentificationImpl serviceAuth = this;

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
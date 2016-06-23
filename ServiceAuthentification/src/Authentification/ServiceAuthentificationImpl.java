/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentification;

import Util.Fonction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import modEntreesSortiesZones.EmpreinteInconnue;
import modEntreesSortiesZones.ServiceAuthentificationPOA;
import modEntreesSortiesZones.ServiceEmpreinte;
import modEntreesSortiesZones.ServiceJournalisation;
import modEntreesSortiesZones.TypeAcces;
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
public class ServiceAuthentificationImpl extends ServiceAuthentificationPOA implements Runnable {

    private byte[] serviceAuthId;
    private org.omg.CORBA.ORB orb;
    private POA rootPOA;
    private NamingContext nameRoot;
    private final String nomObj;
    private final JTextArea areaTextEvent;
    private Connection conn = null;
    private final String nomServEmpreinte = "SEMP";
    private final String nomServJournalisation = "SJOUR";

    public ServiceAuthentificationImpl(JTextArea a) {
        nomObj = "SAUTH";
        areaTextEvent = a;
    }

    private void connexion(String typeCollab) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        //Connexion sur PC Bureau Fabien :
        //conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/D:/Documents/ProjetCorba/h2_db/bdcollab"+typeCollab+";IGNORECASE=TRUE", "sa", "");
        conn = DriverManager.getConnection("jdbc:h2:./h2_db/bdcollab" + typeCollab + ";IGNORECASE=TRUE", "sa", "");
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

    //Méthode utilisée pour récupérer l'objet ServiceEmpreinte distant et appeler sa méthode verifierEmpreinte
    private boolean lancerVerifierEmpreinte(String empCollab, String matricule) throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, EmpreinteInconnue {
        org.omg.CORBA.Object distantSEmp = Fonction.connexionCorba(nomServEmpreinte);
        ServiceEmpreinte servEmp = modEntreesSortiesZones.ServiceEmpreinteHelper.narrow(distantSEmp);

        //Finalement, on vérifie l'empreinte
        return servEmp.verifierEmpreinte(empCollab, matricule);
    }

    //Méthode utilisée pour récupérer l'objet ServiceJournalisation distant et appeler sa méthode ajouterEntree
    private void lancerAjouterEntree(String matricule, int zone, String dateAcces, TypeAcces typeAcces) throws NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName, EmpreinteInconnue {
        org.omg.CORBA.Object distantSJour = Fonction.connexionCorba(nomServJournalisation);

        ServiceJournalisation monServJour = modEntreesSortiesZones.ServiceJournalisationHelper.narrow(distantSJour);
        monServJour.ajouterEntree(matricule, zone, dateAcces, typeAcces);
    }

    @Override
    public Utilisateur[] getCollaborateursTemporaires() {
        areaTextEvent.setText(areaTextEvent.getText() + "Demande de la liste des collaborateurs temporaires...\n");
        List<Utilisateur> tabUtilisateurs = new ArrayList();
        try {
            String query = "SELECT u.matricule AS matricule, u.nomUrs AS nomUsr, u.prenomUsr AS prenomUsr, u.photoUsr AS photoUsr "
                    + "from utilisateur u, collaborateurTemp c "
                    + "WHERE u.matricule = c.matricule_utilisateur "
                    + "order by u.matricule";
            ResultSet rs;
            connexion("Temp");
            rs = lancerInterrogation(query);
            while (rs.next()) {
                tabUtilisateurs.add(new Utilisateur(rs.getString("matricule"), rs.getString("nomUsr"), rs.getString("prenomUsr"), rs.getString("photoUsr")));
            }
            closeConnexion();
            Utilisateur[] lesUtilisateurs = new Utilisateur[tabUtilisateurs.size()];
            lesUtilisateurs = tabUtilisateurs.toArray(lesUtilisateurs);

            areaTextEvent.setText(areaTextEvent.getText() + "Listes des collaborateurs temporaires envoyée !\n");
            return lesUtilisateurs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Utilisateur[] getCollaborateursPermanents() {
        areaTextEvent.setText(areaTextEvent.getText() + "Demande de la liste des collaborateurs permanents...\n");
        List<Utilisateur> tabUtilisateurs = new ArrayList();
        try {
            String query = "SELECT u.matricule AS matricule, u.nomUrs AS nomUsr, u.prenomUsr AS prenomUsr, u.photoUsr AS photoUsr "
                    + "from utilisateur u, collaborateurPerm c "
                    + "WHERE u.matricule = c.matricule_utilisateur ";
            ResultSet rs;
            connexion("Perm");
            rs = lancerInterrogation(query);
            while (rs.next()) {
                tabUtilisateurs.add(new Utilisateur(rs.getString("matricule"), rs.getString("nomUsr"), rs.getString("prenomUsr"), rs.getString("photoUsr")));
            }
            closeConnexion();
            Utilisateur[] lesUtilisateurs = new Utilisateur[tabUtilisateurs.size()];
            lesUtilisateurs = tabUtilisateurs.toArray(lesUtilisateurs);

            areaTextEvent.setText(areaTextEvent.getText() + "Listes des collaborateurs permanents envoyée !\n");
            return lesUtilisateurs;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Utilisateur verifierAuthentificationPorte(String empCollab, String phoUsr, int zone) throws UtilisateurInconnu, EmpreinteInconnue {
        areaTextEvent.setText(areaTextEvent.getText() + "Vérification porte\n");
        String matricule, nomUsr, preUsr;
        Utilisateur usr = null;
        String query = "SELECT matricule, nomUrs, prenomUsr FROM utilisateur "
                + "WHERE photoUsr='" + phoUsr + "'";
        ResultSet rs;
        try {
            /*On tente de chercher dans la basePerm 
             (on commence par celle-ci en partant du principe 
             que la plupart des scans d'empreintes/visages sont faits par des collabPerm...)*/
            connexion("Perm");
            rs = lancerInterrogation(query);
            boolean res = rs.next();
            if (res) {
                areaTextEvent.setText(areaTextEvent.getText() + "Collaborateur permanent à la porte\n");
                nomUsr = rs.getString("nomUrs");
                preUsr = rs.getString("prenomUsr");
                matricule = rs.getString("matricule");
                usr = new Utilisateur(matricule, nomUsr, preUsr, "");
                // Matricule => OK => Vérifier empreinte auprès du serviceEmpreinte : 
                lancerVerifierEmpreinte(empCollab, matricule);
            } else {
                //On tente de chercher dans la baseTemp
                closeConnexion();
                connexion("Temp");
                rs = lancerInterrogation(query);
                res = rs.next();
                if (res) {
                    areaTextEvent.setText(areaTextEvent.getText() + "Collaborateur temporaire à la porte\n");
                    nomUsr = rs.getString("nomUrs");
                    preUsr = rs.getString("prenomUsr");
                    matricule = rs.getString("matricule");
                    usr = new Utilisateur(matricule, nomUsr, preUsr, "");
                    // Matricule => OK => Vérifier empreinte auprès du serviceEmpreinte : 
                    lancerVerifierEmpreinte(empCollab, matricule);
                } else {
                    areaTextEvent.setText(areaTextEvent.getText() + "Collaborateur inconnu : enregistrement journal\n");
                    
                    String formatSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
                    
                    lancerAjouterEntree("inconnu", zone, formatSQL, TypeAcces.nonAuthentifie);
                    //Exception à catcher côté client scanneur d'empreinte :
                    throw new UtilisateurInconnu("Erreur: l'utilisateur n'existe pas dans nos bases de données.");
                }
            }
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmpreinteInconnue ex) {
            String formatSQL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
            try {
                lancerAjouterEntree(usr.matricule, zone, formatSQL, TypeAcces.nonAuthentifie);
            } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex1) {
                Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
            //On "retourne" l'exception pour le client :
            throw new EmpreinteInconnue("Erreur: l'utilisateur est reconnu, mais pas son empreinte.");
        }
        return usr;
    }

    @Override
    public boolean verifierAuthentificationLogicielResp(String matricule, String pwd, int zone) throws UtilisateurInconnu {
        String query = "SELECT COUNT(*) AS rowcount FROM responsableZone "
                + "WHERE idZone = " + zone + " "
                + "AND idCollabPerm_collaborateurPerm = "
                + "(SELECT idCollabPerm FROM collaborateurPerm "
                + " WHERE matricule_utilisateur='" + matricule + "' "
                + " AND passwordPerm='" + pwd + "' )";
        int rowcount;
        ResultSet rs;
        boolean res = false;
        try {
            connexion("Perm");
            rs = lancerInterrogation(query);
            rs.next();
            rowcount = rs.getInt("rowcount");
            if (rowcount > 0) {
                res = true;
            } else {
                throw new UtilisateurInconnu("Erreur, vous n'êtes pas responsable de cette zone.");
            }
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
                + "      WHERE matricule_utilisateur='" + matricule + "' "
                + "      AND passwordPerm='" + pwd + "' ))";
        int rowcount;
        ResultSet rs;
        boolean res = false;
        try {
            connexion("Perm");
            rs = lancerInterrogation(query);
            rs.next();
            rowcount = rs.getInt("rowcount");
            if (rowcount > 0) {
                res = true;
            } else {
                throw new UtilisateurInconnu("Erreur, ce compte RH n'existe pas.");
            }
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                + "      WHERE matricule_utilisateur='" + matricule + "' "
                + "      AND passwordPerm='" + pwd + "' ))";
        int rowcount;
        ResultSet rs;
        boolean res = false;
        try {
            connexion("Perm");
            rs = lancerInterrogation(query);
            rs.next();
            rowcount = rs.getInt("rowcount");
            if (rowcount > 0) {
                res = true;
            } else {
                throw new UtilisateurInconnu("Erreur, ce compte Accueil n'existe pas.");
            }
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean verifierAuthentificationMachineEmpreinteCollaborateurPerm(String matricule, String pwd) throws UtilisateurInconnu {
        String query = "SELECT COUNT(*) AS rowcount FROM collaborateurPerm "
                + "WHERE matricule_utilisateur = '" + matricule + "' "
                + "AND passwordPerm = '" + pwd + "' ";
        int rowcount;
        ResultSet rs;
        boolean res = false;
        try {
            connexion("Perm");
            rs = lancerInterrogation(query);
            rs.next();
            rowcount = rs.getInt("rowcount");
            if (rowcount > 0) {
                res = true;
            } else {
                throw new UtilisateurInconnu("Erreur: collaborateur permanent inconnu.");
            }
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    @Override
    public boolean verifierMatriculeTemp(String matricule) throws UtilisateurInconnu {
        String query = "SELECT COUNT(*) AS rowcount FROM collaborateurTemp "
                + "WHERE matricule_utilisateur = '" + matricule + "' ";
        int rowcount;
        ResultSet rs;
        boolean res = false;
        try {
            connexion("Temp");
            rs = lancerInterrogation(query);
            rs.next();
            rowcount = rs.getInt("rowcount");
            if (rowcount > 0) {
                res = true;
            } else {
                throw new UtilisateurInconnu("Erreur: collaborateur temporaire inconnu.");
            }
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public boolean verifierMatriculePerm(String matricule) throws UtilisateurInconnu {
        String query = "SELECT COUNT(*) AS rowcount FROM collaborateurPerm "
                + "WHERE matricule_utilisateur = '" + matricule + "' ";
        int rowcount;
        ResultSet rs;
        boolean res = false;
        try {
            connexion("Perm");
            rs = lancerInterrogation(query);
            rs.next();
            rowcount = rs.getInt("rowcount");
            if (rowcount > 0) {
                res = true;
            } else {
                throw new UtilisateurInconnu("Erreur: collaborateur permanent inconnu.");
            }
            closeConnexion();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    @Override
    public void ajouterCollaborateurTemp(String matricule, String nomUsr, String preUsr, String phoUsr) throws UtilisateurExistant {
        String queryUsr = "insert into utilisateur values ('" + matricule + "','" + nomUsr + "','" + preUsr + "','" + phoUsr + "')";
        String queryCollab = "insert into collaborateurTemp values (null,'" + matricule + "')";
        try {
            connexion("Temp");
            if (lancerManipulation(queryUsr)) {
                areaTextEvent.setText(areaTextEvent.getText() + "Utilisateur temporaire ajouté avec matricule: " + matricule + "\n");
                if (lancerManipulation(queryCollab)) {
                    areaTextEvent.setText(areaTextEvent.getText() + "Collaborateur temporaire ajouté avec matricule: " + matricule + "\n");
                } else {
                    areaTextEvent.setText(areaTextEvent.getText() + "Impossible d'ajouter le collaborateur temporaire avec matricule: " + matricule + "\n");
                    throw new UtilisateurExistant("Erreur: collaborateur temporaire déjà connu.");
                }
            } else {
                areaTextEvent.setText(areaTextEvent.getText() + "Impossible d'ajouter l'utilisateur temporaire avec matricule: " + matricule + "\n");
                throw new UtilisateurExistant("Erreur: utilisateur déjà connu.");
            }
            closeConnexion();
        } catch (SQLException | ClassNotFoundException ex) {
            //Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new UtilisateurExistant("Erreur: collaborateur temporaire déjà connu.");
        }
    }

    @Override
    public void ajouterCollaborateurPerm(String matricule, String nomUsr, String preUsr, String phoUsr, String pwd) throws UtilisateurExistant {
        String queryUsr = "insert into utilisateur values ('" + matricule + "','" + nomUsr + "','" + preUsr + "','" + phoUsr + "')";
        String queryCollab = "insert into collaborateurPerm values (null,'" + matricule + "','" + pwd + "')";
        try {
            connexion("Perm");
            if (lancerManipulation(queryUsr)) {
                areaTextEvent.setText(areaTextEvent.getText() + "Utilisateur permanent ajouté avec matricule: " + matricule + "\n");
                if (lancerManipulation(queryCollab)) {
                    areaTextEvent.setText(areaTextEvent.getText() + "Collaborateur permanent ajouté avec matricule: " + matricule + "\n");
                } else {
                    areaTextEvent.setText(areaTextEvent.getText() + "Impossible d'ajouter le collaborateur permanent avec matricule: " + matricule + "\n");
                    throw new UtilisateurExistant("Erreur: collaborateur permanent déjà connu.");
                }
            } else {
                areaTextEvent.setText(areaTextEvent.getText() + "Impossible d'ajouter l'utilisateur permanent avec matricule: " + matricule + "\n");
                throw new UtilisateurExistant("Erreur: utilisateur déjà connu.");
            }
            closeConnexion();
        } catch (SQLException | ClassNotFoundException ex) {
            //Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new UtilisateurExistant("Erreur: collaborateur permanent déjà connu.");
        }
    }

    @Override
    public void modifierCollaborateurTemp(String matricule, String nomUsr, String preUsr, String phoUsr) throws UtilisateurInconnu {
        String query = "update utilisateur set nomUrs='" + nomUsr + "', prenomUsr='" + preUsr + "', photoUsr='" + phoUsr + "' where matricule='" + matricule + "'";
        try {
            connexion("Temp");
            if (lancerManipulation(query)) {
                areaTextEvent.setText(areaTextEvent.getText() + "Modification effectuée pour l'utilisateur temporaire au matricule: " + matricule + "\n");
            } else {
                areaTextEvent.setText(areaTextEvent.getText() + "Impossible de modifier l'utilisateur temporaire au matricule: " + matricule + "\n");
                throw new UtilisateurInconnu("Erreur: ce collaborateur temporaire n'existe pas dans nos bases de données.");
            }
            closeConnexion();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifierCollaborateurPerm(String matricule, String nomUsr, String preUsr, String phoUsr) throws UtilisateurInconnu {
        String query = "update utilisateur set nomUrs='" + nomUsr + "', prenomUsr='" + preUsr + "', photoUsr='" + phoUsr + "' where matricule='" + matricule + "'";
        try {
            connexion("Perm");
            if (lancerManipulation(query)) {
                areaTextEvent.setText(areaTextEvent.getText() + "Modification effectuée pour l'utilisateur permanent au matricule: " + matricule + "\n");
            } else {
                areaTextEvent.setText(areaTextEvent.getText() + "Impossible de modifier l'utilisateur permanent au matricule: " + matricule + "\n");
                throw new UtilisateurInconnu("Erreur: ce collaborateur permanent n'existe pas dans nos bases de données.");
            }
            closeConnexion();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        String[] args = null;

        try {
            areaTextEvent.setText(areaTextEvent.getText() + "Démarrage du ServiceAuthentification...\n");
            // Intialisation de l'ORB
            orb = org.omg.CORBA.ORB.init(args, null);
            // Recuperation du POA
            rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            // Creation du servant
            ServiceAuthentificationImpl serviceAuth = this;
            // Activer le servant au sein du POA et recuperer son ID
            serviceAuthId = rootPOA.activate_object(serviceAuth);
            // Activer le POA manager
            rootPOA.the_POAManager().activate();
            // Enregistrement dans le service de nommage
            //*******************************************
            // Recuperation du naming service
            nameRoot = Fonction.resolveNamingService(orb);
            // Construction du nom a enregistrer
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj, "");
            // Enregistrement de l'objet CORBA dans le service de noms
            nameRoot.rebind(nameToRegister, rootPOA.servant_to_reference(serviceAuth));
            // Lancement de l'ORB et mise en attente de requete
            areaTextEvent.setText(areaTextEvent.getText() + "Lancement de l'ORB : en attente de requêtes !\n");
            orb.run();
        } catch (InvalidName | ServantAlreadyActive | WrongPolicy | AdapterInactive | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | ServantNotActive ex) {
            Logger.getLogger(ServiceAuthentificationImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stopServ() {
        areaTextEvent.setText(areaTextEvent.getText() + "Arrêt de '" + nomObj + "'\n");
        orb.shutdown(true);
    }

    public byte[] getServiceAuthId() {
        return serviceAuthId;
    }
}

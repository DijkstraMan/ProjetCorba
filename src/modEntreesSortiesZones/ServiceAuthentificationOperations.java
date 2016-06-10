package modEntreesSortiesZones;

/**
 * Interface definition : ServiceAuthentification
 * 
 * @author OpenORB Compiler
 */
public interface ServiceAuthentificationOperations
{
    /**
     * Operation getUtilisateur
     */
<<<<<<< HEAD
    public modEntreesSortiesZones.Utilisateur getUtilisateur(String matricule)
=======
    public void modifierUtilisateur(String matricule, String nomUsr, String preUsr, String phoUsr)
>>>>>>> ServiceAuthorisationNico
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation verifierAuthentificationPorte
     */
<<<<<<< HEAD
    public modEntreesSortiesZones.Utilisateur verifierAuthentificationPorte(String empCollab, String phoUsr, int zone)
        throws modEntreesSortiesZones.UtilisateurInconnu, modEntreesSortiesZones.EmpreinteInconnue;
=======
    public modEntreesSortiesZones.Utilisateur getUtilisateur(String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu;
>>>>>>> ServiceAuthorisationNico

    /**
     * Operation verifierAuthentificationLogicielResp
     */
    public boolean verifierAuthentificationLogicielResp(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation verifierAuthentificationLogicielRH
     */
<<<<<<< HEAD
    public boolean verifierAuthentificationLogicielRH(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation verifierAuthentificationLogicielAccueil
     */
=======
    public String verifierAuthentificationPorte(String empCollab, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation verifierAuthentificationLogicielResp
     */
    public boolean verifierAuthentificationLogicielResp(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation verifierAuthentificationLogicielRH
     */
    public boolean verifierAuthentificationLogicielRH(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation verifierAuthentificationLogicielAccueil
     */
>>>>>>> ServiceAuthorisationNico
    public boolean verifierAuthentificationLogicielAccueil(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation ajouterCollaborateurTemp
     */
    public void ajouterCollaborateurTemp(String matricule, String nomUsr, String preUsr, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurExistant;

    /**
     * Operation modifierCollaborateurTemp
     */
    public void modifierCollaborateurTemp(String matricule, String nomUsr, String preUsr, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation verifierAuthentificationMachineEmpreinteCollaborateurTemp
     */
    public boolean verifierAuthentificationMachineEmpreinteCollaborateurTemp(String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation ajouterCollaborateurPerm
     */
    public void ajouterCollaborateurPerm(String matricule, String nomUsr, String preUsr, String phoUsr, String pwd)
        throws modEntreesSortiesZones.UtilisateurExistant;

    /**
     * Operation modifierCollaborateurPerm
     */
    public void modifierCollaborateurPerm(String matricule, String nomUsr, String preUsr, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation verifierAuthentificationMachineEmpreinteCollaborateurPerm
     */
    public boolean verifierAuthentificationMachineEmpreinteCollaborateurPerm(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation getCollaborateursTemporaires
     */
    public modEntreesSortiesZones.Utilisateur[] getCollaborateursTemporaires();

    /**
     * Operation getCollaborateursPermanents
     */
    public modEntreesSortiesZones.Utilisateur[] getCollaborateursPermanents();

}

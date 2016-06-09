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
    public modEntreesSortiesZones.Utilisateur getUtilisateur(String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation verifierAuthentificationPorte
     */
    public modEntreesSortiesZones.Utilisateur verifierAuthentificationPorte(String empCollab, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurInconnu, modEntreesSortiesZones.EmpreinteInconnue;

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

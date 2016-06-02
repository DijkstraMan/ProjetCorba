package modEntreesSortiesZones;

/**
 * Interface definition : ServiceAuthentification
 * 
 * @author OpenORB Compiler
 */
public interface ServiceAuthentificationOperations
{
    /**
     * Operation modifierUtilisateur
     */
    public void modifierUtilisateur(String matricule, String nomUsr, String preUsr, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation getUtilisateur
     */
    public modEntreesSortiesZones.Utilisateur getUtilisateur(String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation getUtilisateurs
     */
    public modEntreesSortiesZones.Utilisateur[] getUtilisateurs();

    /**
     * Operation verifierAuthentificationPorte
     */
    public String verifierAuthentificationPorte(String empCollab, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation verifierAuthentificationLogiciel
     */
    public boolean verifierAuthentificationLogiciel(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation ajouterCollaborateurTemp
     */
    public void ajouterCollaborateurTemp(String matricule, String nomUsr, String preUsr, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurExistant;

    /**
     * Operation ajouterCollaborateurPerm
     */
    public void ajouterCollaborateurPerm(String matricule, String nomUsr, String preUsr, String phoUsr, String pwd)
        throws modEntreesSortiesZones.UtilisateurExistant;

}

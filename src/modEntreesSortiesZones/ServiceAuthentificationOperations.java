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
    public void modifierUtilisateur(String m, String n, String preU, String phoU)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation getUtilisateur
     */
    public modEntreesSortiesZones.Utilisateur getUtilisateur(String m)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation getUtilisateurs
     */
    public modEntreesSortiesZones.Utilisateur[] getUtilisateurs();

    /**
     * Operation verifierAuthentificationPorte
     */
    public String verifierAuthentificationPorte(String eC, String p)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation verifierAuthentificationLogiciel
     */
    public boolean verifierAuthentificationLogiciel(String m, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation ajouterCollaborateurTemp
     */
    public void ajouterCollaborateurTemp(String m, String n, String preU, String phoU)
        throws modEntreesSortiesZones.UtilisateurExistant;

    /**
     * Operation ajouterCollaborateurPerm
     */
    public void ajouterCollaborateurPerm(String m, String n, String preU, String phoU, String pwd)
        throws modEntreesSortiesZones.UtilisateurExistant;

}

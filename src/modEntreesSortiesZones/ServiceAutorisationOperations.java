package modEntreesSortiesZones;

/**
 * Interface definition : ServiceAutorisation
 * 
 * @author OpenORB Compiler
 */
public interface ServiceAutorisationOperations
{
    /**
     * Operation verifierAutorisation
     */
    public boolean verifierAutorisation(String matricule, int idZone)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation ajouterAutorisationTemp
     */
    public void ajouterAutorisationTemp(String matricule, int idZone, int hrDebut, int hrFin, String jrDebut, String jrFin)
        throws modEntreesSortiesZones.AutorisationExistante, modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation modifierAutorisationTemp
     */
    public void modifierAutorisationTemp(String matricule, int idZone, int hrDebut, int hrFin, String jrDebut, String jrFin)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation supprimerAutorisationTemp
     */
    public void supprimerAutorisationTemp(String matricule, int idZone)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation ajouterAutorisationPerm
     */
    public void ajouterAutorisationPerm(String matricule, int idZone, int hrDebut, int hrFin)
        throws modEntreesSortiesZones.AutorisationExistante, modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation modifierAutorisationPerm
     */
    public void modifierAutorisationPerm(String matricule, int idZone, int hrDebut, int hrFin)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation supprimerAutorisationPerm
     */
    public void supprimerAutorisationPerm(String matricule, int idZone)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation getIdZoneFromPorte
     */
    public int getIdZoneFromPorte(int idPorte);

    /**
     * Operation getZone
     */
    public modEntreesSortiesZones.Zone[] getZone();

    /**
     * Operation getAutorisationPerm
     */
    public modEntreesSortiesZones.AutorisationPerm[] getAutorisationPerm();

    /**
     * Operation getAutorisationTemp
     */
    public modEntreesSortiesZones.AutorisationTemp[] getAutorisationTemp();

}

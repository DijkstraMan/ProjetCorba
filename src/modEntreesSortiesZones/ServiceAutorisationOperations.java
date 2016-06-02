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
    public void ajouterAutorisationTemp(String matricule, int idZone, String jrDebut, String jrFin)
        throws modEntreesSortiesZones.AutorisationExistante;

    /**
     * Operation modifierAutorisationTemp
     */
    public void modifierAutorisationTemp(String matricule, int idZone, String jrDebut, String jrFin)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation ajouterAutorisationPerm
     */
    public void ajouterAutorisationPerm(String matricule, int idZone, int hrDebut, int hrFin)
        throws modEntreesSortiesZones.AutorisationExistante;

    /**
     * Operation modifierAutorisationPerm
     */
    public void modifierAutorisationPerm(String matricule, int idZone, int hrDebut, int hrFin)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation supprimerAutorisation
     */
    public void supprimerAutorisation(String matricule, int idZone)
        throws modEntreesSortiesZones.AutorisationInconnue;

}

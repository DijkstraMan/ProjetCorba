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
    public boolean verifierAutorisation(int m, String n)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation ajouterAutorisationTemp
     */
    public void ajouterAutorisationTemp(int m, String n, int jD, int jF, int hD, int hF)
        throws modEntreesSortiesZones.AutorisationExistante;

    /**
     * Operation modifierAutorisationTemp
     */
    public void modifierAutorisationTemp(int m, String n, int jD, int jF, int hD, int hF)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation ajouterAutorisationPerm
     */
    public void ajouterAutorisationPerm(int m, String n, int hD, int hF)
        throws modEntreesSortiesZones.AutorisationExistante;

    /**
     * Operation modifierAutorisationPerm
     */
    public void modifierAutorisationPerm(int m, String n, int hD, int hF)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation supprimerAutorisation
     */
    public void supprimerAutorisation(int m, String n)
        throws modEntreesSortiesZones.AutorisationInconnue;

}

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
    public boolean verifierAutorisation(String m, String n)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation ajouterAutorisationTemp
     */
    public void ajouterAutorisationTemp(String m, String n, String jD, String jF)
        throws modEntreesSortiesZones.AutorisationExistante;

    /**
     * Operation modifierAutorisationTemp
     */
    public void modifierAutorisationTemp(String m, String n, String jD, String jF)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation ajouterAutorisationPerm
     */
    public void ajouterAutorisationPerm(String m, String n, int hD, int hF)
        throws modEntreesSortiesZones.AutorisationExistante;

    /**
     * Operation modifierAutorisationPerm
     */
    public void modifierAutorisationPerm(String m, String n, int hD, int hF)
        throws modEntreesSortiesZones.AutorisationInconnue;

    /**
     * Operation supprimerAutorisation
     */
    public void supprimerAutorisation(String m, String n)
        throws modEntreesSortiesZones.AutorisationInconnue;

}

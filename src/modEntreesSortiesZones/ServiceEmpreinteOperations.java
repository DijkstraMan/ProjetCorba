package modEntreesSortiesZones;

/**
 * Interface definition : ServiceEmpreinte
 * 
 * @author OpenORB Compiler
 */
public interface ServiceEmpreinteOperations
{
    /**
     * Operation verifierEmpreinte
     */
    public boolean verifierEmpreinte(String empCollab, String matricule)
        throws modEntreesSortiesZones.EmpreinteInconnue;

    /**
     * Operation ajouterEmpreinte
     */
    public void ajouterEmpreinte(String empCollab, String matricule)
        throws modEntreesSortiesZones.EmpreinteExistante;

    /**
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(String empCollab, String matricule)
        throws modEntreesSortiesZones.EmpreinteInconnue;

    /**
     * Operation supprimerEmpreinteTemp
     */
    public void supprimerEmpreinteTemp(String matricule)
        throws modEntreesSortiesZones.EmpreinteInconnue;

    /**
     * Operation verifierEmpreinteTempExistante
     */
    public boolean verifierEmpreinteTempExistante(String matricule);

    /**
     * Operation verifierEmpreintePermExistante
     */
    public boolean verifierEmpreintePermExistante(String matricule);

}

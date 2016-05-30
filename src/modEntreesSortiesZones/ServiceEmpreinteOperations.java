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
    public boolean verifierEmpreinte(String eC, int m)
        throws modEntreesSortiesZones.EmpreinteInconnue;

    /**
     * Operation ajouterEmpreinte
     */
    public void ajouterEmpreinte(String e, int m)
        throws modEntreesSortiesZones.EmpreinteExistante;

    /**
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(String e, int m)
        throws modEntreesSortiesZones.EmpreinteInconnue;

}

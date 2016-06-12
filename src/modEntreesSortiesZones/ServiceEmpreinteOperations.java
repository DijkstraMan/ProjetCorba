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
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation supprimerEmpreinteTemp
     */
    public void supprimerEmpreinteTemp(String matricule)
        throws modEntreesSortiesZones.EmpreinteInconnue;

<<<<<<< HEAD
    /**
     * Operation verifierEmpreinteTempExistante
     */
    public boolean verifierEmpreinteTempExistante(String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu;

    /**
     * Operation verifierEmpreintePermExistante
     */
    public boolean verifierEmpreintePermExistante(String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu;

=======
>>>>>>> ReponsableZoneNicov2
}

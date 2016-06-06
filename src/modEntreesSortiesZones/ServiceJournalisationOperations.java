package modEntreesSortiesZones;

/**
 * Interface definition : ServiceJournalisation
 * 
 * @author OpenORB Compiler
 */
public interface ServiceJournalisationOperations
{
    /**
     * Operation ajouterEntree
     */
    public void ajouterEntree(String matricule, int idZone, String t, modEntreesSortiesZones.TypeAcces typeAcces);

    /**
     * Operation consulterAcces
     */
    public modEntreesSortiesZones.LogAcces[] consulterAcces();

    /**
     * Operation consulterRefus
     */
    public modEntreesSortiesZones.LogAcces[] consulterRefus();

}

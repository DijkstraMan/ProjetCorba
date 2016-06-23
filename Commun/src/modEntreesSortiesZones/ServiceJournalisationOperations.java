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
    public void ajouterEntree(String matricule, int idZone, String dateAcces, modEntreesSortiesZones.TypeAcces typeAcces);

    /**
     * Operation consulterAcces
     */
    public modEntreesSortiesZones.LogAccesZone[] consulterAcces(int idZone);

    /**
     * Operation consulterTousAcces
     */
    public modEntreesSortiesZones.LogAcces[] consulterTousAcces();

    /**
     * Operation consulterRefus
     */
    public modEntreesSortiesZones.LogAccesZone[] consulterRefus(int idZone);

    /**
     * Operation consulterTousRefus
     */
    public modEntreesSortiesZones.LogAcces[] consulterTousRefus();

}

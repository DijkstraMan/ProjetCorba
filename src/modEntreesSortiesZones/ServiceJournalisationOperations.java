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
    public void ajouterEntree(String m, String n, String t, modEntreesSortiesZones.TypeAcces a);

    /**
     * Operation consulterAcces
     */
    public modEntreesSortiesZones.LogAcces[] consulterAcces();

    /**
     * Operation consulterRefus
     */
    public modEntreesSortiesZones.LogAcces[] consulterRefus();

}

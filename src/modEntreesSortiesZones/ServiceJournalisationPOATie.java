package modEntreesSortiesZones;

/**
 * Interface definition : ServiceJournalisation
 * 
 * @author OpenORB Compiler
 */
public class ServiceJournalisationPOATie extends ServiceJournalisationPOA
{

    //
    // Private reference to implementation object
    //
    private ServiceJournalisationOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ServiceJournalisationPOATie(ServiceJournalisationOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ServiceJournalisationPOATie(ServiceJournalisationOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ServiceJournalisationOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ServiceJournalisationOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation ajouterEntree
     */
    public void ajouterEntree(String matricule, int idZone, String t, modEntreesSortiesZones.TypeAcces typeAcces)
    {
        _tie.ajouterEntree( matricule,  idZone,  t,  typeAcces);
    }

    /**
     * Operation consulterAcces
     */
    public modEntreesSortiesZones.LogAcces[] consulterAcces()
    {
        return _tie.consulterAcces();
    }

    /**
     * Operation consulterRefus
     */
    public modEntreesSortiesZones.LogAcces[] consulterRefus()
    {
        return _tie.consulterRefus();
    }

}

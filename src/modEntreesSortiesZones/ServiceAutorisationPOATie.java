package modEntreesSortiesZones;

/**
 * Interface definition : ServiceAutorisation
 * 
 * @author OpenORB Compiler
 */
public class ServiceAutorisationPOATie extends ServiceAutorisationPOA
{

    //
    // Private reference to implementation object
    //
    private ServiceAutorisationOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ServiceAutorisationPOATie(ServiceAutorisationOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ServiceAutorisationPOATie(ServiceAutorisationOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ServiceAutorisationOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ServiceAutorisationOperations delegate_)
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
     * Operation verifierAutorisation
     */
    public boolean verifierAutorisation(String m, String n)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        return _tie.verifierAutorisation( m,  n);
    }

    /**
     * Operation ajouterAutorisationTemp
     */
    public void ajouterAutorisationTemp(String m, String n, String jD, String jF)
        throws modEntreesSortiesZones.AutorisationExistante
    {
        _tie.ajouterAutorisationTemp( m,  n,  jD,  jF);
    }

    /**
     * Operation modifierAutorisationTemp
     */
    public void modifierAutorisationTemp(String m, String n, String jD, String jF)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.modifierAutorisationTemp( m,  n,  jD,  jF);
    }

    /**
     * Operation ajouterAutorisationPerm
     */
    public void ajouterAutorisationPerm(String m, String n, int hD, int hF)
        throws modEntreesSortiesZones.AutorisationExistante
    {
        _tie.ajouterAutorisationPerm( m,  n,  hD,  hF);
    }

    /**
     * Operation modifierAutorisationPerm
     */
    public void modifierAutorisationPerm(String m, String n, int hD, int hF)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.modifierAutorisationPerm( m,  n,  hD,  hF);
    }

    /**
     * Operation supprimerAutorisation
     */
    public void supprimerAutorisation(String m, String n)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.supprimerAutorisation( m,  n);
    }

}

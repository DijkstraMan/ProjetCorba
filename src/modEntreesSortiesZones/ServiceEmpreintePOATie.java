package modEntreesSortiesZones;

/**
 * Interface definition : ServiceEmpreinte
 * 
 * @author OpenORB Compiler
 */
public class ServiceEmpreintePOATie extends ServiceEmpreintePOA
{

    //
    // Private reference to implementation object
    //
    private ServiceEmpreinteOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ServiceEmpreintePOATie(ServiceEmpreinteOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ServiceEmpreintePOATie(ServiceEmpreinteOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ServiceEmpreinteOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ServiceEmpreinteOperations delegate_)
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
     * Operation verifierEmpreinte
     */
    public boolean verifierEmpreinte(String eC, int m)
        throws modEntreesSortiesZones.EmpreinteInconnue
    {
        return _tie.verifierEmpreinte( eC,  m);
    }

    /**
     * Operation ajouterEmpreinte
     */
    public void ajouterEmpreinte(String e, int m)
        throws modEntreesSortiesZones.EmpreinteExistante
    {
        _tie.ajouterEmpreinte( e,  m);
    }

    /**
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(String e, int m)
        throws modEntreesSortiesZones.EmpreinteInconnue
    {
        _tie.modifierEmpreinte( e,  m);
    }

}

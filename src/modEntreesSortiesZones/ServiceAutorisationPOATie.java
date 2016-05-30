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
    public boolean verifierAutorisation(int m, String n)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        return _tie.verifierAutorisation( m,  n);
    }

    /**
     * Operation ajouterAutorisationTemp
     */
    public void ajouterAutorisationTemp(int m, String n, int jD, int jF, int hD, int hF)
        throws modEntreesSortiesZones.AutorisationExistante
    {
        _tie.ajouterAutorisationTemp( m,  n,  jD,  jF,  hD,  hF);
    }

    /**
     * Operation modifierAutorisationTemp
     */
    public void modifierAutorisationTemp(int m, String n, int jD, int jF, int hD, int hF)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.modifierAutorisationTemp( m,  n,  jD,  jF,  hD,  hF);
    }

    /**
     * Operation ajouterAutorisationPerm
     */
    public void ajouterAutorisationPerm(int m, String n, int hD, int hF)
        throws modEntreesSortiesZones.AutorisationExistante
    {
        _tie.ajouterAutorisationPerm( m,  n,  hD,  hF);
    }

    /**
     * Operation modifierAutorisationPerm
     */
    public void modifierAutorisationPerm(int m, String n, int hD, int hF)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.modifierAutorisationPerm( m,  n,  hD,  hF);
    }

    /**
     * Operation supprimerAutorisation
     */
    public void supprimerAutorisation(int m, String n)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.supprimerAutorisation( m,  n);
    }

}

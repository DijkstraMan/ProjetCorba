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
    public boolean verifierEmpreinte(String empCollab, String matricule)
        throws modEntreesSortiesZones.EmpreinteInconnue
    {
        return _tie.verifierEmpreinte( empCollab,  matricule);
    }

    /**
     * Operation ajouterEmpreinte
     */
    public void ajouterEmpreinte(String empCollab, String matricule)
        throws modEntreesSortiesZones.EmpreinteExistante
    {
        _tie.ajouterEmpreinte( empCollab,  matricule);
    }

    /**
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(String empCollab, String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        _tie.modifierEmpreinte( empCollab,  matricule);
    }

<<<<<<< HEAD
    /**
     * Operation supprimerEmpreinteTemp
     */
    public void supprimerEmpreinteTemp(String matricule)
        throws modEntreesSortiesZones.EmpreinteInconnue
    {
        _tie.supprimerEmpreinteTemp( matricule);
    }

    /**
     * Operation verifierEmpreinteTempExistante
     */
    public boolean verifierEmpreinteTempExistante(String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.verifierEmpreinteTempExistante( matricule);
    }

    /**
     * Operation verifierEmpreintePermExistante
     */
    public boolean verifierEmpreintePermExistante(String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.verifierEmpreintePermExistante( matricule);
    }

=======
>>>>>>> ReponsableZoneNicov2
}

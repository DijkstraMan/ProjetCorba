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
    public boolean verifierAutorisation(String matricule, int idZone)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        return _tie.verifierAutorisation( matricule,  idZone);
    }

    /**
     * Operation ajouterAutorisationTemp
     */
    public void ajouterAutorisationTemp(String matricule, int idZone, String jrDebut, String jrFin)
        throws modEntreesSortiesZones.AutorisationExistante
    {
        _tie.ajouterAutorisationTemp( matricule,  idZone,  jrDebut,  jrFin);
    }

    /**
     * Operation modifierAutorisationTemp
     */
    public void modifierAutorisationTemp(String matricule, int idZone, String jrDebut, String jrFin)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.modifierAutorisationTemp( matricule,  idZone,  jrDebut,  jrFin);
    }

    /**
     * Operation ajouterAutorisationPerm
     */
    public void ajouterAutorisationPerm(String matricule, int idZone, int hrDebut, int hrFin)
        throws modEntreesSortiesZones.AutorisationExistante
    {
        _tie.ajouterAutorisationPerm( matricule,  idZone,  hrDebut,  hrFin);
    }

    /**
     * Operation modifierAutorisationPerm
     */
    public void modifierAutorisationPerm(String matricule, int idZone, int hrDebut, int hrFin)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.modifierAutorisationPerm( matricule,  idZone,  hrDebut,  hrFin);
    }

    /**
     * Operation supprimerAutorisation
     */
    public void supprimerAutorisation(String matricule, int idZone)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.supprimerAutorisation( matricule,  idZone);
    }

    /**
     * Operation getZone
     */
    public modEntreesSortiesZones.Zone[] getZone()
        throws modEntreesSortiesZones.SQLERROR
    {
        return _tie.getZone();
    }

}

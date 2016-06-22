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
    public void ajouterAutorisationTemp(String matricule, int idZone, String hrDebut, String hrFin, String jrDebut, String jrFin)
        throws modEntreesSortiesZones.AutorisationExistante, modEntreesSortiesZones.UtilisateurInconnu
    {
        _tie.ajouterAutorisationTemp( matricule,  idZone,  hrDebut,  hrFin,  jrDebut,  jrFin);
    }

    /**
     * Operation modifierAutorisationTemp
     */
    public void modifierAutorisationTemp(String matricule, int idZone, String hrDebut, String hrFin, String jrDebut, String jrFin)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.modifierAutorisationTemp( matricule,  idZone,  hrDebut,  hrFin,  jrDebut,  jrFin);
    }

    /**
     * Operation supprimerAutorisationTemp
     */
    public void supprimerAutorisationTemp(String matricule, int idZone)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.supprimerAutorisationTemp( matricule,  idZone);
    }

    /**
     * Operation ajouterAutorisationPerm
     */
    public void ajouterAutorisationPerm(String matricule, int idZone, String hrDebut, String hrFin)
        throws modEntreesSortiesZones.AutorisationExistante, modEntreesSortiesZones.UtilisateurInconnu
    {
        _tie.ajouterAutorisationPerm( matricule,  idZone,  hrDebut,  hrFin);
    }

    /**
     * Operation modifierAutorisationPerm
     */
    public void modifierAutorisationPerm(String matricule, int idZone, String hrDebut, String hrFin)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.modifierAutorisationPerm( matricule,  idZone,  hrDebut,  hrFin);
    }

    /**
     * Operation supprimerAutorisationPerm
     */
    public void supprimerAutorisationPerm(String matricule, int idZone)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        _tie.supprimerAutorisationPerm( matricule,  idZone);
    }

    /**
     * Operation getIdZoneFromPorte
     */
    public int getIdZoneFromPorte(int idPorte)
    {
        return _tie.getIdZoneFromPorte( idPorte);
    }

    /**
     * Operation getZone
     */
    public modEntreesSortiesZones.Zone[] getZone()
    {
        return _tie.getZone();
    }

    /**
     * Operation getAutorisationPerm
     */
    public modEntreesSortiesZones.AutorisationPerm[] getAutorisationPerm()
    {
        return _tie.getAutorisationPerm();
    }

    /**
     * Operation getAutorisationTemp
     */
    public modEntreesSortiesZones.AutorisationTemp[] getAutorisationTemp()
    {
        return _tie.getAutorisationTemp();
    }

}

package modEntreesSortiesZones;

/**
 * Interface definition : ServiceAuthentification
 * 
 * @author OpenORB Compiler
 */
public class ServiceAuthentificationPOATie extends ServiceAuthentificationPOA
{

    //
    // Private reference to implementation object
    //
    private ServiceAuthentificationOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public ServiceAuthentificationPOATie(ServiceAuthentificationOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public ServiceAuthentificationPOATie(ServiceAuthentificationOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public ServiceAuthentificationOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(ServiceAuthentificationOperations delegate_)
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
     * Operation getUtilisateur
     */
    public modEntreesSortiesZones.Utilisateur getUtilisateur(String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.getUtilisateur( matricule);
    }

    /**
     * Operation verifierAuthentificationPorte
     */
    public modEntreesSortiesZones.Utilisateur verifierAuthentificationPorte(String empCollab, String phoUsr, int zone)
        throws modEntreesSortiesZones.UtilisateurInconnu, modEntreesSortiesZones.EmpreinteInconnue
    {
        return _tie.verifierAuthentificationPorte( empCollab,  phoUsr,  zone);
    }

    /**
     * Operation verifierAuthentificationLogicielResp
     */
    public boolean verifierAuthentificationLogicielResp(String matricule, String pwd, int zone)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.verifierAuthentificationLogicielResp( matricule,  pwd,  zone);
    }

    /**
     * Operation verifierAuthentificationLogicielRH
     */
    public boolean verifierAuthentificationLogicielRH(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.verifierAuthentificationLogicielRH( matricule,  pwd);
    }

    /**
     * Operation verifierAuthentificationLogicielAccueil
     */
    public boolean verifierAuthentificationLogicielAccueil(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.verifierAuthentificationLogicielAccueil( matricule,  pwd);
    }

    /**
     * Operation ajouterCollaborateurTemp
     */
    public void ajouterCollaborateurTemp(String matricule, String nomUsr, String preUsr, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurExistant
    {
        _tie.ajouterCollaborateurTemp( matricule,  nomUsr,  preUsr,  phoUsr);
    }

    /**
     * Operation modifierCollaborateurTemp
     */
    public void modifierCollaborateurTemp(String matricule, String nomUsr, String preUsr, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        _tie.modifierCollaborateurTemp( matricule,  nomUsr,  preUsr,  phoUsr);
    }

    /**
     * Operation verifierAuthentificationMachineEmpreinteCollaborateurTemp
     */
    public boolean verifierAuthentificationMachineEmpreinteCollaborateurTemp(String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.verifierAuthentificationMachineEmpreinteCollaborateurTemp( matricule);
    }

    /**
     * Operation ajouterCollaborateurPerm
     */
    public void ajouterCollaborateurPerm(String matricule, String nomUsr, String preUsr, String phoUsr, String pwd)
        throws modEntreesSortiesZones.UtilisateurExistant
    {
        _tie.ajouterCollaborateurPerm( matricule,  nomUsr,  preUsr,  phoUsr,  pwd);
    }

    /**
     * Operation modifierCollaborateurPerm
     */
    public void modifierCollaborateurPerm(String matricule, String nomUsr, String preUsr, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        _tie.modifierCollaborateurPerm( matricule,  nomUsr,  preUsr,  phoUsr);
    }

    /**
     * Operation verifierAuthentificationMachineEmpreinteCollaborateurPerm
     */
    public boolean verifierAuthentificationMachineEmpreinteCollaborateurPerm(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.verifierAuthentificationMachineEmpreinteCollaborateurPerm( matricule,  pwd);
    }

    /**
     * Operation getCollaborateursTemporaires
     */
    public modEntreesSortiesZones.Utilisateur[] getCollaborateursTemporaires()
    {
        return _tie.getCollaborateursTemporaires();
    }

    /**
     * Operation getCollaborateursPermanents
     */
    public modEntreesSortiesZones.Utilisateur[] getCollaborateursPermanents()
    {
        return _tie.getCollaborateursPermanents();
    }

}

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
     * Operation modifierUtilisateur
     */
    public void modifierUtilisateur(String matricule, String nomUsr, String preUsr, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        _tie.modifierUtilisateur( matricule,  nomUsr,  preUsr,  phoUsr);
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
     * Operation getUtilisateurs
     */
    public modEntreesSortiesZones.Utilisateur[] getUtilisateurs()
    {
        return _tie.getUtilisateurs();
    }

    /**
     * Operation verifierAuthentificationPorte
     */
    public String verifierAuthentificationPorte(String empCollab, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.verifierAuthentificationPorte( empCollab,  phoUsr);
    }

    /**
     * Operation verifierAuthentificationLogiciel
     */
    public boolean verifierAuthentificationLogiciel(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.verifierAuthentificationLogiciel( matricule,  pwd);
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
     * Operation ajouterCollaborateurPerm
     */
    public void ajouterCollaborateurPerm(String matricule, String nomUsr, String preUsr, String phoUsr, String pwd)
        throws modEntreesSortiesZones.UtilisateurExistant
    {
        _tie.ajouterCollaborateurPerm( matricule,  nomUsr,  preUsr,  phoUsr,  pwd);
    }

}

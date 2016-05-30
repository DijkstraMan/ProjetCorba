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
    public void modifierUtilisateur(String m, String n, String preU, String phoU)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        _tie.modifierUtilisateur( m,  n,  preU,  phoU);
    }

    /**
     * Operation getUtilisateur
     */
    public modEntreesSortiesZones.Utilisateur getUtilisateur(String m)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.getUtilisateur( m);
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
    public String verifierAuthentificationPorte(String eC, String p)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.verifierAuthentificationPorte( eC,  p);
    }

    /**
     * Operation verifierAuthentificationLogiciel
     */
    public boolean verifierAuthentificationLogiciel(String m, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        return _tie.verifierAuthentificationLogiciel( m,  pwd);
    }

    /**
     * Operation ajouterCollaborateurTemp
     */
    public void ajouterCollaborateurTemp(String m, String n, String preU, String phoU)
        throws modEntreesSortiesZones.UtilisateurExistant
    {
        _tie.ajouterCollaborateurTemp( m,  n,  preU,  phoU);
    }

    /**
     * Operation ajouterCollaborateurPerm
     */
    public void ajouterCollaborateurPerm(String m, String n, String preU, String phoU, String pwd)
        throws modEntreesSortiesZones.UtilisateurExistant
    {
        _tie.ajouterCollaborateurPerm( m,  n,  preU,  phoU,  pwd);
    }

}

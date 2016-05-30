package modEntreesSortiesZones;

/**
 * Interface definition : ServiceAuthentification
 * 
 * @author OpenORB Compiler
 */
public class _ServiceAuthentificationStub extends org.omg.CORBA.portable.ObjectImpl
        implements ServiceAuthentification
{
    static final String[] _ids_list =
    {
        "IDL:modEntreesSortiesZones/ServiceAuthentification:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = modEntreesSortiesZones.ServiceAuthentificationOperations.class;

    /**
     * Operation modifierUtilisateur
     */
    public void modifierUtilisateur(String m, String n, String preU, String phoU)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierUtilisateur",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
                    modEntreesSortiesZones.NomUsrHelper.write(_output,n);
                    modEntreesSortiesZones.PrenomUsrHelper.write(_output,preU);
                    modEntreesSortiesZones.PhotoUsrHelper.write(_output,phoU);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(modEntreesSortiesZones.UtilisateurInconnuHelper.id()))
                    {
                        throw modEntreesSortiesZones.UtilisateurInconnuHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierUtilisateur",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    _self.modifierUtilisateur( m,  n,  preU,  phoU);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getUtilisateur
     */
    public modEntreesSortiesZones.Utilisateur getUtilisateur(String m)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getUtilisateur",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
                    _input = this._invoke(_output);
                    modEntreesSortiesZones.Utilisateur _arg_ret = modEntreesSortiesZones.UtilisateurHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(modEntreesSortiesZones.UtilisateurInconnuHelper.id()))
                    {
                        throw modEntreesSortiesZones.UtilisateurInconnuHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getUtilisateur",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    return _self.getUtilisateur( m);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getUtilisateurs
     */
    public modEntreesSortiesZones.Utilisateur[] getUtilisateurs()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getUtilisateurs",true);
                    _input = this._invoke(_output);
                    modEntreesSortiesZones.Utilisateur[] _arg_ret = modEntreesSortiesZones.LesUtilisateursHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getUtilisateurs",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    return _self.getUtilisateurs();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation verifierAuthentificationPorte
     */
    public String verifierAuthentificationPorte(String eC, String p)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAuthentificationPorte",true);
                    modEntreesSortiesZones.EmpreinteCollabHelper.write(_output,eC);
                    modEntreesSortiesZones.PhotoUsrHelper.write(_output,p);
                    _input = this._invoke(_output);
                    String _arg_ret = modEntreesSortiesZones.NomUsrHelper.read(_input);
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(modEntreesSortiesZones.UtilisateurInconnuHelper.id()))
                    {
                        throw modEntreesSortiesZones.UtilisateurInconnuHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierAuthentificationPorte",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    return _self.verifierAuthentificationPorte( eC,  p);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation verifierAuthentificationLogiciel
     */
    public boolean verifierAuthentificationLogiciel(String m, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAuthentificationLogiciel",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
                    modEntreesSortiesZones.PasswordPermHelper.write(_output,pwd);
                    _input = this._invoke(_output);
                    boolean _arg_ret = _input.read_boolean();
                    return _arg_ret;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(modEntreesSortiesZones.UtilisateurInconnuHelper.id()))
                    {
                        throw modEntreesSortiesZones.UtilisateurInconnuHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierAuthentificationLogiciel",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    return _self.verifierAuthentificationLogiciel( m,  pwd);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation ajouterCollaborateurTemp
     */
    public void ajouterCollaborateurTemp(String m, String n, String preU, String phoU)
        throws modEntreesSortiesZones.UtilisateurExistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterCollaborateurTemp",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
                    modEntreesSortiesZones.NomUsrHelper.write(_output,n);
                    modEntreesSortiesZones.PrenomUsrHelper.write(_output,preU);
                    modEntreesSortiesZones.PhotoUsrHelper.write(_output,phoU);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(modEntreesSortiesZones.UtilisateurExistantHelper.id()))
                    {
                        throw modEntreesSortiesZones.UtilisateurExistantHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterCollaborateurTemp",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    _self.ajouterCollaborateurTemp( m,  n,  preU,  phoU);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation ajouterCollaborateurPerm
     */
    public void ajouterCollaborateurPerm(String m, String n, String preU, String phoU, String pwd)
        throws modEntreesSortiesZones.UtilisateurExistant
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterCollaborateurPerm",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
                    modEntreesSortiesZones.NomUsrHelper.write(_output,n);
                    modEntreesSortiesZones.PrenomUsrHelper.write(_output,preU);
                    modEntreesSortiesZones.PhotoUsrHelper.write(_output,phoU);
                    modEntreesSortiesZones.PasswordPermHelper.write(_output,pwd);
                    _input = this._invoke(_output);
                    return;
                }
                catch(org.omg.CORBA.portable.RemarshalException _exception)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _exception)
                {
                    String _exception_id = _exception.getId();
                    if (_exception_id.equals(modEntreesSortiesZones.UtilisateurExistantHelper.id()))
                    {
                        throw modEntreesSortiesZones.UtilisateurExistantHelper.read(_exception.getInputStream());
                    }

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterCollaborateurPerm",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    _self.ajouterCollaborateurPerm( m,  n,  preU,  phoU,  pwd);
                    return;
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}

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
     * Operation verifierAuthentificationPorte
     */
    public modEntreesSortiesZones.Utilisateur verifierAuthentificationPorte(String empCollab, String phoUsr, int zone)
        throws modEntreesSortiesZones.UtilisateurInconnu, modEntreesSortiesZones.EmpreinteInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAuthentificationPorte",true);
                    modEntreesSortiesZones.EmpreinteCollabHelper.write(_output,empCollab);
                    modEntreesSortiesZones.PhotoUsrHelper.write(_output,phoUsr);
                    modEntreesSortiesZones.idZoneHelper.write(_output,zone);
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

                    if (_exception_id.equals(modEntreesSortiesZones.EmpreinteInconnueHelper.id()))
                    {
                        throw modEntreesSortiesZones.EmpreinteInconnueHelper.read(_exception.getInputStream());
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
                    return _self.verifierAuthentificationPorte( empCollab,  phoUsr,  zone);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation verifierAuthentificationLogicielResp
     */
    public boolean verifierAuthentificationLogicielResp(String matricule, String pwd, int zone)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAuthentificationLogicielResp",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.PasswordPermHelper.write(_output,pwd);
                    modEntreesSortiesZones.idZoneHelper.write(_output,zone);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierAuthentificationLogicielResp",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    return _self.verifierAuthentificationLogicielResp( matricule,  pwd,  zone);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation verifierAuthentificationLogicielRH
     */
    public boolean verifierAuthentificationLogicielRH(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAuthentificationLogicielRH",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierAuthentificationLogicielRH",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    return _self.verifierAuthentificationLogicielRH( matricule,  pwd);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation verifierAuthentificationLogicielAccueil
     */
    public boolean verifierAuthentificationLogicielAccueil(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAuthentificationLogicielAccueil",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierAuthentificationLogicielAccueil",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    return _self.verifierAuthentificationLogicielAccueil( matricule,  pwd);
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
    public void ajouterCollaborateurTemp(String matricule, String nomUsr, String preUsr, String phoUsr)
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
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.NomUsrHelper.write(_output,nomUsr);
                    modEntreesSortiesZones.PrenomUsrHelper.write(_output,preUsr);
                    modEntreesSortiesZones.PhotoUsrHelper.write(_output,phoUsr);
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
                    _self.ajouterCollaborateurTemp( matricule,  nomUsr,  preUsr,  phoUsr);
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
     * Operation modifierCollaborateurTemp
     */
    public void modifierCollaborateurTemp(String matricule, String nomUsr, String preUsr, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierCollaborateurTemp",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.NomUsrHelper.write(_output,nomUsr);
                    modEntreesSortiesZones.PrenomUsrHelper.write(_output,preUsr);
                    modEntreesSortiesZones.PhotoUsrHelper.write(_output,phoUsr);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierCollaborateurTemp",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    _self.modifierCollaborateurTemp( matricule,  nomUsr,  preUsr,  phoUsr);
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
     * Operation verifierMatriculeTemp
     */
    public boolean verifierMatriculeTemp(String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierMatriculeTemp",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierMatriculeTemp",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    return _self.verifierMatriculeTemp( matricule);
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
    public void ajouterCollaborateurPerm(String matricule, String nomUsr, String preUsr, String phoUsr, String pwd)
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
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.NomUsrHelper.write(_output,nomUsr);
                    modEntreesSortiesZones.PrenomUsrHelper.write(_output,preUsr);
                    modEntreesSortiesZones.PhotoUsrHelper.write(_output,phoUsr);
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
                    _self.ajouterCollaborateurPerm( matricule,  nomUsr,  preUsr,  phoUsr,  pwd);
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
     * Operation modifierCollaborateurPerm
     */
    public void modifierCollaborateurPerm(String matricule, String nomUsr, String preUsr, String phoUsr)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierCollaborateurPerm",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.NomUsrHelper.write(_output,nomUsr);
                    modEntreesSortiesZones.PrenomUsrHelper.write(_output,preUsr);
                    modEntreesSortiesZones.PhotoUsrHelper.write(_output,phoUsr);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierCollaborateurPerm",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    _self.modifierCollaborateurPerm( matricule,  nomUsr,  preUsr,  phoUsr);
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
     * Operation verifierMatriculePerm
     */
    public boolean verifierMatriculePerm(String matricule)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierMatriculePerm",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierMatriculePerm",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    return _self.verifierMatriculePerm( matricule);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation verifierAuthentificationMachineEmpreinteCollaborateurPerm
     */
    public boolean verifierAuthentificationMachineEmpreinteCollaborateurPerm(String matricule, String pwd)
        throws modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAuthentificationMachineEmpreinteCollaborateurPerm",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierAuthentificationMachineEmpreinteCollaborateurPerm",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    return _self.verifierAuthentificationMachineEmpreinteCollaborateurPerm( matricule,  pwd);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getCollaborateursTemporaires
     */
    public modEntreesSortiesZones.Utilisateur[] getCollaborateursTemporaires()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getCollaborateursTemporaires",true);
                    _input = this._invoke(_output);
                    modEntreesSortiesZones.Utilisateur[] _arg_ret = modEntreesSortiesZones.lesUtilisateursHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCollaborateursTemporaires",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    return _self.getCollaborateursTemporaires();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getCollaborateursPermanents
     */
    public modEntreesSortiesZones.Utilisateur[] getCollaborateursPermanents()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getCollaborateursPermanents",true);
                    _input = this._invoke(_output);
                    modEntreesSortiesZones.Utilisateur[] _arg_ret = modEntreesSortiesZones.lesUtilisateursHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getCollaborateursPermanents",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAuthentificationOperations _self = (modEntreesSortiesZones.ServiceAuthentificationOperations) _so.servant;
                try
                {
                    return _self.getCollaborateursPermanents();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}

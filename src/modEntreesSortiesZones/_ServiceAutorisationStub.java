package modEntreesSortiesZones;

/**
 * Interface definition : ServiceAutorisation
 * 
 * @author OpenORB Compiler
 */
public class _ServiceAutorisationStub extends org.omg.CORBA.portable.ObjectImpl
        implements ServiceAutorisation
{
    static final String[] _ids_list =
    {
        "IDL:modEntreesSortiesZones/ServiceAutorisation:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = modEntreesSortiesZones.ServiceAutorisationOperations.class;

    /**
     * Operation verifierAutorisation
     */
    public boolean verifierAutorisation(String matricule, int idZone)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierAutorisation",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.idZoneHelper.write(_output,idZone);
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
                    if (_exception_id.equals(modEntreesSortiesZones.AutorisationInconnueHelper.id()))
                    {
                        throw modEntreesSortiesZones.AutorisationInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierAutorisation",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAutorisationOperations _self = (modEntreesSortiesZones.ServiceAutorisationOperations) _so.servant;
                try
                {
                    return _self.verifierAutorisation( matricule,  idZone);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation ajouterAutorisationTemp
     */
    public void ajouterAutorisationTemp(String matricule, int idZone, String hrDebut, String hrFin, String jrDebut, String jrFin)
        throws modEntreesSortiesZones.AutorisationExistante, modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterAutorisationTemp",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.idZoneHelper.write(_output,idZone);
                    modEntreesSortiesZones.HeureDebutHelper.write(_output,hrDebut);
                    modEntreesSortiesZones.HeureFinHelper.write(_output,hrFin);
                    modEntreesSortiesZones.JourDebutHelper.write(_output,jrDebut);
                    modEntreesSortiesZones.JourFinHelper.write(_output,jrFin);
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
                    if (_exception_id.equals(modEntreesSortiesZones.AutorisationExistanteHelper.id()))
                    {
                        throw modEntreesSortiesZones.AutorisationExistanteHelper.read(_exception.getInputStream());
                    }

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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterAutorisationTemp",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAutorisationOperations _self = (modEntreesSortiesZones.ServiceAutorisationOperations) _so.servant;
                try
                {
                    _self.ajouterAutorisationTemp( matricule,  idZone,  hrDebut,  hrFin,  jrDebut,  jrFin);
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
     * Operation modifierAutorisationTemp
     */
    public void modifierAutorisationTemp(String matricule, int idZone, String hrDebut, String hrFin, String jrDebut, String jrFin)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierAutorisationTemp",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.idZoneHelper.write(_output,idZone);
                    modEntreesSortiesZones.HeureDebutHelper.write(_output,hrDebut);
                    modEntreesSortiesZones.HeureFinHelper.write(_output,hrFin);
                    modEntreesSortiesZones.JourDebutHelper.write(_output,jrDebut);
                    modEntreesSortiesZones.JourFinHelper.write(_output,jrFin);
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
                    if (_exception_id.equals(modEntreesSortiesZones.AutorisationInconnueHelper.id()))
                    {
                        throw modEntreesSortiesZones.AutorisationInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierAutorisationTemp",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAutorisationOperations _self = (modEntreesSortiesZones.ServiceAutorisationOperations) _so.servant;
                try
                {
                    _self.modifierAutorisationTemp( matricule,  idZone,  hrDebut,  hrFin,  jrDebut,  jrFin);
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
     * Operation supprimerAutorisationTemp
     */
    public void supprimerAutorisationTemp(String matricule, int idZone)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerAutorisationTemp",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.idZoneHelper.write(_output,idZone);
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
                    if (_exception_id.equals(modEntreesSortiesZones.AutorisationInconnueHelper.id()))
                    {
                        throw modEntreesSortiesZones.AutorisationInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerAutorisationTemp",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAutorisationOperations _self = (modEntreesSortiesZones.ServiceAutorisationOperations) _so.servant;
                try
                {
                    _self.supprimerAutorisationTemp( matricule,  idZone);
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
     * Operation ajouterAutorisationPerm
     */
    public void ajouterAutorisationPerm(String matricule, int idZone, String hrDebut, String hrFin)
        throws modEntreesSortiesZones.AutorisationExistante, modEntreesSortiesZones.UtilisateurInconnu
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterAutorisationPerm",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.idZoneHelper.write(_output,idZone);
                    modEntreesSortiesZones.HeureDebutHelper.write(_output,hrDebut);
                    modEntreesSortiesZones.HeureFinHelper.write(_output,hrFin);
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
                    if (_exception_id.equals(modEntreesSortiesZones.AutorisationExistanteHelper.id()))
                    {
                        throw modEntreesSortiesZones.AutorisationExistanteHelper.read(_exception.getInputStream());
                    }

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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterAutorisationPerm",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAutorisationOperations _self = (modEntreesSortiesZones.ServiceAutorisationOperations) _so.servant;
                try
                {
                    _self.ajouterAutorisationPerm( matricule,  idZone,  hrDebut,  hrFin);
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
     * Operation modifierAutorisationPerm
     */
    public void modifierAutorisationPerm(String matricule, int idZone, String hrDebut, String hrFin)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierAutorisationPerm",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.idZoneHelper.write(_output,idZone);
                    modEntreesSortiesZones.HeureDebutHelper.write(_output,hrDebut);
                    modEntreesSortiesZones.HeureFinHelper.write(_output,hrFin);
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
                    if (_exception_id.equals(modEntreesSortiesZones.AutorisationInconnueHelper.id()))
                    {
                        throw modEntreesSortiesZones.AutorisationInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierAutorisationPerm",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAutorisationOperations _self = (modEntreesSortiesZones.ServiceAutorisationOperations) _so.servant;
                try
                {
                    _self.modifierAutorisationPerm( matricule,  idZone,  hrDebut,  hrFin);
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
     * Operation supprimerAutorisationPerm
     */
    public void supprimerAutorisationPerm(String matricule, int idZone)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerAutorisationPerm",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.idZoneHelper.write(_output,idZone);
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
                    if (_exception_id.equals(modEntreesSortiesZones.AutorisationInconnueHelper.id()))
                    {
                        throw modEntreesSortiesZones.AutorisationInconnueHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerAutorisationPerm",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAutorisationOperations _self = (modEntreesSortiesZones.ServiceAutorisationOperations) _so.servant;
                try
                {
                    _self.supprimerAutorisationPerm( matricule,  idZone);
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
     * Operation getIdZoneFromPorte
     */
    public int getIdZoneFromPorte(int idPorte)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getIdZoneFromPorte",true);
                    modEntreesSortiesZones.IdPorteHelper.write(_output,idPorte);
                    _input = this._invoke(_output);
                    int _arg_ret = modEntreesSortiesZones.idZoneHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getIdZoneFromPorte",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAutorisationOperations _self = (modEntreesSortiesZones.ServiceAutorisationOperations) _so.servant;
                try
                {
                    return _self.getIdZoneFromPorte( idPorte);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getZone
     */
    public modEntreesSortiesZones.Zone[] getZone()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getZone",true);
                    _input = this._invoke(_output);
                    modEntreesSortiesZones.Zone[] _arg_ret = modEntreesSortiesZones.lesZonesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getZone",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAutorisationOperations _self = (modEntreesSortiesZones.ServiceAutorisationOperations) _so.servant;
                try
                {
                    return _self.getZone();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getAutorisationPerm
     */
    public modEntreesSortiesZones.AutorisationPerm[] getAutorisationPerm()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getAutorisationPerm",true);
                    _input = this._invoke(_output);
                    modEntreesSortiesZones.AutorisationPerm[] _arg_ret = modEntreesSortiesZones.lesAutorisationsPermHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getAutorisationPerm",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAutorisationOperations _self = (modEntreesSortiesZones.ServiceAutorisationOperations) _so.servant;
                try
                {
                    return _self.getAutorisationPerm();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation getAutorisationTemp
     */
    public modEntreesSortiesZones.AutorisationTemp[] getAutorisationTemp()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("getAutorisationTemp",true);
                    _input = this._invoke(_output);
                    modEntreesSortiesZones.AutorisationTemp[] _arg_ret = modEntreesSortiesZones.lesAutorisationsTempHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("getAutorisationTemp",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAutorisationOperations _self = (modEntreesSortiesZones.ServiceAutorisationOperations) _so.servant;
                try
                {
                    return _self.getAutorisationTemp();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}

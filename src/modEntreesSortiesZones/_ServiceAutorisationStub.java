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
    public void ajouterAutorisationTemp(String matricule, int idZone, String jrDebut, String jrFin)
        throws modEntreesSortiesZones.AutorisationExistante
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
                    _self.ajouterAutorisationTemp( matricule,  idZone,  jrDebut,  jrFin);
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
    public void modifierAutorisationTemp(String matricule, int idZone, String jrDebut, String jrFin)
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
                    _self.modifierAutorisationTemp( matricule,  idZone,  jrDebut,  jrFin);
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
    public void ajouterAutorisationPerm(String matricule, int idZone, int hrDebut, int hrFin)
        throws modEntreesSortiesZones.AutorisationExistante
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
    public void modifierAutorisationPerm(String matricule, int idZone, int hrDebut, int hrFin)
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
     * Operation supprimerAutorisation
     */
    public void supprimerAutorisation(String matricule, int idZone)
        throws modEntreesSortiesZones.AutorisationInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("supprimerAutorisation",true);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("supprimerAutorisation",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceAutorisationOperations _self = (modEntreesSortiesZones.ServiceAutorisationOperations) _so.servant;
                try
                {
                    _self.supprimerAutorisation( matricule,  idZone);
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
     * Operation getZone
     */
    public modEntreesSortiesZones.Zone[] getZone()
        throws modEntreesSortiesZones.SQLERROR
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
                    if (_exception_id.equals(modEntreesSortiesZones.SQLERRORHelper.id()))
                    {
                        throw modEntreesSortiesZones.SQLERRORHelper.read(_exception.getInputStream());
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

}

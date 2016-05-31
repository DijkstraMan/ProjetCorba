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
    public boolean verifierAutorisation(String m, String n)
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
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
                    modEntreesSortiesZones.idZoneHelper.write(_output,n);
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
                    return _self.verifierAutorisation( m,  n);
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
    public void ajouterAutorisationTemp(String m, String n, String jD, String jF)
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
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
                    modEntreesSortiesZones.idZoneHelper.write(_output,n);
                    modEntreesSortiesZones.JourDebutHelper.write(_output,jD);
                    modEntreesSortiesZones.JourFinHelper.write(_output,jF);
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
                    _self.ajouterAutorisationTemp( m,  n,  jD,  jF);
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
    public void modifierAutorisationTemp(String m, String n, String jD, String jF)
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
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
                    modEntreesSortiesZones.idZoneHelper.write(_output,n);
                    modEntreesSortiesZones.JourDebutHelper.write(_output,jD);
                    modEntreesSortiesZones.JourFinHelper.write(_output,jF);
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
                    _self.modifierAutorisationTemp( m,  n,  jD,  jF);
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
    public void ajouterAutorisationPerm(String m, String n, int hD, int hF)
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
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
                    modEntreesSortiesZones.idZoneHelper.write(_output,n);
                    modEntreesSortiesZones.HeureDebutHelper.write(_output,hD);
                    modEntreesSortiesZones.HeureFinHelper.write(_output,hF);
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
                    _self.ajouterAutorisationPerm( m,  n,  hD,  hF);
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
    public void modifierAutorisationPerm(String m, String n, int hD, int hF)
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
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
                    modEntreesSortiesZones.idZoneHelper.write(_output,n);
                    modEntreesSortiesZones.HeureDebutHelper.write(_output,hD);
                    modEntreesSortiesZones.HeureFinHelper.write(_output,hF);
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
                    _self.modifierAutorisationPerm( m,  n,  hD,  hF);
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
    public void supprimerAutorisation(String m, String n)
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
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
                    modEntreesSortiesZones.idZoneHelper.write(_output,n);
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
                    _self.supprimerAutorisation( m,  n);
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

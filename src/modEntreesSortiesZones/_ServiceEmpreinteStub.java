package modEntreesSortiesZones;

/**
 * Interface definition : ServiceEmpreinte
 * 
 * @author OpenORB Compiler
 */
public class _ServiceEmpreinteStub extends org.omg.CORBA.portable.ObjectImpl
        implements ServiceEmpreinte
{
    static final String[] _ids_list =
    {
        "IDL:modEntreesSortiesZones/ServiceEmpreinte:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = modEntreesSortiesZones.ServiceEmpreinteOperations.class;

    /**
     * Operation verifierEmpreinte
     */
    public boolean verifierEmpreinte(String eC, String m)
        throws modEntreesSortiesZones.EmpreinteInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("verifierEmpreinte",true);
                    modEntreesSortiesZones.EmpreinteCollabHelper.write(_output,eC);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("verifierEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceEmpreinteOperations _self = (modEntreesSortiesZones.ServiceEmpreinteOperations) _so.servant;
                try
                {
                    return _self.verifierEmpreinte( eC,  m);
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation ajouterEmpreinte
     */
    public void ajouterEmpreinte(String e, String m)
        throws modEntreesSortiesZones.EmpreinteExistante
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterEmpreinte",true);
                    modEntreesSortiesZones.EmpreinteCollabHelper.write(_output,e);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
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
                    if (_exception_id.equals(modEntreesSortiesZones.EmpreinteExistanteHelper.id()))
                    {
                        throw modEntreesSortiesZones.EmpreinteExistanteHelper.read(_exception.getInputStream());
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceEmpreinteOperations _self = (modEntreesSortiesZones.ServiceEmpreinteOperations) _so.servant;
                try
                {
                    _self.ajouterEmpreinte( e,  m);
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
     * Operation modifierEmpreinte
     */
    public void modifierEmpreinte(String e, String m)
        throws modEntreesSortiesZones.EmpreinteInconnue
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("modifierEmpreinte",true);
                    modEntreesSortiesZones.EmpreinteCollabHelper.write(_output,e);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,m);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("modifierEmpreinte",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceEmpreinteOperations _self = (modEntreesSortiesZones.ServiceEmpreinteOperations) _so.servant;
                try
                {
                    _self.modifierEmpreinte( e,  m);
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

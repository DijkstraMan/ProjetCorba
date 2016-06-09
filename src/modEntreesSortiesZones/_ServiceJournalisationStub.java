package modEntreesSortiesZones;

/**
 * Interface definition : ServiceJournalisation
 * 
 * @author OpenORB Compiler
 */
public class _ServiceJournalisationStub extends org.omg.CORBA.portable.ObjectImpl
        implements ServiceJournalisation
{
    static final String[] _ids_list =
    {
        "IDL:modEntreesSortiesZones/ServiceJournalisation:1.0"
    };

    public String[] _ids()
    {
     return _ids_list;
    }

    private final static Class _opsClass = modEntreesSortiesZones.ServiceJournalisationOperations.class;

    /**
     * Operation ajouterEntree
     */
    public void ajouterEntree(String matricule, int idZone, String dateAcces, modEntreesSortiesZones.TypeAcces typeAcces)
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("ajouterEntree",true);
                    modEntreesSortiesZones.MatriculeHelper.write(_output,matricule);
                    modEntreesSortiesZones.idZoneHelper.write(_output,idZone);
                    modEntreesSortiesZones.dateLogHelper.write(_output,dateAcces);
                    modEntreesSortiesZones.TypeAccesHelper.write(_output,typeAcces);
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
                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: "+ _exception_id);
                }
                finally
                {
                    this._releaseReply(_input);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("ajouterEntree",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceJournalisationOperations _self = (modEntreesSortiesZones.ServiceJournalisationOperations) _so.servant;
                try
                {
                    _self.ajouterEntree( matricule,  idZone,  dateAcces,  typeAcces);
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
     * Operation consulterAcces
     */
    public modEntreesSortiesZones.LogAcces[] consulterAcces()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterAcces",true);
                    _input = this._invoke(_output);
                    modEntreesSortiesZones.LogAcces[] _arg_ret = modEntreesSortiesZones.logsAccesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulterAcces",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceJournalisationOperations _self = (modEntreesSortiesZones.ServiceJournalisationOperations) _so.servant;
                try
                {
                    return _self.consulterAcces();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

    /**
     * Operation consulterRefus
     */
    public modEntreesSortiesZones.LogAcces[] consulterRefus()
    {
        while(true)
        {
            if (!this._is_local())
            {
                org.omg.CORBA.portable.InputStream _input = null;
                try
                {
                    org.omg.CORBA.portable.OutputStream _output = this._request("consulterRefus",true);
                    _input = this._invoke(_output);
                    modEntreesSortiesZones.LogAcces[] _arg_ret = modEntreesSortiesZones.logsAccesHelper.read(_input);
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
                org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("consulterRefus",_opsClass);
                if (_so == null)
                   continue;
                modEntreesSortiesZones.ServiceJournalisationOperations _self = (modEntreesSortiesZones.ServiceJournalisationOperations) _so.servant;
                try
                {
                    return _self.consulterRefus();
                }
                finally
                {
                    _servant_postinvoke(_so);
                }
            }
        }
    }

}

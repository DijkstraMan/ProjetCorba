package modEntreesSortiesZones;

/**
 * Interface definition : ServiceJournalisation
 * 
 * @author OpenORB Compiler
 */
public abstract class ServiceJournalisationPOA extends org.omg.PortableServer.Servant
        implements ServiceJournalisationOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ServiceJournalisation _this()
    {
        return ServiceJournalisationHelper.narrow(_this_object());
    }

    public ServiceJournalisation _this(org.omg.CORBA.ORB orb)
    {
        return ServiceJournalisationHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:modEntreesSortiesZones/ServiceJournalisation:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("ajouterEntree")) {
                return _invoke_ajouterEntree(_is, handler);
        } else if (opName.equals("consulterAcces")) {
                return _invoke_consulterAcces(_is, handler);
        } else if (opName.equals("consulterRefus")) {
                return _invoke_consulterRefus(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_ajouterEntree(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.idZoneHelper.read(_is);
        int arg2_in = modEntreesSortiesZones.TimeStampHelper.read(_is);
        modEntreesSortiesZones.TypeAcces arg3_in = modEntreesSortiesZones.TypeAccesHelper.read(_is);

        ajouterEntree(arg0_in, arg1_in, arg2_in, arg3_in);

        _output = handler.createReply();

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterAcces(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        modEntreesSortiesZones.LogAcces[] _arg_result = consulterAcces();

        _output = handler.createReply();
        modEntreesSortiesZones.LogsAccesHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_consulterRefus(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        modEntreesSortiesZones.LogAcces[] _arg_result = consulterRefus();

        _output = handler.createReply();
        modEntreesSortiesZones.LogsAccesHelper.write(_output,_arg_result);

        return _output;
    }

}

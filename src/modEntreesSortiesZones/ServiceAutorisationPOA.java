package modEntreesSortiesZones;

/**
 * Interface definition : ServiceAutorisation
 * 
 * @author OpenORB Compiler
 */
public abstract class ServiceAutorisationPOA extends org.omg.PortableServer.Servant
        implements ServiceAutorisationOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ServiceAutorisation _this()
    {
        return ServiceAutorisationHelper.narrow(_this_object());
    }

    public ServiceAutorisation _this(org.omg.CORBA.ORB orb)
    {
        return ServiceAutorisationHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:modEntreesSortiesZones/ServiceAutorisation:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("ajouterAutorisationPerm")) {
                return _invoke_ajouterAutorisationPerm(_is, handler);
        } else if (opName.equals("ajouterAutorisationTemp")) {
                return _invoke_ajouterAutorisationTemp(_is, handler);
        } else if (opName.equals("getZone")) {
                return _invoke_getZone(_is, handler);
        } else if (opName.equals("modifierAutorisationPerm")) {
                return _invoke_modifierAutorisationPerm(_is, handler);
        } else if (opName.equals("modifierAutorisationTemp")) {
                return _invoke_modifierAutorisationTemp(_is, handler);
        } else if (opName.equals("supprimerAutorisation")) {
                return _invoke_supprimerAutorisation(_is, handler);
        } else if (opName.equals("verifierAutorisation")) {
                return _invoke_verifierAutorisation(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_verifierAutorisation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        int arg1_in = modEntreesSortiesZones.idZoneHelper.read(_is);

        try
        {
            boolean _arg_result = verifierAutorisation(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (modEntreesSortiesZones.AutorisationInconnue _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.AutorisationInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterAutorisationTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        int arg1_in = modEntreesSortiesZones.idZoneHelper.read(_is);
        String arg2_in = modEntreesSortiesZones.JourDebutHelper.read(_is);
        String arg3_in = modEntreesSortiesZones.JourFinHelper.read(_is);

        try
        {
            ajouterAutorisationTemp(arg0_in, arg1_in, arg2_in, arg3_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.AutorisationExistante _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.AutorisationExistanteHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierAutorisationTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        int arg1_in = modEntreesSortiesZones.idZoneHelper.read(_is);
        String arg2_in = modEntreesSortiesZones.JourDebutHelper.read(_is);
        String arg3_in = modEntreesSortiesZones.JourFinHelper.read(_is);

        try
        {
            modifierAutorisationTemp(arg0_in, arg1_in, arg2_in, arg3_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.AutorisationInconnue _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.AutorisationInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterAutorisationPerm(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        int arg1_in = modEntreesSortiesZones.idZoneHelper.read(_is);
        int arg2_in = modEntreesSortiesZones.HeureDebutHelper.read(_is);
        int arg3_in = modEntreesSortiesZones.HeureFinHelper.read(_is);

        try
        {
            ajouterAutorisationPerm(arg0_in, arg1_in, arg2_in, arg3_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.AutorisationExistante _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.AutorisationExistanteHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierAutorisationPerm(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        int arg1_in = modEntreesSortiesZones.idZoneHelper.read(_is);
        int arg2_in = modEntreesSortiesZones.HeureDebutHelper.read(_is);
        int arg3_in = modEntreesSortiesZones.HeureFinHelper.read(_is);

        try
        {
            modifierAutorisationPerm(arg0_in, arg1_in, arg2_in, arg3_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.AutorisationInconnue _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.AutorisationInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerAutorisation(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        int arg1_in = modEntreesSortiesZones.idZoneHelper.read(_is);

        try
        {
            supprimerAutorisation(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.AutorisationInconnue _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.AutorisationInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getZone(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        modEntreesSortiesZones.Zone[] _arg_result = getZone();

        _output = handler.createReply();
        modEntreesSortiesZones.lesZonesHelper.write(_output,_arg_result);

        return _output;
    }

}

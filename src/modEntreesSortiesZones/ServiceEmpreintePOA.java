package modEntreesSortiesZones;

/**
 * Interface definition : ServiceEmpreinte
 * 
 * @author OpenORB Compiler
 */
public abstract class ServiceEmpreintePOA extends org.omg.PortableServer.Servant
        implements ServiceEmpreinteOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ServiceEmpreinte _this()
    {
        return ServiceEmpreinteHelper.narrow(_this_object());
    }

    public ServiceEmpreinte _this(org.omg.CORBA.ORB orb)
    {
        return ServiceEmpreinteHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:modEntreesSortiesZones/ServiceEmpreinte:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("ajouterEmpreinte")) {
                return _invoke_ajouterEmpreinte(_is, handler);
        } else if (opName.equals("modifierEmpreinte")) {
                return _invoke_modifierEmpreinte(_is, handler);
        } else if (opName.equals("supprimerEmpreinteTemp")) {
                return _invoke_supprimerEmpreinteTemp(_is, handler);
        } else if (opName.equals("verifierEmpreinte")) {
                return _invoke_verifierEmpreinte(_is, handler);
        } else if (opName.equals("verifierEmpreintePermExistante")) {
                return _invoke_verifierEmpreintePermExistante(_is, handler);
        } else if (opName.equals("verifierEmpreinteTempExistante")) {
                return _invoke_verifierEmpreinteTempExistante(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_verifierEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.EmpreinteCollabHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.MatriculeHelper.read(_is);

        try
        {
            boolean _arg_result = verifierEmpreinte(arg0_in, arg1_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (modEntreesSortiesZones.EmpreinteInconnue _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.EmpreinteInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.EmpreinteCollabHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.MatriculeHelper.read(_is);

        try
        {
            ajouterEmpreinte(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.EmpreinteExistante _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.EmpreinteExistanteHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_modifierEmpreinte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.EmpreinteCollabHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.MatriculeHelper.read(_is);

        try
        {
            modifierEmpreinte(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.UtilisateurInconnu _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.UtilisateurInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerEmpreinteTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);

        try
        {
            supprimerEmpreinteTemp(arg0_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.EmpreinteInconnue _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.EmpreinteInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierEmpreinteTempExistante(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);

        try
        {
            boolean _arg_result = verifierEmpreinteTempExistante(arg0_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (modEntreesSortiesZones.UtilisateurInconnu _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.UtilisateurInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierEmpreintePermExistante(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);

        try
        {
            boolean _arg_result = verifierEmpreintePermExistante(arg0_in);

            _output = handler.createReply();
            _output.write_boolean(_arg_result);

        }
        catch (modEntreesSortiesZones.UtilisateurInconnu _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.UtilisateurInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

}

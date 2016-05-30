package modEntreesSortiesZones;

/**
 * Interface definition : ServiceAuthentification
 * 
 * @author OpenORB Compiler
 */
public abstract class ServiceAuthentificationPOA extends org.omg.PortableServer.Servant
        implements ServiceAuthentificationOperations, org.omg.CORBA.portable.InvokeHandler
{
    public ServiceAuthentification _this()
    {
        return ServiceAuthentificationHelper.narrow(_this_object());
    }

    public ServiceAuthentification _this(org.omg.CORBA.ORB orb)
    {
        return ServiceAuthentificationHelper.narrow(_this_object(orb));
    }

    private static String [] _ids_list =
    {
        "IDL:modEntreesSortiesZones/ServiceAuthentification:1.0"
    };

    public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte [] objectId)
    {
        return _ids_list;
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        if (opName.equals("ajouterCollaborateurPerm")) {
                return _invoke_ajouterCollaborateurPerm(_is, handler);
        } else if (opName.equals("ajouterCollaborateurTemp")) {
                return _invoke_ajouterCollaborateurTemp(_is, handler);
        } else if (opName.equals("getUtilisateur")) {
                return _invoke_getUtilisateur(_is, handler);
        } else if (opName.equals("getUtilisateurs")) {
                return _invoke_getUtilisateurs(_is, handler);
        } else if (opName.equals("modifierUtilisateur")) {
                return _invoke_modifierUtilisateur(_is, handler);
        } else if (opName.equals("verifierAuthentificationLogiciel")) {
                return _invoke_verifierAuthentificationLogiciel(_is, handler);
        } else if (opName.equals("verifierAuthentificationPorte")) {
                return _invoke_verifierAuthentificationPorte(_is, handler);
        } else {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_modifierUtilisateur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.NomUsrHelper.read(_is);
        String arg2_in = modEntreesSortiesZones.PrenomUsrHelper.read(_is);
        String arg3_in = modEntreesSortiesZones.PhotoUsrHelper.read(_is);

        try
        {
            modifierUtilisateur(arg0_in, arg1_in, arg2_in, arg3_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.UtilisateurInconnu _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.UtilisateurInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getUtilisateur(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);

        try
        {
            modEntreesSortiesZones.Utilisateur _arg_result = getUtilisateur(arg0_in);

            _output = handler.createReply();
            modEntreesSortiesZones.UtilisateurHelper.write(_output,_arg_result);

        }
        catch (modEntreesSortiesZones.UtilisateurInconnu _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.UtilisateurInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getUtilisateurs(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        modEntreesSortiesZones.Utilisateur[] _arg_result = getUtilisateurs();

        _output = handler.createReply();
        modEntreesSortiesZones.LesUtilisateursHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierAuthentificationPorte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.EmpreinteCollabHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.PhotoUsrHelper.read(_is);

        try
        {
            String _arg_result = verifierAuthentificationPorte(arg0_in, arg1_in);

            _output = handler.createReply();
            modEntreesSortiesZones.NomUsrHelper.write(_output,_arg_result);

        }
        catch (modEntreesSortiesZones.UtilisateurInconnu _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.UtilisateurInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierAuthentificationLogiciel(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.PasswordPermHelper.read(_is);

        try
        {
            boolean _arg_result = verifierAuthentificationLogiciel(arg0_in, arg1_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterCollaborateurTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.NomUsrHelper.read(_is);
        String arg2_in = modEntreesSortiesZones.PrenomUsrHelper.read(_is);
        String arg3_in = modEntreesSortiesZones.PhotoUsrHelper.read(_is);

        try
        {
            ajouterCollaborateurTemp(arg0_in, arg1_in, arg2_in, arg3_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.UtilisateurExistant _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.UtilisateurExistantHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterCollaborateurPerm(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.NomUsrHelper.read(_is);
        String arg2_in = modEntreesSortiesZones.PrenomUsrHelper.read(_is);
        String arg3_in = modEntreesSortiesZones.PhotoUsrHelper.read(_is);
        String arg4_in = modEntreesSortiesZones.PasswordPermHelper.read(_is);

        try
        {
            ajouterCollaborateurPerm(arg0_in, arg1_in, arg2_in, arg3_in, arg4_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.UtilisateurExistant _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.UtilisateurExistantHelper.write(_output,_exception);
        }
        return _output;
    }

}

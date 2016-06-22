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

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("ajouterCollaborateurPerm",
                    new Operation_ajouterCollaborateurPerm());
            operationMap.put("ajouterCollaborateurTemp",
                    new Operation_ajouterCollaborateurTemp());
            operationMap.put("getCollaborateursPermanents",
                    new Operation_getCollaborateursPermanents());
            operationMap.put("getCollaborateursTemporaires",
                    new Operation_getCollaborateursTemporaires());
            operationMap.put("modifierCollaborateurPerm",
                    new Operation_modifierCollaborateurPerm());
            operationMap.put("modifierCollaborateurTemp",
                    new Operation_modifierCollaborateurTemp());
            operationMap.put("verifierAuthentificationLogicielAccueil",
                    new Operation_verifierAuthentificationLogicielAccueil());
            operationMap.put("verifierAuthentificationLogicielRH",
                    new Operation_verifierAuthentificationLogicielRH());
            operationMap.put("verifierAuthentificationLogicielResp",
                    new Operation_verifierAuthentificationLogicielResp());
            operationMap.put("verifierAuthentificationMachineEmpreinteCollaborateurPerm",
                    new Operation_verifierAuthentificationMachineEmpreinteCollaborateurPerm());
            operationMap.put("verifierAuthentificationMachineEmpreinteCollaborateurTemp",
                    new Operation_verifierAuthentificationMachineEmpreinteCollaborateurTemp());
            operationMap.put("verifierAuthentificationPorte",
                    new Operation_verifierAuthentificationPorte());
            operationMap.put("verifierMatriculePerm",
                    new Operation_verifierMatriculePerm());
            operationMap.put("verifierMatriculeTemp",
                    new Operation_verifierMatriculeTemp());
    }

    public final org.omg.CORBA.portable.OutputStream _invoke(final String opName,
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler)
    {

        final AbstractOperation operation = (AbstractOperation)operationMap.get(opName);

        if (null == operation) {
            throw new org.omg.CORBA.BAD_OPERATION(opName);
        }

        return operation.invoke(this, _is, handler);
    }

    // helper methods
    private org.omg.CORBA.portable.OutputStream _invoke_verifierAuthentificationPorte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.EmpreinteCollabHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.PhotoUsrHelper.read(_is);
        int arg2_in = modEntreesSortiesZones.idZoneHelper.read(_is);

        try
        {
            modEntreesSortiesZones.Utilisateur _arg_result = verifierAuthentificationPorte(arg0_in, arg1_in, arg2_in);

            _output = handler.createReply();
            modEntreesSortiesZones.UtilisateurHelper.write(_output,_arg_result);

        }
        catch (modEntreesSortiesZones.UtilisateurInconnu _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.UtilisateurInconnuHelper.write(_output,_exception);
        }
        catch (modEntreesSortiesZones.EmpreinteInconnue _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.EmpreinteInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierAuthentificationLogicielResp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.PasswordPermHelper.read(_is);
        int arg2_in = modEntreesSortiesZones.idZoneHelper.read(_is);

        try
        {
            boolean _arg_result = verifierAuthentificationLogicielResp(arg0_in, arg1_in, arg2_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_verifierAuthentificationLogicielRH(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.PasswordPermHelper.read(_is);

        try
        {
            boolean _arg_result = verifierAuthentificationLogicielRH(arg0_in, arg1_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_verifierAuthentificationLogicielAccueil(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.PasswordPermHelper.read(_is);

        try
        {
            boolean _arg_result = verifierAuthentificationLogicielAccueil(arg0_in, arg1_in);

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
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
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

    private org.omg.CORBA.portable.OutputStream _invoke_modifierCollaborateurTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.NomUsrHelper.read(_is);
        String arg2_in = modEntreesSortiesZones.PrenomUsrHelper.read(_is);
        String arg3_in = modEntreesSortiesZones.PhotoUsrHelper.read(_is);

        try
        {
            modifierCollaborateurTemp(arg0_in, arg1_in, arg2_in, arg3_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.UtilisateurInconnu _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.UtilisateurInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierMatriculeTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);

        try
        {
            boolean _arg_result = verifierMatriculeTemp(arg0_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_verifierAuthentificationMachineEmpreinteCollaborateurTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);

        try
        {
            boolean _arg_result = verifierAuthentificationMachineEmpreinteCollaborateurTemp(arg0_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_ajouterCollaborateurPerm(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
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

    private org.omg.CORBA.portable.OutputStream _invoke_modifierCollaborateurPerm(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.NomUsrHelper.read(_is);
        String arg2_in = modEntreesSortiesZones.PrenomUsrHelper.read(_is);
        String arg3_in = modEntreesSortiesZones.PhotoUsrHelper.read(_is);

        try
        {
            modifierCollaborateurPerm(arg0_in, arg1_in, arg2_in, arg3_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.UtilisateurInconnu _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.UtilisateurInconnuHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_verifierMatriculePerm(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);

        try
        {
            boolean _arg_result = verifierMatriculePerm(arg0_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_verifierAuthentificationMachineEmpreinteCollaborateurPerm(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        String arg1_in = modEntreesSortiesZones.PasswordPermHelper.read(_is);

        try
        {
            boolean _arg_result = verifierAuthentificationMachineEmpreinteCollaborateurPerm(arg0_in, arg1_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_getCollaborateursTemporaires(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        modEntreesSortiesZones.Utilisateur[] _arg_result = getCollaborateursTemporaires();

        _output = handler.createReply();
        modEntreesSortiesZones.lesUtilisateursHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getCollaborateursPermanents(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        modEntreesSortiesZones.Utilisateur[] _arg_result = getCollaborateursPermanents();

        _output = handler.createReply();
        modEntreesSortiesZones.lesUtilisateursHelper.write(_output,_arg_result);

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                ServiceAuthentificationPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation_verifierAuthentificationPorte extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_verifierAuthentificationPorte(_is, handler);
        }
    }

    private static final class Operation_verifierAuthentificationLogicielResp extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_verifierAuthentificationLogicielResp(_is, handler);
        }
    }

    private static final class Operation_verifierAuthentificationLogicielRH extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_verifierAuthentificationLogicielRH(_is, handler);
        }
    }

    private static final class Operation_verifierAuthentificationLogicielAccueil extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_verifierAuthentificationLogicielAccueil(_is, handler);
        }
    }

    private static final class Operation_ajouterCollaborateurTemp extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_ajouterCollaborateurTemp(_is, handler);
        }
    }

    private static final class Operation_modifierCollaborateurTemp extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_modifierCollaborateurTemp(_is, handler);
        }
    }

    private static final class Operation_verifierMatriculeTemp extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_verifierMatriculeTemp(_is, handler);
        }
    }

    private static final class Operation_verifierAuthentificationMachineEmpreinteCollaborateurTemp extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_verifierAuthentificationMachineEmpreinteCollaborateurTemp(_is, handler);
        }
    }

    private static final class Operation_ajouterCollaborateurPerm extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_ajouterCollaborateurPerm(_is, handler);
        }
    }

    private static final class Operation_modifierCollaborateurPerm extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_modifierCollaborateurPerm(_is, handler);
        }
    }

    private static final class Operation_verifierMatriculePerm extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_verifierMatriculePerm(_is, handler);
        }
    }

    private static final class Operation_verifierAuthentificationMachineEmpreinteCollaborateurPerm extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_verifierAuthentificationMachineEmpreinteCollaborateurPerm(_is, handler);
        }
    }

    private static final class Operation_getCollaborateursTemporaires extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getCollaborateursTemporaires(_is, handler);
        }
    }

    private static final class Operation_getCollaborateursPermanents extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAuthentificationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getCollaborateursPermanents(_is, handler);
        }
    }

}

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

    private static final java.util.Map operationMap = new java.util.HashMap();

    static {
            operationMap.put("ajouterAutorisationPerm",
                    new Operation_ajouterAutorisationPerm());
            operationMap.put("ajouterAutorisationTemp",
                    new Operation_ajouterAutorisationTemp());
            operationMap.put("getAutorisationPerm",
                    new Operation_getAutorisationPerm());
            operationMap.put("getAutorisationTemp",
                    new Operation_getAutorisationTemp());
            operationMap.put("getIdZoneFromPorte",
                    new Operation_getIdZoneFromPorte());
            operationMap.put("getZone",
                    new Operation_getZone());
            operationMap.put("modifierAutorisationPerm",
                    new Operation_modifierAutorisationPerm());
            operationMap.put("modifierAutorisationTemp",
                    new Operation_modifierAutorisationTemp());
            operationMap.put("supprimerAutorisationPerm",
                    new Operation_supprimerAutorisationPerm());
            operationMap.put("supprimerAutorisationTemp",
                    new Operation_supprimerAutorisationTemp());
            operationMap.put("verifierAutorisation",
                    new Operation_verifierAutorisation());
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

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerAutorisationTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        int arg1_in = modEntreesSortiesZones.idZoneHelper.read(_is);

        try
        {
            supprimerAutorisationTemp(arg0_in, arg1_in);

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

    private org.omg.CORBA.portable.OutputStream _invoke_supprimerAutorisationPerm(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        String arg0_in = modEntreesSortiesZones.MatriculeHelper.read(_is);
        int arg1_in = modEntreesSortiesZones.idZoneHelper.read(_is);

        try
        {
            supprimerAutorisationPerm(arg0_in, arg1_in);

            _output = handler.createReply();

        }
        catch (modEntreesSortiesZones.AutorisationInconnue _exception)
        {
            _output = handler.createExceptionReply();
            modEntreesSortiesZones.AutorisationInconnueHelper.write(_output,_exception);
        }
        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getIdZoneFromPorte(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;
        int arg0_in = modEntreesSortiesZones.IdPorteHelper.read(_is);

        int _arg_result = getIdZoneFromPorte(arg0_in);

        _output = handler.createReply();
        modEntreesSortiesZones.idZoneHelper.write(_output,_arg_result);

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

    private org.omg.CORBA.portable.OutputStream _invoke_getAutorisationPerm(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        modEntreesSortiesZones.AutorisationPerm[] _arg_result = getAutorisationPerm();

        _output = handler.createReply();
        modEntreesSortiesZones.lesAutorisationsPermHelper.write(_output,_arg_result);

        return _output;
    }

    private org.omg.CORBA.portable.OutputStream _invoke_getAutorisationTemp(
            final org.omg.CORBA.portable.InputStream _is,
            final org.omg.CORBA.portable.ResponseHandler handler) {
        org.omg.CORBA.portable.OutputStream _output;

        modEntreesSortiesZones.AutorisationTemp[] _arg_result = getAutorisationTemp();

        _output = handler.createReply();
        modEntreesSortiesZones.lesAutorisationsTempHelper.write(_output,_arg_result);

        return _output;
    }

    // operation classes
    private abstract static class AbstractOperation {
        protected abstract org.omg.CORBA.portable.OutputStream invoke(
                ServiceAutorisationPOA target,
                org.omg.CORBA.portable.InputStream _is,
                org.omg.CORBA.portable.ResponseHandler handler);
    }

    private static final class Operation_verifierAutorisation extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_verifierAutorisation(_is, handler);
        }
    }

    private static final class Operation_ajouterAutorisationTemp extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_ajouterAutorisationTemp(_is, handler);
        }
    }

    private static final class Operation_modifierAutorisationTemp extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_modifierAutorisationTemp(_is, handler);
        }
    }

    private static final class Operation_supprimerAutorisationTemp extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_supprimerAutorisationTemp(_is, handler);
        }
    }

    private static final class Operation_ajouterAutorisationPerm extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_ajouterAutorisationPerm(_is, handler);
        }
    }

    private static final class Operation_modifierAutorisationPerm extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_modifierAutorisationPerm(_is, handler);
        }
    }

    private static final class Operation_supprimerAutorisationPerm extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_supprimerAutorisationPerm(_is, handler);
        }
    }

    private static final class Operation_getIdZoneFromPorte extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getIdZoneFromPorte(_is, handler);
        }
    }

    private static final class Operation_getZone extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getZone(_is, handler);
        }
    }

    private static final class Operation_getAutorisationPerm extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getAutorisationPerm(_is, handler);
        }
    }

    private static final class Operation_getAutorisationTemp extends AbstractOperation
    {
        protected org.omg.CORBA.portable.OutputStream invoke(
                final ServiceAutorisationPOA target,
                final org.omg.CORBA.portable.InputStream _is,
                final org.omg.CORBA.portable.ResponseHandler handler) {
            return target._invoke_getAutorisationTemp(_is, handler);
        }
    }

}

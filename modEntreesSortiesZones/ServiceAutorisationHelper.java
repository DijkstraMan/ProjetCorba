package modEntreesSortiesZones;

/** 
 * Helper class for : ServiceAutorisation
 *  
 * @author OpenORB Compiler
 */ 
public class ServiceAutorisationHelper
{
    /**
     * Insert ServiceAutorisation into an any
     * @param a an any
     * @param t ServiceAutorisation value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.ServiceAutorisation t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ServiceAutorisation from an any
     * @param a an any
     * @return the extracted ServiceAutorisation value
     */
    public static modEntreesSortiesZones.ServiceAutorisation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return modEntreesSortiesZones.ServiceAutorisationHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the ServiceAutorisation TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"ServiceAutorisation");
        }
        return _tc;
    }

    /**
     * Return the ServiceAutorisation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/ServiceAutorisation:1.0";

    /**
     * Read ServiceAutorisation from a marshalled stream
     * @param istream the input stream
     * @return the readed ServiceAutorisation value
     */
    public static modEntreesSortiesZones.ServiceAutorisation read(org.omg.CORBA.portable.InputStream istream)
    {
        return(modEntreesSortiesZones.ServiceAutorisation)istream.read_Object(modEntreesSortiesZones._ServiceAutorisationStub.class);
    }

    /**
     * Write ServiceAutorisation into a marshalled stream
     * @param ostream the output stream
     * @param value ServiceAutorisation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.ServiceAutorisation value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ServiceAutorisation
     * @param obj the CORBA Object
     * @return ServiceAutorisation Object
     */
    public static ServiceAutorisation narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServiceAutorisation)
            return (ServiceAutorisation)obj;

        if (obj._is_a(id()))
        {
            _ServiceAutorisationStub stub = new _ServiceAutorisationStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ServiceAutorisation
     * @param obj the CORBA Object
     * @return ServiceAutorisation Object
     */
    public static ServiceAutorisation unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServiceAutorisation)
            return (ServiceAutorisation)obj;

        _ServiceAutorisationStub stub = new _ServiceAutorisationStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}

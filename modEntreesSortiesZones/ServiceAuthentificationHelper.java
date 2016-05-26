package modEntreesSortiesZones;

/** 
 * Helper class for : ServiceAuthentification
 *  
 * @author OpenORB Compiler
 */ 
public class ServiceAuthentificationHelper
{
    /**
     * Insert ServiceAuthentification into an any
     * @param a an any
     * @param t ServiceAuthentification value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.ServiceAuthentification t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ServiceAuthentification from an any
     * @param a an any
     * @return the extracted ServiceAuthentification value
     */
    public static modEntreesSortiesZones.ServiceAuthentification extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return modEntreesSortiesZones.ServiceAuthentificationHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the ServiceAuthentification TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"ServiceAuthentification");
        }
        return _tc;
    }

    /**
     * Return the ServiceAuthentification IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/ServiceAuthentification:1.0";

    /**
     * Read ServiceAuthentification from a marshalled stream
     * @param istream the input stream
     * @return the readed ServiceAuthentification value
     */
    public static modEntreesSortiesZones.ServiceAuthentification read(org.omg.CORBA.portable.InputStream istream)
    {
        return(modEntreesSortiesZones.ServiceAuthentification)istream.read_Object(modEntreesSortiesZones._ServiceAuthentificationStub.class);
    }

    /**
     * Write ServiceAuthentification into a marshalled stream
     * @param ostream the output stream
     * @param value ServiceAuthentification value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.ServiceAuthentification value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ServiceAuthentification
     * @param obj the CORBA Object
     * @return ServiceAuthentification Object
     */
    public static ServiceAuthentification narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServiceAuthentification)
            return (ServiceAuthentification)obj;

        if (obj._is_a(id()))
        {
            _ServiceAuthentificationStub stub = new _ServiceAuthentificationStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ServiceAuthentification
     * @param obj the CORBA Object
     * @return ServiceAuthentification Object
     */
    public static ServiceAuthentification unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServiceAuthentification)
            return (ServiceAuthentification)obj;

        _ServiceAuthentificationStub stub = new _ServiceAuthentificationStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}

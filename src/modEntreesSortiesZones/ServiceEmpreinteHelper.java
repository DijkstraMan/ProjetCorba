package modEntreesSortiesZones;

/** 
 * Helper class for : ServiceEmpreinte
 *  
 * @author OpenORB Compiler
 */ 
public class ServiceEmpreinteHelper
{
    /**
     * Insert ServiceEmpreinte into an any
     * @param a an any
     * @param t ServiceEmpreinte value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.ServiceEmpreinte t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ServiceEmpreinte from an any
     * @param a an any
     * @return the extracted ServiceEmpreinte value
     */
    public static modEntreesSortiesZones.ServiceEmpreinte extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return modEntreesSortiesZones.ServiceEmpreinteHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the ServiceEmpreinte TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"ServiceEmpreinte");
        }
        return _tc;
    }

    /**
     * Return the ServiceEmpreinte IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/ServiceEmpreinte:1.0";

    /**
     * Read ServiceEmpreinte from a marshalled stream
     * @param istream the input stream
     * @return the readed ServiceEmpreinte value
     */
    public static modEntreesSortiesZones.ServiceEmpreinte read(org.omg.CORBA.portable.InputStream istream)
    {
        return(modEntreesSortiesZones.ServiceEmpreinte)istream.read_Object(modEntreesSortiesZones._ServiceEmpreinteStub.class);
    }

    /**
     * Write ServiceEmpreinte into a marshalled stream
     * @param ostream the output stream
     * @param value ServiceEmpreinte value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.ServiceEmpreinte value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ServiceEmpreinte
     * @param obj the CORBA Object
     * @return ServiceEmpreinte Object
     */
    public static ServiceEmpreinte narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServiceEmpreinte)
            return (ServiceEmpreinte)obj;

        if (obj._is_a(id()))
        {
            _ServiceEmpreinteStub stub = new _ServiceEmpreinteStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ServiceEmpreinte
     * @param obj the CORBA Object
     * @return ServiceEmpreinte Object
     */
    public static ServiceEmpreinte unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServiceEmpreinte)
            return (ServiceEmpreinte)obj;

        _ServiceEmpreinteStub stub = new _ServiceEmpreinteStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}

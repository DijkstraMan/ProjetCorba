package modEntreesSortiesZones;

/** 
 * Helper class for : ServiceJournalisation
 *  
 * @author OpenORB Compiler
 */ 
public class ServiceJournalisationHelper
{
    /**
     * Insert ServiceJournalisation into an any
     * @param a an any
     * @param t ServiceJournalisation value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.ServiceJournalisation t)
    {
        a.insert_Object(t , type());
    }

    /**
     * Extract ServiceJournalisation from an any
     * @param a an any
     * @return the extracted ServiceJournalisation value
     */
    public static modEntreesSortiesZones.ServiceJournalisation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        try {
            return modEntreesSortiesZones.ServiceJournalisationHelper.narrow(a.extract_Object());
        } catch (final org.omg.CORBA.BAD_PARAM e) {
            throw new org.omg.CORBA.MARSHAL(e.getMessage());
        }
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the ServiceJournalisation TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_interface_tc(id(),"ServiceJournalisation");
        }
        return _tc;
    }

    /**
     * Return the ServiceJournalisation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/ServiceJournalisation:1.0";

    /**
     * Read ServiceJournalisation from a marshalled stream
     * @param istream the input stream
     * @return the readed ServiceJournalisation value
     */
    public static modEntreesSortiesZones.ServiceJournalisation read(org.omg.CORBA.portable.InputStream istream)
    {
        return(modEntreesSortiesZones.ServiceJournalisation)istream.read_Object(modEntreesSortiesZones._ServiceJournalisationStub.class);
    }

    /**
     * Write ServiceJournalisation into a marshalled stream
     * @param ostream the output stream
     * @param value ServiceJournalisation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.ServiceJournalisation value)
    {
        ostream.write_Object((org.omg.CORBA.portable.ObjectImpl)value);
    }

    /**
     * Narrow CORBA::Object to ServiceJournalisation
     * @param obj the CORBA Object
     * @return ServiceJournalisation Object
     */
    public static ServiceJournalisation narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServiceJournalisation)
            return (ServiceJournalisation)obj;

        if (obj._is_a(id()))
        {
            _ServiceJournalisationStub stub = new _ServiceJournalisationStub();
            stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
            return stub;
        }

        throw new org.omg.CORBA.BAD_PARAM();
    }

    /**
     * Unchecked Narrow CORBA::Object to ServiceJournalisation
     * @param obj the CORBA Object
     * @return ServiceJournalisation Object
     */
    public static ServiceJournalisation unchecked_narrow(org.omg.CORBA.Object obj)
    {
        if (obj == null)
            return null;
        if (obj instanceof ServiceJournalisation)
            return (ServiceJournalisation)obj;

        _ServiceJournalisationStub stub = new _ServiceJournalisationStub();
        stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
        return stub;

    }

}

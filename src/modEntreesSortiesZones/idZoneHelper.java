package modEntreesSortiesZones;

/** 
 * Helper class for : idZone
 *  
 * @author OpenORB Compiler
 */ 
public class idZoneHelper
{
    /**
     * Insert idZone into an any
     * @param a an any
     * @param t idZone value
     */
    public static void insert(org.omg.CORBA.Any a, int t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract idZone from an any
     * @param a an any
     * @return the extracted idZone value
     */
    public static int extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the idZone TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"idZone",orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_long));
        }
        return _tc;
    }

    /**
     * Return the idZone IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/idZone:1.0";

    /**
     * Read idZone from a marshalled stream
     * @param istream the input stream
     * @return the readed idZone value
     */
    public static int read(org.omg.CORBA.portable.InputStream istream)
    {
        int new_one;
        new_one = istream.read_long();

        return new_one;
    }

    /**
     * Write idZone into a marshalled stream
     * @param ostream the output stream
     * @param value idZone value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, int value)
    {
        ostream.write_long(value);
    }

}

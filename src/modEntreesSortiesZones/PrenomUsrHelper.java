package modEntreesSortiesZones;

/** 
 * Helper class for : PrenomUsr
 *  
 * @author OpenORB Compiler
 */ 
public class PrenomUsrHelper
{
    /**
     * Insert PrenomUsr into an any
     * @param a an any
     * @param t PrenomUsr value
     */
    public static void insert(org.omg.CORBA.Any a, String t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract PrenomUsr from an any
     * @param a an any
     * @return the extracted PrenomUsr value
     */
    public static String extract(org.omg.CORBA.Any a)
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
     * Return the PrenomUsr TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"PrenomUsr",orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
        }
        return _tc;
    }

    /**
     * Return the PrenomUsr IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/PrenomUsr:1.0";

    /**
     * Read PrenomUsr from a marshalled stream
     * @param istream the input stream
     * @return the readed PrenomUsr value
     */
    public static String read(org.omg.CORBA.portable.InputStream istream)
    {
        String new_one;
        new_one = istream.read_string();

        return new_one;
    }

    /**
     * Write PrenomUsr into a marshalled stream
     * @param ostream the output stream
     * @param value PrenomUsr value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, String value)
    {
        ostream.write_string(value);
    }

}

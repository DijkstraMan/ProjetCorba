package modEntreesSortiesZones;

/** 
 * Helper class for : PasswordPerm
 *  
 * @author OpenORB Compiler
 */ 
public class PasswordPermHelper
{
    /**
     * Insert PasswordPerm into an any
     * @param a an any
     * @param t PasswordPerm value
     */
    public static void insert(org.omg.CORBA.Any a, String t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract PasswordPerm from an any
     * @param a an any
     * @return the extracted PasswordPerm value
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
     * Return the PasswordPerm TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"PasswordPerm",orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string));
        }
        return _tc;
    }

    /**
     * Return the PasswordPerm IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/PasswordPerm:1.0";

    /**
     * Read PasswordPerm from a marshalled stream
     * @param istream the input stream
     * @return the readed PasswordPerm value
     */
    public static String read(org.omg.CORBA.portable.InputStream istream)
    {
        String new_one;
        new_one = istream.read_string();

        return new_one;
    }

    /**
     * Write PasswordPerm into a marshalled stream
     * @param ostream the output stream
     * @param value PasswordPerm value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, String value)
    {
        ostream.write_string(value);
    }

}

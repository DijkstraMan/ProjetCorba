package modEntreesSortiesZones;

/** 
 * Helper class for : TypeAcces
 *  
 * @author OpenORB Compiler
 */ 
public class TypeAccesHelper
{
    /**
     * Insert TypeAcces into an any
     * @param a an any
     * @param t TypeAcces value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.TypeAcces t)
    {
        a.type(type());
        write(a.create_output_stream(),t);
    }

    /**
     * Extract TypeAcces from an any
     * @param a an any
     * @return the extracted TypeAcces value
     */
    public static modEntreesSortiesZones.TypeAcces extract(org.omg.CORBA.Any a)
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
     * Return the TypeAcces TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            String []_members = new String[3];
            _members[0] = "autorise";
            _members[1] = "nonAutorise";
            _members[2] = "nonAuthentifie";
            _tc = orb.create_enum_tc(id(),"TypeAcces",_members);
        }
        return _tc;
    }

    /**
     * Return the TypeAcces IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/TypeAcces:1.0";

    /**
     * Read TypeAcces from a marshalled stream
     * @param istream the input stream
     * @return the readed TypeAcces value
     */
    public static modEntreesSortiesZones.TypeAcces read(org.omg.CORBA.portable.InputStream istream)
    {
        return TypeAcces.from_int(istream.read_ulong());
    }

    /**
     * Write TypeAcces into a marshalled stream
     * @param ostream the output stream
     * @param value TypeAcces value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.TypeAcces value)
    {
        ostream.write_ulong(value.value());
    }

}

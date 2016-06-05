package modEntreesSortiesZones;

/** 
 * Helper class for : Testrer
 *  
 * @author OpenORB Compiler
 */ 
public class TestrerHelper
{
    private static final boolean HAS_OPENORB;
    static {
        boolean hasOpenORB = false;
        try {
            Thread.currentThread().getContextClassLoader().loadClass("org.openorb.CORBA.Any");
            hasOpenORB = true;
        }
        catch(ClassNotFoundException ex) {
        }
        HAS_OPENORB = hasOpenORB;
    }
    /**
     * Insert Testrer into an any
     * @param a an any
     * @param t Testrer value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.Testrer t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.TestrerHolder(t));
    }

    /**
     * Extract Testrer from an any
     * @param a an any
     * @return the extracted Testrer value
     */
    public static modEntreesSortiesZones.Testrer extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.TestrerHolder)
                    return ((modEntreesSortiesZones.TestrerHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.TestrerHolder h = new modEntreesSortiesZones.TestrerHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;
    private static boolean _working = false;

    /**
     * Return the Testrer TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            synchronized(org.omg.CORBA.TypeCode.class) {
                if (_tc != null)
                    return _tc;
                if (_working)
                    return org.omg.CORBA.ORB.init().create_recursive_tc(id());
                _working = true;
                org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[1];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "raison";
                _members[0].type = orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_string);
                _tc = orb.create_exception_tc(id(),"Testrer",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Testrer IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/Testrer:1.0";

    /**
     * Read Testrer from a marshalled stream
     * @param istream the input stream
     * @return the readed Testrer value
     */
    public static modEntreesSortiesZones.Testrer read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.Testrer new_one = new modEntreesSortiesZones.Testrer();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.raison = istream.read_string();

        return new_one;
    }

    /**
     * Write Testrer into a marshalled stream
     * @param ostream the output stream
     * @param value Testrer value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.Testrer value)
    {
        ostream.write_string(id());
        ostream.write_string(value.raison);
    }

}

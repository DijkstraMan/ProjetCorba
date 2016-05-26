package modEntreesSortiesZones;

/** 
 * Helper class for : UtilisateurInconnu
 *  
 * @author OpenORB Compiler
 */ 
public class UtilisateurInconnuHelper
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
     * Insert UtilisateurInconnu into an any
     * @param a an any
     * @param t UtilisateurInconnu value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.UtilisateurInconnu t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.UtilisateurInconnuHolder(t));
    }

    /**
     * Extract UtilisateurInconnu from an any
     * @param a an any
     * @return the extracted UtilisateurInconnu value
     */
    public static modEntreesSortiesZones.UtilisateurInconnu extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.UtilisateurInconnuHolder)
                    return ((modEntreesSortiesZones.UtilisateurInconnuHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.UtilisateurInconnuHolder h = new modEntreesSortiesZones.UtilisateurInconnuHolder(read(a.create_input_stream()));
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
     * Return the UtilisateurInconnu TypeCode
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
                _tc = orb.create_exception_tc(id(),"UtilisateurInconnu",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the UtilisateurInconnu IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/UtilisateurInconnu:1.0";

    /**
     * Read UtilisateurInconnu from a marshalled stream
     * @param istream the input stream
     * @return the readed UtilisateurInconnu value
     */
    public static modEntreesSortiesZones.UtilisateurInconnu read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.UtilisateurInconnu new_one = new modEntreesSortiesZones.UtilisateurInconnu();

        if (!istream.read_string().equals(id()))
         throw new org.omg.CORBA.MARSHAL();
        new_one.raison = istream.read_string();

        return new_one;
    }

    /**
     * Write UtilisateurInconnu into a marshalled stream
     * @param ostream the output stream
     * @param value UtilisateurInconnu value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.UtilisateurInconnu value)
    {
        ostream.write_string(id());
        ostream.write_string(value.raison);
    }

}

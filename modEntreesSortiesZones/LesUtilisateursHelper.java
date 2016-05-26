package modEntreesSortiesZones;

/** 
 * Helper class for : LesUtilisateurs
 *  
 * @author OpenORB Compiler
 */ 
public class LesUtilisateursHelper
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
     * Insert LesUtilisateurs into an any
     * @param a an any
     * @param t LesUtilisateurs value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.Utilisateur[] t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.LesUtilisateursHolder(t));
    }

    /**
     * Extract LesUtilisateurs from an any
     * @param a an any
     * @return the extracted LesUtilisateurs value
     */
    public static modEntreesSortiesZones.Utilisateur[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.LesUtilisateursHolder)
                    return ((modEntreesSortiesZones.LesUtilisateursHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.LesUtilisateursHolder h = new modEntreesSortiesZones.LesUtilisateursHolder(read(a.create_input_stream()));
            a.insert_Streamable(h);
            return h.value;
        }
        return read(a.create_input_stream());
    }

    //
    // Internal TypeCode value
    //
    private static org.omg.CORBA.TypeCode _tc = null;

    /**
     * Return the LesUtilisateurs TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"LesUtilisateurs",orb.create_sequence_tc(0,modEntreesSortiesZones.UtilisateurHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the LesUtilisateurs IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/LesUtilisateurs:1.0";

    /**
     * Read LesUtilisateurs from a marshalled stream
     * @param istream the input stream
     * @return the readed LesUtilisateurs value
     */
    public static modEntreesSortiesZones.Utilisateur[] read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.Utilisateur[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new modEntreesSortiesZones.Utilisateur[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = modEntreesSortiesZones.UtilisateurHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write LesUtilisateurs into a marshalled stream
     * @param ostream the output stream
     * @param value LesUtilisateurs value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.Utilisateur[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            modEntreesSortiesZones.UtilisateurHelper.write(ostream,value[i7]);

        }
    }

}

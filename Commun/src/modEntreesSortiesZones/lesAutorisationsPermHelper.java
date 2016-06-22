package modEntreesSortiesZones;

/** 
 * Helper class for : lesAutorisationsPerm
 *  
 * @author OpenORB Compiler
 */ 
public class lesAutorisationsPermHelper
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
     * Insert lesAutorisationsPerm into an any
     * @param a an any
     * @param t lesAutorisationsPerm value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.AutorisationPerm[] t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.lesAutorisationsPermHolder(t));
    }

    /**
     * Extract lesAutorisationsPerm from an any
     * @param a an any
     * @return the extracted lesAutorisationsPerm value
     */
    public static modEntreesSortiesZones.AutorisationPerm[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.lesAutorisationsPermHolder)
                    return ((modEntreesSortiesZones.lesAutorisationsPermHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.lesAutorisationsPermHolder h = new modEntreesSortiesZones.lesAutorisationsPermHolder(read(a.create_input_stream()));
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
     * Return the lesAutorisationsPerm TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"lesAutorisationsPerm",orb.create_sequence_tc(0,modEntreesSortiesZones.AutorisationPermHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the lesAutorisationsPerm IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/lesAutorisationsPerm:1.0";

    /**
     * Read lesAutorisationsPerm from a marshalled stream
     * @param istream the input stream
     * @return the readed lesAutorisationsPerm value
     */
    public static modEntreesSortiesZones.AutorisationPerm[] read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.AutorisationPerm[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new modEntreesSortiesZones.AutorisationPerm[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = modEntreesSortiesZones.AutorisationPermHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write lesAutorisationsPerm into a marshalled stream
     * @param ostream the output stream
     * @param value lesAutorisationsPerm value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.AutorisationPerm[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            modEntreesSortiesZones.AutorisationPermHelper.write(ostream,value[i7]);

        }
    }

}

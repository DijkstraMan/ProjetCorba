package modEntreesSortiesZones;

/** 
 * Helper class for : lesLogsAcces
 *  
 * @author OpenORB Compiler
 */ 
public class lesLogsAccesHelper
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
     * Insert lesLogsAcces into an any
     * @param a an any
     * @param t lesLogsAcces value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.LogAcces[] t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.lesLogsAccesHolder(t));
    }

    /**
     * Extract lesLogsAcces from an any
     * @param a an any
     * @return the extracted lesLogsAcces value
     */
    public static modEntreesSortiesZones.LogAcces[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.lesLogsAccesHolder)
                    return ((modEntreesSortiesZones.lesLogsAccesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.lesLogsAccesHolder h = new modEntreesSortiesZones.lesLogsAccesHolder(read(a.create_input_stream()));
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
     * Return the lesLogsAcces TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"lesLogsAcces",orb.create_sequence_tc(0,modEntreesSortiesZones.LogAccesHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the lesLogsAcces IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/lesLogsAcces:1.0";

    /**
     * Read lesLogsAcces from a marshalled stream
     * @param istream the input stream
     * @return the readed lesLogsAcces value
     */
    public static modEntreesSortiesZones.LogAcces[] read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.LogAcces[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new modEntreesSortiesZones.LogAcces[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = modEntreesSortiesZones.LogAccesHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write lesLogsAcces into a marshalled stream
     * @param ostream the output stream
     * @param value lesLogsAcces value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.LogAcces[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            modEntreesSortiesZones.LogAccesHelper.write(ostream,value[i7]);

        }
    }

}

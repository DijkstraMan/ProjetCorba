package modEntreesSortiesZones;

/** 
 * Helper class for : lesLogsAccesZone
 *  
 * @author OpenORB Compiler
 */ 
public class lesLogsAccesZoneHelper
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
     * Insert lesLogsAccesZone into an any
     * @param a an any
     * @param t lesLogsAccesZone value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.LogAccesZone[] t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.lesLogsAccesZoneHolder(t));
    }

    /**
     * Extract lesLogsAccesZone from an any
     * @param a an any
     * @return the extracted lesLogsAccesZone value
     */
    public static modEntreesSortiesZones.LogAccesZone[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.lesLogsAccesZoneHolder)
                    return ((modEntreesSortiesZones.lesLogsAccesZoneHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.lesLogsAccesZoneHolder h = new modEntreesSortiesZones.lesLogsAccesZoneHolder(read(a.create_input_stream()));
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
     * Return the lesLogsAccesZone TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"lesLogsAccesZone",orb.create_sequence_tc(0,modEntreesSortiesZones.LogAccesZoneHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the lesLogsAccesZone IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/lesLogsAccesZone:1.0";

    /**
     * Read lesLogsAccesZone from a marshalled stream
     * @param istream the input stream
     * @return the readed lesLogsAccesZone value
     */
    public static modEntreesSortiesZones.LogAccesZone[] read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.LogAccesZone[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new modEntreesSortiesZones.LogAccesZone[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = modEntreesSortiesZones.LogAccesZoneHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write lesLogsAccesZone into a marshalled stream
     * @param ostream the output stream
     * @param value lesLogsAccesZone value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.LogAccesZone[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            modEntreesSortiesZones.LogAccesZoneHelper.write(ostream,value[i7]);

        }
    }

}

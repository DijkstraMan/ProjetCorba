package modEntreesSortiesZones;

/** 
 * Helper class for : lesZones
 *  
 * @author OpenORB Compiler
 */ 
public class lesZonesHelper
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
     * Insert lesZones into an any
     * @param a an any
     * @param t lesZones value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.Zone[] t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.lesZonesHolder(t));
    }

    /**
     * Extract lesZones from an any
     * @param a an any
     * @return the extracted lesZones value
     */
    public static modEntreesSortiesZones.Zone[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.lesZonesHolder)
                    return ((modEntreesSortiesZones.lesZonesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.lesZonesHolder h = new modEntreesSortiesZones.lesZonesHolder(read(a.create_input_stream()));
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
     * Return the lesZones TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"lesZones",orb.create_sequence_tc(0,modEntreesSortiesZones.ZoneHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the lesZones IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/lesZones:1.0";

    /**
     * Read lesZones from a marshalled stream
     * @param istream the input stream
     * @return the readed lesZones value
     */
    public static modEntreesSortiesZones.Zone[] read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.Zone[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new modEntreesSortiesZones.Zone[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = modEntreesSortiesZones.ZoneHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write lesZones into a marshalled stream
     * @param ostream the output stream
     * @param value lesZones value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.Zone[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            modEntreesSortiesZones.ZoneHelper.write(ostream,value[i7]);

        }
    }

}

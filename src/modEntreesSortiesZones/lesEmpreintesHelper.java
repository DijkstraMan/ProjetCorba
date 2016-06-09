package modEntreesSortiesZones;

/** 
 * Helper class for : lesEmpreintes
 *  
 * @author OpenORB Compiler
 */ 
public class lesEmpreintesHelper
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
     * Insert lesEmpreintes into an any
     * @param a an any
     * @param t lesEmpreintes value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.Empreinte[] t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.lesEmpreintesHolder(t));
    }

    /**
     * Extract lesEmpreintes from an any
     * @param a an any
     * @return the extracted lesEmpreintes value
     */
    public static modEntreesSortiesZones.Empreinte[] extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if(HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.lesEmpreintesHolder)
                    return ((modEntreesSortiesZones.lesEmpreintesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.lesEmpreintesHolder h = new modEntreesSortiesZones.lesEmpreintesHolder(read(a.create_input_stream()));
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
     * Return the lesEmpreintes TypeCode
     * @return a TypeCode
     */
    public static org.omg.CORBA.TypeCode type()
    {
        if (_tc == null) {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            _tc = orb.create_alias_tc(id(),"lesEmpreintes",orb.create_sequence_tc(0,modEntreesSortiesZones.EmpreinteHelper.type()));
        }
        return _tc;
    }

    /**
     * Return the lesEmpreintes IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/lesEmpreintes:1.0";

    /**
     * Read lesEmpreintes from a marshalled stream
     * @param istream the input stream
     * @return the readed lesEmpreintes value
     */
    public static modEntreesSortiesZones.Empreinte[] read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.Empreinte[] new_one;
        {
        int size7 = istream.read_ulong();
        new_one = new modEntreesSortiesZones.Empreinte[size7];
        for (int i7=0; i7<new_one.length; i7++)
         {
            new_one[i7] = modEntreesSortiesZones.EmpreinteHelper.read(istream);

         }
        }

        return new_one;
    }

    /**
     * Write lesEmpreintes into a marshalled stream
     * @param ostream the output stream
     * @param value lesEmpreintes value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.Empreinte[] value)
    {
        ostream.write_ulong(value.length);
        for (int i7=0; i7<value.length; i7++)
        {
            modEntreesSortiesZones.EmpreinteHelper.write(ostream,value[i7]);

        }
    }

}

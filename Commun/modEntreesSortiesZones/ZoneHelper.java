package modEntreesSortiesZones;

/** 
 * Helper class for : Zone
 *  
 * @author OpenORB Compiler
 */ 
public class ZoneHelper
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
     * Insert Zone into an any
     * @param a an any
     * @param t Zone value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.Zone t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.ZoneHolder(t));
    }

    /**
     * Extract Zone from an any
     * @param a an any
     * @return the extracted Zone value
     */
    public static modEntreesSortiesZones.Zone extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.ZoneHolder)
                    return ((modEntreesSortiesZones.ZoneHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.ZoneHolder h = new modEntreesSortiesZones.ZoneHolder(read(a.create_input_stream()));
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
     * Return the Zone TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[2];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "idZne";
                _members[0].type = modEntreesSortiesZones.idZoneHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nomZne";
                _members[1].type = modEntreesSortiesZones.nomZoneHelper.type();
                _tc = orb.create_struct_tc(id(),"Zone",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Zone IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/Zone:1.0";

    /**
     * Read Zone from a marshalled stream
     * @param istream the input stream
     * @return the readed Zone value
     */
    public static modEntreesSortiesZones.Zone read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.Zone new_one = new modEntreesSortiesZones.Zone();

        new_one.idZne = modEntreesSortiesZones.idZoneHelper.read(istream);
        new_one.nomZne = modEntreesSortiesZones.nomZoneHelper.read(istream);

        return new_one;
    }

    /**
     * Write Zone into a marshalled stream
     * @param ostream the output stream
     * @param value Zone value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.Zone value)
    {
        modEntreesSortiesZones.idZoneHelper.write(ostream,value.idZne);
        modEntreesSortiesZones.nomZoneHelper.write(ostream,value.nomZne);
    }

}

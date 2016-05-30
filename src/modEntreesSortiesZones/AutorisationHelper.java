package modEntreesSortiesZones;

/** 
 * Helper class for : Autorisation
 *  
 * @author OpenORB Compiler
 */ 
public class AutorisationHelper
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
     * Insert Autorisation into an any
     * @param a an any
     * @param t Autorisation value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.Autorisation t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.AutorisationHolder(t));
    }

    /**
     * Extract Autorisation from an any
     * @param a an any
     * @return the extracted Autorisation value
     */
    public static modEntreesSortiesZones.Autorisation extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.AutorisationHolder)
                    return ((modEntreesSortiesZones.AutorisationHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.AutorisationHolder h = new modEntreesSortiesZones.AutorisationHolder(read(a.create_input_stream()));
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
     * Return the Autorisation TypeCode
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
                org.omg.CORBA.StructMember []_members = new org.omg.CORBA.StructMember[4];

                _members[0] = new org.omg.CORBA.StructMember();
                _members[0].name = "mat";
                _members[0].type = modEntreesSortiesZones.MatriculeHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "n";
                _members[1].type = modEntreesSortiesZones.idZoneHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "hD";
                _members[2].type = modEntreesSortiesZones.HeureDebutHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "hF";
                _members[3].type = modEntreesSortiesZones.HeureFinHelper.type();
                _tc = orb.create_struct_tc(id(),"Autorisation",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the Autorisation IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/Autorisation:1.0";

    /**
     * Read Autorisation from a marshalled stream
     * @param istream the input stream
     * @return the readed Autorisation value
     */
    public static modEntreesSortiesZones.Autorisation read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.Autorisation new_one = new modEntreesSortiesZones.Autorisation();

        new_one.mat = modEntreesSortiesZones.MatriculeHelper.read(istream);
        new_one.n = modEntreesSortiesZones.idZoneHelper.read(istream);
        new_one.hD = modEntreesSortiesZones.HeureDebutHelper.read(istream);
        new_one.hF = modEntreesSortiesZones.HeureFinHelper.read(istream);

        return new_one;
    }

    /**
     * Write Autorisation into a marshalled stream
     * @param ostream the output stream
     * @param value Autorisation value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.Autorisation value)
    {
        modEntreesSortiesZones.MatriculeHelper.write(ostream,value.mat);
        modEntreesSortiesZones.idZoneHelper.write(ostream,value.n);
        modEntreesSortiesZones.HeureDebutHelper.write(ostream,value.hD);
        modEntreesSortiesZones.HeureFinHelper.write(ostream,value.hF);
    }

}

package modEntreesSortiesZones;

/** 
 * Helper class for : AutorisationPerm
 *  
 * @author OpenORB Compiler
 */ 
public class AutorisationPermHelper
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
     * Insert AutorisationPerm into an any
     * @param a an any
     * @param t AutorisationPerm value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.AutorisationPerm t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.AutorisationPermHolder(t));
    }

    /**
     * Extract AutorisationPerm from an any
     * @param a an any
     * @return the extracted AutorisationPerm value
     */
    public static modEntreesSortiesZones.AutorisationPerm extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.AutorisationPermHolder)
                    return ((modEntreesSortiesZones.AutorisationPermHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.AutorisationPermHolder h = new modEntreesSortiesZones.AutorisationPermHolder(read(a.create_input_stream()));
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
     * Return the AutorisationPerm TypeCode
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
                _members[0].name = "matricule";
                _members[0].type = modEntreesSortiesZones.MatriculeHelper.type();
                _members[1] = new org.omg.CORBA.StructMember();
                _members[1].name = "nomZone";
                _members[1].type = modEntreesSortiesZones.nomZoneHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "hrDebut";
                _members[2].type = modEntreesSortiesZones.HeureDebutHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "hrFin";
                _members[3].type = modEntreesSortiesZones.HeureFinHelper.type();
                _tc = orb.create_struct_tc(id(),"AutorisationPerm",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the AutorisationPerm IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/AutorisationPerm:1.0";

    /**
     * Read AutorisationPerm from a marshalled stream
     * @param istream the input stream
     * @return the readed AutorisationPerm value
     */
    public static modEntreesSortiesZones.AutorisationPerm read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.AutorisationPerm new_one = new modEntreesSortiesZones.AutorisationPerm();

        new_one.matricule = modEntreesSortiesZones.MatriculeHelper.read(istream);
        new_one.nomZone = modEntreesSortiesZones.nomZoneHelper.read(istream);
        new_one.hrDebut = modEntreesSortiesZones.HeureDebutHelper.read(istream);
        new_one.hrFin = modEntreesSortiesZones.HeureFinHelper.read(istream);

        return new_one;
    }

    /**
     * Write AutorisationPerm into a marshalled stream
     * @param ostream the output stream
     * @param value AutorisationPerm value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.AutorisationPerm value)
    {
        modEntreesSortiesZones.MatriculeHelper.write(ostream,value.matricule);
        modEntreesSortiesZones.nomZoneHelper.write(ostream,value.nomZone);
        modEntreesSortiesZones.HeureDebutHelper.write(ostream,value.hrDebut);
        modEntreesSortiesZones.HeureFinHelper.write(ostream,value.hrFin);
    }

}

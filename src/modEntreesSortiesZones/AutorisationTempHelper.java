package modEntreesSortiesZones;

/** 
 * Helper class for : AutorisationTemp
 *  
 * @author OpenORB Compiler
 */ 
public class AutorisationTempHelper
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
     * Insert AutorisationTemp into an any
     * @param a an any
     * @param t AutorisationTemp value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.AutorisationTemp t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.AutorisationTempHolder(t));
    }

    /**
     * Extract AutorisationTemp from an any
     * @param a an any
     * @return the extracted AutorisationTemp value
     */
    public static modEntreesSortiesZones.AutorisationTemp extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.AutorisationTempHolder)
                    return ((modEntreesSortiesZones.AutorisationTempHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.AutorisationTempHolder h = new modEntreesSortiesZones.AutorisationTempHolder(read(a.create_input_stream()));
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
     * Return the AutorisationTemp TypeCode
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
                _members[2].name = "jourDebut";
                _members[2].type = modEntreesSortiesZones.JourDebutHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "jourFin";
                _members[3].type = modEntreesSortiesZones.JourFinHelper.type();
                _tc = orb.create_struct_tc(id(),"AutorisationTemp",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the AutorisationTemp IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/AutorisationTemp:1.0";

    /**
     * Read AutorisationTemp from a marshalled stream
     * @param istream the input stream
     * @return the readed AutorisationTemp value
     */
    public static modEntreesSortiesZones.AutorisationTemp read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.AutorisationTemp new_one = new modEntreesSortiesZones.AutorisationTemp();

        new_one.matricule = modEntreesSortiesZones.MatriculeHelper.read(istream);
        new_one.nomZone = modEntreesSortiesZones.nomZoneHelper.read(istream);
        new_one.jourDebut = modEntreesSortiesZones.JourDebutHelper.read(istream);
        new_one.jourFin = modEntreesSortiesZones.JourFinHelper.read(istream);

        return new_one;
    }

    /**
     * Write AutorisationTemp into a marshalled stream
     * @param ostream the output stream
     * @param value AutorisationTemp value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.AutorisationTemp value)
    {
        modEntreesSortiesZones.MatriculeHelper.write(ostream,value.matricule);
        modEntreesSortiesZones.nomZoneHelper.write(ostream,value.nomZone);
        modEntreesSortiesZones.JourDebutHelper.write(ostream,value.jourDebut);
        modEntreesSortiesZones.JourFinHelper.write(ostream,value.jourFin);
    }

}

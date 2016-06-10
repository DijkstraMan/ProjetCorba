package modEntreesSortiesZones;

/** 
 * Helper class for : LogAcces
 *  
 * @author OpenORB Compiler
 */ 
public class LogAccesHelper
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
     * Insert LogAcces into an any
     * @param a an any
     * @param t LogAcces value
     */
    public static void insert(org.omg.CORBA.Any a, modEntreesSortiesZones.LogAcces t)
    {
        a.insert_Streamable(new modEntreesSortiesZones.LogAccesHolder(t));
    }

    /**
     * Extract LogAcces from an any
     * @param a an any
     * @return the extracted LogAcces value
     */
    public static modEntreesSortiesZones.LogAcces extract(org.omg.CORBA.Any a)
    {
        if (!a.type().equal(type()))
            throw new org.omg.CORBA.MARSHAL();
        if (HAS_OPENORB && a instanceof org.openorb.CORBA.Any) {
            // streamable extraction. The jdk stubs incorrectly define the Any stub
            org.openorb.CORBA.Any any = (org.openorb.CORBA.Any)a;
            try {
                org.omg.CORBA.portable.Streamable s = any.extract_Streamable();
                if(s instanceof modEntreesSortiesZones.LogAccesHolder)
                    return ((modEntreesSortiesZones.LogAccesHolder)s).value;
            } catch (org.omg.CORBA.BAD_INV_ORDER ex) {
            }
            modEntreesSortiesZones.LogAccesHolder h = new modEntreesSortiesZones.LogAccesHolder(read(a.create_input_stream()));
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
     * Return the LogAcces TypeCode
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
                _members[1].name = "idZone";
                _members[1].type = modEntreesSortiesZones.idZoneHelper.type();
                _members[2] = new org.omg.CORBA.StructMember();
                _members[2].name = "dateAcces";
                _members[2].type = modEntreesSortiesZones.dateLogHelper.type();
                _members[3] = new org.omg.CORBA.StructMember();
                _members[3].name = "typeAcces";
                _members[3].type = modEntreesSortiesZones.TypeAccesHelper.type();
                _tc = orb.create_struct_tc(id(),"LogAcces",_members);
                _working = false;
            }
        }
        return _tc;
    }

    /**
     * Return the LogAcces IDL ID
     * @return an ID
     */
    public static String id()
    {
        return _id;
    }

    private final static String _id = "IDL:modEntreesSortiesZones/LogAcces:1.0";

    /**
     * Read LogAcces from a marshalled stream
     * @param istream the input stream
     * @return the readed LogAcces value
     */
    public static modEntreesSortiesZones.LogAcces read(org.omg.CORBA.portable.InputStream istream)
    {
        modEntreesSortiesZones.LogAcces new_one = new modEntreesSortiesZones.LogAcces();

        new_one.matricule = modEntreesSortiesZones.MatriculeHelper.read(istream);
        new_one.idZone = modEntreesSortiesZones.idZoneHelper.read(istream);
<<<<<<< HEAD
        new_one.dateAcces = modEntreesSortiesZones.dateLogHelper.read(istream);
=======
        new_one.t = modEntreesSortiesZones.TimeStampHelper.read(istream);
>>>>>>> ServiceAuthorisationNico
        new_one.typeAcces = modEntreesSortiesZones.TypeAccesHelper.read(istream);

        return new_one;
    }

    /**
     * Write LogAcces into a marshalled stream
     * @param ostream the output stream
     * @param value LogAcces value
     */
    public static void write(org.omg.CORBA.portable.OutputStream ostream, modEntreesSortiesZones.LogAcces value)
    {
        modEntreesSortiesZones.MatriculeHelper.write(ostream,value.matricule);
        modEntreesSortiesZones.idZoneHelper.write(ostream,value.idZone);
<<<<<<< HEAD
        modEntreesSortiesZones.dateLogHelper.write(ostream,value.dateAcces);
=======
        modEntreesSortiesZones.TimeStampHelper.write(ostream,value.t);
>>>>>>> ServiceAuthorisationNico
        modEntreesSortiesZones.TypeAccesHelper.write(ostream,value.typeAcces);
    }

}

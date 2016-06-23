package modEntreesSortiesZones;

/**
 * Holder class for : LogAccesZone
 * 
 * @author OpenORB Compiler
 */
final public class LogAccesZoneHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal LogAccesZone value
     */
    public modEntreesSortiesZones.LogAccesZone value;

    /**
     * Default constructor
     */
    public LogAccesZoneHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LogAccesZoneHolder(modEntreesSortiesZones.LogAccesZone initial)
    {
        value = initial;
    }

    /**
     * Read LogAccesZone from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LogAccesZoneHelper.read(istream);
    }

    /**
     * Write LogAccesZone into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LogAccesZoneHelper.write(ostream,value);
    }

    /**
     * Return the LogAccesZone TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LogAccesZoneHelper.type();
    }

}

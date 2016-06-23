package modEntreesSortiesZones;

/**
 * Holder class for : lesLogsAccesZone
 * 
 * @author OpenORB Compiler
 */
final public class lesLogsAccesZoneHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal lesLogsAccesZone value
     */
    public modEntreesSortiesZones.LogAccesZone[] value;

    /**
     * Default constructor
     */
    public lesLogsAccesZoneHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public lesLogsAccesZoneHolder(modEntreesSortiesZones.LogAccesZone[] initial)
    {
        value = initial;
    }

    /**
     * Read lesLogsAccesZone from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = lesLogsAccesZoneHelper.read(istream);
    }

    /**
     * Write lesLogsAccesZone into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        lesLogsAccesZoneHelper.write(ostream,value);
    }

    /**
     * Return the lesLogsAccesZone TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return lesLogsAccesZoneHelper.type();
    }

}

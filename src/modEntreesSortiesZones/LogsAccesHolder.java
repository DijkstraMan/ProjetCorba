package modEntreesSortiesZones;

/**
 * Holder class for : LogsAcces
 * 
 * @author OpenORB Compiler
 */
final public class LogsAccesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal LogsAcces value
     */
    public modEntreesSortiesZones.LogAcces[] value;

    /**
     * Default constructor
     */
    public LogsAccesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LogsAccesHolder(modEntreesSortiesZones.LogAcces[] initial)
    {
        value = initial;
    }

    /**
     * Read LogsAcces from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LogsAccesHelper.read(istream);
    }

    /**
     * Write LogsAcces into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LogsAccesHelper.write(ostream,value);
    }

    /**
     * Return the LogsAcces TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LogsAccesHelper.type();
    }

}

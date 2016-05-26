package modEntreesSortiesZones;

/**
 * Holder class for : LogAcces
 * 
 * @author OpenORB Compiler
 */
final public class LogAccesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal LogAcces value
     */
    public modEntreesSortiesZones.LogAcces value;

    /**
     * Default constructor
     */
    public LogAccesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LogAccesHolder(modEntreesSortiesZones.LogAcces initial)
    {
        value = initial;
    }

    /**
     * Read LogAcces from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LogAccesHelper.read(istream);
    }

    /**
     * Write LogAcces into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LogAccesHelper.write(ostream,value);
    }

    /**
     * Return the LogAcces TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LogAccesHelper.type();
    }

}

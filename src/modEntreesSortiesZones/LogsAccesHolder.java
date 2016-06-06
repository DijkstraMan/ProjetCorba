package modEntreesSortiesZones;

/**
 * Holder class for : logsAcces
 * 
 * @author OpenORB Compiler
 */
final public class logsAccesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal logsAcces value
     */
    public modEntreesSortiesZones.LogAcces[] value;

    /**
     * Default constructor
     */
    public logsAccesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public logsAccesHolder(modEntreesSortiesZones.LogAcces[] initial)
    {
        value = initial;
    }

    /**
     * Read logsAcces from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = logsAccesHelper.read(istream);
    }

    /**
     * Write logsAcces into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        logsAccesHelper.write(ostream,value);
    }

    /**
     * Return the logsAcces TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return logsAccesHelper.type();
    }

}

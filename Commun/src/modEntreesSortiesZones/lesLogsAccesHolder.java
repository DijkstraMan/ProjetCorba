package modEntreesSortiesZones;

/**
 * Holder class for : lesLogsAcces
 * 
 * @author OpenORB Compiler
 */
final public class lesLogsAccesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal lesLogsAcces value
     */
    public modEntreesSortiesZones.LogAcces[] value;

    /**
     * Default constructor
     */
    public lesLogsAccesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public lesLogsAccesHolder(modEntreesSortiesZones.LogAcces[] initial)
    {
        value = initial;
    }

    /**
     * Read lesLogsAcces from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = lesLogsAccesHelper.read(istream);
    }

    /**
     * Write lesLogsAcces into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        lesLogsAccesHelper.write(ostream,value);
    }

    /**
     * Return the lesLogsAcces TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return lesLogsAccesHelper.type();
    }

}

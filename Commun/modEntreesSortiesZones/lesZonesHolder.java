package modEntreesSortiesZones;

/**
 * Holder class for : lesZones
 * 
 * @author OpenORB Compiler
 */
final public class lesZonesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal lesZones value
     */
    public modEntreesSortiesZones.Zone[] value;

    /**
     * Default constructor
     */
    public lesZonesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public lesZonesHolder(modEntreesSortiesZones.Zone[] initial)
    {
        value = initial;
    }

    /**
     * Read lesZones from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = lesZonesHelper.read(istream);
    }

    /**
     * Write lesZones into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        lesZonesHelper.write(ostream,value);
    }

    /**
     * Return the lesZones TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return lesZonesHelper.type();
    }

}

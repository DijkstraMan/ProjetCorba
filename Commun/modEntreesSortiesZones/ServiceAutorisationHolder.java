package modEntreesSortiesZones;

/**
 * Holder class for : ServiceAutorisation
 * 
 * @author OpenORB Compiler
 */
final public class ServiceAutorisationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ServiceAutorisation value
     */
    public modEntreesSortiesZones.ServiceAutorisation value;

    /**
     * Default constructor
     */
    public ServiceAutorisationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ServiceAutorisationHolder(modEntreesSortiesZones.ServiceAutorisation initial)
    {
        value = initial;
    }

    /**
     * Read ServiceAutorisation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ServiceAutorisationHelper.read(istream);
    }

    /**
     * Write ServiceAutorisation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ServiceAutorisationHelper.write(ostream,value);
    }

    /**
     * Return the ServiceAutorisation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ServiceAutorisationHelper.type();
    }

}

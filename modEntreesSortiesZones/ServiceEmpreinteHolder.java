package modEntreesSortiesZones;

/**
 * Holder class for : ServiceEmpreinte
 * 
 * @author OpenORB Compiler
 */
final public class ServiceEmpreinteHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ServiceEmpreinte value
     */
    public modEntreesSortiesZones.ServiceEmpreinte value;

    /**
     * Default constructor
     */
    public ServiceEmpreinteHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ServiceEmpreinteHolder(modEntreesSortiesZones.ServiceEmpreinte initial)
    {
        value = initial;
    }

    /**
     * Read ServiceEmpreinte from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ServiceEmpreinteHelper.read(istream);
    }

    /**
     * Write ServiceEmpreinte into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ServiceEmpreinteHelper.write(ostream,value);
    }

    /**
     * Return the ServiceEmpreinte TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ServiceEmpreinteHelper.type();
    }

}

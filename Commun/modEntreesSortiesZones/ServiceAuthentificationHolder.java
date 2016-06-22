package modEntreesSortiesZones;

/**
 * Holder class for : ServiceAuthentification
 * 
 * @author OpenORB Compiler
 */
final public class ServiceAuthentificationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ServiceAuthentification value
     */
    public modEntreesSortiesZones.ServiceAuthentification value;

    /**
     * Default constructor
     */
    public ServiceAuthentificationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ServiceAuthentificationHolder(modEntreesSortiesZones.ServiceAuthentification initial)
    {
        value = initial;
    }

    /**
     * Read ServiceAuthentification from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ServiceAuthentificationHelper.read(istream);
    }

    /**
     * Write ServiceAuthentification into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ServiceAuthentificationHelper.write(ostream,value);
    }

    /**
     * Return the ServiceAuthentification TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ServiceAuthentificationHelper.type();
    }

}

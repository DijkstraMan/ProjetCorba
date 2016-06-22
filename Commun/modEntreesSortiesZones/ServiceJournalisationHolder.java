package modEntreesSortiesZones;

/**
 * Holder class for : ServiceJournalisation
 * 
 * @author OpenORB Compiler
 */
final public class ServiceJournalisationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ServiceJournalisation value
     */
    public modEntreesSortiesZones.ServiceJournalisation value;

    /**
     * Default constructor
     */
    public ServiceJournalisationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ServiceJournalisationHolder(modEntreesSortiesZones.ServiceJournalisation initial)
    {
        value = initial;
    }

    /**
     * Read ServiceJournalisation from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ServiceJournalisationHelper.read(istream);
    }

    /**
     * Write ServiceJournalisation into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ServiceJournalisationHelper.write(ostream,value);
    }

    /**
     * Return the ServiceJournalisation TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ServiceJournalisationHelper.type();
    }

}

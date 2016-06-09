package modEntreesSortiesZones;

/**
 * Holder class for : lesEmpreintes
 * 
 * @author OpenORB Compiler
 */
final public class lesEmpreintesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal lesEmpreintes value
     */
    public modEntreesSortiesZones.Empreinte[] value;

    /**
     * Default constructor
     */
    public lesEmpreintesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public lesEmpreintesHolder(modEntreesSortiesZones.Empreinte[] initial)
    {
        value = initial;
    }

    /**
     * Read lesEmpreintes from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = lesEmpreintesHelper.read(istream);
    }

    /**
     * Write lesEmpreintes into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        lesEmpreintesHelper.write(ostream,value);
    }

    /**
     * Return the lesEmpreintes TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return lesEmpreintesHelper.type();
    }

}

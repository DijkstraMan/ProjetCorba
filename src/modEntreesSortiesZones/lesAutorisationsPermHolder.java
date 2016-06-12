package modEntreesSortiesZones;

/**
 * Holder class for : lesAutorisationsPerm
 * 
 * @author OpenORB Compiler
 */
final public class lesAutorisationsPermHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal lesAutorisationsPerm value
     */
    public modEntreesSortiesZones.AutorisationPerm[] value;

    /**
     * Default constructor
     */
    public lesAutorisationsPermHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public lesAutorisationsPermHolder(modEntreesSortiesZones.AutorisationPerm[] initial)
    {
        value = initial;
    }

    /**
     * Read lesAutorisationsPerm from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = lesAutorisationsPermHelper.read(istream);
    }

    /**
     * Write lesAutorisationsPerm into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        lesAutorisationsPermHelper.write(ostream,value);
    }

    /**
     * Return the lesAutorisationsPerm TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return lesAutorisationsPermHelper.type();
    }

}

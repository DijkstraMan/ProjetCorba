package modEntreesSortiesZones;

/**
 * Holder class for : lesAutorisationsTemp
 * 
 * @author OpenORB Compiler
 */
final public class lesAutorisationsTempHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal lesAutorisationsTemp value
     */
    public modEntreesSortiesZones.AutorisationTemp[] value;

    /**
     * Default constructor
     */
    public lesAutorisationsTempHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public lesAutorisationsTempHolder(modEntreesSortiesZones.AutorisationTemp[] initial)
    {
        value = initial;
    }

    /**
     * Read lesAutorisationsTemp from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = lesAutorisationsTempHelper.read(istream);
    }

    /**
     * Write lesAutorisationsTemp into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        lesAutorisationsTempHelper.write(ostream,value);
    }

    /**
     * Return the lesAutorisationsTemp TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return lesAutorisationsTempHelper.type();
    }

}

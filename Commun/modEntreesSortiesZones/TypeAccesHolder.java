package modEntreesSortiesZones;

/**
 * Holder class for : TypeAcces
 * 
 * @author OpenORB Compiler
 */
final public class TypeAccesHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal TypeAcces value
     */
    public modEntreesSortiesZones.TypeAcces value;

    /**
     * Default constructor
     */
    public TypeAccesHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public TypeAccesHolder(modEntreesSortiesZones.TypeAcces initial)
    {
        value = initial;
    }

    /**
     * Read TypeAcces from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = TypeAccesHelper.read(istream);
    }

    /**
     * Write TypeAcces into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        TypeAccesHelper.write(ostream,value);
    }

    /**
     * Return the TypeAcces TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return TypeAccesHelper.type();
    }

}

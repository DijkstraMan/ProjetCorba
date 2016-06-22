package modEntreesSortiesZones;

/**
 * Holder class for : AutorisationPerm
 * 
 * @author OpenORB Compiler
 */
final public class AutorisationPermHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AutorisationPerm value
     */
    public modEntreesSortiesZones.AutorisationPerm value;

    /**
     * Default constructor
     */
    public AutorisationPermHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AutorisationPermHolder(modEntreesSortiesZones.AutorisationPerm initial)
    {
        value = initial;
    }

    /**
     * Read AutorisationPerm from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AutorisationPermHelper.read(istream);
    }

    /**
     * Write AutorisationPerm into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AutorisationPermHelper.write(ostream,value);
    }

    /**
     * Return the AutorisationPerm TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AutorisationPermHelper.type();
    }

}

package modEntreesSortiesZones;

/**
 * Holder class for : AutorisationTemp
 * 
 * @author OpenORB Compiler
 */
final public class AutorisationTempHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AutorisationTemp value
     */
    public modEntreesSortiesZones.AutorisationTemp value;

    /**
     * Default constructor
     */
    public AutorisationTempHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AutorisationTempHolder(modEntreesSortiesZones.AutorisationTemp initial)
    {
        value = initial;
    }

    /**
     * Read AutorisationTemp from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AutorisationTempHelper.read(istream);
    }

    /**
     * Write AutorisationTemp into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AutorisationTempHelper.write(ostream,value);
    }

    /**
     * Return the AutorisationTemp TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AutorisationTempHelper.type();
    }

}

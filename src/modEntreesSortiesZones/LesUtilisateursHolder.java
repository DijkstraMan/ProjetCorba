package modEntreesSortiesZones;

/**
 * Holder class for : LesUtilisateurs
 * 
 * @author OpenORB Compiler
 */
final public class LesUtilisateursHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal LesUtilisateurs value
     */
    public modEntreesSortiesZones.Utilisateur[] value;

    /**
     * Default constructor
     */
    public LesUtilisateursHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public LesUtilisateursHolder(modEntreesSortiesZones.Utilisateur[] initial)
    {
        value = initial;
    }

    /**
     * Read LesUtilisateurs from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = LesUtilisateursHelper.read(istream);
    }

    /**
     * Write LesUtilisateurs into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        LesUtilisateursHelper.write(ostream,value);
    }

    /**
     * Return the LesUtilisateurs TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return LesUtilisateursHelper.type();
    }

}

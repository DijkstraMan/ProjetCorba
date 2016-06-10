package modEntreesSortiesZones;

/**
 * Holder class for : lesUtilisateurs
 * 
 * @author OpenORB Compiler
 */
final public class lesUtilisateursHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal lesUtilisateurs value
     */
    public modEntreesSortiesZones.Utilisateur[] value;

    /**
     * Default constructor
     */
    public lesUtilisateursHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public lesUtilisateursHolder(modEntreesSortiesZones.Utilisateur[] initial)
    {
        value = initial;
    }

    /**
     * Read lesUtilisateurs from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = lesUtilisateursHelper.read(istream);
    }

    /**
     * Write lesUtilisateurs into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        lesUtilisateursHelper.write(ostream,value);
    }

    /**
     * Return the lesUtilisateurs TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return lesUtilisateursHelper.type();
    }

}

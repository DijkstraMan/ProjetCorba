package modEntreesSortiesZones;

/**
 * Holder class for : UtilisateurInconnu
 * 
 * @author OpenORB Compiler
 */
final public class UtilisateurInconnuHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal UtilisateurInconnu value
     */
    public modEntreesSortiesZones.UtilisateurInconnu value;

    /**
     * Default constructor
     */
    public UtilisateurInconnuHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public UtilisateurInconnuHolder(modEntreesSortiesZones.UtilisateurInconnu initial)
    {
        value = initial;
    }

    /**
     * Read UtilisateurInconnu from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = UtilisateurInconnuHelper.read(istream);
    }

    /**
     * Write UtilisateurInconnu into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        UtilisateurInconnuHelper.write(ostream,value);
    }

    /**
     * Return the UtilisateurInconnu TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return UtilisateurInconnuHelper.type();
    }

}

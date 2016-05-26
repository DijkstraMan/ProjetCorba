package modEntreesSortiesZones;

/**
 * Holder class for : Utilisateur
 * 
 * @author OpenORB Compiler
 */
final public class UtilisateurHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Utilisateur value
     */
    public modEntreesSortiesZones.Utilisateur value;

    /**
     * Default constructor
     */
    public UtilisateurHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public UtilisateurHolder(modEntreesSortiesZones.Utilisateur initial)
    {
        value = initial;
    }

    /**
     * Read Utilisateur from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = UtilisateurHelper.read(istream);
    }

    /**
     * Write Utilisateur into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        UtilisateurHelper.write(ostream,value);
    }

    /**
     * Return the Utilisateur TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return UtilisateurHelper.type();
    }

}

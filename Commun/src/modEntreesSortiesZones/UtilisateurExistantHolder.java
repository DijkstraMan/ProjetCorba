package modEntreesSortiesZones;

/**
 * Holder class for : UtilisateurExistant
 * 
 * @author OpenORB Compiler
 */
final public class UtilisateurExistantHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal UtilisateurExistant value
     */
    public modEntreesSortiesZones.UtilisateurExistant value;

    /**
     * Default constructor
     */
    public UtilisateurExistantHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public UtilisateurExistantHolder(modEntreesSortiesZones.UtilisateurExistant initial)
    {
        value = initial;
    }

    /**
     * Read UtilisateurExistant from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = UtilisateurExistantHelper.read(istream);
    }

    /**
     * Write UtilisateurExistant into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        UtilisateurExistantHelper.write(ostream,value);
    }

    /**
     * Return the UtilisateurExistant TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return UtilisateurExistantHelper.type();
    }

}

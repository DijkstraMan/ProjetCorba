package modEntreesSortiesZones;

/**
 * Holder class for : SQLERROR
 * 
 * @author OpenORB Compiler
 */
final public class SQLERRORHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal SQLERROR value
     */
    public modEntreesSortiesZones.SQLERROR value;

    /**
     * Default constructor
     */
    public SQLERRORHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public SQLERRORHolder(modEntreesSortiesZones.SQLERROR initial)
    {
        value = initial;
    }

    /**
     * Read SQLERROR from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = SQLERRORHelper.read(istream);
    }

    /**
     * Write SQLERROR into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        SQLERRORHelper.write(ostream,value);
    }

    /**
     * Return the SQLERROR TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return SQLERRORHelper.type();
    }

}

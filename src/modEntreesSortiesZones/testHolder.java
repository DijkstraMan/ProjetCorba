package modEntreesSortiesZones;

/**
 * Holder class for : test
 * 
 * @author OpenORB Compiler
 */
final public class testHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal test value
     */
    public modEntreesSortiesZones.test value;

    /**
     * Default constructor
     */
    public testHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public testHolder(modEntreesSortiesZones.test initial)
    {
        value = initial;
    }

    /**
     * Read test from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = testHelper.read(istream);
    }

    /**
     * Write test into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        testHelper.write(ostream,value);
    }

    /**
     * Return the test TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return testHelper.type();
    }

}

package modEntreesSortiesZones;

/**
 * Holder class for : Testrer
 * 
 * @author OpenORB Compiler
 */
final public class TestrerHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Testrer value
     */
    public modEntreesSortiesZones.Testrer value;

    /**
     * Default constructor
     */
    public TestrerHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public TestrerHolder(modEntreesSortiesZones.Testrer initial)
    {
        value = initial;
    }

    /**
     * Read Testrer from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = TestrerHelper.read(istream);
    }

    /**
     * Write Testrer into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        TestrerHelper.write(ostream,value);
    }

    /**
     * Return the Testrer TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return TestrerHelper.type();
    }

}

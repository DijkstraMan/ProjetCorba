package modEntreesSortiesZones;

/**
 * Exception definition : test
 * 
 * @author OpenORB Compiler
 */
public final class test extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public test()
    {
        super(testHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public test(String raison)
    {
        super(testHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public test(String orb_reason, String raison)
    {
        super(testHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}

package modEntreesSortiesZones;

/**
 * Exception definition : Testrer
 * 
 * @author OpenORB Compiler
 */
public final class Testrer extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public Testrer()
    {
        super(TestrerHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public Testrer(String raison)
    {
        super(TestrerHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public Testrer(String orb_reason, String raison)
    {
        super(TestrerHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}

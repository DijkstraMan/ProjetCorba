package modEntreesSortiesZones;

/**
 * Exception definition : SQLERROR
 * 
 * @author OpenORB Compiler
 */
public final class SQLERROR extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public SQLERROR()
    {
        super(SQLERRORHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public SQLERROR(String raison)
    {
        super(SQLERRORHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public SQLERROR(String orb_reason, String raison)
    {
        super(SQLERRORHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}

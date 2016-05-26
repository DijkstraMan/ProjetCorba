package modEntreesSortiesZones;

/**
 * Exception definition : AutorisationInconnue
 * 
 * @author OpenORB Compiler
 */
public final class AutorisationInconnue extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public AutorisationInconnue()
    {
        super(AutorisationInconnueHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public AutorisationInconnue(String raison)
    {
        super(AutorisationInconnueHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public AutorisationInconnue(String orb_reason, String raison)
    {
        super(AutorisationInconnueHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}

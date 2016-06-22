package modEntreesSortiesZones;

/**
 * Exception definition : EmpreinteInconnue
 * 
 * @author OpenORB Compiler
 */
public final class EmpreinteInconnue extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public EmpreinteInconnue()
    {
        super(EmpreinteInconnueHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public EmpreinteInconnue(String raison)
    {
        super(EmpreinteInconnueHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public EmpreinteInconnue(String orb_reason, String raison)
    {
        super(EmpreinteInconnueHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}

package modEntreesSortiesZones;

/**
 * Exception definition : AutorisationExistante
 * 
 * @author OpenORB Compiler
 */
public final class AutorisationExistante extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public AutorisationExistante()
    {
        super(AutorisationExistanteHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public AutorisationExistante(String raison)
    {
        super(AutorisationExistanteHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public AutorisationExistante(String orb_reason, String raison)
    {
        super(AutorisationExistanteHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}

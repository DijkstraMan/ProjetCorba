package modEntreesSortiesZones;

/**
 * Exception definition : UtilisateurExistant
 * 
 * @author OpenORB Compiler
 */
public final class UtilisateurExistant extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public UtilisateurExistant()
    {
        super(UtilisateurExistantHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public UtilisateurExistant(String raison)
    {
        super(UtilisateurExistantHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public UtilisateurExistant(String orb_reason, String raison)
    {
        super(UtilisateurExistantHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}

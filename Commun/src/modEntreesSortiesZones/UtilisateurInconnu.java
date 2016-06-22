package modEntreesSortiesZones;

/**
 * Exception definition : UtilisateurInconnu
 * 
 * @author OpenORB Compiler
 */
public final class UtilisateurInconnu extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public UtilisateurInconnu()
    {
        super(UtilisateurInconnuHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public UtilisateurInconnu(String raison)
    {
        super(UtilisateurInconnuHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public UtilisateurInconnu(String orb_reason, String raison)
    {
        super(UtilisateurInconnuHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}

package modEntreesSortiesZones;

/**
 * Exception definition : EmpreinteExistante
 * 
 * @author OpenORB Compiler
 */
public final class EmpreinteExistante extends org.omg.CORBA.UserException
{
    /**
     * Exception member raison
     */
    public String raison;

    /**
     * Default constructor
     */
    public EmpreinteExistante()
    {
        super(EmpreinteExistanteHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param raison raison exception member
     */
    public EmpreinteExistante(String raison)
    {
        super(EmpreinteExistanteHelper.id());
        this.raison = raison;
    }

    /**
     * Full constructor with fields initialization
     * @param raison raison exception member
     */
    public EmpreinteExistante(String orb_reason, String raison)
    {
        super(EmpreinteExistanteHelper.id() +" " +  orb_reason);
        this.raison = raison;
    }

}

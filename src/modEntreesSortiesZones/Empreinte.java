package modEntreesSortiesZones;

/**
 * Struct definition : Empreinte
 * 
 * @author OpenORB Compiler
*/
public final class Empreinte implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member matricule
     */
    public String matricule;

    /**
     * Struct member empCollab
     */
    public String empCollab;

    /**
     * Default constructor
     */
    public Empreinte()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param empCollab empCollab struct member
     */
    public Empreinte(String matricule, String empCollab)
    {
        this.matricule = matricule;
        this.empCollab = empCollab;
    }

}

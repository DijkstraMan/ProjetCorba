package modEntreesSortiesZones;

/**
 * Struct definition : LogAcces
 * 
 * @author OpenORB Compiler
*/
public final class LogAcces implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member matricule
     */
    public String matricule;

    /**
     * Struct member idZone
     */
    public int idZone;

    /**
     * Struct member t
     */
    public int t;

    /**
     * Struct member typeAcces
     */
    public modEntreesSortiesZones.TypeAcces typeAcces;

    /**
     * Default constructor
     */
    public LogAcces()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param idZone idZone struct member
     * @param t t struct member
     * @param typeAcces typeAcces struct member
     */
    public LogAcces(String matricule, int idZone, int t, modEntreesSortiesZones.TypeAcces typeAcces)
    {
        this.matricule = matricule;
        this.idZone = idZone;
        this.t = t;
        this.typeAcces = typeAcces;
    }

}

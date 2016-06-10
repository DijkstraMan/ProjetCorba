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
     * Struct member dateAcces
     */
    public String dateAcces;

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
<<<<<<< HEAD
     * @param dateAcces dateAcces struct member
     * @param typeAcces typeAcces struct member
     */
    public LogAcces(String matricule, int idZone, String dateAcces, modEntreesSortiesZones.TypeAcces typeAcces)
    {
        this.matricule = matricule;
        this.idZone = idZone;
        this.dateAcces = dateAcces;
=======
     * @param t t struct member
     * @param typeAcces typeAcces struct member
     */
    public LogAcces(String matricule, int idZone, int t, modEntreesSortiesZones.TypeAcces typeAcces)
    {
        this.matricule = matricule;
        this.idZone = idZone;
        this.t = t;
>>>>>>> ServiceAuthorisationNico
        this.typeAcces = typeAcces;
    }

}

package modEntreesSortiesZones;

/**
 * Struct definition : LogAccesZone
 * 
 * @author OpenORB Compiler
*/
public final class LogAccesZone implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member matricule
     */
    public String matricule;

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
    public LogAccesZone()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param dateAcces dateAcces struct member
     * @param typeAcces typeAcces struct member
     */
    public LogAccesZone(String matricule, String dateAcces, modEntreesSortiesZones.TypeAcces typeAcces)
    {
        this.matricule = matricule;
        this.dateAcces = dateAcces;
        this.typeAcces = typeAcces;
    }

}

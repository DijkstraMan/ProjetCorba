package modEntreesSortiesZones;

/**
 * Struct definition : AutorisationPerm
 * 
 * @author OpenORB Compiler
*/
public final class AutorisationPerm implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member matricule
     */
    public String matricule;

    /**
     * Struct member nomZone
     */
    public String nomZone;

    /**
     * Struct member hrDebut
     */
    public String hrDebut;

    /**
     * Struct member hrFin
     */
    public String hrFin;

    /**
     * Default constructor
     */
    public AutorisationPerm()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param nomZone nomZone struct member
     * @param hrDebut hrDebut struct member
     * @param hrFin hrFin struct member
     */
    public AutorisationPerm(String matricule, String nomZone, String hrDebut, String hrFin)
    {
        this.matricule = matricule;
        this.nomZone = nomZone;
        this.hrDebut = hrDebut;
        this.hrFin = hrFin;
    }

}

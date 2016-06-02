package modEntreesSortiesZones;

/**
 * Struct definition : Autorisation
 * 
 * @author OpenORB Compiler
*/
public final class Autorisation implements org.omg.CORBA.portable.IDLEntity
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
     * Struct member hrDebut
     */
    public int hrDebut;

    /**
     * Struct member hrFin
     */
    public int hrFin;

    /**
     * Default constructor
     */
    public Autorisation()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param idZone idZone struct member
     * @param hrDebut hrDebut struct member
     * @param hrFin hrFin struct member
     */
    public Autorisation(String matricule, int idZone, int hrDebut, int hrFin)
    {
        this.matricule = matricule;
        this.idZone = idZone;
        this.hrDebut = hrDebut;
        this.hrFin = hrFin;
    }

}

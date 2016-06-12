package modEntreesSortiesZones;

/**
 * Struct definition : AutorisationTemp
 * 
 * @author OpenORB Compiler
*/
public final class AutorisationTemp implements org.omg.CORBA.portable.IDLEntity
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
     * Struct member jourDebut
     */
    public String jourDebut;

    /**
     * Struct member jourFin
     */
    public String jourFin;

    /**
     * Default constructor
     */
    public AutorisationTemp()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param nomZone nomZone struct member
     * @param jourDebut jourDebut struct member
     * @param jourFin jourFin struct member
     */
    public AutorisationTemp(String matricule, String nomZone, String jourDebut, String jourFin)
    {
        this.matricule = matricule;
        this.nomZone = nomZone;
        this.jourDebut = jourDebut;
        this.jourFin = jourFin;
    }

}

package modEntreesSortiesZones;

/**
 * Struct definition : Utilisateur
 * 
 * @author OpenORB Compiler
*/
public final class Utilisateur implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member matricule
     */
    public String matricule;

    /**
     * Struct member nomUsr
     */
    public String nomUsr;

    /**
     * Struct member preUsr
     */
    public String preUsr;

    /**
     * Struct member phoUsr
     */
    public String phoUsr;

    /**
     * Default constructor
     */
    public Utilisateur()
    { }

    /**
     * Constructor with fields initialization
     * @param matricule matricule struct member
     * @param nomUsr nomUsr struct member
     * @param preUsr preUsr struct member
     * @param phoUsr phoUsr struct member
     */
    public Utilisateur(String matricule, String nomUsr, String preUsr, String phoUsr)
    {
        this.matricule = matricule;
        this.nomUsr = nomUsr;
        this.preUsr = preUsr;
        this.phoUsr = phoUsr;
    }

}

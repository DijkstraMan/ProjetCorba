package modEntreesSortiesZones;

/**
 * Struct definition : Utilisateur
 * 
 * @author OpenORB Compiler
*/
public final class Utilisateur implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member mat
     */
    public String mat;

    /**
     * Struct member nU
     */
    public String nU;

    /**
     * Struct member preU
     */
    public String preU;

    /**
     * Struct member phoU
     */
    public String phoU;

    /**
     * Default constructor
     */
    public Utilisateur()
    { }

    /**
     * Constructor with fields initialization
     * @param mat mat struct member
     * @param nU nU struct member
     * @param preU preU struct member
     * @param phoU phoU struct member
     */
    public Utilisateur(String mat, String nU, String preU, String phoU)
    {
        this.mat = mat;
        this.nU = nU;
        this.preU = preU;
        this.phoU = phoU;
    }

}

package modEntreesSortiesZones;

/**
 * Struct definition : Autorisation
 * 
 * @author OpenORB Compiler
*/
public final class Autorisation implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member mat
     */
    public int mat;

    /**
     * Struct member n
     */
    public String n;

    /**
     * Struct member hD
     */
    public int hD;

    /**
     * Struct member hF
     */
    public int hF;

    /**
     * Default constructor
     */
    public Autorisation()
    { }

    /**
     * Constructor with fields initialization
     * @param mat mat struct member
     * @param n n struct member
     * @param hD hD struct member
     * @param hF hF struct member
     */
    public Autorisation(int mat, String n, int hD, int hF)
    {
        this.mat = mat;
        this.n = n;
        this.hD = hD;
        this.hF = hF;
    }

}

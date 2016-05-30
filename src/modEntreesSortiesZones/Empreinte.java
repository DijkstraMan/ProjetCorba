package modEntreesSortiesZones;

/**
 * Struct definition : Empreinte
 * 
 * @author OpenORB Compiler
*/
public final class Empreinte implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member mat
     */
    public int mat;

    /**
     * Struct member eC
     */
    public String eC;

    /**
     * Default constructor
     */
    public Empreinte()
    { }

    /**
     * Constructor with fields initialization
     * @param mat mat struct member
     * @param eC eC struct member
     */
    public Empreinte(int mat, String eC)
    {
        this.mat = mat;
        this.eC = eC;
    }

}

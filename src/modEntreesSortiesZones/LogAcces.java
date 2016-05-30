package modEntreesSortiesZones;

/**
 * Struct definition : LogAcces
 * 
 * @author OpenORB Compiler
*/
public final class LogAcces implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member m
     */
    public String m;

    /**
     * Struct member n
     */
    public String n;

    /**
     * Struct member t
     */
    public int t;

    /**
     * Struct member a
     */
    public modEntreesSortiesZones.TypeAcces a;

    /**
     * Default constructor
     */
    public LogAcces()
    { }

    /**
     * Constructor with fields initialization
     * @param m m struct member
     * @param n n struct member
     * @param t t struct member
     * @param a a struct member
     */
    public LogAcces(String m, String n, int t, modEntreesSortiesZones.TypeAcces a)
    {
        this.m = m;
        this.n = n;
        this.t = t;
        this.a = a;
    }

}

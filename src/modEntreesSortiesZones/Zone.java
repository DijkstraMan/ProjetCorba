package modEntreesSortiesZones;

/**
 * Struct definition : Zone
 * 
 * @author OpenORB Compiler
*/
public final class Zone implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idZne
     */
    public int idZne;

    /**
     * Struct member nomZne
     */
    public String nomZne;

    /**
     * Default constructor
     */
    public Zone()
    { }

    /**
     * Constructor with fields initialization
     * @param idZne idZne struct member
     * @param nomZne nomZne struct member
     */
    public Zone(int idZne, String nomZne)
    {
        this.idZne = idZne;
        this.nomZne = nomZne;
    }

}

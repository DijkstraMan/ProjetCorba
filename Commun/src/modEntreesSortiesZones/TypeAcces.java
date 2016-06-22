package modEntreesSortiesZones;

/**
 * Enum definition : TypeAcces
 *
 * @author OpenORB Compiler
*/
public final class TypeAcces implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member autorise value 
     */
    public static final int _autorise = 0;

    /**
     * Enum member autorise
     */
    public static final TypeAcces autorise = new TypeAcces(_autorise);

    /**
     * Enum member nonAutorise value 
     */
    public static final int _nonAutorise = 1;

    /**
     * Enum member nonAutorise
     */
    public static final TypeAcces nonAutorise = new TypeAcces(_nonAutorise);

    /**
     * Enum member nonAuthentifie value 
     */
    public static final int _nonAuthentifie = 2;

    /**
     * Enum member nonAuthentifie
     */
    public static final TypeAcces nonAuthentifie = new TypeAcces(_nonAuthentifie);

    /**
     * Internal member value 
     */
    private final int _TypeAcces_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private TypeAcces( final int value )
    {
        _TypeAcces_value = value;
    }

    /**
     * Maintains singleton property for serialized enums.
     * Issue 4271: IDL/Java issue, Mapping for IDL enum.
     */
    public java.lang.Object readResolve() throws java.io.ObjectStreamException
    {
        return from_int( value() );
    }

    /**
     * Return the internal member value
     * @return the member value
     */
    public int value()
    {
        return _TypeAcces_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static TypeAcces from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return autorise;
        case 1 :
            return nonAutorise;
        case 2 :
            return nonAuthentifie;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_TypeAcces_value)
        {
        case 0 :
            return "autorise";
        case 1 :
            return "nonAutorise";
        case 2 :
            return "nonAuthentifie";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}

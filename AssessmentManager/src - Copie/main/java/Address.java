import java.io.Serializable;


/**
 *
 */
public class Address implements Serializable {
    /**
     *
     */
    private String city;
    /**
     *
     */
    private int postalCode;
    /**
     *
     */
    private String street;
    /**
     *
     */
    private int number;
    //public List<Course> courseList;

    /**
     * @param adrCity city City of the person
     * @param adrPostalCode postalCode Postalcode of the person
     * @param adrStreet street Street name of the person
     * @param adrNumber number Number of the house of the person
     */
    public Address(
            final String adrCity,
            final int adrPostalCode,
            final String adrStreet,
            final int adrNumber) {
        this.city = adrCity;
        this.postalCode = adrPostalCode;
        this.street = adrStreet;
        this.number = adrNumber;
    }

    /**
     * @return city City of the person
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @return postalCode Postalcode of the person
     */
    public int getPostalCode() {
        return this.postalCode;
    }

    /**
     * @return street Street name of the person
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * @return number Number of the house of the person
     */
    public int getNumber() {
        return this.number;
    }
}

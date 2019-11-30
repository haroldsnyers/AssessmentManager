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
     * @param city city City of the person
     * @param postalCode postalCode Postalcode of the person
     * @param street street Street name of the person
     * @param number number Number of the house of the person
     */
    public Address(final String AdrCity, final int AdrPostalCode, final String AdrStreet, final int AdrNumber) {
        this.city = AdrCity;
        this.postalCode = AdrPostalCode;
        this.street = AdrStreet;
        this.number = AdrNumber;
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

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
     * @param city city
     * @param postalCode postalCode
     * @param street street
     * @param number number
     */
    public Address(final String AdrCity, final int AdrPostalCode, final String AdrStreet, final int AdrNumber) {
        this.city = AdrCity;
        this.postalCode = AdrPostalCode;
        this.street = AdrStreet;
        this.number = AdrNumber;
    }

    /**
     * @return city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @return postalCode
     */
    public int getPostalCode() {
        return this.postalCode;
    }

    /**
     * @return street
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * @return number
     */
    public int getNumber() {
        return this.number;
    }
}

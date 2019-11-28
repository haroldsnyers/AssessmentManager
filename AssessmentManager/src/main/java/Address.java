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
     * @param city
     * @param postalCode
     * @param street
     * @param number
     */
    public Address(final String city, final int postalCode, final String street, final int number) {
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.number = number;
    }

    /**
     * @return
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @return
     */
    public int getPostalCode() {
        return this.postalCode;
    }

    /**
     * @return
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * @return
     */
    public int getNumber() {
        return this.number;
    }
}

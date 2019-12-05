import java.io.Serializable;

/**
 *
 */
public class Person implements Serializable {
    /**
     *
     */
    private final int id;
    /**
     *
     */
    private final String firstName;
    /**
     *
     */
    private final String lastName;
    /**
     *
     */
    private Address address;

    /**
     * @param id
     * @param firstName
     * @param lastName
     */
    public Person(final int id, final String firstName, final String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

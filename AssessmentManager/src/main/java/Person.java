import java.io.Serializable;

public class Person implements Serializable {
    final int ID;
    final String firstName;
    final String lastName;
    private Address address;

    public Person(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
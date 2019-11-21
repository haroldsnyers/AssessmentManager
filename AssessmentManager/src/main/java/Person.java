import java.io.Serializable;

public class Person implements Serializable {
    public int ID;
    public String firstName;
    public String lastName;
    private Address address;
    
    public Teacher(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
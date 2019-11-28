import java.io.Serializable;

public class Address implements Serializable {
    public String city;
    public int postalCode;
    public String street;
    private int number;
    //public List<Course> courseList;

    public Address(String city, int postalCode, String street, int number) {
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.number = number;
    }
}
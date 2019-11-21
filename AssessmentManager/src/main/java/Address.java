import java.util.ArrayList;
//import java.util.Dictionary;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

public class Address implements Serializable {
    public String city;
    public int postalCode;
    public String street;
    private int number;
    //public List<Course> courseList;
    Map<String, Course> coursesDico;

    public Teacher(String city, int postalCode, String street, int number) {
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.number = number;
    }
}
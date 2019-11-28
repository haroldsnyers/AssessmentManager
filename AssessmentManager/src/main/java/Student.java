import java.io.Serializable;

/**
 *
 */
public class Student implements Serializable {
	/**
	 *
	 */
	private final String name;
	/**
	 *
	 */
	private final String surname;
	/**
	 *
	 */
	private final int ID_number;

	/**
	 * @param name
	 * @param surname
	 * @param ID
	 */
	public Student(String name, String surname, int ID) {
		this.name = name;
		this.surname = surname;
		this.ID_number = ID;
	}
}

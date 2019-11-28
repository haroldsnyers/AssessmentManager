import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

/**
 *
 */
public class School implements Serializable {
	/**
	 *
	 */
	  private static String name;
	/**
	 *
	 */
	  private static String address;
	  //private static Teacher ListTeacher[];
	/**
	 *
	 */
	  private Map<Integer, Student>studentsDico;
	/**
	 *
	 */
	  private Map<Integer, Teacher>teachersDico;

	/**
	 * @param name
	 * @param address
	 */
	  public School(final String name, final String address) {
		  this.name = name;
		  this.address = address;
		  this.studentsDico = new HashMap<Integer, Student>();
		  this.teachersDico = new HashMap<Integer, Teacher>();
		  //this.ListTeacher = ListTeacher;			  
	  }

	/**
	 * @param teach
	 */
	  public void addTeacher(final Teacher teach) {
		  this.teachersDico.put(teach.id, teach);
	  }

	/**
	 * @param stud
	 */
	  public void addStudent(final Student stud) {
		  this.studentsDico.put(stud.ID_number, stud);
	  }
}

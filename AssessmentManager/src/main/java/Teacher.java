import java.util.ArrayList;
//import java.util.Dictionary;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Teacher extends Person {
	/**
	 *
	 */
	private String passwd;
	//public List<Course> courseList;
	/**
	 *
	 */
	private Map<String, Course> coursesDico;

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param passwd
	 */
	public Teacher(final int id, final String firstName,
				   final String lastName,
				   final String passwd) {
		super(id, firstName, lastName);
		this.passwd = passwd;
		coursesDico = new HashMap<String, Course>();
		//courseList=new ArrayList<Course>();
	}

	/**
	 * @param course
	 */
	public void addCourse(final Course course) {

		coursesDico.put(course.code, course);
		//courseList.add(course);
	}

	/**
	 * @param stud
	 * @param courseCode
	 */
	public void addStudToCourse(final Student stud,
								final String courseCode) {
		coursesDico.get(courseCode).addStudent(stud);
	}

	/**
	 * @return
	 */
	public List<Course> getCourseList() {
		ArrayList<Course> coursesList = new ArrayList<>(coursesDico.values());
		return coursesList;
	}

	/**
	 * @param code
	 * @return
	 */
	public boolean checkCourseCode(final String code) { //Scanner sc) {
		return coursesDico.containsKey(code); //sc.nextLine());
	}

	/**
	 *
	 */
	public void displayCourses() {
		for (Map.Entry<String, Course> e : coursesDico.entrySet()) {
		    System.out.print(e.getKey() + " = " + e.getValue().name + " | ");
		}
	}

	/**
	 * @param courseCode
	 * @param option
	 * @param year
	 * @return
	 */
	public int displayStat(final String courseCode,
						   final int option, final int year) {
		Course thisCourse = coursesDico.get(courseCode);
		if (option == 0) {
			return thisCourse.displayGraph(year);
		} else if (option == 1) {
			return thisCourse.displayHistogram(year);
		}
		return 2;
	}

	/**
	 * @param passwd
	 * @return
	 */
	public boolean checkPasswd(final String passwd) {
		return (this.passwd == passwd);
	}

	/**
	 * @param courseCode
	 * @param year
	 * @param id
	 * @param points
	 * @return
	 */
	public int encodePoints(final String courseCode, final int year,
							final int id, final int points) {
		Course thisCourse = coursesDico.get(courseCode);
		if (thisCourse.hasStudent(id)) {
			thisCourse.addPoints(year, id, points);
		} else {
			return 1;
		}
		return 0;
	}

	/**
	 * @param code
	 * @return
	 */
	public String getCourseName(final String code) {
		return this.coursesDico.get(code).name;
	}
}

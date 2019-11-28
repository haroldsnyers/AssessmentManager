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
	 * @param id id
	 * @param firstName firstName
	 * @param lastName lastName
	 * @param password password
	 */
	public Teacher(final int id, final String firstName,
				   final String lastName,
				   final String password) {
		super(id, firstName, lastName);
		this.passwd = password;
		coursesDico = new HashMap<String, Course>();
		//courseList=new ArrayList<Course>();
	}

	/**
	 * @param course course
	 */
	public void addCourse(final Course course) {

		coursesDico.put(course.getCode(), course);
		//courseList.add(course);
	}

	/**
	 * @param stud stduent
	 * @param courseCode course code
	 */
	public void addStudToCourse(final Student stud,
								final String courseCode) {
		coursesDico.get(courseCode).addStudent(stud);
	}

	/**
	 * @return courses list
	 */
	public List<Course> getCourseList() {
		ArrayList<Course> coursesList = new ArrayList<>(coursesDico.values());
		return coursesList;
	}

	/**
	 * @param code code
	 * @return courses dico
	 */
	public boolean checkCourseCode(final String code) { //Scanner sc) {
		return coursesDico.containsKey(code); //sc.nextLine());
	}

	/**.
	 * void
	 */
	public void displayCourses() {
		for (Map.Entry<String, Course> e : coursesDico.entrySet()) {
		    System.out.print(e.getKey() + " = " + e.getValue().getName() + " | ");
		}
	}

	/**
	 * @param courseCode courses code
	 * @param option option
	 * @param year year
	 * @return thiscourse
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
	 * @param password password
	 * @return password
	 */
	public boolean checkPasswd(final String password) {
		return (this.passwd == password);
	}

	/**
	 * @param courseCode course code
	 * @param year year
	 * @param id id
	 * @param points points
	 * @return int
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
	 * @param code code
	 * @return courses dico
	 */
	public String getCourseName(final String code) {
		return this.coursesDico.get(code).getName();
	}
}

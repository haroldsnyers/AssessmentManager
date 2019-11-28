import java.util.ArrayList;
//import java.util.Dictionary;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

public class Teacher extends Person {
	final String passwd;
	//public List<Course> courseList;
	private Map<String, Course> coursesDico;
	
	public Teacher(int ID, String firstName, String lastName, String passwd) {
		super(ID, firstName, lastName);
		this.passwd = passwd;
		coursesDico = new HashMap<String, Course>();
		//courseList=new ArrayList<Course>();
	}
	
	public void addCourse(final Course course) {

		coursesDico.put(course.code, course);
		//courseList.add(course);
	}
	
	public void addStudToCourse(final Student stud, final String courseCode) {
		coursesDico.get(courseCode).addStudent(stud);
	}
	
	public List<Course> getCourseList() {
		ArrayList<Course> coursesList = new ArrayList<>(coursesDico.values());
		return coursesList;
	}
	
	public boolean checkCourseCode(final String code) { //Scanner sc) {
		return coursesDico.containsKey(code); //sc.nextLine());
	}
	
	public void displayCourses() {
		for (Map.Entry<String, Course> e : coursesDico.entrySet()) {
		    System.out.print(e.getKey() + " = " + e.getValue().name + " | ");
		}
	}
	
	public int displayStat(final String courseCode, final int option, final int year) {
		Course thisCourse = coursesDico.get(courseCode);
		if (option == 0) {
			return thisCourse.displayGraph(year);
		} else if (option == 1) {
			return thisCourse.displayHistogram(year);
		}
		return 2;
	}
	
	public boolean checkPasswd(final String passwd) {
		return (this.passwd == passwd);
	}
	
	public int encodePoints(final String courseCode, final int year, final int id, final int points) {
		Course thisCourse = coursesDico.get(courseCode);
		if (thisCourse.hasStudent(id)) {
			thisCourse.addPoints(year, id, points);
		} else {
			return 1;
		}
		return 0;
	}
	public String getCourseName(final String code) {
		return this.coursesDico.get(code).name;
	}
}

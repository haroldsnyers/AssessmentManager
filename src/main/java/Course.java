//import java.util.Dictionary;
//import java.util.Hashtable;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;

/**
 *
 */
public class Course implements Serializable {
    /**
     *
     */
	private final String name;
	/**
	 *
	 */
	private final String code;
	/**
	 *
	 */
	private final int creditNumber;
	/**
	 *
	 */
	private Map<Integer, Student> studentDico;
	/**
	 *
	 */
	private Map<Integer, HashMap<Integer, Integer>> pointsDico;

	/**
	 * @param courseName String course name
	 * @param courseCode String course code
	 * @param numberCredit String number of credit
	 */
	public Course(
	        final String courseName,
            final String courseCode,
            final int numberCredit) {
		this.name = courseName;
		this.code = courseCode;
		this.creditNumber = numberCredit;
		studentDico = new HashMap<Integer, Student>();
		pointsDico = new HashMap<Integer, HashMap<Integer, Integer>>();
	}

	/**
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * @param stud Student
	 */
	public void addStudent(final Student stud) {
		this.studentDico.put(stud.id, stud);
	}

	/**
	 * @param id id of student
	 * @return list of students
	 */
	public boolean hasStudent(final int id) {
		return this.studentDico.containsKey(id);
	}

	/**
	 * @param year int year
	 * @param id int id of student
	 * @param points int points
	 */
	public void addPoints(final int year, final int id, final int points) {
		if (!pointsDico.containsKey(year)) {
			pointsDico.put(year, new HashMap<Integer, Integer>());
		}
		pointsDico.get(year).put(id, points);
	}

	/**
	 * @param year int year
	 * @return a number
	 */
	public int displayGraph(final int year) {
		if (pointsDico.containsKey(year)) {
			for (
			        Map.Entry<Integer, Integer> e
                    : pointsDico.get(year).entrySet()
            ) {
			    System.out.print("Stud " + e.getKey() + " : ");
			    printNtimes(e.getValue(), "-");
			    System.out.println(e.getValue());
			}
			return 2;
		} else {
			System.out.println(
			        "Aucun points n'ont �t�" +
                    " encod� pour cette ann�e."
            );
			return 1;
		}
	}

	/**
	 * @param year int year
	 * @return a number
	 */
	public int displayHistogram(final int year) {
		if (pointsDico.containsKey(year)) {
			int[] frequencies = new int[] {
			        0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0
			};
			for (
			        Map.Entry<Integer, Integer> e
                    : pointsDico.get(year).entrySet()
            ) {
			    frequencies[e.getValue() - 1]++;
			}

			System.out.println("R�sultat \\ " + "Fr�quence");

			int score = 0;
			for (int freq:frequencies) {
				final int scoreLimit = 10;
				if (score < scoreLimit) {
					System.out.print(' ');
				}
				System.out.print(score);
				printNtimes(freq, "-");
				System.out.println(' ');
				score++;
			}
			return 2;
		} else {
			System.out.println(
			        "Aucun points n'ont �t�" +
                    " encod�s pour cette ann�e."
            );
			return 1;
		}
	}

	/**
	 * @param n int n for points
	 * @param charact the character to print to symbolise points
	 */
	public void printNtimes(final int n, final String charact) {
		for (int i = 0; i < n; i++) {
			System.out.print(charact);
		}
	}
}

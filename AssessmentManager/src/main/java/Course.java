import java.util.ArrayList;
import java.util.List;
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
	public final String name;
	/**
	 *
	 */
	public final String code;
	/**
	 *
	 */
	public final int creditNumber;
	/**
	 *
	 */
	public Map<Integer, Student> studentDico;
	/**
	 *
	 */
	public Map<Integer, HashMap<Integer, Integer>>pointsDico;

	/**
	 * @param courseName
	 * @param courseCode
	 * @param creditNumber
	 */
	public Course(final String courseName, final String courseCode, final int creditNumber) {
		this.name = name;
		this.code = code;
		this.creditNumber = creditNumber;
		studentDico = new HashMap<Integer, Student>();
		pointsDico = new HashMap<Integer, HashMap<Integer, Integer>>();
	}

	/**
	 * @param stud
	 */
	public void addStudent(final Student stud) {
		this.studentDico.put(stud.ID_number, stud);
	}

	/**
	 * @param ID
	 * @return
	 */
	public boolean hasStudent(final int ID) {return this.studentDico.containsKey(ID);
	}

	/**
	 * @param year
	 * @param id
	 * @param points
	 */
	public void addPoints(final int year, final int id, final int points) {
		if(!pointsDico.containsKey(year)) {
			pointsDico.put(year, new HashMap<Integer, Integer>());
		}
		pointsDico.get(year).put(id, points);
	}

	/**
	 * @param year
	 * @return
	 */
	public int displayGraph(final int year) {
		if(pointsDico.containsKey(year)) {
			for (Map.Entry<Integer, Integer> e : pointsDico.get(year).entrySet()) {
			    System.out.print("Stud " + e.getKey() + " : ");
			    printNtimes(e.getValue(),"-");
			    System.out.println(e.getValue());
			}
			return 2; 
		}
		else {
			System.out.println("Aucun points n'ont �t� encod� pour cette ann�e.");
			return 1;
		}
	}

	/**
	 * @param year
	 * @return
	 */
	public int displayHistogram(final int year) {
		if(pointsDico.containsKey(year)) {
			int[] frequencies = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			for (Map.Entry<Integer, Integer> e : pointsDico.get(year).entrySet()){
			    frequencies[e.getValue()-1] ++;
			}

			System.out.println("R�sultat \\ " + "Fr�quence");

			int score = 0;
			for(int freq:frequencies) {
				if(score < 10)System.out.print(' ');
				System.out.print(score);
				printNtimes(freq,"-");
				System.out.println(' ');
				score ++;
			}
			return 2; 
		}
		else {
			System.out.println("Aucun points n'ont �t� encod�s pour cette ann�e.");
			return 1;
		}
	}

	/**
	 * @param n
	 * @param charact
	 */
	public void printNtimes(final int n, final String charact) {
		for(int i=0; i<n; i++) {
			System.out.print(charact);
		}
	}
}

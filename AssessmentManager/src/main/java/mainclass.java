import java.util.Scanner;
import java.lang.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class mainclass {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final int id = 115;
		final int creditPython = 5;
		final int creditJava = 6;
		final int jukiid = 16000;
		final int jugoid = 16119;
		final int yanid = 16001;
		final int year = 2019;
		final int note = 12;
		final int note2 = 16;
		final int note3 = 10;
		final int note4 = 8;
		Teacher combe = new Teacher(id, "Seb", "Combefis", "yOLO");
		Course pythonCourse = new Course("Python", "py", creditPython);
		Course javaCourse = new Course("Java", "ja", creditJava);
		combe.addCourse(pythonCourse);
		combe.addCourse(javaCourse);
		Student juki = new Student(jukiid, "Kirstein", "Julien");
		Student jugo = new Student(jugoid, "Gorjon", "Julien");
		Student yan = new Student(yanid, "Argyrakis", "yannis");
		javaCourse.addPoints(year, jugoid, note);
		javaCourse.addPoints(year, yanid, note2);
		javaCourse.addPoints(year, jukiid, note3);
		pythonCourse.addPoints(year, jugoid, note2);
		pythonCourse.addPoints(year, yanid, note4);
		pythonCourse.addPoints(year, jukiid, note);
		combe.addStudToCourse(juki, "py");
		combe.addStudToCourse(jugo, "py");
		combe.addStudToCourse(yan, "py");
		combe.addStudToCourse(juki, "ja");
		combe.addStudToCourse(jugo, "ja");
		combe.addStudToCourse(yan, "ja");
		School ecam = new School("Ecam", "Promenade de l'Alma");
		ecam.addTeacher(combe);
		ecam.addStudent(juki);
		ecam.addStudent(jugo);
		ecam.addStudent(yan);
		// IN THE FUTUR, THIS WOULD BE USEFULL TO BE ABLE
		// TO SAVE ALL THE OBJECTS
		// IN A FILE AND RESTORE THEM TO USE THEM
		// HERE IS THE WAy TO DO IT
		// SAVE THE OBJECT ECAM
		try {
			FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			// Write objects to file
			o.writeObject(ecam);
			o.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// LOAD THE OBJECT ECAM
		try {
			FileInputStream is = new FileInputStream("myObjects.txt");
			ObjectInputStream ois = new ObjectInputStream(is);
			School ECAM = (School) ois.readObject();
			ois.close();
			is.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		String courseCode = "";
		int options = 0;
		int state = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("--- Assessment Manager 2000 ---");
		// GET PROFESSEUR NAME HERE
		Teacher teacher = combe;
		System.out.println("Bonjour professeur !");
		while (true) {
			//Course selection
			while (state == 0) {
				System.out.print("Entrez le code du cours qui vous int�resse : | ");
				teacher.displayCourses();
				System.out.println("");
				String codeInput = sc.nextLine();
				if (!teacher.checkCourseCode(codeInput)) {
					System.out.println("Erreur, veuillez entrez un code valide !");
				} else {
					state = 1;
					courseCode = codeInput;
				}
			}
			while (state == 1) {
				System.out.println("Cours s�lectionn� : " + teacher.getCourseName(courseCode));
				System.out.println("Que souhaitez vous faire ? (0 = Encoder points | 1 = Stats & Affichage | 9 = Retour)");
				options = checkIntInput(sc);
			  	if (options == 0 || options == 1 || options == 9) {
			  		if (options == 9) {
			  			state = 0;
			  		} else {
						state = 2;
			  		}
				} else {
					System.out.println("Erreur, veuillez entrez une commande valide !");
					/*print ERROR*/  		
				}
			}
			while (state == 2) {
				if (options == 0) {
					encoder(teacher, courseCode, sc);
					state = 1;
				}
				else if (options == 1) {
					state = statistics_display(teacher, courseCode, sc);
					// Stats et affichage // at the end -> histogramme or graph
				}
				else {
						state = 0; //Retour au menu du cours
					}
			}            
		}
	}

    /**
     * @param teach Teacher of the teacher class
     * @param courseCode Id of the course
     * @param sc heu
     * @return
     */
	public static int encoder(final Teacher teach, final String courseCode, final Scanner sc) {
		int year;
		int studID;
		int points;

		System.out.println("--- Code du cours  : " + courseCode + " ---"); // CHERCHE LE STRING DU COURS
		System.out.println("Ann�e acad�mique :");
		year = checkIntInput(sc);
		System.out.println("Matricule de l'�tudiant :");
		studID = checkIntInput(sc);
		System.out.println("Points obtenus : /20");
		points = checkIntInput(sc);
		if (points > 20) {
			points = 20;
		}
		if (teach.encodePoints(courseCode, year, studID, points) == 0) {
			System.out.println(studID + " - " + points + "/20 " + " - " + year + " - enregistr� avec succ�s !");
			return 0;
		}
		else {
				System.out.println("Erreur : L'�tudiant " + studID + " ne participe pas � ce cours.");
				return 1;
			} 
	}

	/**
	 * @param teach Teacher of the teacher class
	 * @param courseCode Id of the course
	 * @param sc heu
	 * @return
	 */
	public static int statistics_display(Teacher teach, String courseCode, Scanner sc) {
		int option = 0;
		System.out.println("--- Cours ID : " + courseCode + " ---"); // CHERCHE LE STRING DU COURS
		System.out.println("Affichage (0 = Graphe �l�ves | 1 = Histogramme des points | 2 = Evolution moyenne par ann�e | 9 = Retour)");
		option = checkIntInput(sc);
		if (option == 9) {
			return 1;
		}
		else if (option == 2) {
			System.out.println("Non disponible");
			return 2;
		}
		System.out.println("Entrez l'ann�e qui vous int�resse :");
		int year = checkIntInput(sc);
		return teach.displayStat(courseCode, option, year);
	}

    /**
     * @param sc heu
     * @return
     */
	public static int checkIntInput(Scanner sc) {
		int i = 0;
		boolean validated = false;
		while (!validated) {
			try { 
				i = Integer.parseInt(sc.nextLine());
				validated = true;
			}
			catch (Exception e) {
				System.out.println("Erreur, veuillez entrez un nombre !");
			}
		}
		return i;
	} }

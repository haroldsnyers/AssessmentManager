import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Random;
import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class mainclassTest {

    @Test
    void testAddress(){
        Address address = new Address ("Bxl",1000,"Rue du test",10);
    }

	@Test
	void testIntInput(){
		Random rand = new Random();
		// Obtain a number between [0 - 99].
		int i = rand.nextInt(100);
		String to_check = Integer.toString(i);
		Scanner in = new Scanner(to_check);
		assertEquals(mainclass.checkIntInput(in), i);

	}

	@Test
	void testLink() throws FileNotFoundException {

		
		InputStream is1 = this.getClass().getClassLoader().getResourceAsStream("/encoder_data.txt");
 		Scanner is = new Scanner(is1);
 		System.out.println(is1);
		System.out.println(is);


	}

	@Test
	void testEncoder()
	{
        Address address = new Address ("Bxl",1000,"Rue du test",10);
        Teacher combe=new Teacher(115, "Seb","Combefis", "YOLO");
		Course csharpCourse=new Course("Csharp","c#",5);
		combe.addCourse(csharpCourse);

		Student Yan=new Student(16133, "Argyrakis","Yannis");
		combe.addStudToCourse(Yan, "c#");

		
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("/encoder_data.txt");
		Scanner in = new Scanner(is);

		assertEquals(mainclass.encoder(combe,"c#",in),0);

	}

	@Test
	void testStatisticsDisplay(){
        Address address = new Address ("Bxl",1000,"Rue du test",10);
        Teacher combe=new Teacher(115, "Seb","Combefis", "YOLO");
		Course csharpCourse=new Course("Csharp","C#",5);

		combe.addCourse(csharpCourse);

		Student JuKi=new Student(16000,"Julien", "Kirstein");
		Student JuGo=new Student(16119,"Julien" ,"Gorjon");
		Student Yan=new Student(16001,"Yannis", "Argyrakis");

		csharpCourse.addPoints(2019, 16119, 16);
		csharpCourse.addPoints(2019, 16001, 15);
		csharpCourse.addPoints(2019, 16000, 10);


		combe.addStudToCourse(JuKi, "C#");
		combe.addStudToCourse(JuGo, "C#");
		combe.addStudToCourse(Yan, "C#");

		
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("/data_stats.txt");
		Scanner in = new Scanner(is);
		assertEquals(mainclass.statistics_display(combe,"C#", in),2);
	}

    @Test
    void testSchool(){
        Address address = new Address ("Bxl",1000,"Rue du test",10);
        Teacher combe=new Teacher(115, "Seb","Combefis", "YOLO");

		Student JuKi=new Student(16000,"Julien", "Kirstein");
		Student JuGo=new Student(16119,"Julien" ,"Gorjon");
		Student Yan=new Student(16001,"Yannis", "Argyrakis");

        School ECAM = new School("ECAM", "place de l'alma");

        ECAM.addStudent(JuKi);
        ECAM.addStudent(JuGo);
        ECAM.addStudent(Yan);

        ECAM.addTeacher(combe);

        System.out.println(ECAM.getTeachers());
        System.out.println(ECAM.getStudents());
        System.out.println("\n");
    }
}

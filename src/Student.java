import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private String courses = null;
	private int tuitionBalance = 0;
	private static int costOfCourses = 600; // static means that the value is not specific to the
											// object, but is something that is true to all objects
	private static int id = 1000;
	
	// Constructor -- prompt user to enter student's name and year
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter the student first name: ");
		this.firstName = in.nextLine();
		
		System.out.print("\nEnter the student last name: ");
		this.lastName = in.nextLine();
		
		System.out.print("\n1 - for Freshman"
				+ "\n2 - for Sophomore"
				+ "\n3 - for Junior"
				+ "\n4 - for Senior"
				+ "\nEnter the student class year: ");
		this.gradeYear = in.nextInt();
		
		setStudentID();		
	}
	
	// Generate an ID
	private void setStudentID() {
		// Grade level + ID
		id++;
		studentID = gradeYear + "" + id;
	}
	
	// Enroll in Courses
	public void enroll() {
		// Get inside a loop, user hits Q when they're done enrolling
		do {
			System.out.print("Enter course to enroll (Q to quit): ");
			Scanner in = new Scanner(System.in);
			String course = in.nextLine();
			if (!course.equals("Q")) {
				courses = courses + "\n" + course;
				tuitionBalance = tuitionBalance + costOfCourses;
			}
			else { break; }
		} while (1 != 0);			
	}
	
	// View balance
	public void viewBalance() {
		System.out.println("You Balance Is: $" + tuitionBalance);
	}
	
	// Pay tuition
	public void payTuition() {
		viewBalance();
		System.out.print("Enter your payment: $");
		Scanner in = new Scanner(System.in);
		int payment = in.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("\nThank you for your payment of $" + payment);
		viewBalance();
	}
	
	// Show status
	public String toString() {
		return "\nName: " + firstName + " " + lastName +
				"\nGrade: " + gradeYear +
				"\nStudent ID: " + studentID +
				"\nCourses Enrolled: " + courses +
				"\nBalance: $" + tuitionBalance;
	}
}

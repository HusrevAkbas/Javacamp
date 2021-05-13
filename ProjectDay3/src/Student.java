
public class Student extends User{

	String firstName;
	String lastName;
	String studentNumber;
	String[] courses;
	
	public Student(String userName, String firstName, String lastName, String studentNumber) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentNumber() {
		return studentNumber;
	}
}

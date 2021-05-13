
public class Instructor extends User {

	String firstName;
	String lastName;
	String instructorNumber;
	String[] courses;
	
	public Instructor(String userName, String firstName, String lastName, String instructorNumber) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.instructorNumber = instructorNumber;
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

	public String getInstructorNumber() {
		return instructorNumber;
	}
}

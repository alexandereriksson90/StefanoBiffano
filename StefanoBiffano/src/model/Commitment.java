package model;

public class Commitment {
	private Role role;
	private String courseID;
	private Person person;
	
	public Commitment(Role role, Person person, String courseID) {
		this.person = person;
		this.courseID = courseID;
		this.role = role;
		
	}
	
	public Role getRole() {
		return role;
	}
	
	public Person getPerson() {
		return person;
	}

	public String getCourseID() {
		return courseID;
	}
	@Override
	public String toString()
	{
		return role.toString() + " " + person.getFirstName()+ " " + person.getLastName() + " " + courseID;	
	}

}

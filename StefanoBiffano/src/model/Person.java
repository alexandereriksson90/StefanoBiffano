package model;

public class Person {
	private String socialSecurityNumber;
	private String firstName, lastName;
	
	public Person(String ssn, String firstName, String lastName) {
		socialSecurityNumber = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
}

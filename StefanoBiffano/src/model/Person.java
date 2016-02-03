package model;

public class Person {
	protected String socialSecurityNumber;
	protected String firstName, lastName;
	
	public Person (String ssn) {
		ssn = socialSecurityNumber;
	}
	public Person(String ssn, String fName, String lName) {
		ssn = socialSecurityNumber;
		fName = firstName;
		lName = lastName;
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

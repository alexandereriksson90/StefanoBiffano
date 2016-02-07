package model;

public class StudentGrade {
	private Grade grade;
	private Person student;
	
	public StudentGrade(Grade grade,Person student)
	{
		this.grade = grade;
		this.student = student;
	}

	public Grade getGrade() 
	{
		return grade;
	}

	public void setGrade(Grade grade) 
	{
		this.grade = grade;
	}

	public Person getStudent() 
	{
		return student;
	}

	public void setStudent(Person student) 
	{
		this.student = student;
	}
}

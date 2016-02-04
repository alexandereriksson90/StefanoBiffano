package model;

import java.util.LinkedList;

public class CourseInstance 
{
	private LinkedList<Commitment> commitments;
	private Course course;
	

	private String regCode;
	private String coursePeriod;
	private Person examinator;
	private Person courseCoordinator;


	public CourseInstance(String regCode, Course course, Person courseCoordinator, Person examinator) 
	{
		this.course = course;
		this.regCode = regCode;
		this.examinator = examinator;
		this.courseCoordinator = courseCoordinator;
		commitments.add(new Commitment(Role.COURSECOORDINATOR, courseCoordinator,course.getCourseID()));
		commitments.add(new Commitment(Role.EXAMINATOR, examinator,course.getCourseID()));
	}

	public String getCoursePeriod()
	{
		return coursePeriod;
	}

	public void setCoursePeriod(String coursePeriod)
	{
		this.coursePeriod = coursePeriod;
	}

	public void addCommitment(Commitment commitment) 
	{
		commitments.add(commitment);
	}

	public LinkedList<Commitment> getCommitments() 
	{
		return commitments;
	}

	public void removeCommitment(Commitment commitment) 
	{
		commitments.remove(commitment);
	}	

	public LinkedList<Person> getStudents()
	{
		LinkedList<Person> students = new LinkedList<Person>();
		for(Commitment c : commitments)
		{
			if(c.getRole() == Role.STUDENT)
				students.add(c.getPerson());
		}
		return students;
	}

	public Person getExaminator() 
	{
		
		return examinator;
	}

	public Person getCourseCoordinator() 
	{
		return courseCoordinator;
	}

	public void setCourseCoordinator(Person courseCoordinator) 
	{
		this.courseCoordinator = courseCoordinator;
	}

	public void setExaminator(Person examinator) {
		this.examinator = examinator;
	}
	
	public Course getCourse()
	{
		return course;
	}

}

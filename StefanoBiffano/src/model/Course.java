package model;

public class Course 
{
	private String courseID;
	private String courseName;
	
	public Course(String courseCode, String courseName)
	{
		this.courseID = courseCode;
		this.courseName = courseName;
	}
	
	public String getCourseID() 
	{
		return courseID;
	}

	public String getCourseName() 
	{
		return courseName;
	}	
	
}

package model;

import java.util.LinkedList;

public final class CourseList {
	LinkedList<Course> courseList;
	public CourseList()
	{
		courseList = new LinkedList<Course>();
		createCourseList();
	}
	private void createCourseList()
	{
		courseList.add(new Course("DVG01-123", "Datakommunikation"));
		courseList.add(new Course("DVG02-345", "Programvaruteknik"));
		courseList.add(new Course("KVA03-678", "Kvalitetsstyrning"));
		courseList.add(new Course("MA404-910", "Envariabelanalys"));
		courseList.add(new Course("DVG05-111", "Datorgrafik"));
		
	}
	public LinkedList<Course> getCourses()
	{
		return courseList;
	}
	void addCourse(Course course)
	{
		courseList.add(course);	
	}
	void removeCourse(Course course)
	{
		courseList.remove(course);
	}

}

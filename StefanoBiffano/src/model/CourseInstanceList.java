package model;

import java.util.LinkedList;

public class CourseInstanceList
{
	LinkedList<CourseInstance> courseInstanceList;
	private CourseList courseList;

	public CourseInstanceList(CourseList courseList)
	{
		this.courseList = courseList;
		courseInstanceList = new LinkedList<CourseInstance>();
		createCourseInstanceList();
	}

	private void createCourseInstanceList()
	{
		courseInstanceList.add(new CourseInstance("jh232o", courseList.getCourses().get(0),
				new Person("760516-7636", "Per", "Ek"), new Person("800212-5666", "Alexander", "Larsson")));

		courseInstanceList.add(new CourseInstance("asd21p", courseList.getCourses().get(2),
				new Person("661216-1634", "Malin", "Mann"), new Person("670313-2561", "Stefan", "Eriksson")));
		
		courseInstanceList.add(new CourseInstance("hsd22a", courseList.getCourses().get(1),
				new Person("871105-1224", "Gunnar", "Helgesson"), new Person("720322-4723", "Jonas", "Boustedt")));

	}

	public LinkedList<CourseInstance> getCourseInstances()
	{
		return courseInstanceList;
	}

	public void addCourseInstance(CourseInstance courseInstance)
	{
		courseInstanceList.add(courseInstance);
	}

	public void removeCourseInstance(CourseInstance courseInstance)
	{
		courseInstanceList.remove(courseInstance);
	}

}

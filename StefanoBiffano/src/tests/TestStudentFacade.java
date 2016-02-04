package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import model.CourseInstance;
import model.CourseList;
import model.Person;
import model.StudentFacade;

public class TestStudentFacade
{
	private StudentFacade student;
	private LinkedList<CourseInstance> instances;
	private CourseList courseList;

	@Before
	public void setUp() throws Exception
	{
		student = new StudentFacade(new Person("19920513-7562","Erik","Gustafsson"));
		instances = new LinkedList<CourseInstance>();
		courseList = new CourseList();
		instances.add(new CourseInstance("jh232o",courseList.getCourses().get(0),
										new Person("760516-7636","Per","Ek"), 
										new Person("800212-5666","Alexander","Larsson")));
		
		instances.add(new CourseInstance("asd21p",courseList.getCourses().get(2),
										new Person("661216-1634","Malin","Mann"), 
										new Person("670313-2561","Stefan","Eriksson")));
				
	}

	@Test
	public void testRegisterToCourseInstance()
	{
		
		student.registerToCourseInstance(instances.get(0));
	}

}

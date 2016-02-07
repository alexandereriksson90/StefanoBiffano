package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import facade.ExaminatorFacade;
import model.CourseInstanceList;
import model.CourseList;
import model.Grade;
import model.Person;
import model.StudentGrade;
import facade.StudentFacade;

public class TestExaminatorFacade
{
	private StudentFacade student1, student2;
	private StudentGrade studentGrade1,studentGrade2;
	private ExaminatorFacade examinator;
	private CourseInstanceList instances;
	private CourseList courseList;
	@Before
	public void setUp() throws Exception
	{
		examinator = new ExaminatorFacade();
		courseList = new CourseList();
		instances = new CourseInstanceList(courseList);
		
		student1 = new StudentFacade(new Person("19920513-7562", "Erik", "Gustafsson"));
		student2 = new StudentFacade(new Person("19910725-1265", "Halvar", "Bengtsson"));
		
		studentGrade1 = new StudentGrade(Grade.B,new Person("19920513-7562", "Erik", "Gustafsson"));
		studentGrade2 = new StudentGrade(Grade.Fx,new Person("19910725-1265", "Halvar", "Bengtsson"));
	}

	@Test
	public void testSetGrade()
	{
		student1.registerToCourseInstance(instances.getCourseInstances().get(0));
		student2.registerToCourseInstance(instances.getCourseInstances().get(0));
		
		examinator.setStudentGrade(instances.getCourseInstances().get(0), studentGrade1);
		examinator.setStudentGrade(instances.getCourseInstances().get(0), studentGrade2);
		
		assertEquals(Grade.B, examinator.getStudentGrades(
				instances.getCourseInstances().get(0)).get(0).getGrade());	
		assertEquals(Grade.Fx, examinator.getStudentGrades(
				instances.getCourseInstances().get(0)).get(1).getGrade());	
		
	}

}

package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import model.Commitment;
import model.Course;
import model.CourseInstance;
import model.CourseInstanceList;
import model.CourseList;
import model.Person;
import model.Role;
import model.StudentFacade;

public class TestStudentFacade
{
	private StudentFacade student;
	private CourseInstanceList instances;
	private CourseList courseList;
	private CourseInstance expectedInstance;

	@Before
	public void setUp() throws Exception
	{
		student = new StudentFacade(new Person("19920513-7562", "Erik", "Gustafsson"));
		courseList = new CourseList();
		instances = new CourseInstanceList(courseList);
		expectedInstance = new CourseInstance("jh232o", courseList.getCourses().get(0),
				new Person("760516-7636", "Per", "Ek"), new Person("800212-5666", "Alexander", "Larsson"));

	}

	@Test
	public void testRegisterToCourseInstance()
	{
		student.registerToCourseInstance(instances.getCourseInstances().get(0));
		assertEquals(expectedInstance.getCourse().getCourseName(),
				student.seeRegistrations(instances).get(0).getCourse().getCourseName());

	}

	@Test
	public void testUnRegisterFromCourseInstance()
	{
		student.registerToCourseInstance(instances.getCourseInstances().get(0));
		student.unregisterFromCourseInstance(instances.getCourseInstances().get(0));
		assertEquals(0, student.seeRegistrations(instances).size());
	}

	@Test
	public void testSeeCommitment()
	{
		student.registerToCourseInstance(instances.getCourseInstances().get(0));
		System.out.println(student.seeCommitment(instances.getCourseInstances().get(0)).toString());
		assertEquals("STUDENT Erik Gustafsson DVG01-123",
				student.seeCommitment(instances.getCourseInstances().get(0)).toString());

	}

	@Test
	public void testgetCourses()
	{
		assertEquals(courseList.getCourses().get(0).getCourseID(),
				student.getCourses().getCourses().get(0).getCourseID());
		assertEquals(courseList.getCourses().get(1).getCourseID(),
				student.getCourses().getCourses().get(1).getCourseID());
		assertEquals(courseList.getCourses().get(2).getCourseID(),
				student.getCourses().getCourses().get(2).getCourseID());
		assertEquals(courseList.getCourses().get(3).getCourseID(),
				student.getCourses().getCourses().get(3).getCourseID());
		assertEquals(courseList.getCourses().get(4).getCourseID(),
				student.getCourses().getCourses().get(4).getCourseID());
	}

	@Test
	public void testgetTeachers()
	{
		instances.getCourseInstances().get(0).addCommitment(
				new Commitment(Role.TEACHER, new Person("800212-5666", "Mats", "Karlsson"),courseList.getCourses().get(0).getCourseID()));
		assertEquals("800212-5666",student.getTeachers(instances.getCourseInstances().get(0)).get(0).getSocialSecurityNumber());
	}

	@Test
	public void testgetExaminator()
	{
		assertEquals("Alexander",student.getExaminator(instances.getCourseInstances().get(0)).getFirstName());
	}

	@Test
	public void testgetCourseCoordinator()
	{
		assertEquals("Per",student.getCourseCoordinator(instances.getCourseInstances().get(0)).getFirstName());
	}

}

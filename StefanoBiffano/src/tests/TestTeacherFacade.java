package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import facade.TeacherFacade;
import model.Commitment;
import model.CourseInstance;
import model.CourseInstanceList;
import model.CourseList;
import model.Person;
import model.Role;
import facade.StudentFacade;

public class TestTeacherFacade
{
	private StudentFacade student1, student2;
	private TeacherFacade teacher;
	private CourseInstanceList instances;
	private CourseList courseList;
	@Before
	public void setUp() throws Exception
	{
		student1 = new StudentFacade(new Person("19920513-7562", "Erik", "Gustafsson"));
		student2 = new StudentFacade(new Person("19910725-1265", "Halvar", "Bengtsson"));
		teacher = new TeacherFacade();
		courseList = new CourseList();
		instances = new CourseInstanceList(courseList);
		new CourseInstance("jh232o", courseList.getCourses().get(0),
				new Person("760516-7636", "Per", "Ek"), new Person("800212-5666", "Alexander", "Larsson"));

	}

	@Test
	public void testGetCourses()
	{
		assertEquals(courseList.getCourses().get(0).getCourseID(),
				teacher.getCourses().getCourses().get(0).getCourseID());
		assertEquals(courseList.getCourses().get(1).getCourseID(),
				teacher.getCourses().getCourses().get(1).getCourseID());
		assertEquals(courseList.getCourses().get(2).getCourseID(),
				teacher.getCourses().getCourses().get(2).getCourseID());
		assertEquals(courseList.getCourses().get(3).getCourseID(),
				teacher.getCourses().getCourses().get(3).getCourseID());
		assertEquals(courseList.getCourses().get(4).getCourseID(),
				teacher.getCourses().getCourses().get(4).getCourseID());
	}

	@Test
	public void testGetTeachers()
	{
		instances.getCourseInstances().get(0).addCommitment(new Commitment(Role.TEACHER,
				new Person("800212-5666", "Mats", "Karlsson"), courseList.getCourses().get(0).getCourseID()));
		assertEquals("800212-5666",
				teacher.getTeachers(instances.getCourseInstances().get(0)).get(0).getSocialSecurityNumber());
	}

	@Test
	public void testGetExaminator()
	{
		assertEquals("Alexander", teacher.getExaminator(instances.getCourseInstances().get(0)).getFirstName());
	}

	@Test
	public void testGetCourseCoordinator()
	{
		assertEquals("Per", teacher.getCourseCoordinator(instances.getCourseInstances().get(0)).getFirstName());
	}

	@Test
	public void testSeeInstanceCommitments()
	{
		student1.registerToCourseInstance(instances.getCourseInstances().get(0));
		student2.registerToCourseInstance(instances.getCourseInstances().get(0));
		System.out.println(teacher.seeInstanceCommitments(instances.getCourseInstances().get(0)));

		assertEquals("Per", teacher.seeInstanceCommitments(
				instances.getCourseInstances().get(0)).get(0).getPerson()
				.getFirstName());
		assertEquals("Alexander", teacher.seeInstanceCommitments(
				instances.getCourseInstances().get(0)).get(1).getPerson()
				.getFirstName());
		assertEquals("Erik", teacher.seeInstanceCommitments(
				instances.getCourseInstances().get(0)).get(2).getPerson()
				.getFirstName());
		assertEquals("Halvar", teacher.seeInstanceCommitments(
				instances.getCourseInstances().get(0)).get(3).getPerson()
				.getFirstName());

	}

}

package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import facade.CourseCoordinatorFacade;
import model.CourseInstance;
import model.CourseInstanceList;
import model.CourseList;
import model.Person;

public class TestCourseCoordinatorFacade
{
	private CourseCoordinatorFacade courseCoordinatorFacade;
	private CourseInstanceList instances;
	private CourseList courseList;
	private CourseInstance expectedInstance;
	private CourseInstance courseInstance;
	
	@Before
	public void setUp() throws Exception
	{
		courseCoordinatorFacade = new CourseCoordinatorFacade();
		courseList = new CourseList();
		instances = new CourseInstanceList(courseList);
		expectedInstance = new CourseInstance("pd234", courseList.getCourses().get(4),
				new Person("790526-7156", "Pär", "Knutsson"), new Person("670212-5786", "Malin", "Larsson"));
		courseInstance = new CourseInstance("pd234", courseList.getCourses().get(4),
				new Person("790526-7156", "Pär", "Knutsson"), new Person("670212-5786", "Malin", "Larsson"));
	}

	@Test
	public void testCreateCourseInstance()
	{
		
		instances = courseCoordinatorFacade.createCourseInstance(instances, courseInstance);
		assertEquals(expectedInstance.getRegCode(),
				instances.getCourseInstances().get(3).getRegCode());

	}
	
	@Test
	public void testSetCourseCoordinator()
	{
		System.out.println(courseInstance.getCourseCoordinator().getSocialSecurityNumber());
		courseCoordinatorFacade.setCourseCoordinator(courseInstance, new Person("198323-2354", "Lars", "Adaktusson"));
		assertEquals("198323-2354",
				courseInstance.getCourseCoordinator().getSocialSecurityNumber());
		System.out.println(courseInstance.getCourseCoordinator().getSocialSecurityNumber());
	}
	
	@Test
	public void testSetExaminator()
	{
		System.out.println(courseInstance.getExaminator().getFirstName());
		courseCoordinatorFacade.setExaminator(courseInstance, new Person("781201-7903", "Petter", "Jansson"));
		assertEquals("Petter",
				courseInstance.getExaminator().getFirstName());
		System.out.println(courseInstance.getExaminator().getFirstName());
		
	}
	

	

}

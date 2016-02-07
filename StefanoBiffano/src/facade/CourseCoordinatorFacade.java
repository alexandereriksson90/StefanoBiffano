package facade;

import java.util.LinkedList;

import model.Commitment;
import model.CourseInstance;
import model.CourseInstanceList;
import model.CourseList;
import model.Person;
import model.Role;
import model.StudentGrade;

public class CourseCoordinatorFacade implements RoleFacade
{

	@Override
	public LinkedList<Person> getTeachers(CourseInstance courseInstance)
	{
		LinkedList<Person> teachers = new LinkedList<Person>();
		for (Commitment c : courseInstance.getCommitments())
		{
			if (c.getRole() == Role.TEACHER)
				teachers.add(c.getPerson());
		}
		return teachers;
	}

	@Override
	public Person getExaminator(CourseInstance courseInstance)
	{
		return courseInstance.getExaminator();
	}

	@Override
	public Person getCourseCoordinator(CourseInstance courseInstance)
	{
		return courseInstance.getCourseCoordinator();
	}

	@Override
	public CourseList getCourses()
	{
		return new CourseList();
	}

	@Override
	public void registerToCourseInstance(CourseInstance courseInstance)
	{
		throw new UnauthorizedMethodException();
	}

	@Override
	public void unregisterFromCourseInstance(CourseInstance courseInstance)
	{
		throw new UnauthorizedMethodException();
	}

	@Override
	public LinkedList<Commitment> seeInstanceCommitments(CourseInstance courseInstance)
	{
		return courseInstance.getCommitments();
	}

	@Override
	public LinkedList<CourseInstance> seeRegistrations(CourseInstanceList courseInstanceList)
	{
		throw new UnauthorizedMethodException();
	}

	@Override
	public Commitment seeCommitment(CourseInstance courseInstance)
	{
		throw new UnauthorizedMethodException();
	}

	@Override
	public void setStudentGrade(CourseInstance courseInstance, StudentGrade studentGrade)
	{
		throw new UnauthorizedMethodException();
	}

	@Override
	public LinkedList<StudentGrade> getStudentGrades(CourseInstance courseInstance)
	{
		return courseInstance.getStudentgrades();
	}

	@Override
	public void removeStudentGrade(CourseInstance courseInstance, StudentGrade studentGrade)
	{
		throw new UnauthorizedMethodException();
	}
	
	@Override
	public CourseInstanceList createCourseInstance(CourseInstanceList courseInstanceList, CourseInstance courseInstance)
	{
		courseInstanceList.addCourseInstance(courseInstance);
		return courseInstanceList;
	}
	
	@Override
	public void setCourseCoordinator(CourseInstance courseInstance, Person coordinator)
	{
		courseInstance.setCourseCoordinator(coordinator);
	}

	@Override
	public void setExaminator(CourseInstance courseInstance, Person examinator)
	{
		courseInstance.setExaminator(examinator);
	}

}

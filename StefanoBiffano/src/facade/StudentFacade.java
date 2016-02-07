package facade;

import java.util.LinkedList;

import model.Commitment;
import model.CourseInstance;
import model.CourseInstanceList;
import model.CourseList;
import model.Person;
import model.Role;
import model.StudentGrade;

public class StudentFacade implements RoleFacade
{
	private Person student;

	public StudentFacade(Person student)
	{
		this.student = student;
	}

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

	public void registerToCourseInstance(CourseInstance courseInstance)
	{
		courseInstance.addCommitment(new Commitment(Role.STUDENT, student, courseInstance.getCourse().getCourseID()));
	}

	public void unregisterFromCourseInstance(CourseInstance courseInstance)
	{
		courseInstance.removeCommitment(seeCommitment(courseInstance));
	}

	public LinkedList<CourseInstance> seeRegistrations(CourseInstanceList courseInstanceList)
	{
		LinkedList<CourseInstance> courses = new LinkedList<CourseInstance>();

		for (CourseInstance ci : courseInstanceList.getCourseInstances())
		{
			if (seeCommitment(ci) != null)
				courses.add(ci);
		}
		return courses;
	}

	public Commitment seeCommitment(CourseInstance courseInstance)
	{
		Commitment studentCommitment = null;

		for (Commitment c : courseInstance.getCommitments())
		{
			if (c.getPerson() == student && c.getRole() == Role.STUDENT)
			{
				studentCommitment = c;
			}
		}
		return studentCommitment;
	}

	@Override
	public LinkedList<Commitment> seeInstanceCommitments(CourseInstance courseInstance)
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
		throw new UnauthorizedMethodException();
	}

	@Override
	public void removeStudentGrade(CourseInstance courseInstance, StudentGrade studentGrade)
	{
		throw new UnauthorizedMethodException();
	}

	@Override
	public void setExaminator(CourseInstance courseInstance, Person examinator)
	{
		throw new UnauthorizedMethodException();
	}

	@Override
	public CourseInstanceList createCourseInstance(CourseInstanceList courseInstanceList, CourseInstance courseInstance)
	{
		throw new UnauthorizedMethodException();
	}

	@Override
	public void setCourseCoordinator(CourseInstance courseInstance, Person coordinator)
	{
		throw new UnauthorizedMethodException();
	}

}

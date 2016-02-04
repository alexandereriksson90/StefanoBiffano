package model;

import java.util.LinkedList;

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
		courseInstance.addCommitment(new Commitment(Role.STUDENT, this.student, courseInstance.getCourse().getCourseID()));
	}

	public void unregisterFromCourseInstance(CourseInstance courseInstance)
	{
		courseInstance.removeCommitment(seeCommitment(courseInstance));
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

}

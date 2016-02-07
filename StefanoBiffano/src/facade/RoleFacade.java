package facade;

import java.util.LinkedList;

import model.Commitment;
import model.CourseInstance;
import model.CourseInstanceList;
import model.CourseList;
import model.Person;
import model.StudentGrade;

public interface RoleFacade 
{
	LinkedList<Person> getTeachers(CourseInstance courseInstance);
	Person getExaminator(CourseInstance courseInstance);
	CourseList getCourses();
	Person getCourseCoordinator(CourseInstance courseInstance);
	void registerToCourseInstance(CourseInstance courseInstance);
	void unregisterFromCourseInstance(CourseInstance courseInstance);
	LinkedList<CourseInstance> seeRegistrations(CourseInstanceList courseInstanceList);
	Commitment seeCommitment(CourseInstance courseInstance);
	LinkedList<Commitment> seeInstanceCommitments(CourseInstance courseInstance);
	void setStudentGrade(CourseInstance courseInstance, StudentGrade studentGrade);
	LinkedList<StudentGrade> getStudentGrades(CourseInstance courseInstance);
	void removeStudentGrade(CourseInstance courseInstance, StudentGrade studentGrade);
	void setExaminator(CourseInstance courseInstance, Person examinator);
	CourseInstanceList createCourseInstance(CourseInstanceList courseInstanceList, CourseInstance courseInstance);
	void setCourseCoordinator(CourseInstance courseInstance, Person coordinator);
}

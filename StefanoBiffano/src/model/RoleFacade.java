package model;

import java.util.LinkedList;

public interface RoleFacade {
	LinkedList<Person> getTeachers(CourseInstance courseInstance);
	Person getExaminator(CourseInstance courseInstance);
	Person getCourseCoordinator(CourseInstance courseInstance);
	CourseList getCourses();
}

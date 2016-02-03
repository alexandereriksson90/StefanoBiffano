package model;

import java.util.LinkedList;

public class CourseInstance {
	private CommitmentList commitments;
	private Course course;
	private String regCode;
	
	public CourseInstance(String regCode, Course course) {
		this.course = course;
		this.regCode = regCode;
	}
	
	void addCommitment(Commitment commitment) {
		commitments.add(commitment);
	}
	
	void removeCommitment(Commitment commitment) {
		commitments.remove(commitment);
	}

}

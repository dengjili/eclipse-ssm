package priv.dengjl.entity;

import java.io.Serializable;

public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	private int subjectNo;

	private int classHour;

	private int gradeId;

	private String subjectName;

	public Subject() {
	}

	public int getSubjectNo() {
		return this.subjectNo;
	}

	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}

	public int getClassHour() {
		return this.classHour;
	}

	public void setClassHour(int classHour) {
		this.classHour = classHour;
	}

	public int getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
package priv.dengjl.entity;

import java.io.Serializable;
import java.util.Date;

public class Result implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date examDate;

	private int studentResult;

	private int studnetNo;

	private int subjectNo;

	public Result() {
	}

	public Date getExamDate() {
		return this.examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public int getStudentResult() {
		return this.studentResult;
	}

	public void setStudentResult(int studentResult) {
		this.studentResult = studentResult;
	}

	public int getStudnetNo() {
		return this.studnetNo;
	}

	public void setStudnetNo(int studnetNo) {
		this.studnetNo = studnetNo;
	}

	public int getSubjectNo() {
		return this.subjectNo;
	}

	public void setSubjectNo(int subjectNo) {
		this.subjectNo = subjectNo;
	}

}
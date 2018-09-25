package priv.dengjl.entity;

import java.io.Serializable;


public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;

	private int gradeId;

	private String gradeName;

	public Grade() {
	}

	public int getGradeId() {
		return this.gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeName() {
		return this.gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

}
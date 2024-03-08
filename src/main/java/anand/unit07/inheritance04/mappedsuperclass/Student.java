package anand.unit07.inheritance04.mappedsuperclass;

import javax.persistence.Entity;

@Entity
public class Student extends Person {
    private String studentId;
    private String branch;
    
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}

}

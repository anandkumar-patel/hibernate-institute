package anand.unit07.inheritance04.mappedsuperclass;

import javax.persistence.Entity;

@Entity
public class Teacher extends Person {
	private String teacherId;
	private String subject;
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

}

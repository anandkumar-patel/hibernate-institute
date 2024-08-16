package anand.u01t04.methods;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "subject_methods")
public class Subject {
	@Id
	private int subjectId;
	private String name;
	private String teacher;
	public int getSubjectId() {
		return subjectId;
	}
	public Subject() {
		super();
	}
	public Subject(int subjectId, String name, String teacher) {
		super();
		this.subjectId = subjectId;
		this.name = name;
		this.teacher = teacher;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", name=" + name + ", teacher=" + teacher + "]";
	}
	
}
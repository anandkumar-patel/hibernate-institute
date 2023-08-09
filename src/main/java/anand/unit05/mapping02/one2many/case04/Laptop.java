package anand.unit05.mapping02.one2many.case04;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
	private int lapId;
	private String brandName;
	private String modelName;
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student1;
	
	public int getLapId() {
		return lapId;
	}

	public void setLapId(int lapId) {
		this.lapId = lapId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Student getStudent() {
		return student1;
	}

	public void setStudent(Student student) {
		this.student1 = student;
	}
}

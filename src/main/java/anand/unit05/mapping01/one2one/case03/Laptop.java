package anand.unit05.mapping01.one2one.case03;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "laptop03")
public class Laptop {
	@Id
	private int lapId;
	private String brandName;
	private String modelName;
	@OneToOne(mappedBy = "laptop")
	private Student student;

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
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Laptop [lapId=" + lapId + ", brandName=" + brandName + ", modelName=" + modelName + "]";
	}
	
}

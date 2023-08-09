package anand.unit05.mapping03.many2many.case03;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Laptop {
	@Id
	private int lapId;
	private String brandName;
	private String modelName;
	@ManyToMany
	private List<Student> students = new ArrayList<>();
	
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

	public List<Student> getStudent() {
		return students;
	}

	public void setStudent(List<Student> students) {
		this.students = students;
	}
}

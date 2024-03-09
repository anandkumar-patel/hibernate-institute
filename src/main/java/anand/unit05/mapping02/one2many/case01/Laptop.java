package anand.unit05.mapping02.one2many.case01;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "laptop04")
public class Laptop {
	@Id
	private int lapId;
	private String brandName;
	private String modelName;
	
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
}

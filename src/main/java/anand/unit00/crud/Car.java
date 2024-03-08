package anand.unit00.crud;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "car_unit00")
public class Car {

	@Id
	private String model;
	private String price;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", price=" + price + "]";
	}

}
package anand.unit07.inheritance02.tableperclass;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {
	private int numDoors;
	private String carType;
	
	public int getNumDoors() {
		return numDoors;
	}

	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	@Override
	public String toString() {
		return "Car [numDoors=" + numDoors + ", carType=" + carType + "]";
	}
}

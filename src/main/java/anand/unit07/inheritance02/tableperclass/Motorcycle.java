package anand.unit07.inheritance02.tableperclass;

import javax.persistence.Entity;

@Entity
public class Motorcycle extends Vehicle {
	private boolean hasFairing;
	private String bikeType;

	public boolean isHasFairing() {
		return hasFairing;
	}

	public void setHasFairing(boolean hasFairing) {
		this.hasFairing = hasFairing;
	}

	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}

	@Override
	public String toString() {
		return "Motorcycle [hasFairing=" + hasFairing + ", bikeType=" + bikeType + "]";
	}
}

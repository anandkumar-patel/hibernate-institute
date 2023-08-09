package anand.unit02.collection;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private int homeNo;
	private String streetName;
	private String cityName;
	private String stateName;
	private int pinCode;
	public int getHomeNo() {
		return homeNo;
	}
	public void setHomeNo(int homeNo) {
		this.homeNo = homeNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "Address [homeNo=" + homeNo + ", streetName=" + streetName + ", cityName=" + cityName + ", stateName="
				+ stateName + ", pinCode=" + pinCode + "]";
	}

}

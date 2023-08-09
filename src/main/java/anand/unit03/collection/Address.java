package anand.unit03.collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name="home_no", length=4)
	private int homeNo;
	@Column(name="street_name", length=50)
	private String streetName;
	@Column(name="city_name", length=20, insertable=true)
	private String cityName;
	@Column(name="state_name", length=20)
	private String stateName;
	@Column(name="pin_code", length=6, nullable=false)
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

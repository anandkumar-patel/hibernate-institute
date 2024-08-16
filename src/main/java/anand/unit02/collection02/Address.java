package anand.unit02.collection02;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private int homeNo;
	private String city;
	private String state;
	public int getHomeNo() {
		return homeNo;
	}
	public void setHomeNo(int homeNo) {
		this.homeNo = homeNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [homeNo=" + homeNo + ", city=" + city + ", state=" + state + "]";
	}

}
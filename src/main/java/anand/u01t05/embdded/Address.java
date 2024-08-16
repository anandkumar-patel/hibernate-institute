package anand.u01t05.embdded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name="home_no", length=4)
	private int homeNo;
	
	@Column(name="city", length=20, insertable=true)
	private String city;
	
	@Column(name="state", length=20)
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

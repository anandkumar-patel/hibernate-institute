package anand.unit03.compositeprimarykey.idclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "airports")
@IdClass(AirportId.class)
public class Airport {
	@Id
	@Column(name = "country_code")
	private String countryCode;
	@Id
	@Column(name = "city_code")
	private String cityCode;
	private String name;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Airport [countryCode=" + countryCode + ", cityCode=" + cityCode + ", name=" + name + "]";
	}
	
}

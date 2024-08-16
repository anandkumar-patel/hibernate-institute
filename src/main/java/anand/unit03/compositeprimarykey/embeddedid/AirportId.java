package anand.unit03.compositeprimarykey.embeddedid;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AirportId implements Serializable{
	private static final long serialVersionUID = 1L;
	@Column(name = "country_code")
	private String countryCode;
	
	@Column(name = "city_code")
	private String cityCode;
	
	public AirportId() {
		super();
	}
	public AirportId(String countryCode, String cityCode) {
		super();
		this.countryCode = countryCode;
		this.cityCode = cityCode;
	}
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
	@Override
	public int hashCode() {
		return Objects.hash(cityCode, countryCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirportId other = (AirportId) obj;
		return Objects.equals(cityCode, other.cityCode) && Objects.equals(countryCode, other.countryCode);
	}
	@Override
	public String toString() {
		return "AirportId [countryCode=" + countryCode + ", cityCode=" + cityCode + "]";
	}
	
	
	
}

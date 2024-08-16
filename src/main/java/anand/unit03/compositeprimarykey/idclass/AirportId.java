package anand.unit03.compositeprimarykey.idclass;

import java.io.Serializable;
import java.util.Objects;

public class AirportId implements Serializable{
	private static final long serialVersionUID = 1L;
	private String countryCode;
	private String cityCode;
	
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
	
}

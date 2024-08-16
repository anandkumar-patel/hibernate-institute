package anand.unit03.compositeprimarykey.embeddedid;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "airport_em")
@Table(name = "airports_em")
public class Airport {
	@EmbeddedId
	private AirportId id;
	private String name;
	
	public AirportId getId() {
		return id;
	}
	public void setId(AirportId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Airport [id=" + id + ", name=" + name + "]";
	}
	
	
}

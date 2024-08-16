package anand.unit06.cascade.master;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "state")
public class StateMaster {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Long stateId;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private CountryMaster country;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CityMaster> cities;

    // Getters and setters
    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryMaster getCountry() {
        return country;
    }

    public void setCountry(CountryMaster country) {
        this.country = country;
    }

    public Set<CityMaster> getCities() {
        return cities;
    }

    public void setCities(Set<CityMaster> cities) {
        this.cities = cities;
    }

	@Override
	public String toString() {
		return "StateMaster [stateId=" + stateId + ", name=" + name + "]";
	}
    
}

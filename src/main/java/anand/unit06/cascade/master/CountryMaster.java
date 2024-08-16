package anand.unit06.cascade.master;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "country")
public class CountryMaster {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<StateMaster> states;

    // Getters and setters
    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StateMaster> getStates() {
        return states;
    }

    public void setStates(Set<StateMaster> states) {
        this.states = states;
    }

	@Override
	public String toString() {
		return "CountryMaster [countryId=" + countryId + ", name=" + name + "]";
	}
    
}

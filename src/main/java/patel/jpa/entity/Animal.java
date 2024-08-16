package patel.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import patel.jpa.config.xml.AnimalEntityListener;


@Entity
@EntityListeners(AnimalEntityListener.class)
@Table(name = "animal")
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Boolean dangerous;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getDangerous() {
		return dangerous;
	}
	public void setDangerous(Boolean dangerous) {
		this.dangerous = dangerous;
	}
	@Override
	public String toString() {
		return "Animal [id=" + id + ", name=" + name + ", dangerous=" + dangerous + "]";
	}

	
}

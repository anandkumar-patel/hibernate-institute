package patel.jpa.config.xml;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import patel.jpa.entity.Animal;

public class AnimalEntityListener {
	@PrePersist
	public void animalPrePersist(Animal ob) {
		System.out.println("Listening Animal Pre Persist : " + ob.getName());
	}

	@PostPersist
	public void animalPostPersist(Animal ob) {
		System.out.println("Listening Animal Post Persist : " + ob.getName());
	}

	@PostLoad
	public void animalPostLoad(Animal ob) {
		System.out.println("Listening Animal Post Load : " + ob.getName());
	}

	@PreUpdate
	public void animalPreUpdate(Animal ob) {
		System.out.println("Listening Animal Pre Update : " + ob.getName());
	}

	@PostUpdate
	public void animalPostUpdate(Animal ob) {
		System.out.println("Listening Animal Post Update : " + ob.getName());
	}

	@PreRemove
	public void animalPreRemove(Animal ob) {
		System.out.println("Listening Animal Pre Remove : " + ob.getName());
	}

	@PostRemove
		public void animalPostRemove(Animal ob) {
			System.out.println("Listening Animal Post Remove : " + ob.getName());
		}
}

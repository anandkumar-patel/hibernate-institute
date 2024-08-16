package patel.jpa.config.xml;

import javax.persistence.EntityManager;

import patel.jpa.entity.Animal;

public class JPAListenerMain {
	public static void main(String[] args) {
		System.out.println("main method started...");
		EntityManager entityManager = JPAUtility.getEntityManager();	
		entityManager.getTransaction().begin();
		//persist animal
		Animal animal = new Animal();
		animal.setName("lion");
		animal.setDangerous(true);
		entityManager.persist(animal);
		entityManager.getTransaction().commit();
		//refresh animal
		entityManager.refresh(animal);
		//update animal
		entityManager.getTransaction().begin();				
		animal.setName("tiger");
		entityManager.getTransaction().commit();
		//remove animal
		entityManager.getTransaction().begin();				
		//entityManager.remove(animal);
		entityManager.getTransaction().commit();		
		entityManager.close();
		JPAUtility.close();
		System.out.println("main method ended...");
	}
}

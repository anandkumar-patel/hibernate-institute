package patel.jpa.config.xml;

import javax.persistence.EntityManager;

import patel.jpa.entity.Farmer;

public class JpaMain {

	public static void main(String[] args) {
		EntityManager em = JPAUtility.getEntityManager();
		persist(em);
		//find(em);
		//update(em);
		//contains(em);
		//detach(em);
		//remove(em);
		
		em.close();
		JPAUtility.close();
		
	}
	
	public static void persist(EntityManager em) {
		System.out.println("*** in persist() method ***");
		em.getTransaction().begin();
		Farmer f = new Farmer();
		f.setId(6);
		f.setName("Ram");
		f.setVillage("Dhananjaypur");
		em.persist(f);
		em.getTransaction().commit();
		System.out.println("entity persisted...");
	}
	
	public static void find(EntityManager em) {
		System.out.println("*** in find() method ***");
		Farmer farmer = em.find(Farmer.class, 1);
		System.out.println(farmer.toString());
		System.out.println("entity found...");
	}
	
	public static void update(EntityManager em) {
		System.out.println("*** in update() method ***");
		Farmer farmer = em.find(Farmer.class, 1);
		System.out.println("before update :"+farmer);
		farmer.setVillage("dariyapur");
		em.getTransaction().begin();
		//em.merge(farmer);
		em.getTransaction().commit();
		System.out.println("after update :"+farmer);
		System.out.println("entity updated...");
	}
	
	public static void contains(EntityManager em) {
		System.out.println("*** in contains() method ***");
		Farmer farmer = em.find(Farmer.class, 1);
		System.out.println(em.contains(farmer)); // true
		em.detach(farmer);
		System.out.println(em.contains(farmer)); // false
		em.getTransaction().begin();
		//farmer.setVillage("solum");
		farmer = em.merge(farmer);
		em.getTransaction().commit();
		System.out.println(em.contains(farmer)); // true 
		
		Farmer farmer1 = new Farmer();
		farmer1.setId(2);
		farmer1.setName("shyam");
		farmer1.setVillage("gokul");
		System.out.println(em.contains(farmer1)); // false
	}
	
	public static void detach(EntityManager em) {
		System.out.println("*** in detach() method ***");
		Farmer farmer = em.find(Farmer.class, 1);
		System.out.println(em.contains(farmer)); // true
		em.detach(farmer);
		System.out.println(em.contains(farmer)); // false
		System.out.println("entity detached...");
	}
	
	public static void merge(EntityManager em) {
		System.out.println("*** in merge() method ***");
		Farmer farmer = em.find(Farmer.class, 1);
		System.out.println(em.contains(farmer)); // true
		em.detach(farmer);
		System.out.println(em.contains(farmer)); // false
		em.getTransaction().begin();
		//farmer.setVillage("solum");
		farmer = em.merge(farmer);
		em.getTransaction().commit();
		System.out.println(em.contains(farmer)); // true 
		System.out.println("entity merged...");
	}
	
	public static void remove(EntityManager em) {
		Farmer farmer = em.find(Farmer.class, 1);
		em.getTransaction().begin();
		em.remove(farmer);
		em.getTransaction().commit();
		System.out.println("entity removed...");
	}
}
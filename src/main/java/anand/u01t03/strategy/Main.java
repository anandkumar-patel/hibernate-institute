package anand.u01t03.strategy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Main obj = new Main();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		obj.persist(sessionFactory);
		
		sessionFactory.close();
	}
	
	
	// saving simple entity
	public void persist(SessionFactory sf) {
		Session session = sf.openSession();
		SimpleEntity entity = new SimpleEntity("anand patel1", "anand comment1");
		session.beginTransaction();
		System.out.println("before persist the entity");
		session.persist(entity);
		System.out.println("after persist the entity");
		session.getTransaction().commit();
		System.out.println("after commit the entity");
		session.close();
	}
	

}

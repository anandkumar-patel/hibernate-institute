package anand.unit05.mapping02.one2many.case02;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class MainClass {
     
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//mapping(sessionFactory);
		//fetch(sessionFactory);
		update(sessionFactory);
		sessionFactory.close();
	}
	
	public static void fetch(SessionFactory sf) {
		System.out.println("***** fetch method started  *****");
		Session session = sf.openSession();
		
		Laptop lap1 = session.get(Laptop.class, 11);
		System.out.println("Laptop details :"+lap1.getModelName());
		
		Student st1 = session.get(Student.class, 1111);
		System.out.println("Student Name :"+st1.getName());
		
		System.out.println("Student's Laptop details :"+st1.getLaptops().get(0).getModelName());
		
		session.close();
	}
	
	public static void update(SessionFactory sf) {
		System.out.println("***** update method started  *****");
		Session session = sf.openSession();
		session.beginTransaction();
		Laptop lap1 = session.get(Laptop.class, 11);
		lap1.setBrandName("hp1");
		
		Student st1 = session.get(Student.class, 1111);
		st1.setMarks(12.55f);
		
		List<Laptop> laps = st1.getLaptops();
		//laps.remove(0);
		st1.removeLaptop(laps.get(0));	
		session.getTransaction().commit();
		session.close();
	}
	
	public static void mapping(SessionFactory sessionFactory) {
		System.out.println("***** mapping method started  *****");
		Session session = sessionFactory.openSession();

		Laptop lap1 = new Laptop();
		lap1.setLapId(11);
		lap1.setBrandName("hp");
		lap1.setModelName("celerio");
		
		Laptop lap2 = new Laptop();
		lap2.setLapId(12);
		lap2.setBrandName("dell");
		lap2.setModelName("insprion");
		
		

		Student student1 = new Student();
		student1.setRollNo(1111);
		student1.setName("Urmila");
		student1.setMarks(800.50f);
		student1.getLaptops().add(lap1);
		student1.getLaptops().add(lap2);
		
				
		session.beginTransaction();

		session.save(student1);

		session.save(lap1);
		session.save(lap2);

		session.getTransaction().commit();
		session.close();
	}
}
package anand.unit05.mapping01.one2one.case01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class MainClass {
     
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		mappingConcepts(sessionFactory);
		
		sessionFactory.close();
	}
	
	public static void mappingConcepts(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();

		Laptop lap1 = new Laptop();
		lap1.setLapId(12);
		lap1.setBrandName("hp");
		lap1.setModelName("celerio");
		
		Laptop lap2 = new Laptop();
		lap2.setLapId(11);
		lap2.setBrandName("dell");
		lap2.setModelName("insprion");

		Student student1 = new Student();
		student1.setRollNo(1122);
		student1.setName("Urmila");
		student1.setMarks(800.50f);
		student1.setLaptop(lap2);
		
		Student student2 = new Student();
		student2.setRollNo(1112);
		student2.setName("anand");
		student2.setMarks(500.50f);
		student2.setLaptop(lap1);
		
		session.beginTransaction();

		session.save(student1);
		session.save(student2);
		
		session.save(lap1);
		session.save(lap2);

		session.getTransaction().commit();
		session.close();
	}
}
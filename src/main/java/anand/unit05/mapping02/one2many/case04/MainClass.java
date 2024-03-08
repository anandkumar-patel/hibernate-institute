package anand.unit05.mapping02.one2many.case04;

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
		
		Laptop lap3 = new Laptop();
		lap3.setLapId(13);
		lap3.setBrandName("lenovo");
		lap3.setModelName("ideapad");

		Laptop lap4 = new Laptop();
		lap4.setLapId(14);
		lap4.setBrandName("hcl");
		lap4.setModelName("basic");

		Student student1 = new Student();
		student1.setRollNo(1111);
		student1.setName("Urmila");
		student1.setMarks(800.50f);
		student1.getLaptop().add(lap1);
		student1.getLaptop().add(lap3);
		
		Student student2 = new Student();
		student2.setRollNo(1112);
		student2.setName("anand");
		student2.setMarks(500.50f);
		student1.getLaptop().add(lap2);
		student1.getLaptop().add(lap4);
	
		lap1.setStudent(student1);
		lap3.setStudent(student1);
		
		lap2.setStudent(student2);
		lap4.setStudent(student2);

		session.beginTransaction();

		session.save(student1);
		session.save(student2);

		session.save(lap1);
		session.save(lap2);
		session.save(lap3);
		session.save(lap4);

		session.getTransaction().commit();
		session.close();
	}
}
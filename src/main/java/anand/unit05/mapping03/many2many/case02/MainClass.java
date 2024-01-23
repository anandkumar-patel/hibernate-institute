package anand.unit05.mapping03.many2many.case02;

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
		lap1.setLapId(11);
		lap1.setBrandName("hp");
		lap1.setModelName("celerio");
		
		Laptop lap2 = new Laptop();
		lap2.setLapId(12);
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
		student1.setRollNo(1112);
		student1.setName("anand");
		student1.setMarks(800.50f);
		student1.getLaptop().add(lap1);
		student1.getLaptop().add(lap2);
		
		Student student2 = new Student();
		student2.setRollNo(1113);
		student2.setName("uday");
		student2.setMarks(700.50f);
		student2.getLaptop().add(lap3);
		student2.getLaptop().add(lap4);
		
		Student student3 = new Student();
		student3.setRollNo(1114);
		student3.setName("urmila");
		student3.setMarks(670.50f);
		student3.getLaptop().add(lap1);
		student3.getLaptop().add(lap2);
		
		Student student4 = new Student();
		student4.setRollNo(1115);
		student4.setName("surya");
		student4.setMarks(900.50f);
		student4.getLaptop().add(lap3);
		student4.getLaptop().add(lap4);
		
		session.beginTransaction();
		session.save(student1);
		session.save(student2);
		session.save(student3);
		session.save(student4);

		session.save(lap1);
		session.save(lap2);
		session.save(lap3);
		session.save(lap4);

		session.getTransaction().commit();
		session.close();
	}
}
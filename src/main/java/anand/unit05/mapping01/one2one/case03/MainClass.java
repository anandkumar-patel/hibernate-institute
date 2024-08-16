package anand.unit05.mapping01.one2one.case03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class MainClass {
     
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//mapping(sessionFactory);
		
		fetch(sessionFactory);
		
		sessionFactory.close();
	}
	
	public static void fetch(SessionFactory sf) {
		Session session = sf.openSession();
		
//		Laptop lap1 = session.get(Laptop.class, 11);
//		System.out.println("Laptop Model :"+lap1.getModelName());
//		System.out.println("Student Name :"+lap1.getStudent().getName());
		
		Student st1 = session.get(Student.class, 1112);
		System.out.println("Student's Detail :"+st1);
		
		System.out.println("Student's Laptop Detail :"+st1.getLaptop());
		
	}
	public static void mapping(SessionFactory sessionFactory) {
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
		student1.setLaptop(lap1);
		
		Student student2 = new Student();
		student2.setRollNo(1112);
		student2.setName("anand");
		student2.setMarks(500.50f);
		student2.setLaptop(lap2);
		
		lap1.setStudent(student1);
		lap2.setStudent(student2);
		
		session.beginTransaction();

		session.save(student1);
		session.save(student2);

		session.getTransaction().commit();
		session.close();
	}
}
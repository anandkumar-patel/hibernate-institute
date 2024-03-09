package anand.unit05.mapping03.many2many.case03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class MainClass {
     
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		mapping(sessionFactory);
		fetch(sessionFactory);
		
		sessionFactory.close();
	}
	public static void fetch(SessionFactory sf) {
		Session session = sf.openSession();
		
		Laptop lap1 = session.get(Laptop.class, 11);
		System.out.println("Laptop details :"+lap1.getModelName());
		System.out.println("student linked to Laptop :"+lap1.getStudents().get(0).getName());
		
		Student st1 = session.get(Student.class, 1112);
		System.out.println("Student Name :"+st1.getName());
		
		System.out.println("Student's Laptop details :"+st1.getLaptops().get(0).getModelName());
		
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
		student1.getLaptops().add(lap1);
		student1.getLaptops().add(lap2);
		
		Student student2 = new Student();
		student2.setRollNo(1113);
		student2.setName("uday");
		student2.setMarks(700.50f);
		student2.getLaptops().add(lap3);
		student2.getLaptops().add(lap4);
		
		Student student3 = new Student();
		student3.setRollNo(1114);
		student3.setName("urmila");
		student3.setMarks(670.50f);
		student3.getLaptops().add(lap1);
		student3.getLaptops().add(lap2);
		
		Student student4 = new Student();
		student4.setRollNo(1115);
		student4.setName("surya");
		student4.setMarks(900.50f);
		student4.getLaptops().add(lap3);
		student4.getLaptops().add(lap4);
	

		lap1.getStudents().add(student2);
		lap1.getStudents().add(student3);
		lap2.getStudents().add(student4);
		lap2.getStudents().add(student1);
		lap3.getStudents().add(student2);
		lap3.getStudents().add(student3);
		lap4.getStudents().add(student4);
		lap4.getStudents().add(student1);
		
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
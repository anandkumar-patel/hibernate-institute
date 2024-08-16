package anand.unit05.mapping01.one2one.case01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class MainClass {
     
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		//mapping(sessionFactory);
		insert(sessionFactory);
//		delete(sessionFactory);
		//fetch(sessionFactory);
		sessionFactory.close();
	}
	
	public static void fetch(SessionFactory sf) {
		Session session = sf.openSession();
		
		Laptop lap1 = session.get(Laptop.class, 11);
		System.out.println("Laptop details :"+lap1.getModelName());
		
		Student st1 = session.get(Student.class, 1112);
		System.out.println("Student's Details :"+st1);
		
		System.out.println("Student's Laptop details :"+st1.getLaptop());
		
	}
	
	public static void insert(SessionFactory sf) {
		Student student = new Student();
		student.setRollNo(1113);
		student.setName("anand");
		student.setMarks(900.50f);
		
		Laptop lap = new Laptop();
		lap.setLapId(13);
		lap.setBrandName("lenovo");
		lap.setModelName("ideapad");
		
		student.setLaptop(lap);
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void delete(SessionFactory sf) {
		Session session = sf.openSession();
		Student st = session.get(Student.class, 1112);
		session.beginTransaction();
		session.delete(st);
		session.getTransaction().commit();
		session.close();
	}
	
	public static void mapping(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();

		Laptop lap1 = new Laptop();
		lap1.setLapId(11);
		lap1.setBrandName("hp");
		lap1.setModelName("celerio");
		
		Student student1 = new Student();
		student1.setRollNo(1111);
		student1.setName("Urmila");
		student1.setMarks(800.50f);
		student1.setLaptop(lap1);
		
		session.beginTransaction();
		session.save(student1);
		session.getTransaction().commit();
		session.close();
	}
}
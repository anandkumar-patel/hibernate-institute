package anand.u01t04.methods;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Main obj = new Main();
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		//obj.insertSampleData(sessionFactory);
		
		//obj.get(sessionFactory);
		//obj.load(sessionFactory);
		
		//obj.evict(sessionFactory);

		//obj.persist(sessionFactory);
		
		//obj.delete(sessionFactory);
		
		
		sessionFactory.close();
	}
	
	public void get(SessionFactory sessionFactory) {
		System.out.println("get method start.....");
		Session session = sessionFactory.openSession();
		Student student = session.get(Student.class, 1112);
		System.out.println("get method get called here,but details is not yet accessed...");
		System.out.println("Student Name : " + student.getName());
		
		Set<Subject> subjects = student.getSubjects();
		System.out.println("Student details : ");
		for(Subject subject: subjects) {
			System.out.println(subject);
		}
		System.out.println("get method end.....");
		session.close();
	}

	public void load(SessionFactory sessionFactory) {
		System.out.println("load method start.....");
		Session session = sessionFactory.openSession();
		Student student = session.load(Student.class, 1112);
		System.out.println("load method get called here,but details is not yet accessed...");
		System.out.println("Student Name : " + student.getName());
		
		Set<Subject> subjects = student.getSubjects();
		System.out.println("Student details : ");
		for(Subject subject: subjects) {
			System.out.println(subject);
		}
		System.out.println("load method end.....");
		session.close();
	}
	
	public void evict(SessionFactory sessionFactory) {
		System.out.println("evict method start.....");
		Session session = sessionFactory.openSession();
		Student student = session.load(Student.class, 1112);
		session.beginTransaction();
		student.setName("rama");
		session.evict(student);
		System.out.println(student);
		
		session.saveOrUpdate(student);
		session.getTransaction().commit();
		
		
		System.out.println("evict method end.....");
		session.close();
	}

	public void persist(SessionFactory sf) {
		Session session = sf.openSession();
		
		Subject hindi = session.get(Subject.class, 11);
		Subject math = session.get(Subject.class, 14);
		
		Student kanha = new Student(1113, "kanha", 5);
		kanha.getSubjects().add(hindi);
		kanha.getSubjects().add(math);
		session.beginTransaction();
		session.persist(kanha);
		session.getTransaction().commit();
		session.close();
	}
	
	public void save(SessionFactory sf) {
		Session session = sf.openSession();
		
		Subject hindi = new Subject(15, "history", "ramya");
		Subject math = new Subject(16, "geography", "kusum");
		
		Student kanha = new Student(1113, "ram", 5);
		kanha.getSubjects().add(hindi);
		kanha.getSubjects().add(math);
		session.beginTransaction();
		session.persist(kanha);
		session.getTransaction().commit();
		session.close();
	}
	
	public void update(SessionFactory sf) {
		Session session = sf.openSession();
		
		Subject hindi = new Subject(15, "history", "ramya");
		Subject math = new Subject(16, "geography", "kusum");
		
		Student kanha = new Student(1113, "ram", 5);
		kanha.getSubjects().add(hindi);
		kanha.getSubjects().add(math);
		session.beginTransaction();
		session.persist(kanha);
		session.getTransaction().commit();
		session.close();
	}
	
	public void saveAndUpdate(SessionFactory sf) {
		Session session = sf.openSession();
		
		Subject hindi = new Subject(15, "history", "ramya");
		Subject math = new Subject(16, "geography", "kusum");
		
		Student kanha = new Student(1113, "ram", 5);
		kanha.getSubjects().add(hindi);
		kanha.getSubjects().add(math);
		session.beginTransaction();
		session.persist(kanha);
		session.getTransaction().commit();
		session.close();
	}
	
	public void delete(SessionFactory sf) {
		Session session = sf.openSession();
		Student kanha = session.get(Student.class, 1113);
		session.beginTransaction();
		session.delete(kanha);
		session.getTransaction().commit();
		session.close();
	}
	public void insertSampleData(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		
		Subject hindi = new Subject(11, "hindi", "rachana");
		Subject english = new Subject(12, "english", "priya");
		Subject science = new Subject(13, "science", "saumya");
		Subject math = new Subject(14, "mathematics", "nikita");
		
		Student ram = new Student(1112, "ram", 1);
		Student shyam = new Student(1122, "shyam", 2);
		
		ram.getSubjects().add(hindi);
		ram.getSubjects().add(math);
		shyam.getSubjects().add(science);
		shyam.getSubjects().add(english);

		session.beginTransaction();
		session.save(hindi);
		session.save(english);
		session.save(science);
		session.save(math);
		
		session.save(shyam);
		session.save(ram);
		
		session.getTransaction().commit();

		session.close();
	}

}

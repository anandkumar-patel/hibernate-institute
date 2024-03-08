package anand.unit07.inheritance04.mappedsuperclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainMethod {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Teacher mathTeacher = new Teacher();
		mathTeacher.setName("Raman");
		mathTeacher.setAge(45);
		mathTeacher.setTeacherId("t001");
		mathTeacher.setSubject("Mathematics");
		
		Teacher scienceTeacher = new Teacher();
		scienceTeacher.setName("raghav");
		scienceTeacher.setAge(55);
		scienceTeacher.setTeacherId("t002");
		scienceTeacher.setSubject("Science");
		
		Student student1 = new Student();
		student1.setName("Ananya");
		student1.setAge(7);
		student1.setStudentId("sid01");
		student1.setBranch("science");
		
		Student student2 = new Student();
		student2.setName("Surya");
		student2.setAge(5);
		student2.setStudentId("sid02");
		student2.setBranch("mathematics");
		
		Student student3 = new Student();
		student3.setName("Banni");
		student3.setAge(37);
		student3.setStudentId("sid03");
		student3.setBranch("homescience");
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.save(mathTeacher);
		session.save(scienceTeacher);
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		session.getTransaction().commit();
		
		session.close();
		sf.close();
			
	}

}

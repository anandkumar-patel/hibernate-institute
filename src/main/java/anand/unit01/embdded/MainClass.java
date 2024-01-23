package anand.unit01.embdded;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {
    
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		User user = new User();
		user.setName("Anand");
		user.setAge(23);
		user.setSalary(34500);
		
		Address homeAddress = new Address();
		homeAddress.setHomeNo(222);
		homeAddress.setStreetName("kundaha road");
		homeAddress.setCityName("Jaunpur");
		homeAddress.setStateName("Uttar Pradesh");
		homeAddress.setPinCode(222201);
		
		Address officeAddress = new Address();
		officeAddress.setHomeNo(111);
		officeAddress.setStreetName("arekere road");
		officeAddress.setCityName("Bangalore");
		officeAddress.setStateName("Karnataka");
		officeAddress.setPinCode(560076);
		
		user.setHomeAddress(homeAddress);
		user.setOfficeAddress(officeAddress);
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
	}
	
}

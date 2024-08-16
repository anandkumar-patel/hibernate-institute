package anand.u01t05.embdded;

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
		homeAddress.setCity("Jaunpur");
		homeAddress.setState("Uttar Pradesh");
		
		Address officeAddress = new Address();
		officeAddress.setHomeNo(111);
		officeAddress.setCity("Bangalore");
		officeAddress.setState("Karnataka");
		
		user.setHomeAddress(homeAddress);
		user.setOfficeAddress(officeAddress);
				
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
	}
	
}

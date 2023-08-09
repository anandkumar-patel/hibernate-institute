package anand.unit02.collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainClass {
    
	public static void main(String[] args) {

		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
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
		
		user.getAddresses().add(homeAddress);
		user.getAddresses().add(officeAddress);
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		session.close();
		sessionFactory.close();
	}
	
}

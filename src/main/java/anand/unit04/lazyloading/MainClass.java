package anand.unit04.lazyloading;

import java.util.Collection;

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
		
		user.getAddresses().add(homeAddress);
		user.getAddresses().add(officeAddress);
		
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		System.out.println("session object closed here....");
		
		user = null;
		session = sessionFactory.openSession();
		user = (User) session.get(User.class, 1);
		//session.close();
		System.out.println("User Details {Name-" + user.getName() + ", Age-" + user.getAge() + ", salary-"
				+ user.getSalary() + "}");
		Collection<Address> addresses = user.getAddresses();
		//session.close();
		//System.out.println("Size of addresses :"+addresses.size());
		System.out.println("Address :");
		for(Address address: addresses) {
			System.out.println(address.getCityName());
		}
		session.close(); 
		sessionFactory.close();
	}
	
}

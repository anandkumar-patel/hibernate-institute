package anand.unit07.inheritance02.tableperclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MainClass {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure().buildSessionFactory();

		mappingConcepts(sessionFactory);

		sessionFactory.close();
	}

	public static void mappingConcepts(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();

		Car car = new Car();
        car.setManufacturer("Toyota");
        car.setModel("Camry");
        car.setNumDoors(4);
        car.setCarType("Sedan");

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.setManufacturer("Harley-Davidson");
        motorcycle.setModel("Sportster");
        motorcycle.setHasFairing(true);
        motorcycle.setBikeType("Cruiser");

		session.beginTransaction();

		session.save(car);
		session.save(motorcycle);

		session.getTransaction().commit();
		session.close();
	}

	public static void fetchData(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		// Retrieve instances from the database
		Vehicle retrievedCar = session.get(Car.class, 1);
		System.out.println("Retrieved Car: " + retrievedCar);

		Vehicle retrievedMotorcycle = session.get(Motorcycle.class, 2);
		System.out.println("Retrieved Motorcycle: " + retrievedMotorcycle);

		session.close();
	}
}
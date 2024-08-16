package anand.unit07.inheritance01.singletable;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure().buildSessionFactory();

		mapping(sessionFactory);
		fetch(sessionFactory);
		sessionFactory.close();
	}

	public static void mapping(SessionFactory sessionFactory) {
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

		// session.save(vehicle);
		session.save(car);
		session.save(motorcycle);

		session.getTransaction().commit();
		session.close();
	}

	public static void fetch(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		List<Vehicle> vehicles = session.createQuery("From Vehicle", Vehicle.class).getResultList();
		for (Vehicle vehicle : vehicles) {
			System.out.println("Vehicle Manufacturer: " + vehicle.getManufacturer());

			if (vehicle instanceof Car) {
				Car car = (Car) vehicle;
				System.out.println(car.toString());
				System.out.println("Manufacturer: " + car.getManufacturer() + ", Model: " + car.getModel());
			} else if (vehicle instanceof Motorcycle) {
				Motorcycle motorcycle = (Motorcycle) vehicle;
				System.out.println(motorcycle.toString());
				System.out.println("Manufacturer: " + motorcycle.getManufacturer() + ", Model: " + motorcycle.getModel());
			}

			// Access shared and subclass-specific attributes here
		}
		session.close();
	}
}
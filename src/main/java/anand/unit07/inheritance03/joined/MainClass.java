package anand.unit07.inheritance03.joined;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		mappingConcepts(sessionFactory);
		System.out.println("******* FETCHING ALL VEHICLES *******");
		fetchVehicle(sessionFactory);
		System.out.println("******* FETCHING ALL CARS *******");
		fetchCar(sessionFactory);
		System.out.println("******* FETCHING ALL MOTORCYCLES *******");
		fetchMotorcycle(sessionFactory);
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

	public static void fetchVehicle(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Vehicle> vehicles = session.createQuery("FROM Vehicle", Vehicle.class).getResultList();
		for (Vehicle vehicle : vehicles) {
			if (vehicle instanceof Car) {
				Car car = (Car) vehicle;
				System.out.println(car.toString());
				System.out.println("Manufacturer: " + car.getManufacturer() + ", Model: " + car.getModel());
			} else {
				Motorcycle motorcycle = (Motorcycle) vehicle;
				System.out.println(motorcycle.toString());
				System.out.println("Manufacturer: " + motorcycle.getManufacturer() + ", Model: " + motorcycle.getModel());

			}
		}

		session.getTransaction().commit();
	}

	public static void fetchCar(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Car> cars = session.createQuery("FROM Car", Car.class).getResultList();
		System.out.println("Cars:");
		for (Car car : cars) {
			System.out.println(car.toString());
			System.out.println("Manufacturer: " + car.getManufacturer() + ", Model: " + car.getModel());
		}
		session.getTransaction().commit();

	}

	public static void fetchMotorcycle(SessionFactory sessionFactory) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Motorcycle> motorcycles = session.createQuery("FROM Motorcycle", Motorcycle.class).getResultList();
		System.out.println("\nMotorcycles:");
		for (Motorcycle motorcycle : motorcycles) {
			System.out.println(motorcycle.toString());
			System.out.println("Manufacturer: " + motorcycle.getManufacturer() + ", Model: " + motorcycle.getModel());
		}

		session.getTransaction().commit();

	}
}
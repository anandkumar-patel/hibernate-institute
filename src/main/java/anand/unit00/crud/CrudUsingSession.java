package anand.unit00.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import anand.base.Car;

public class CrudUsingSession {

	public void create(SessionFactory sessionFactory) {
		System.out.println("Creating car records...");
		Car mustang = new Car();
		mustang.setModel("mustang");
		mustang.setPrice("40,000.00");

		Car mondeo = new Car();
		mondeo.setModel("mondeo");
		mondeo.setPrice("20,000.00");

		Car swift = new Car();
		swift.setModel("suzuki swift");
		swift.setPrice("10,000.00");

		Car beleno = new Car();
		beleno.setModel("suzuki beleno");
		beleno.setPrice("20,000.00");

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(mustang);
		session.save(mondeo);
		session.save(swift);
		session.save(beleno);
		session.getTransaction().commit();

		session.close();
	}

	public void read(SessionFactory sessionFactory, String model) {
		Session session = sessionFactory.openSession();
		Car car = session.get(Car.class, model);
		System.out.println(car.toString());
	}

	public void update(SessionFactory sessionFactory, String model) {
		Session session = sessionFactory.openSession();
		System.out.println("Updating mustang price...");
		Car mustang = (Car) session.get(Car.class, model);
		mustang.setPrice("35,250.00");

		session.beginTransaction();
		session.saveOrUpdate(mustang);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(SessionFactory sessionFactory, String model) {
		Session session = sessionFactory.openSession();
		System.out.println("Deleting mondeo record...");
		Car mondeo = (Car) session.get(Car.class, model);

		session.beginTransaction();
		session.delete(mondeo);
		session.getTransaction().commit();
		session.close();
	}
}
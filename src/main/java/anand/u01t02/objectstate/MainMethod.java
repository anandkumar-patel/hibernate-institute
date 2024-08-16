package anand.u01t02.objectstate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainMethod {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		// transient state
		Employee newEmployee = new Employee();
		newEmployee.setName("John Doe");
		newEmployee.setSalary(50000.0);

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(newEmployee); // transitions to persistent state
		Employee e2 = session.get(Employee.class, 1L);
		session.getTransaction().commit();

		session.close(); // employee object is now in detached state

		// modifying a detached entity
		newEmployee.setSalary(55000.0);

		// re-attaching the entity
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(newEmployee); // transitions back to persistent state
		session.getTransaction().commit();

		// deleted state
		session.beginTransaction();
		Employee employeeToDelete = session.get(Employee.class, 1L);
		session.delete(employeeToDelete); // transitions to deleted state
		session.getTransaction().commit();

	}

}

package anand.unit08.named;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		//DataSample.insertData(session);

		System.out.println("***** hqlNamedQuery() & hqlNamedNativeQuery() *****");
		NamedAndNamedNativeQuery namedObj = new NamedAndNamedNativeQuery();
		namedObj.hqlNamedQuery(session);
		namedObj.hqlNamedNativeQuery(session);

		session.close();
		sessionFactory.close();
	}
}

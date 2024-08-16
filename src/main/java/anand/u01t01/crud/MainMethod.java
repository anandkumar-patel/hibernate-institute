package anand.u01t01.crud;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainMethod {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
				.configure().buildSessionFactory();
		CrudUsingSession crudObj = new CrudUsingSession();
		crudObj.create(sessionFactory);
		crudObj.read(sessionFactory, "mondeo");
		crudObj.update(sessionFactory, "mustang");
		crudObj.delete(sessionFactory, "mondeo");
		
		sessionFactory.close();
	}

}

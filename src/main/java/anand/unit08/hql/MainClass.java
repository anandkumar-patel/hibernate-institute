package anand.unit08.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import anand.unit08.SampleDataEntry;

public class MainClass {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		//SampleDataEntry.insertStaff(session);

		System.out.println("***** hql queries *****");
		HqlQuery hqlQuery = new HqlQuery();
		hqlQuery.simpleHqlQuery(session);
		hqlQuery.hqlQueryWithCondition(session);
		hqlQuery.hqlQueryUniqueResult(session);
		hqlQuery.hqlQueryWithPositionalParameters(session);
		hqlQuery.hqlQueryWithNamedParameters(session);
		hqlQuery.hqlQueryWithMixedParameters01(session);
		hqlQuery.hqlQueryWithMixedParameters02(session);
		hqlQuery.hqlQueryWithLimitAndOffset(session);
		hqlQuery.hqlQueryWithSelectedColumns(session);
		hqlQuery.hqlQuerySingleResult(session);
		hqlQuery.hqlQueryUpdate(session);
		hqlQuery.hqlQueryDelete(session);

		session.close();
		sessionFactory.close();
	}
}

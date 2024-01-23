package anand.unit08.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		// DataSample.insertData(session);

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
		hqlQuery.hqlQueryUniqeResult(session);
		hqlQuery.hqlQuerySingleResult(session);
		hqlQuery.hqlQueryUpdate(session);
		hqlQuery.hqlQueryDelete(session);

		System.out.println("***** native sql queries *****");
		NativeSqlQuery nativeQuery = new NativeSqlQuery();
		nativeQuery.nativeAllColumnObjectArrayReturn(session);
		nativeQuery.nativeSelectedColumnObjectArrayReturn(session);
		nativeQuery.nativeAllColumn(session);
		nativeQuery.nativeQueryUpdate(session);
		nativeQuery.nativeQueryDelete(session);

		System.out.println("***** hqlNamedQuery() & hqlNamedNativeQuery() *****");
		NamedAndNamedNativeQuery namedObj = new NamedAndNamedNativeQuery();
		namedObj.hqlNamedQuery(session);
		namedObj.hqlNamedNativeQuery(session);

		session.close();
		sessionFactory.close();
	}
}

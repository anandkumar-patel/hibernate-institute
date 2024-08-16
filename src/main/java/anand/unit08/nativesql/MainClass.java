package anand.unit08.nativesql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import anand.unit08.SampleDataEntry;

public class MainClass {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		//SampleDataEntry.insertSimpleEntity(session);
		//SampleDataEntry.insertOne2OneEntity(session);
		//SampleDataEntry.insertOne2ManyEntity(session);
		//SampleDataEntry.insertMany2OneEntity(session);

		System.out.println("***** native sql queries *****");
		NativeSqlQuery nativeQuery = new NativeSqlQuery();
//		nativeQuery.scalarsValues1(session);
//		nativeQuery.scalarsValues2(session);
//		nativeQuery.scalarsValues3(session);
//		nativeQuery.scalarsValues4(session);
//		nativeQuery.scalarsValues5(session);
//		nativeQuery.scalarsValues6(session);
//		nativeQuery.scalarsValues7(session);
//
//		nativeQuery.nativeEntity1(session);
//		nativeQuery.nativeEntity2(session);
//		nativeQuery.nativeEntity3(session);
//		nativeQuery.nativeEntity4(session);
//		nativeQuery.nativeEntity5(session);
//		nativeQuery.nativeEntity6(session);
		
//		nativeQuery.many2one1(session);
//		nativeQuery.many2one2(session);
//		nativeQuery.many2one3(session);
//		nativeQuery.many2one4(session);
//		nativeQuery.many2one5(session);

//		nativeQuery.nativeQueryUpdate(session);
//		nativeQuery.nativeQueryDelete(session);

//		nativeQuery.check1(session);
//		nativeQuery.check2(session);
//		nativeQuery.check3(session);
		nativeQuery.check4(session);
		
		session.close();
		sessionFactory.close();
	}
}

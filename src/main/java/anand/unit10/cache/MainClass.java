package anand.unit10.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MainClass {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

//		createAlien(sessionFactory);
		firstLevelCache(sessionFactory);
		firstLevelCacheAfter(sessionFactory);
//		secondLevelCache(sessionFactory);
		sessionFactory.close();
	}

	public static void firstLevelCache(SessionFactory sf) {
		System.out.println("firstLevelCache() : begins");
		Session session = sf.openSession();
		session.beginTransaction();

		Alien alien1 = (Alien) session.get(Alien.class, 17);
		System.out.println(alien1);
		alien1.setColor("Red");
		session.update(alien1);
		session.getTransaction().commit();
		Alien alien2 = (Alien) session.get(Alien.class, 17);
		System.out.println(alien2);
		System.out.println("firstLevelCache() : end");
	}

	public static void firstLevelCacheAfter(SessionFactory sf) {
		System.out.println("firstLevelCacheAfter() : begins");
		Session session1 = sf.openSession();
		session1.beginTransaction();

		Alien alien1 = (Alien) session1.get(Alien.class, 17);
		System.out.println(alien1);

		Alien alie2 = (Alien) session1.get(Alien.class, 18);
		System.out.println(alie2);

		Alien alien3 = (Alien) session1.get(Alien.class, 17);
		System.out.println(alien3);

		session1.getTransaction().commit();
		session1.close();
		System.out.println("firstLevelCacheAfter() : session1 closed, session2 opened..");
		Session session2 = sf.openSession();
		session2.beginTransaction();
		Alien alien4 = (Alien) session2.get(Alien.class, 17);
		System.out.println(alien4);

		session2.getTransaction().commit();
		session2.close();
		System.out.println("firstLevelCacheAfter() : end");
	}

	public static void secondLevelCache(SessionFactory sf) {
		Alien alien = null;
		Session session1 = sf.openSession();
		session1.beginTransaction();

		alien = (Alien) session1.get(Alien.class, 17);
		System.out.println(alien);

		alien = (Alien) session1.get(Alien.class, 18);
		System.out.println(alien);

		alien = (Alien) session1.get(Alien.class, 17);
		System.out.println(alien);

		Query<Alien> query1 = session1.createQuery("from Alien where id =14", Alien.class);
		query1.setCacheable(true);
		alien = (Alien) query1.uniqueResult();
		System.out.println(alien);

		session1.getTransaction().commit();
		session1.close();

		Session session2 = sf.openSession();
		session2.beginTransaction();
		Query<Alien> query2 = session2.createQuery("from Alien where id =14", Alien.class);
		query2.setCacheable(true);
		alien = (Alien) query2.uniqueResult();
		System.out.println(alien);

		session2.getTransaction().commit();
		session2.close();
	}

	public static void createAlien(SessionFactory sf) {
		Alien a1 = new Alien();
		a1.setId(11);
		a1.setName("dome");
		a1.setColor("blue");

		Alien a2 = new Alien();
		a2.setId(12);
		a2.setName("duke");
		a2.setColor("red");

		Alien a3 = new Alien();
		a3.setId(13);
		a3.setName("dos");
		a3.setColor("purple");

		Alien a4 = new Alien();
		a4.setId(14);
		a4.setName("eurke");
		a4.setColor("black");

		Alien a5 = new Alien();
		a5.setId(15);
		a5.setName("drel");
		a5.setColor("red");

		Alien a6 = new Alien();
		a6.setId(16);
		a6.setName("surr");
		a6.setColor("violet");

		Alien a7 = new Alien();
		a7.setId(17);
		a7.setName("zyuy");
		a7.setColor("pink");

		Alien a8 = new Alien();
		a8.setId(18);
		a8.setName("susu");
		a8.setColor("orange");

		Session session = sf.openSession();
		session.beginTransaction();

		session.save(a1);
		session.save(a2);
		session.save(a3);
		session.save(a4);
		session.save(a5);
		session.save(a6);
		session.save(a7);
		session.save(a8);

		session.getTransaction().commit();
		session.close();
	}

}
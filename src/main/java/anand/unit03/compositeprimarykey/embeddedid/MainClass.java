package anand.unit03.compositeprimarykey.embeddedid;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MainClass {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//insertData(sf);
		
		Session session = sf.openSession();
		
		String sql = "from airport_em  where id.countryCode = ?0";
		Query<Airport> query = session.createQuery(sql, Airport.class);
		query.setParameter(0, "NP");
		List<Airport> airports = query.list();
		for(Airport airport : airports) {
			System.out.println(airport);
		}

		session.close();
		sf.close();
	}
	
	public static void insertData(SessionFactory sf) {
		Airport airport1 = new Airport();
		airport1.setId(new AirportId("IN", "BLR"));
		airport1.setName("Kempegowda International Airport");
		
		Airport airport2 = new Airport();
		airport2.setId(new AirportId("IN", "HYD"));
		airport2.setName("RajivGandhi International Airport");
		
		Airport airport3 = new Airport();
		airport3.setId(new AirportId("NP", "KTM"));
		airport3.setName("Tribhuvan International Airport");
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(airport1);
		session.save(airport2);
		session.save(airport3);
		session.getTransaction().commit();
		session.close();
		
	}

}

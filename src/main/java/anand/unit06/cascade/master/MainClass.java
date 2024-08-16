package anand.unit06.cascade.master;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import anand.unit06.cascade01.one2one.Post;
import anand.unit06.cascade01.one2one.PostDetails;

public class MainClass {

	    private static SessionFactory sessionFactory;

	    static {
	        sessionFactory = new Configuration().configure().buildSessionFactory();
	    }

	    public void insertMasterData() {
	        Session session = sessionFactory.openSession();
	        Transaction transaction = null;

	        try {
	            transaction = session.beginTransaction();

	            // Create and persist Country
	            CountryMaster country = new CountryMaster();
	            country.setName("India");
	            session.save(country);

	            // Create and persist State
	            StateMaster state1 = new StateMaster();
	            state1.setName("State 1");
	            state1.setCountry(country);
	            session.save(state1);

	            StateMaster state2 = new StateMaster();
	            state2.setName("State 2");
	            state2.setCountry(country);
	            session.save(state2);

	            // Create and persist City
	            CityMaster city1 = new CityMaster();
	            city1.setName("City 1");
	            city1.setState(state1);
	            session.save(city1);

	            CityMaster city2 = new CityMaster();
	            city2.setName("City 2");
	            city2.setState(state1);
	            session.save(city2);

	            CityMaster city3 = new CityMaster();
	            city3.setName("City 3");
	            city3.setState(state2);
	            session.save(city3);

	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }

		public static void main(String[] args) {
			MainClass service = new MainClass();
			// service.insertMasterData();
			// service.fethState();
		}

		private void fethState() {
			Session session = sessionFactory.openSession();
			StateMaster state = session.get(StateMaster.class, 1L);
			
			System.out.println(state);
			System.out.println(state.getCountry());
			
			System.out.println(state.getCities());
		}
		
	}

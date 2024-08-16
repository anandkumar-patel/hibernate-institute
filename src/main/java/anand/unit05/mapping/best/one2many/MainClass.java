package anand.unit05.mapping.best.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class MainClass {

	    private static SessionFactory sessionFactory;

	    static {
	        sessionFactory = new Configuration().configure().buildSessionFactory();
	    }

	    public static void main(String[] args) {
	        MainClass service = new MainClass();
	        
	        service.persistPost();
	        //service.mergePost();
	        //service.deletePost();
	        service.deletePostDetails();    }
		
		private void persistPost() {
			Session session = sessionFactory.openSession();
			Post post = new Post().setTitle("hibernate in depth..")
					.addComment(new PostComment().setReview("must read book"))
					.addComment(new PostComment().setReview("best book"));
					
			session.beginTransaction();
			session.persist(post);
			session.getTransaction().commit();
			session.close();
			
		}
		
		private void mergePost() {
			Session session = sessionFactory.openSession();
			Post post = session.get(Post.class, 1L);
			
			
			session.beginTransaction();
			session.merge(post);
			session.getTransaction().commit();
			session.close();
			
		}
		
		private void deletePost() {
			Session session = sessionFactory.openSession();
			Post post = session.get(Post.class, 1L);
			
			session.beginTransaction();
			session.delete(post);
			session.getTransaction().commit();
			session.close();
			
		}
		
		private void deletePostDetails() {
			
		}
	}

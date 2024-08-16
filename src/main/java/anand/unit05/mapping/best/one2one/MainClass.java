package anand.unit05.mapping.best.one2one;

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
		service.fetchPost();
		// service.mergePost();
		// service.deletePost();
		//service.deletePostDetails();
	}

	private void persistPost() {
		Session session = sessionFactory.openSession();
		Post post1 = new Post();
		post1.setTitle("Spring master class");
		Post post2 = new Post();
		post2.setTitle("Hibernate master class");

		PostDetails details1 = new PostDetails("anand");
		PostDetails details2 = new PostDetails("shyam");
		
		post1.setDetails(details1);
		post2.setDetails(details2);
		
		session.beginTransaction();
		session.persist(post1);
		session.persist(post2);
		session.getTransaction().commit();
		session.close();

	}

	private void mergePost() {
		Session session = sessionFactory.openSession();
		Post post = session.get(Post.class, 1L);

		PostDetails details = post.getDetails();

		session.beginTransaction();
		session.merge(post);
		session.getTransaction().commit();
		session.close();

	}
	
	private void fetchPost() {
		Session session = sessionFactory.openSession();
		Post post = session.get(Post.class, 1L);
		System.out.println(post.getTitle());
		//System.out.println(post.getDetails().getCreatedBy());
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
		Session session = sessionFactory.openSession();
		Post post = session.get(Post.class, 2L);
		post.removeDetails();
		session.close();

	}
}

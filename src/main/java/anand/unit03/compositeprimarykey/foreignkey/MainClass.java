package anand.unit03.compositeprimarykey.foreignkey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// explore it
public class MainClass {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		insertData(sf);
		
		Session session = sf.openSession();
		
		
		session.close();
		sf.close();
	}
	
	public static void insertData(SessionFactory sf) {
		Session session = sf.openSession();
		session.beginTransaction();
		Product product1 = new Product();
		product1.setName("iPhone 15");
		product1.setPrice(1199);
		
		Product product2 = new Product();
		product2.setName("iPhone 15");
		product2.setPrice(1199);
		
		session.save(product1);
		//session.save(product2);
		
		Order order = new Order();
		order.setCustomerName("anand patel");
		order.setStatus("In Progress");
		
		session.save(order);
		
		OrderDetail orderDetail = new OrderDetail();
		
		OrderDetailID orderDetailId = new OrderDetailID();
		orderDetailId.setOrder(order);
		orderDetailId.setProduct(product1);
		
		orderDetail.setId(orderDetailId);
		orderDetail.setQuantity(2);
		orderDetail.setUnitPrice(1199);
		orderDetail.setSubtotal(2398);
		
		session.save(orderDetailId);
		session.getTransaction().commit();
		session.close();
	}

}

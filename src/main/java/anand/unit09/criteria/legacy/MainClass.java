package anand.unit09.criteria.legacy;

import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainClass {
	
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		//insertStaff(session);
		CriteriaMethods cri = new CriteriaMethods();
		//cri.method1(session);
		
		ProjectionMethods proj = new ProjectionMethods();
//		proj.property(session);
//		proj.min(session);
//		proj.rowCount(session);
//		proj.groupProperty(session);
//		proj.alias(session);
		proj.distinct(session);
		
		session.close();
		sessionFactory.close();
	}
	
	public static void insertStaff(Session session) {

		session.beginTransaction();

		Staff staff1 = new Staff();
		staff1.setStaffId(21);
		staff1.setStaffName("jaynat");
		staff1.setStaffDept("support");
		staff1.setSalary(BigDecimal.valueOf(2000.00));
		staff1.setBonus(BigDecimal.valueOf(1300));

		Staff staff2 = new Staff();
		staff2.setStaffId(22);
		staff2.setStaffName("ravindra");
		staff2.setStaffDept("eng");
		staff2.setSalary(BigDecimal.valueOf(3000.00));
		staff2.setBonus(BigDecimal.valueOf(300));

		Staff staff3 = new Staff();
		staff3.setStaffId(23);
		staff3.setStaffName("rajit");
		staff3.setStaffDept("advocate");
		staff3.setSalary(BigDecimal.valueOf(5000.00));
		staff3.setBonus(BigDecimal.valueOf(500));

		Staff staff4 = new Staff();
		staff4.setStaffId(24);
		staff4.setStaffName("rajan");
		staff4.setStaffDept("qa");
		staff4.setSalary(BigDecimal.valueOf(6500.00));
		staff4.setBonus(BigDecimal.valueOf(600));

		Staff staff5 = new Staff();
		staff5.setStaffId(25);
		staff5.setStaffName("sanjay");
		staff5.setStaffDept("advocate");
		staff5.setSalary(BigDecimal.valueOf(7000.00));
		staff5.setBonus(BigDecimal.valueOf(700));

		Staff staff6 = new Staff();
		staff6.setStaffId(26);
		staff6.setStaffName("vijay");
		staff6.setStaffDept("support");
		staff6.setSalary(BigDecimal.valueOf(6900.00));
		staff6.setBonus(BigDecimal.valueOf(600));

		Staff staff7 = new Staff();
		staff7.setStaffId(27);
		staff7.setStaffName("sebu");
		staff7.setStaffDept("support");
		staff7.setSalary(BigDecimal.valueOf(6500.00));
		staff7.setBonus(BigDecimal.valueOf(600));

		session.save(staff1);
		session.save(staff2);
		session.save(staff3);
		session.save(staff4);
		session.save(staff5);
		session.save(staff6);
		session.save(staff7);

		session.getTransaction().commit();
	}
}

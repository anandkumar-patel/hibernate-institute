package anand.unit08.hql;

import java.math.BigDecimal;

import org.hibernate.Session;

import anand.base.Staff;

public class DataSample {
	
	public static void insertData(Session session) {
		System.out.println("***** insertData() *****");
		
		session.beginTransaction();

		Staff staff1 = new Staff();
		staff1.setStaffId(21);
		staff1.setStaffName("Jaynat");
		staff1.setStaffDept("Mantainin");
		staff1.setSalary(BigDecimal.valueOf(2000.00));

		Staff staff2 = new Staff();
		staff2.setStaffId(22);
		staff2.setStaffName("Ravindra");
		staff2.setStaffDept("cleaning");
		staff2.setSalary(BigDecimal.valueOf(3000.00));

		Staff staff3 = new Staff();
		staff3.setStaffId(23);
		staff3.setStaffName("Rajit");
		staff3.setStaffDept("advocate");
		staff3.setSalary(BigDecimal.valueOf(5000.00));

		Staff staff4 = new Staff();
		staff4.setStaffId(24);
		staff4.setStaffName("Rajan");
		staff4.setStaffDept("maintain");
		staff4.setSalary(BigDecimal.valueOf(6500.00));

		Staff staff5 = new Staff();
		staff5.setStaffId(25);
		staff5.setStaffName("Sanjay");
		staff5.setStaffDept("advocate");
		staff5.setSalary(BigDecimal.valueOf(7000.00));

		session.save(staff1);
		session.save(staff2);
		session.save(staff3);
		session.save(staff4);
		session.save(staff5);

		session.getTransaction().commit();
	}

}

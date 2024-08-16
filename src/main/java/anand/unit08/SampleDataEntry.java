package anand.unit08;

import java.math.BigDecimal;

import org.hibernate.Session;

import anand.unit08.entity.Many2OneChildEntity;
import anand.unit08.entity.Many2OneParentEntity;
import anand.unit08.entity.One2ManyChildEntity;
import anand.unit08.entity.One2ManyParentEntity;
import anand.unit08.entity.One2OneChildEntity;
import anand.unit08.entity.One2OneParentEntity;
import anand.unit08.entity.SimpleEntity;

public class SampleDataEntry {

	public static void insertSimpleEntity(Session session) {
		SimpleEntity se1 = new SimpleEntity();
		se1.setId(1);
		se1.setName("entity01");
		se1.setComment("entity01 comment");

		SimpleEntity se2 = new SimpleEntity();
		se2.setId(2);
		se2.setName("entity02");
		se2.setComment("entity02 comment");

		SimpleEntity se3 = new SimpleEntity();
		se3.setId(3);
		se3.setName("entity03");
		se3.setComment("entity03 comment");

		SimpleEntity se4 = new SimpleEntity();
		se4.setId(4);
		se4.setName("entity04");
		se4.setComment("entity04 comment");

		session.beginTransaction();
		session.save(se1);
		session.save(se2);
		session.save(se3);
		session.save(se4);
		session.getTransaction().commit();

	}

	public static void insertOne2OneEntity(Session session) {
		System.out.println("*** in insertOne2OneEntity() method ***");
		One2OneChildEntity ch1 = new One2OneChildEntity();
		ch1.setChildId(1);
		ch1.setChildName("child1 name");
		ch1.setComment("child1 comment");
		One2OneChildEntity ch2 = new One2OneChildEntity();
		ch2.setChildId(2);
		ch2.setChildName("child2 name");
		ch2.setComment("child2 comment");
		One2OneChildEntity ch3 = new One2OneChildEntity();
		ch3.setChildId(3);
		ch3.setChildName("child3 name");
		ch3.setComment("child3 comment");
		
		One2OneParentEntity p1 = new One2OneParentEntity();
		p1.setParentId(1);
		p1.setParentName("parent1 name");
		p1.setComment("parent1 comment");
		p1.setChild(ch1);
		
		One2OneParentEntity p2 = new One2OneParentEntity();
		p2.setParentId(2);
		p2.setParentName("parent2 name");
		p2.setComment("parent2 comment");
		p2.setChild(ch2);
		
		One2OneParentEntity p3 = new One2OneParentEntity();
		p3.setParentId(3);
		p3.setParentName("parent3 name");
		p3.setComment("parent3 comment");
		p3.setChild(ch3);
		
		session.beginTransaction();
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(ch1);
		session.save(ch2);
		session.save(ch3);
		session.getTransaction().commit();
	
	}

	public static void insertOne2ManyEntity(Session session) {

		System.out.println("*** in insertOne2ManyEntity() method ***");
		One2ManyChildEntity ch1 = new One2ManyChildEntity();
		ch1.setChildId(1);
		ch1.setChildName("child1 name");
		ch1.setComment("child1 comment");
		
		One2ManyChildEntity ch2 = new One2ManyChildEntity();
		ch2.setChildId(2);
		ch2.setChildName("child2 name");
		ch2.setComment("child2 comment");
		
		One2ManyChildEntity ch3 = new One2ManyChildEntity();
		ch3.setChildId(3);
		ch3.setChildName("child3 name");
		ch3.setComment("child3 comment");
		
		One2ManyChildEntity ch4 = new One2ManyChildEntity();
		ch4.setChildId(4);
		ch4.setChildName("child4 name");
		ch4.setComment("child4 comment");
		
		One2ManyChildEntity ch5 = new One2ManyChildEntity();
		ch5.setChildId(5);
		ch5.setChildName("child5 name");
		ch5.setComment("child5 comment");
		
		One2ManyChildEntity ch6 = new One2ManyChildEntity();
		ch6.setChildId(6);
		ch6.setChildName("child6 name");
		ch6.setComment("child6 comment");
		
		One2ManyParentEntity p1 = new One2ManyParentEntity();
		p1.setParentId(1);
		p1.setParentName("parent1 name");
		p1.setComment("parent1 comment");
		p1.getChild().add(ch1);
		p1.getChild().add(ch4);
		
		One2ManyParentEntity p2 = new One2ManyParentEntity();
		p2.setParentId(2);
		p2.setParentName("parent2 name");
		p2.setComment("parent2 comment");
		p2.getChild().add(ch2);
		p2.getChild().add(ch5);
		
		One2ManyParentEntity p3 = new One2ManyParentEntity();
		p3.setParentId(3);
		p3.setParentName("parent3 name");
		p3.setComment("parent3 comment");
		p3.getChild().add(ch3);
		p3.getChild().add(ch6);
		
		session.beginTransaction();
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(ch1);
		session.save(ch2);
		session.save(ch3);
		session.save(ch4);
		session.save(ch5);
		session.save(ch6);
		session.getTransaction().commit();
	}

	public static void insertMany2OneEntity(Session session) {
		System.out.println("*** in insertOne2ManyEntity() method ***");
		
		Many2OneChildEntity ch1 = new Many2OneChildEntity();
		ch1.setChildId(1);
		ch1.setChildName("child1 name");
		ch1.setComment("child1 comment");
		
		
		Many2OneParentEntity p1 = new Many2OneParentEntity();
		p1.setParentId(1);
		p1.setParentName("parent1 name");
		p1.setComment("parent1 comment");
		p1.setChild(ch1);

		Many2OneParentEntity p2 = new Many2OneParentEntity();
		p2.setParentId(2);
		p2.setParentName("parent2 name");
		p2.setComment("parent2 comment");
		p2.setChild(ch1);

		Many2OneParentEntity p3 = new Many2OneParentEntity();
		p3.setParentId(3);
		p3.setParentName("parent3 name");
		p3.setComment("parent3 comment");
		p3.setChild(ch1);
		
		session.beginTransaction();
		session.save(ch1);
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.getTransaction().commit();

	}

	public static void insertMany2ManyEntity(Session session) {

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

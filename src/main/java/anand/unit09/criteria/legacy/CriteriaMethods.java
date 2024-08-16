package anand.unit09.criteria.legacy;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;


public class CriteriaMethods {
	
	public void method1(Session session) {
		Criteria criteria = session.createCriteria(Staff.class);
		// fetch all staff where staffName is Sanjay and staffId 25
		criteria.add(Restrictions.eq("staffName", "Sanjay")).add(Restrictions.eq("staffId", 24));
		
		// fetch all staff where staffName is Sanjay or staffId 24 and order the result by salary descending
		//criteria.add(Restrictions.or(Restrictions.eq("staffName", "Sanjay"),Restrictions.eq("staffId", 24))).addOrder(Order.desc("salary"));
		
		//
		Staff exampleStaff = new Staff();
		
		Example obj = Example.create(exampleStaff);

		
		List<Staff> staffs = criteria.list();
		for(Staff staff : staffs) {
			System.out.println(staff);
		}
		
	}

}

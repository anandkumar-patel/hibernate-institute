package anand.unit09.criteria.legacy;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class ProjectionMethods {

	public void property(Session session) {
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.setProjection(Projections.property("staffDept"));
		List<String> depts = criteria.list();
		System.out.println("All departments :");
		for (String dept : depts) {
			System.out.println(dept);
		}

	}

	public void min(Session session) {
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.setProjection(Projections.min("salary"));
		BigDecimal minSalary = (BigDecimal) criteria.uniqueResult();
		System.out.println("Min Salary :" + minSalary);

	}

	public void rowCount(Session session) {
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.setProjection(Projections.rowCount());
		Long rowCount = (Long) criteria.uniqueResult();
		System.out.println("Row count :" + rowCount);

	}

	// conjunction with aggregate functions like count, sum, avg.
	// and use of Projections.projectionList()
	public void groupProperty(Session session) {
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("staffDept"))
				.add(Projections.avg("salary")));
		List<Object[]> results = criteria.list();
		for (Object[] result : results) {
			String department = (String) result[0];
			Double avgSalary = (Double) result[1];
			System.out.println("Department: " + department + ", Average Salary: " + avgSalary);
		}
	}

	public void alias(Session session) {
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.setProjection(
				Projections.projectionList().add(Projections.groupProperty("staffDept").as("departmentAlias"))
						.add(Projections.avg("salary").as("averageSalary")));

		List<Object[]> results = criteria.list();
		for (Object[] result : results) {
			String department = (String) result[0];
			Double avgSalary = (Double) result[1];
			System.out.println("Department: " + department + ", Average Salary: " + avgSalary);
		}
	}

	public void distinct(Session session) {
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.setProjection(Projections.distinct(Projections.property("staffDept")));

		List<String> depts = criteria.list();
		System.out.println("Department");
		for (String dept : depts) {
			System.out.println(dept);
		}
	}
	
	public void distinct1(Session session) {
		Criteria criteria = session.createCriteria(Staff.class);
		//criteria.setProjection(Projections.sqlProjection(sql, columnAliases, types));

		List<String> depts = criteria.list();
		for (String dept : depts) {
			System.out.println("Department: " + dept);
		}
	}
}

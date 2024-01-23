package anand.unit08.hql;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import anand.base.Staff;

public class HqlQuery {

	public void simpleHqlQuery(Session session) {
		System.out.println("HqlQuery : ***** simpleHqlQuery() *****");
		Query<Staff> query = session.createQuery("from Staff", Staff.class);
		List<Staff> staffs = query.list();
		for (Staff staff : staffs) {
			System.out.println(staff);
		}
	}

	public void hqlQueryWithCondition(Session session) {
		System.out.println("HqlQuery : ***** hqlQueryWithCondition() *****");
		Query<Staff> query = session.createQuery("from Staff where staffId >22", Staff.class);
		List<Staff> staffs = query.list();
		for (Staff staff : staffs) {
			System.out.println(staff);
		}
	}

	public void hqlQueryUniqueResult(Session session) {
		System.out.println("HqlQuery : ***** hqlQueryUniqueResult() *****");
		Query<Staff> query = session.createQuery("from Staff where staffName = 'Ravindra'", Staff.class);
		Staff staff = query.uniqueResult();
		System.out.println(staff);
	}

	public void hqlQueryWithPositionalParameters(Session session) {
		System.out.println("HqlQuery : ***** hqlQueryWithPositionalParameters() *****");

		Query<Staff> query = session.createQuery("from Staff where staffId >?0  and staffName = ?1", Staff.class);
		query.setParameter(0, 22);
		query.setParameter(1, "Rajan");

		List<Staff> staffs = query.getResultList();
		for (Staff staff : staffs) {
			System.out.println(staff);
		}
	}

	public void hqlQueryWithNamedParameters(Session session) {
		System.out.println("HqlQuery : ***** hqlQueryWithNamedParameters() *****");
		Query<Staff> query = session.createQuery("from Staff where staffId >:sid  and staffName = :name", Staff.class);
		query.setParameter("sid", 22);
		query.setParameter("name", "Rajan");

		List<Staff> staffs = query.getResultList();
		for (Staff staff : staffs) {
			System.out.println(staff);
		}
	}

	public void hqlQueryWithMixedParameters01(Session session) {
		System.out.println("HqlQuery : ***** hqlQueryWithMixedParameters01() *****");
		Query<Staff> query = session.createQuery("from Staff where staffId >?0  and staffName = :name", Staff.class);
		query.setParameter(0, 22);
		query.setParameter("name", "Rajan");
		List<Staff> staffs = query.getResultList();
		for (Staff staff : staffs) {
			System.out.println(staff);
		}
	}

	public void hqlQueryWithMixedParameters02(Session session) {
		System.out.println("HqlQuery : ***** hqlQueryWithMixedParameters02() *****");
		Query<Staff> query = session.createQuery("from Staff where staffId >:sid  and staffName = ?0", Staff.class);
		query.setParameter("sid", 22);
		query.setParameter(0, "Rajan");

		List<Staff> staffs = query.getResultList();
		for (Staff staff : staffs) {
			System.out.println(staff);
		}
	}

	// fetch all staff from row next to 2 and it will list 3 record only
	public void hqlQueryWithLimitAndOffset(Session session) {
		System.out.println("HqlQuery : ***** hqlQueryWithLimitAndOffset() *****");
		Query<Staff> query = session.createQuery("from Staff", Staff.class);
		query.setFirstResult(2);
		query.setMaxResults(3);

		List<Staff> staffs = query.list();
		for (Staff staff : staffs) {
			System.out.println(staff);
		}
	}

	public void hqlQueryWithSelectedColumns(Session session) {
		System.out.println("HqlQuery : ***** hqlQueryWithSelectedColumns() *****");

		Query<Object[]> query = session.createQuery("select staffId, staffName from Staff where staffId >?0",
				Object[].class);
		query.setParameter(0, 22);
		List<Object[]> staffs = query.list();
		for (Object[] staffObj : staffs) {
			System.out.println(staffObj[0] + " : " + staffObj[1]);
		}
	}

	public void hqlQueryUniqeResult(Session session) {
		System.out.println("HqlQuery : ***** hqlQueryUniqeResult() *****");
		Query<BigDecimal> query = session.createQuery("select sum(salary) from Staff where staffId > ?0",
				BigDecimal.class);
		query.setParameter(0, 22);
		BigDecimal sumSal = query.uniqueResult();
		System.out.println("Sum of Salary :" + sumSal);

	}

	public void hqlQuerySingleResult(Session session) {
		System.out.println("HqlQuery : ***** hqlQuerySingleResult() *****");
		Query<BigDecimal> query = session.createQuery("select sum(salary) from Staff where staffId > ?0",
				BigDecimal.class);
		query.setParameter(0, 22);
		BigDecimal sumSal = query.getSingleResult();
		System.out.println("Sum of Salary :" + sumSal);

	}

	public void hqlQueryUpdate(Session session) {
		session.beginTransaction();
		System.out.println("HqlQuery : ***** hqlQueryUpdate() *****");
		Query query = session.createQuery("update Staff set staffDept =:dept where staffId =:staffId");
		query.setParameter("dept", "updated dept");
		query.setParameter("staffId", 22);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		session.getTransaction().commit();
	}
	
	public void hqlQueryDelete(Session session) {
		session.beginTransaction();
		System.out.println("HqlQuery : ***** hqlQueryDelete() *****");
		Query query = session.createQuery("delete from Staff where staffId =:staffId");
		query.setParameter("staffId", 22);
		int rowCount = query.executeUpdate();
		System.out.println("Rows deleted: " + rowCount);
		session.getTransaction().commit();
	}

}

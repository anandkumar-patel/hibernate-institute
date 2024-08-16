package anand.unit08.named;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import anand.unit08.Staff;

public class NamedAndNamedNativeQuery {

	public void hqlNamedQuery(Session session) {
		System.out.println("NamedAndNamedNativeQuery : ***** hqlNamedQuery() *****");
		Query<Staff> query = session.createNamedQuery("Staff.byName", Staff.class);
		query.setParameter(1, "Rajan");

		List<Staff> staffs = query.getResultList();
		for (Staff staff : staffs) {
			System.out.println(staff);
		}
	}

	public void hqlNamedNativeQuery(Session session) {
		System.out.println("NamedAndNamedNativeQuery : ***** hqlNamedNativeQuery() *****");
		@SuppressWarnings("unchecked")
		NativeQuery<Staff> query = session.getNamedNativeQuery("Staff.byId");
		query.setParameter("staffId", 24);

		List<Staff> staffs = query.getResultList();
		for (Staff staff : staffs) {
			System.out.println(staff);
		}
	}

}

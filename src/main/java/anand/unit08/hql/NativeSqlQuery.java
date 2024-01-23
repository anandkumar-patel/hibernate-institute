package anand.unit08.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import anand.base.Staff;

public class NativeSqlQuery {
	// here order of column will be based on the table.
	public void nativeAllColumnObjectArrayReturn(Session session) {
		System.out.println("NativeSqlQuery : ***** nativeAllColumn() *****");
		NativeQuery <Object[]>query = session.createNativeQuery("select * from staff_table");
		List<Object[]> staffs = query.getResultList();
		System.out.println("Staff Id , staff_name, staff_dept");
		for (Object[] staff : staffs) {
			System.out.println(staff[0]+", "+staff[1]+", "+staff[2]);
		}
	}
	
	public void nativeSelectedColumnObjectArrayReturn(Session session) {
		System.out.println("NativeSqlQuery : ***** nativeAllColumn() *****");
		NativeQuery <Object[]>query = session.createNativeQuery("select staff_name, staff_dept from staff_table");
		List<Object[]> staffs = query.getResultList();
		System.out.println("staff_name, staff_dept");
		for (Object[] staff : staffs) {
			System.out.println(staff[0]+", "+staff[1]);
		}
	}
	
	public void nativeAllColumn(Session session) {
		System.out.println("NativeSqlQuery : ***** nativeAllColumn() *****");
		NativeQuery <Staff>query = session.createNativeQuery("select * from staff_table", Staff.class);
		List<Staff> staffs = query.getResultList();
		for (Staff staff : staffs) {
			System.out.println(staff);
		}
	}
	
	public void nativeQueryUpdate(Session session) {
		System.out.println("NativeSqlQuery : ***** nativeQueryUpdate() *****");
		session.beginTransaction();
		NativeQuery query = session.createNativeQuery("update staff_table set salary = :sal where staff_id =:id");
		query.setParameter("sal", 20000);
		query.setParameter("id", 23);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		session.getTransaction().commit();
	}
	
	public void nativeQueryDelete(Session session) {
		session.beginTransaction();
		System.out.println("HqlQuery : ***** nativeQueryDelete() *****");
		Query query = session.createNativeQuery("delete from staff_table where staff_id =:staffId");
		query.setParameter("staffId", 23);
		int rowCount = query.executeUpdate();
		System.out.println("Rows deleted: " + rowCount);
		session.getTransaction().commit();
	}
}

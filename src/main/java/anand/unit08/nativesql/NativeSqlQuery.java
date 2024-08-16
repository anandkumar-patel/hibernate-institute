package anand.unit08.nativesql;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

import anand.unit05.mapping01.one2one.case03.Laptop;
import anand.unit05.mapping01.one2one.case03.Student;
import anand.unit08.entity.EntityDto;
import anand.unit08.entity.Many2OneChildEntity;
import anand.unit08.entity.Many2OneParentEntity;
import anand.unit08.entity.One2ManyChildEntity;
import anand.unit08.entity.One2ManyParentEntity;
import anand.unit08.entity.One2OneChildEntity;
import anand.unit08.entity.One2OneChildEntity1;
import anand.unit08.entity.One2OneParentEntity;
import anand.unit08.entity.One2OneParentEntity1;
import anand.unit08.entity.SimpleEntity;

public class NativeSqlQuery {

	// order of column will be same as in database
	// hibernate will use ResultSetMetadata to deduce the actual order and types.
	// list of scalars (column) values
	public void scalarsValues1(Session session) {
		System.out.println("NativeSqlQuery : ***** scalarsValues1() *****");
		NativeQuery query = session.createNativeQuery("select * from simple_entity");
		List<Object[]> rowList = query.list();
		System.out.println("entity details");
		for (Object[] row : rowList) {
			System.out.println(row[0] + ", " + row[1] + ", " + row[2]);
		}
	}

	// here provided all columns for maintaining the order
	// we can provide only few column too.
	public void scalarsValues2(Session session) {
		System.out.println("NativeSqlQuery : ***** scalarsValues2() *****");
		NativeQuery query = session.createNativeQuery("select id, name, comment from simple_entity");
		List<Object[]> rowList = query.list();
		System.out.println("entity details");
		for (Object[] row : rowList) {
			System.out.println(row[0] + ", " + row[1] + ", " + row[2]);
		}
	}

	// native query with explicit result set selection
	public void scalarsValues3(Session session) {
		System.out.println("NativeSqlQuery : ***** scalarsValues3() *****");
		NativeQuery query = session.createNativeQuery("select * from simple_entity");
		query.addScalar("name", StringType.INSTANCE);
		query.addScalar("id"); // hibernate will attempt to automatically detect the underlying type
		List<Object[]> rowList = query.list();
		System.out.println("name, id");
		for (Object[] row : rowList) {
			System.out.println(row[0] + ", " + row[1]);
		}
	}

	// one2one join scalar
	public void scalarsValues4(Session session) {
		System.out.println("NativeSqlQuery : ***** scalarsValues4() *****");
		NativeQuery query = session.createNativeQuery("select * from one2one_pentity where p_id > ?");
		query.setParameter(1, 2);
		List<Object[]> rowList = query.list();
		System.out.println("entity details");
		for (Object[] row : rowList) {
			System.out.println(row[0] + ":" + row[1] + ":" + row[2] + ":" + row[3]);
		}
	}

	// one2one join scalar
	public void scalarsValues5(Session session) {
		System.out.println("NativeSqlQuery : ***** scalarsValues5() *****");
		NativeQuery query = session.createNativeQuery(
				"select * from one2one_pentity p join one2one_centity c on p.p_id = c.c_id where p_id > ?");
		query.setParameter(1, 2);
		List<Object[]> rowList = query.list();
		System.out.println("entity details");
		for (Object[] row : rowList) {
			System.out.println(
					row[0] + ":" + row[1] + ":" + row[2] + ":" + row[3] + ":" + row[4] + ":" + row[5] + ":" + row[6]);
		}
	}

	// one2one join scalar with selected column
	public void scalarsValues6(Session session) {
		System.out.println("NativeSqlQuery : ***** scalarsValues6() *****");
		NativeQuery query = session.createNativeQuery(
				"select * from one2one_pentity p join one2one_centity c on p.child_id = c.c_id where p_id > ?");
		query.setParameter(1, 2);
		query.addScalar("p_id", IntegerType.INSTANCE);
		query.addScalar("p_name", StringType.INSTANCE);
		query.addScalar("childname", StringType.INSTANCE);
		query.addScalar("c_comment", StringType.INSTANCE);
		List<Object[]> rowList = query.list();
		System.out.println("student details");
		for (Object[] row : rowList) {
			System.out.println(row[0] + ":" + row[1] + ":" + row[2] + ":" + row[3]);
		}
	}

	// one2many join scalar
	public void scalarsValues7(Session session) {
		System.out.println("NativeSqlQuery : ***** scalarsValues7() *****");
		NativeQuery query = session.createNativeQuery(
				"select * from one2many_pentity p join one2many_centity c on p.p_id = c.parent_id where p_id > ?");
		query.setParameter(1, 2);
		List<Object[]> rowList = query.list();
		System.out.println("entity details");
		for (Object[] row : rowList) {
			System.out.println(
					row[0] + ":" + row[1] + ":" + row[2] + ":" + row[3] + ":" + row[4] + ":" + row[5] + ":" + row[6]);
		}
	}

	// returning as list of entity by createNativeQuery() 2 param
	public void nativeEntity1(Session session) {
		System.out.println("NativeSqlQuery : ***** nativeEntity1() *****");
		NativeQuery<SimpleEntity> query = session.createNativeQuery("select * from simple_entity", SimpleEntity.class);
		List<SimpleEntity> list = query.list();
		System.out.println("staff details");
		for (SimpleEntity en : list) {
			System.out.println(en);
		}
	}


//  returning as list of Staff entity by createNativeQuery() 1 param and addEntity
	public void nativeEntity2(Session session) {
		System.out.println("NativeSqlQuery : ***** nativeEntity2() *****");
		NativeQuery query = session.createNativeQuery("select * from simple_entity");
		query.addEntity(SimpleEntity.class);
		// or query.addEntity("anand.unit08.Staff");
		List<SimpleEntity> list = query.list();
		System.out.println("staff details");
		for (SimpleEntity en : list) {
			System.out.println(en);
		}
	}

	// here provided all columns
	public void nativeEntity3(Session session) {
		System.out.println("NativeSqlQuery : ***** nativeEntity3() *****");
		NativeQuery query = session.createNativeQuery("select id, comment, name from  simple_entity");
		query.addEntity(SimpleEntity.class);
		List<SimpleEntity> list = query.list();
		System.out.println("entity details");
		for (SimpleEntity en : list) {
			System.out.println(en);
		}
	}

	// one2one mapped parent entity
	//here fetch type will determine when child entity query will execute
	public void nativeEntity4(Session session) {
		System.out.println("NativeSqlQuery : ***** nativeEntity4() *****");
		NativeQuery query = session.createNativeQuery("select * from one2one_pentity where p_id >= ?");
		query.setParameter(1, 2);
		query.addEntity(One2OneParentEntity.class);
		List<One2OneParentEntity> list = query.list();
		System.out.println("Student details");
		for (One2OneParentEntity entity : list) {
			System.out.println(entity);
			One2OneChildEntity child = entity.getChild();
			System.out.println(child);
		}
	}

	// one2many mapped parent entity
	public void nativeEntity5(Session session) {
		System.out.println("NativeSqlQuery : ***** nativeEntity5() *****");
		NativeQuery query = session.createNativeQuery("select * from one2many_pentity where p_id > ?");
		query.setParameter(1, 2);
		query.addEntity(One2ManyParentEntity.class);
		List<One2ManyParentEntity> list = query.list();
		System.out.println("Student details");
		for (One2ManyParentEntity entity : list) {
			System.out.println(entity);
			List<One2ManyChildEntity> children = entity.getChild();
			for (One2ManyChildEntity child : children) {
				System.out.println(child);
			}
		}
	}

	// student mapped to laptop but throwing error
	public void nativeEntity6(Session session) {
		System.out.println("NativeSqlQuery : ***** nativeEntity6() *****");
		NativeQuery query = session.createNativeQuery("select * from student03");
		query.addEntity("student", Student.class).addJoin("lp", "student.laptop");
		List<Student> students = query.list();
		System.out.println("Student details");
		for (Student st : students) {
			System.out.println("Student : " + st.toString());
		}
	}

	// joined- one2one both student and laptop table
	public void nativeEntity7(Session session) {
		System.out.println("NativeSqlQuery : ***** nativeEntity7() *****");
		NativeQuery query = session
				.createNativeQuery("select * from student03 st join laptop03 lp on st.laptop_id = lp.lapid");
		query.addEntity("student", Student.class).addJoin("lp", "student.laptop");

		List<Object[]> tuples = query.list();
		System.out.println("Student details");
		for (Object[] data : tuples) {
			Student st = (Student) data[0];
			Laptop lp = (Laptop) data[1];
			System.out.println(st);
			System.out.println(lp);
		}
	}

	// joined- one2one both student and laptop table
	public void nativeEntity8(Session session) {
		System.out.println("NativeSqlQuery : ***** nativeEntity8() *****");
		NativeQuery query = session
				.createNativeQuery("select * from student03 st join laptop03 lp on st.laptop_id = lp.lapid");
		query.addEntity("student", anand.unit05.mapping02.one2many.case04.Student.class).addJoin("lp",
				"student.laptop");

		List<Object[]> tuples = query.list();
		System.out.println("Student details");
		for (Object[] data : tuples) {
			Student st = (Student) data[0];
			List<Laptop> lp = (List<Laptop>) data[1];
			System.out.println(st);
			System.out.println(lp);
		}
	}
	
	
	public void many2one1(Session session) {
		NativeQuery query = session.createNativeQuery("select * from many2one_pentity where p_id  >= ?");
		query.setParameter(1, 2);
		query.addEntity(Many2OneParentEntity.class);
		List<Many2OneParentEntity> list = query.list();
		for(Many2OneParentEntity en : list) {
			System.out.println(en);
			Many2OneChildEntity ch = en.getChild();
			System.out.println(ch);
		}
	}
	
	public void many2one2(Session session) {
		NativeQuery query = session.createNativeQuery("select p_id,p_name,p_comment,child_id from many2one_pentity where p_id  >= ?");
		query.setParameter(1, 2);
		query.addEntity(Many2OneParentEntity.class);
		List<Many2OneParentEntity> list = query.list();
		for(Many2OneParentEntity en : list) {
			System.out.println(en);
			Many2OneChildEntity ch = en.getChild();
			System.out.println(ch);
		}
	}
	
	public void many2one3(Session session) {
		NativeQuery query = session.createNativeQuery("select * from many2one_pentity p join many2one_centity c on (p.child_id = c.c_id) where p_id  >= ?");
		query.setParameter(1, 2);
		query.addEntity(Many2OneParentEntity.class);
		List<Many2OneParentEntity> list = query.list();
		for(Many2OneParentEntity en : list) {
			System.out.println(en);
			Many2OneChildEntity ch = en.getChild();
			System.out.println(ch);
		}
	}
	
	public void many2one4(Session session) {
		NativeQuery query = session.createNativeQuery("select * from many2one_pentity p join many2one_centity c on (p.child_id = c.c_id) where p_id  >= ?");
		query.setParameter(1, 2);
		query.addEntity("parent",Many2OneParentEntity.class);
		query.addJoin("child", "parent.child");
		List<Object[]> list = query.list();
		for(Object[] en : list) {
			Many2OneParentEntity parent = (Many2OneParentEntity) en[0];
			Many2OneChildEntity child = (Many2OneChildEntity) en[1];
			System.out.println(parent);
			System.out.println(child);
		}
	}

	// By default, when using the addJoin() method, the result set will 
	// contain both entities that are joined. To construct the entity 
	// hierarchy, you need to use a ROOT_ENTITY or DISTINCT_ROOT_ENTITY ResultTransformer.
	// explain why here child entity ?????????
	public void many2one5(Session session) {
		NativeQuery query = session.createNativeQuery("select * from many2one_pentity parent join many2one_centity child on (parent.child_id = child.c_id) where p_id  >= ?");
		query.setParameter(1, 2);
		query.addEntity("parent",Many2OneParentEntity.class);
		query.addJoin("child", "parent.child");
		query.setResultTransformer(Criteria.ROOT_ENTITY);
		List<Many2OneChildEntity> list = query.list();
		for(Many2OneChildEntity child : list) {
			System.out.println(child);
		}
	}
	
	// if in both table there is some same-name column then we use alias and query.addEntity("p", One2OneParentEntity1.class);
	// now the mentioned entity will return
	public void check1(Session session) {
		NativeQuery query = session.createNativeQuery("select p.*, c.* from one2one_pentity1 p join one2one_centity1 c on (p.child_id = c.c_id)");
		query.addEntity("p", One2OneParentEntity1.class);
		List<One2OneParentEntity1> list = query.list();
		for(One2OneParentEntity1 en : list) {
			System.out.println(en);
		}
	}
	
	// here it will return joined table because we added query.addEntity("c", One2OneChildEntity1.class);
	public void check2(Session session) {
		NativeQuery query = session.createNativeQuery("select p.*, c.* from one2one_pentity1 p join one2one_centity1 c on (p.child_id = c.c_id)");
		query.addEntity("c", One2OneChildEntity1.class);
		List<One2OneChildEntity1> list = query.list();
		for(One2OneChildEntity1 en : list) {
			System.out.println(en);
		}
	}
	
	// here it will return object array because we added both entity;
	public void check3(Session session) {
		NativeQuery query = session.createNativeQuery("select p.*, c.* from one2one_pentity1 p join one2one_centity1 c on (p.child_id = c.c_id)");
		query.addEntity("p", One2OneParentEntity1.class);
		query.addEntity("c", One2OneChildEntity1.class);
		List<Object[]> list = query.list();
		for(Object[] en : list) {
			System.out.println(en[0]);
			System.out.println(en[1]);
		}
	}
	
	// returning a DTO
	public void check4(Session session) {
		NativeQuery query = session.createNativeQuery("select p_id as \"id\", p_name as \"parentName\", c_name as \"childName\" from one2one_pentity p join one2one_centity c on (p.child_id = c.c_id)");
		query.setResultTransformer(Transformers.aliasToBean(EntityDto.class));
		List<EntityDto> list = query.list();
		for(EntityDto en : list) {
			System.out.println(en.toString());
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
	
	
	
	public void entityMapping1(Session session) {
		
	}
}

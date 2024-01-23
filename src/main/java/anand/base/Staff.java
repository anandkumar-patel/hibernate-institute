package anand.base;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="Staff.byName", query=" from Staff where staffName = ?1")
@NamedNativeQuery(name="Staff.byId", query=" select * from staff_table where staff_id = :staffId",resultClass=Staff.class)
@Table(name ="staff_table")
public class Staff {
	@Id
	@Column(name="staff_id")
	private int staffId;
	@Column(name="staff_name")
	private String staffName;
	@Column(name="staff_dept")
	private String staffDept;
	private BigDecimal salary;
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffDept() {
		return staffDept;
	}
	public void setStaffDept(String staffDept) {
		this.staffDept = staffDept;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffDept=" + staffDept + "]";
	}

}
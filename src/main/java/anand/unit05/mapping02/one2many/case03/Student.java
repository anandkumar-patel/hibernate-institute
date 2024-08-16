package anand.unit05.mapping02.one2many.case03;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
 
@Entity
@Table(name = "student06")
public class Student {
   
	@Id
    private int rollNo;
    private String name;
    private float marks;
    @OneToMany
    private List<Laptop> laptops = new ArrayList<>();
    
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	public List<Laptop> getLaptops() {
		return laptops;
	}
	
	public void addLaptop(Laptop laptop) {
		this.laptops.add(laptop);
		laptop.setStudent(this);
	}
	public void removeLaptop(Laptop laptop) {
		this.laptops.remove(laptop);
		laptop.setStudent(null);
	}
    
}
package anand.unit05.mapping02.one2many.case04;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
 
 
@Entity(name = "student07")
public class Student {
   
	@Id
    private int rollNo;
    private String name;
    private float marks;
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private List<Laptop> laptop = new ArrayList<>();
    
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
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}     
    
}
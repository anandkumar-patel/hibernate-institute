package anand.unit05.mapping03.many2many.case03;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
 
 
@Entity
public class Student implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private int rollNo;
    private String name;
    private float marks;
    @ManyToMany
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
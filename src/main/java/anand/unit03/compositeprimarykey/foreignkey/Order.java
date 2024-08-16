package anand.unit03.compositeprimarykey.foreignkey;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(name = "customer_name", length = 50, nullable = false)
    private String customerName;
     
    @Column(length = 20, nullable = false)
    private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerName=" + customerName + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerName, id, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerName, other.customerName) && Objects.equals(id, other.id)
				&& Objects.equals(status, other.status);
	}
	
}

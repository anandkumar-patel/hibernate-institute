package anand.unit03.compositeprimarykey.foreignkey;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetail {
	@EmbeddedId
	private OrderDetailID id = new OrderDetailID();
	private int quantity;
	@Column(name = "unit_price")
	private float unitPrice;
	private float subtotal;
	public OrderDetailID getId() {
		return id;
	}
	public void setId(OrderDetailID id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, quantity, subtotal, unitPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetail other = (OrderDetail) obj;
		return Objects.equals(id, other.id) && quantity == other.quantity
				&& Float.floatToIntBits(subtotal) == Float.floatToIntBits(other.subtotal)
				&& Float.floatToIntBits(unitPrice) == Float.floatToIntBits(other.unitPrice);
	}
	
}

package anand.unit08.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "one2one_centity")
public class One2OneChildEntity {
	@Id
	@Column(name = "c_id")
	private int childId;
	@Column(name = "c_name")
	private String childName;
	@Column(name = "c_comment")
	private String comment;
	
	public int getChildId() {
		return childId;
	}
	public void setChildId(int childId) {
		this.childId = childId;
	}
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "One2OneChildEntity [childId=" + childId + ", childName=" + childName + ", comment=" + comment + "]";
	}

}

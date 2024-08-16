package anand.unit08.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "one2one_pentity1")
public class One2OneParentEntity1 {
	@Id
	@Column(name = "p_id")
	private int parentId;
	@Column(name = "p_name")
	private String parentName;
	@Column(name = "p_comment")
	private String comment;
	@OneToOne
	@JoinColumn(name = "child_id")
	private One2OneChildEntity1 child;
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public One2OneChildEntity1 getChild() {
		return child;
	}
	public void setChild(One2OneChildEntity1 child) {
		this.child = child;
	}
	@Override
	public String toString() {
		return "One2OneParentEntity [parentId=" + parentId + ", parentName=" + parentName + ", comment=" + comment
				+ "]";
	}
	

}

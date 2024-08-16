package anand.unit08.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "many2one_pentity")
public class Many2OneParentEntity {
	@Id
	@Column(name = "p_id")
	private int parentId;
	@Column(name = "p_name")
	private String parentName;
	@Column(name = "p_comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "child_id")
	private Many2OneChildEntity child;

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

	public Many2OneChildEntity getChild() {
		return child;
	}

	public void setChild(Many2OneChildEntity child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "Many2OneParentEntity [parentId=" + parentId + ", parentName=" + parentName + ", comment=" + comment
				+ "]";
	}
	
}

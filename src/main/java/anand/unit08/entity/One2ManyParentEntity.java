package anand.unit08.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "one2many_pentity")
public class One2ManyParentEntity {
	@Id
	@Column(name = "p_id")
	private int parentId;
	@Column(name = "p_name")
	private String parentName;
	@Column(name = "p_comment")
	private String comment;
	@OneToMany
	@JoinColumn(name ="parent_id")
	private List<One2ManyChildEntity> child = new ArrayList<>();
	
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
	public List<One2ManyChildEntity> getChild() {
		return child;
	}
	public void setChild(List<One2ManyChildEntity> child) {
		this.child = child;
	}
	@Override
	public String toString() {
		return "One2ManyParentEntity [parentId=" + parentId + ", parentName=" + parentName + ", comment=" + comment
				+ "]";
	}
	

}

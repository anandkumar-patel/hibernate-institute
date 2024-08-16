package anand.unit08.entity;

public class EntityDto {
	private int id;
	private String parentName;
	private String childName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	@Override
	public String toString() {
		return "EntityDto [parentName=" + parentName + ", childName=" + childName + "]";
	}	
}

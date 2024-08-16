package anand.unit06.cascade01.one2one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "post01")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	@OneToOne(mappedBy = "post", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
	private PostDetails details;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public PostDetails getDetails() {
		return details;
	}
	public void setDetails(PostDetails details) {
		this.details = details;
		details.setPost(this);
	}
	
	public void removeDetails() {
		this.details = null;
	}
}

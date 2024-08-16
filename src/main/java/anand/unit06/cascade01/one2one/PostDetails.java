package anand.unit06.cascade01.one2one;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "post_details01")
public class PostDetails {
	@Id
	private Long id;
	@Column(name = "created_on")
	@Temporal(TemporalType.DATE)
	private Date createdOn;
	private String createdBy;

	@OneToOne
	@MapsId
	private Post post;

	public PostDetails() {

	}

	public PostDetails(String createdBy) {
		this.createdBy = createdBy;
		this.createdOn = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}

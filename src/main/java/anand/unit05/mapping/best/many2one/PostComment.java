package anand.unit05.mapping.best.many2one;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "post_comment")
public class PostComment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Post post;
	private String review;
	public Long getId() {
		return id;
	}
	public PostComment setId(Long id) {
		this.id = id;
		return this;
	}
	public Post getPost() {
		return post;
	}
	public PostComment setPost(Post post) {
		this.post = post;
		return this;
	}
	public String getReview() {
		return review;
	}
	public PostComment setReview(String review) {
		this.review = review;
		return this;
	}
	

}

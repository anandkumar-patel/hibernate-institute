package anand.unit05.mapping.best.many2one;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<PostComment> comments = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public Post setId(Long id) {
		this.id = id;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public Post setTitle(String title) {
		this.title = title;
		return this;
	}
	public List<PostComment> getComments() {
		return comments;
	}
	public Post setComments(List<PostComment> comments) {
		this.comments = comments;
		return this;
	}
	
	public Post addComment(PostComment comment) {
		comments.add(comment);
		comment.setPost(this);
		return this;
	}
	
	public Post removeComment(PostComment comment) {
		comments.remove(comment);
		comment.setPost(null);
		return this;
	}
	
}

package com.example.social.post;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.social.user.User;
@Entity
public class Post {
	
	@Id
	private String id;
	private String postdate;
	private String details;
	
	@ManyToOne
	private User user;
	
	public Post() {
		
	}
	
	public Post(String id, String postdate, String details, User user) {
		super();
		this.id = id;
		this.postdate = postdate;
		this.details = details;
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}

package com.example.social.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

	@Autowired
	PostRepo postRepo;
	
	public List<Post> getAllPost(){
		return (List<Post>)postRepo.findAll();
	}
	
	public Post getPost(String id) {
		return postRepo.findById(id).get();
	}
	
	public List<Post> getPostByUser(String id){
		return postRepo.findByUserId(id);
	}
	
	public List<Post> getPostByPostdate(String postdate){
		return postRepo.getPostByPostdate(postdate);
	}
	public void addPost(Post post) {
		postRepo.save(post);
	}
	
	public void updatePost(String id, Post post) {
		Post posts = postRepo.findById(id).get();
		posts.setDetails(post.getDetails());
		posts.setPostdate(post.getPostdate());
		posts.setUser(post.getUser());
	}
	
	public void deletePost(String id) {
		postRepo.delete(postRepo.findById(id).get());
	}
}

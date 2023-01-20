package com.example.social.post;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepo extends CrudRepository<Post, String> {
	public List<Post> findByUserId(String id);
	
	@Query("select p from Post p where p.postdate = :postdate")
	public List<Post> getPostByPostdate(@Param("postdate") String postdate);
}

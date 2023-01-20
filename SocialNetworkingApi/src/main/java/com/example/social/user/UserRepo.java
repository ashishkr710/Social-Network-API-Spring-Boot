package com.example.social.user;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends CrudRepository<User, String> {
	@Query("select u from User u where u.firstlname = :fname")
	public List<User> getUserByFirstname(@Param("fname") String fname);
	
	@Query("select u from User u where u.lastname = :lname")
	public List<User> getUserByLastname(@Param("lname") String lname);
}

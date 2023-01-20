package com.example.social.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.social.post.Post;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	
	
	public User getUser(String id) {
		return userRepo.findById(id).get();
		
	}
	public List<User> getAllUser(){
		return (List<User>) userRepo.findAll();
				
	}
	
	public List<User> getUserByFirstname(String fname){
		return userRepo.getUserByFirstname(fname);
	}
	
	public List<User> getUserByLastname(String lname){
		return userRepo.getUserByLastname(lname);
	}
	
	public void addUser(User user) {
		userRepo.save(user);
		}
	public void updateUser(String id, User user) {
		User us= userRepo.findById(id).get();
		us.setFirstlname(user.getFirstlname());
		us.setLastname(user.getLastname());
		us.setEmail(user.getEmail());
		us.setLocation(user.getLocation());
	}
	
	public void deleteUser(String id) {
		userRepo.delete(userRepo.findById(id).get());
	}
}

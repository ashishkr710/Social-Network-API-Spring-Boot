package com.example.social.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.social.location.Location;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id")String id) {
		return userService.getUser(id);
	}

	@GetMapping("/user")
	public String getAllUser (Model model){
		
		List<User> users = userService.getAllUser();
		model.addAttribute("users", users);
		model.addAttribute("user", new User());
		System.out.println("user dashboard");
		return "users";
	}
	
	@GetMapping("/user/fname/{fname}")
	public List<User> getUserByFirstname(@PathVariable("fname") String fname){
		return userService.getUserByFirstname(fname);
	}
	
	@GetMapping("/user/lname/{lname}")
	public List<User> getUserByLastname(@PathVariable("lname") String lname){
		return userService.getUserByLastname(lname);
	}
	
	@PostMapping("/user/add")
	public String addUser(@ModelAttribute("user") User user, @RequestParam("location_id") String location_id) {
		System.out.println(user);
		Location location = new Location();
		location.setId(location_id);
		user.setLocation(location);
		System.out.println(user.getId());
		System.out.println(user.getFirstlname());
		System.out.println(user.getLastname());
		userService.addUser(user);
		System.out.println(location_id);
		return "redirect:/user";
	}
	
	@PutMapping("/user/update/{id}")
	public String updateUser(@PathVariable("id") String id, User user) {
		userService.updateUser(id, user);
		return "user updated successfully";
	}
	
	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") String id) {
		userService.deleteUser(id);
		return "redirect:/user";
	}
	
}

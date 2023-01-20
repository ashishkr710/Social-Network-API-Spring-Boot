package com.example.social.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.social.user.User;


@Controller
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping("/post/{id}")
	public Post getPostById(@PathVariable("id")String id) {
		return postService.getPost(id);
	}
	@GetMapping("/post")
	public List<Post> getAllPost(){
		return postService.getAllPost();
	}
	@GetMapping("/post/user/{id}")
	public String getPostByUser(@PathVariable("id") String id, Model model) {
		model.addAttribute("posts", postService.getPostByUser(id));
		model.addAttribute("post", new Post());
		return "postbyuser";
	}
	@GetMapping("/post/date/{postdate}")
	public List<Post> getPostByPostdate(@PathVariable("postdate") String postdate){
		return postService.getPostByPostdate(postdate);
	}
	@PostMapping("/post")
	public String addPost(@ModelAttribute("posts") Post posts, @RequestParam("userid") String userid) {
		User user = new User();
		user.setId(userid);
		posts.setUser(user);
		postService.addPost(posts);
		return "redirect:/post/user/"+userid;
	}
	
	@PutMapping("/post/update/{id}")
	public String updatePost(@PathVariable("id") String id,@RequestBody Post post) {
		postService.updatePost(id, post);
		return "post is updated successfully";
	}
	
	@RequestMapping("/post/delete/{id}")
	public String deletePost(@PathVariable("id") String id) {
		String uId = postService.getPost(id).getUser().getId();
		postService.deletePost(id);
		return "redirect:/post/user/"+uId;
	}
}

package com.example.social.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mycontroller {
	@GetMapping("/a")
	public String welcomes() {
		return "index";
	}
}

package com.q.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.q.model.Blog;
import com.q.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value="/toBlog")
	public String toBlog(Model model){
		List<Blog> blogs = blogService.queryAll();
		model.addAttribute("blogs", blogs);
		return "Blog";
	}
}

package com.q.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.q.dao.BlogDao;
import com.q.model.Blog;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	public void insertBlog(Blog blog){
		blogDao.insertBlog(blog);
	}
	
	public List<Blog> queryAll(){
		List<Blog> blogs = blogDao.querytBlog();
		return blogs;
	}
}

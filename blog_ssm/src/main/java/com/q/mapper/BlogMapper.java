package com.q.mapper;

import java.util.List;

import com.q.model.Blog;

public interface BlogMapper {
	//新增一条Blog记录
	public void insertBlog(Blog blog); 
	
	public List<Blog> queryBlog();
	
	public void updateBlog(Blog blog);

	public void deleteBlog(Blog blog);
	
	public Blog queryBlogById(int id); 
	
	public List<Blog> queryByType(String type);
}

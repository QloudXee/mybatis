package com.q.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.q.mapper.BlogMapper;
import com.q.model.Blog;
import com.q.util.MyBatisUtil;

public class BlogTest {
	
	public static void main(String[] args) {
		BlogTest bt = new BlogTest();
		bt.blogTest();
	}
	
	public void blogTest(){
		SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		int id = 9; 
		Blog blog = blogMapper.queryBlogById(id);
		System.out.println(blog.getAuthor().getUsername());
		session.close();
	}
	
}

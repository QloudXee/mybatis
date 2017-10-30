package com.q.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.q.mapper.BlogMapper;
import com.q.model.Blog;
import com.q.util.MyBatisUtil;

public class Test {
	
	public static void main(String[] args) {
		Test test = new Test();
		//test.testInsertBlog();
		/*List<Blog> blogList = test.testQuerytBlog();
		for(Blog blogTemp : blogList){
			System.out.println(blogTemp);
		}*/
		//test.testUpdatetBlog();
		test.testDeleteBlog();
	}
	
	public void testInsertBlog(){
		//�������ļ��л�ȡsessionfactory
		SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
		//��ȡsession
		SqlSession session = sessionFactory.openSession();
		Blog blog = new Blog();
		blog.setTitle("����");
		//���ýӿ�
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		blogMapper.insertBlog(blog);
		session.commit();
		session.close();
	}
	public List<Blog> testQuerytBlog(){
		SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		List<Blog> blogs = blogMapper.queryBlog();
		session.close();
		return blogs;
	}
	public void testUpdatetBlog(){
		SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		Blog blog = new Blog();
		blog.setId(15l);
		blog.setContent("�������������ԣ������������֮");
		blog.setTitle("���");
		blog.setType("ΰ���Դ�");
		blog.setCreateTime(null);
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		blogMapper.updateBlog(blog);
		session.commit();
		session.close();
	}
	public void testDeleteBlog(){
		SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
		SqlSession session = sessionFactory.openSession();
		BlogMapper blogMapper = session.getMapper(BlogMapper.class);
		Blog blog = new Blog();
		blog.setId(15l);
		blogMapper.deleteBlog(blog);
		session.commit();
		session.close();
	}
}

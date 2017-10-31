package com.q.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.q.mapper.BlogMapper;
import com.q.model.Blog;
import com.q.util.MyBatisUtil;

@Repository
public class BlogDao {
		//插入
		public void insertBlog(Blog blog){
			//从配置文件中获取sessionfactory
			SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
			//获取session
			SqlSession session = sessionFactory.openSession();
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			blogMapper.insertBlog(blog);
			session.commit();
			session.close();
		}
		//查询全部
		public List<Blog> querytBlog(){
			SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
			SqlSession session = sessionFactory.openSession();
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			List<Blog> blogs = blogMapper.queryBlog();
			session.close();
			return blogs;
		}
		//修改
		public void testUpdatetBlog(){
			SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
			SqlSession session = sessionFactory.openSession();
			Blog blog = new Blog();
			blog.setId(15l);
			blog.setContent("苟利国家生死以，岂因祸福避趋之");
			blog.setTitle("蛤蛤传");
			blog.setType("伟人自传");
			blog.setCreateTime(null);
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			blogMapper.updateBlog(blog);
			session.commit();
			session.close();
		}
		//根据id删除
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
		//根据id查询
		public void getBlogById(){
			SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
			SqlSession session = sessionFactory.openSession();
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			int id = 14;
			Blog blog = blogMapper.queryBlogById(id);
			System.out.println(blog);
			session.commit();
			session.close();
		}
		//查询所有政治类的
		public void queryBYType(){
			SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
			SqlSession session = sessionFactory.openSession();
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			String type="政论";
			List<Blog> blogs = blogMapper.queryByType(type);
			for(Blog blog : blogs){
				System.out.println(blog);
			}
			session.commit();
			session.close();
		}
}

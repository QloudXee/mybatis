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
		//����
		public void insertBlog(Blog blog){
			//�������ļ��л�ȡsessionfactory
			SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
			//��ȡsession
			SqlSession session = sessionFactory.openSession();
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			blogMapper.insertBlog(blog);
			session.commit();
			session.close();
		}
		//��ѯȫ��
		public List<Blog> querytBlog(){
			SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
			SqlSession session = sessionFactory.openSession();
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			List<Blog> blogs = blogMapper.queryBlog();
			session.close();
			return blogs;
		}
		//�޸�
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
		//����idɾ��
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
		//����id��ѯ
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
		//��ѯ�����������
		public void queryBYType(){
			SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
			SqlSession session = sessionFactory.openSession();
			BlogMapper blogMapper = session.getMapper(BlogMapper.class);
			String type="����";
			List<Blog> blogs = blogMapper.queryByType(type);
			for(Blog blog : blogs){
				System.out.println(blog);
			}
			session.commit();
			session.close();
		}
}

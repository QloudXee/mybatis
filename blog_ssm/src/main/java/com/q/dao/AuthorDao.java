package com.q.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.q.mapper.AuthorMapper;
import com.q.model.Author;
import com.q.util.MyBatisUtil;

public class AuthorDao {
		//修改作者密码
		public void alertAuthor(){
			SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
			SqlSession session = sessionFactory.openSession();
			AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
			Author author = new Author();
			author.setPassword("23456");
			author.setUsername("黄");
			authorMapper.alertPassword(author);
			session.commit();
			session.close();
		}
		//删除作者
		public void deleteAuthor(){
			SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
			SqlSession session = sessionFactory.openSession();
			AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
			String username="巴拿马";
			/*Author author = new Author();
			author.setPassword("123456");
			author.setUsername("黄");*/
			authorMapper.deleteAuthor(username);
			session.commit();
			session.close();
		}
}

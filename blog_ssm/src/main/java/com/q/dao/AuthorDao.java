package com.q.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.q.mapper.AuthorMapper;
import com.q.model.Author;
import com.q.util.MyBatisUtil;

public class AuthorDao {
		//�޸���������
		public void alertAuthor(){
			SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
			SqlSession session = sessionFactory.openSession();
			AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
			Author author = new Author();
			author.setPassword("23456");
			author.setUsername("��");
			authorMapper.alertPassword(author);
			session.commit();
			session.close();
		}
		//ɾ������
		public void deleteAuthor(){
			SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
			SqlSession session = sessionFactory.openSession();
			AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
			String username="������";
			/*Author author = new Author();
			author.setPassword("123456");
			author.setUsername("��");*/
			authorMapper.deleteAuthor(username);
			session.commit();
			session.close();
		}
}

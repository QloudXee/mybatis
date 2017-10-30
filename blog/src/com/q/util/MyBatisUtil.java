package com.q.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	//SqlSessionFactoryΪ������
	private final static SqlSessionFactory sqlSessionFactory; 
	
	static{ //��̬���飬ִֻ��һ��
		String resource = "mybatis-config.xml"; 
		Reader reader = null;
		try {
		      reader = Resources.getResourceAsReader(resource); //��ȡ�����ļ�
		} catch (IOException e) {
		      System.out.println(e.getMessage());
		}
		//����SqlSessionFactory����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
	}
	
	//���ص���SqlSessionFactory����
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
}

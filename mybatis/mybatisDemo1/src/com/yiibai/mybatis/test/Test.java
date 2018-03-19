package com.yiibai.mybatis.test;

import java.io.Reader;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.model.User;

public class Test {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static{
		try {
			reader = Resources.getResourceAsReader("config/Config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = (User)sqlSession.selectOne("com.yiibai.mybatis.mapper.UserMapper.GetUserByID", 1);
		if (user != null) {
			System.out.println(user.getuserName()+"ÊÖ»úºÅ:"+user.getUserPhone());
		}
	}
}

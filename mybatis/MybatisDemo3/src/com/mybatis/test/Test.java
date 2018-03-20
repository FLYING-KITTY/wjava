package com.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.dao.UsersMapper;
import com.mybatis.model.Users;

public class Test {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static {
		try {
			reader = Resources.getResourceAsReader("Config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
	
	public static void main(String[] args) {
		// selectAll();
		// insert();
		SqlSession session = sqlSessionFactory.openSession();
		UsersMapper usersMapper = session.getMapper(UsersMapper.class);
		usersMapper.delete(5);
		session.commit();
		selectAll();
	}

	private static void insert() {
		SqlSession session = sqlSessionFactory.openSession();
		UsersMapper usersMapper = session.getMapper(UsersMapper.class);
		Users users = new Users();
		users.setUserID(5);
		users.setUserName("tony");
		users.setUserPhone("18995831681");
		usersMapper.insert(users);
		session.commit();
		selectAll();
	}

	private static void selectAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UsersMapper usersMapper = sqlSession.getMapper(UsersMapper.class);
		//
		List<Users> usersList = usersMapper.selectAll();
		for (Users users : usersList) {
			System.out.println(users.getuserName()+"ÊÖ»úºÅ£º"+users.getUserPhone());
		}
		sqlSession.close();
	}
}

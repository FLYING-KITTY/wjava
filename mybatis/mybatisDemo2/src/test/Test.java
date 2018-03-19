package test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.mapper.UserMapper;
import com.yiibai.mybatis.model.User;

public class Test {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static{
		try {
			reader = Resources.getResourceAsReader("config/Config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SqlSessionFactory getSession(){
		return sqlSessionFactory;
	}
	
	public static void main(String[] args) {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// ע�⣺δcommit(),��������ִ�У�������־û������ݿ�
		int line = userMapper.UpdUserByID("jack", 1);
		User user = userMapper.GetUserByID(1);
		// ע��
		// ��ɾ�ò��������Ҫcommit����������ֻ�ǻ����ڵ�ǰsession����δ�־û������ݿ�
		session.commit();
		System.out.println(line);
		System.out.println(user.getuserName()+"�ֻ���:"+user.getUserPhone());
	}
}

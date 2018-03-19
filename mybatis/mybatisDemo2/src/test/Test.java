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
		// 注意：未commit(),更新是有执行，但不会持久化到数据库
		int line = userMapper.UpdUserByID("jack", 1);
		User user = userMapper.GetUserByID(1);
		// 注意
		// 增删该操作，务必要commit，否则数据只是缓存在当前session，并未持久化到数据库
		session.commit();
		System.out.println(line);
		System.out.println(user.getuserName()+"手机号:"+user.getUserPhone());
	}
}

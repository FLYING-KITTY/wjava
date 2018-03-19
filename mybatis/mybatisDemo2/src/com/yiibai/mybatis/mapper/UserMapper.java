package com.yiibai.mybatis.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yiibai.mybatis.model.User;

public interface UserMapper {
	@Select("select * from users where userID= #{userID}")
	public User GetUserByID(int userID);
	
	// ��һ�ִ��ε�д�� @Param("��������")
	// one
	/*@Update("update users set userName = #{userName} where userID = #{userID}")
	public int UpdUserByID( @Param("userName") String userName, @Param("userID") int userID);*/

	
	// �ڶ��ִ��ε�д�� #{0}��ʾ��һ������  #{1}��ʾ�ڶ����������Դ�����
	// two
	/*@Update("update users set userName = #{0} where userID = #{1}")
	public int UpdUserByID(String userName, int userID);*/
	
	
	// �����ִ��ε�д�� #{param1}��ʾ��һ������  #{param2}��ʾ�ڶ����������Դ�����
	// three
	@Update("update users set userName = #{param1} where userID = #{param2}")
	public int UpdUserByID(String userName, int userID);
	
	// ע���һ�ֺͺ����߷������ɻ��ʹ�ã������������
}

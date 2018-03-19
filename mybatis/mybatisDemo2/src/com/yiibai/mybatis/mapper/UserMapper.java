package com.yiibai.mybatis.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yiibai.mybatis.model.User;

public interface UserMapper {
	@Select("select * from users where userID= #{userID}")
	public User GetUserByID(int userID);
	
	// 第一种传参的写法 @Param("参数名称")
	// one
	/*@Update("update users set userName = #{userName} where userID = #{userID}")
	public int UpdUserByID( @Param("userName") String userName, @Param("userID") int userID);*/

	
	// 第二种传参的写法 #{0}表示第一个参数  #{1}表示第二个参数，以此类推
	// two
	/*@Update("update users set userName = #{0} where userID = #{1}")
	public int UpdUserByID(String userName, int userID);*/
	
	
	// 第三种传参的写法 #{param1}表示第一个参数  #{param2}表示第二个参数，以此类推
	// three
	@Update("update users set userName = #{param1} where userID = #{param2}")
	public int UpdUserByID(String userName, int userID);
	
	// 注意第一种和后两者方法不可混合使用，后两者则可以
}

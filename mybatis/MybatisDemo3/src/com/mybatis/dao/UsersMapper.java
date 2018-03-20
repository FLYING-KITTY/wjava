package com.mybatis.dao;

import java.util.List;

import com.mybatis.model.Users;

public interface UsersMapper {
	public void insert(Users users);

	public void delete(int userID);
	
	public void update(Users users);
	
	public List<Users> select(int userID);
	
	public List<Users> selectAll();
}

package com.whc.noteserver.dao;

import java.util.List;

import com.whc.noteserver.entity.User;

public interface UserDao {
	public List<User> login(User user);

	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param user 从前台传入的user
	 * @return 从数据库查询的user
	 */
	public List<User> getUserByUserName(User user);

	/**
	 * 添加用户信息
	 * 
	 * @param user 从前台传入的user
	 * @return 1
	 */
	public int addUser(User user);
	
	/**
	 * 更新用户信息
	 * @param user 从前台传入的user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * 根据id获取用户信息
	 * @param user
	 * @return
	 */
	public List<User> getUserByID(User user);
}

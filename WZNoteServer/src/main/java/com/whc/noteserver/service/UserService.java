package com.whc.noteserver.service;

import com.whc.noteserver.entity.User;

public interface UserService {
	/**
	 * 用户登录
	 * 
	 * @param user 传入的user
	 * @return 从数据库查询返回的User
	 */
	public User login(User user);

	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param user 从前台传入的user
	 * @return 从数据库查询的user
	 */
	public User getUserByUserName(User user);

	/**
	 * 添加用户信息
	 * 
	 * @param user前台传入的user
	 * @return 1
	 */
	public int addUser(User user);

}

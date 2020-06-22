package com.whc.noteserver.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whc.noteserver.dao.JFDao;
import com.whc.noteserver.dao.UserDao;
import com.whc.noteserver.entity.JF;
import com.whc.noteserver.entity.User;
import com.whc.noteserver.service.UserService;

@Service
public class UserImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Autowired
	JFDao jfDao;

	public User login(User user) {
//		System.out.println(user);
		List<User> list = userDao.login(user);
		if (list == null || list.isEmpty()) {
			System.out.println("用户名、密码不匹配");
			return null;
		} else {
			System.out.println(list.get(0));
			return list.get(0);
		}
	}

	@Override
	public User getUserByUserName(User user) {
		List<User> list = userDao.getUserByUserName(user);
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	public int addUser(User user) {
		JF jf = new JF();
		jf.setId(UUID.randomUUID().toString());
		jf.setJf(5);
		jf.setUser_id(user.getId());
		int re = jfDao.addJF(jf);
		System.out.println("添加积分返回值："+re);
		return userDao.addUser(user);
	}
	
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}
	
	public User getUserByID(User user) {
		List<User> list=userDao.getUserByID(user);
		if(list==null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

}

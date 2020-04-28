package com.whc.noteserver.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.whc.noteserver.entity.User;
import com.whc.noteserver.service.UserService;
import com.whc.noteserver.test.Person;
import com.whc.noteserver.util.JsonResult;
import com.whc.noteserver.util.MD5;

@Controller // 注解，组件扫描加入到spring容器中
@RequestMapping("/user") // 类controller的映射路径
public class UserController {

	private Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping("/login") // 方法的映射路径
	@ResponseBody // 将返回信息输送到网页端
	public Object login(User user) {
		// System.out.println(user.toString());
		// userService.login(user);
		logger.debug("登录：" + user.getUsername());
		logger.info("登录：" + user.getUsername());

		try {
			user.setPassword(MD5.md5(user.getPassword(), "helloworld"));
		} catch (Exception e) {
//			e.printStackTrace(); 
			logger.error("MD5加密",e);
		}
		User userResult = userService.login(user);

		JsonResult jsonResult;
		if (userResult != null) {
			jsonResult = new JsonResult(JsonResult.STATE_SUCCESS, "", userResult);
		} else {
			jsonResult = new JsonResult(JsonResult.STATE_ERROR, "用户名或密码错误", null);
		}

		return jsonResult;

	}

	@RequestMapping("/register")
	@ResponseBody
	public Object register(User user) {
		user.setId(UUID.randomUUID().toString());
		try {
			String newpassword = MD5.md5(user.getPassword(), "helloworld");
			user.setPassword(newpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResult jsonResult = null;
		System.out.println(user);
		// 1.判断前台传过来的用户名是否重复
		User userResult = userService.getUserByUserName(user);
		if (userResult == null) {
			// 可以注册
			// 2.如果不重复，说明可以注册，把User信息添加到数据库
			int result = userService.addUser(user);
			if (result == 1) {
				// 数据库插入成功
				jsonResult = new JsonResult(JsonResult.STATE_SUCCESS, "注册成功", null);
			} else {
				// 数据库插入失败
				jsonResult = new JsonResult(JsonResult.STATE_ERROR, "注册失败", null);
			}

		} else {
			// 存在相同的用户名，不可以注册
			jsonResult = new JsonResult(JsonResult.STATE_ERROR, "存在重复的用户名", null);
		}

		return jsonResult;
	}

}

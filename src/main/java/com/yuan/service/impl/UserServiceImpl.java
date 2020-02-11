package com.yuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.yuan.mapper.UserMapper;
import com.yuan.model.User;
import com.yuan.model.entity.UpdateJfTp;
import com.yuan.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserByUsername(String username) {
		return userMapper.getUserByUsername(username);
	}
	
	@Override
	public void insertUser(User user) {
		String password = user.getPassword();
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		user.setPassword(password);
		userMapper.insertSelective(user);
	}

	@Override
	public User getUserByIdcard(String idcard) {
		return userMapper.getUserByIdcard(idcard);

	}

	@Override
	public void updataUser(User user) {
		userMapper.updateByPrimaryKey(user);
	}

	@Override
	public void updateUserTpJf(UpdateJfTp updateJfTp) {
		userMapper.updateUserTpJf(updateJfTp);
		
	}

	
}

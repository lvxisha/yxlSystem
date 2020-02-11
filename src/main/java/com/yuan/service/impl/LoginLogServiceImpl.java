package com.yuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuan.mapper.LoginLogMapper;
import com.yuan.model.LoginLog;
import com.yuan.model.Page;
import com.yuan.service.LoginLogService;
@Service
public class LoginLogServiceImpl implements LoginLogService{
	@Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public int insert(LoginLog loginLog) {
        return loginLogMapper.insertSelective(loginLog);
    }

	@Override
	public int selectLoginLogCount(Integer userId) {
		return loginLogMapper.selectLoginLogCount(userId);
	}

	@Override
	public List<LoginLog> selectLoginLogInfo(Integer userId, Page page) {
		return loginLogMapper.selectLoginLogInfo(userId,page);
	}
}

package com.yuan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuan.mapper.AirplaneMapper;
import com.yuan.service.AirplaneService;

/**
* @ClassName: AirplaneServiceImpl
* @Package com.yuan.service.impl
* @Description: 飞机订票接口实现类
* @author yxl
* @date 2019年9月21日 下午2:57:19
*
*/
@Service
public class AirplaneServiceImpl implements AirplaneService{

	@Autowired
	private AirplaneMapper airplaneMapper;
	

}

package com.yuan.service;

import java.util.List;

import com.yuan.model.User;
import com.yuan.model.entity.UpdateJfTp;

public interface UserService {
/**
 * 
 * @Title: getUserByUsername
 * @Description: 通过用户名查询用户信息
 * @author: yxl
 * @param @param username
 * @param @return 参数
 * @return User 返回类型
 * @throws
 */
	User getUserByUsername(String username);
	/**
	 * 
	 * @Title: getUserByIdcard
	 * @Description:通过身份证号获取用户信息
	 * @author: yxl
	 * @date 2019年8月31日
	 * @param @param username
	 * @param @return 参数
	 * @return User 返回类型
	 * @throws
	 */
	User getUserByIdcard(String idcard);
	/**
	 * 
	 * @Title: insertUser
	 * @Description: 注册用户
	 * @author: yxl
	 * @date 2019年9月3日
	 * @param @param user 参数
	 * @return void 返回类型
	 * @throws
	 */
	void insertUser(User user);
	/**
	 * 
	 * @Title: updataUser
	 * @Description: 更改密码
	 * @author: yxl
	 * @date 2019年9月3日
	 * @param @param user 参数
	 * @return void 返回类型
	 * @throws
	 */
	void updataUser(User user);
	/**
	 * @Title: updateUserTpJf
	 * @Description:更新用户积分和退票数目
	 * @author: yxl
	 * @date 2019年9月21日
	 * @param @param userId 参数
	 * @return void 返回类型
	 * @throws
	 */
	void updateUserTpJf(UpdateJfTp updateJfTp);
	

}
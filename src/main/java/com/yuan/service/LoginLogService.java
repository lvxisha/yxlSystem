package com.yuan.service;

import java.util.List;

import com.yuan.model.LoginLog;
import com.yuan.model.Page;

/**
 * 
* @ClassName: LoginLogService
* @Package com.yuan.service
* @Description: 登录业务层
* @author yxl
* @date 2019年9月4日 下午7:48:51
*
 */
public interface LoginLogService {
	 
	int insert(LoginLog loginLog);

	/**
	 * @Title: selectLoginLogCount
	 * @Description:根据用户ID统计用户登录日志
	 * @author: yxl
	 * @date 2019年9月25日
	 * @param @param userId
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	int selectLoginLogCount(Integer userId);

	/**
	 * @Title: selectLoginLogInfo
	 * @Description:查询登录日志
	 * @author: yxl
	 * @date 2019年9月25日
	 * @param @param userId
	 * @param @param page
	 * @param @return 参数
	 * @return LoginLog 返回类型
	 * @throws
	 */
	List<LoginLog> selectLoginLogInfo(Integer userId, Page page);
}

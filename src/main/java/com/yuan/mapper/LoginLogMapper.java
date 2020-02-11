package com.yuan.mapper;

import java.util.List;

import com.yuan.model.LoginLog;
import com.yuan.model.Page;

public interface LoginLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    LoginLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginLog record);

    int updateByPrimaryKey(LoginLog record);

	/**
	 * @Title: selectLoginLogCount
	 * @Description:根据用户ID统计用户登录日志
	 * @author: yxl
	 * @date 2019年9月25日
	 * @param @param loginLogId
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	int selectLoginLogCount(Integer userId);

	/**
	 * @Title: selectLoginLogInfo
	 * @Description:
	 * @author: yxl
	 * @date 2019年9月25日
	 * @param @return 参数
	 * @return LoginLog 返回类型
	 * @throws
	 */
	List<LoginLog> selectLoginLogInfo(Integer userId, Page page);
}
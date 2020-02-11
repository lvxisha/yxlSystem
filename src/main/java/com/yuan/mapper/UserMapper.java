package com.yuan.mapper;

import com.yuan.model.User;
import com.yuan.model.entity.UpdateJfTp;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
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
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author: yxl
	 * @date 2019年8月31日
	 * @param @param idcard
	 * @param @return 参数
	 * @return User 返回类型
	 * @throws
	 */
    User getUserByIdcard(String idcard);

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
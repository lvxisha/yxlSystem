package com.yuan.mapper;

import java.util.List;

import com.yuan.model.Orderform;
import com.yuan.model.Page;
import com.yuan.model.entity.RecommendationTicket;

public interface OrderformMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderform record);

    int insertSelective(Orderform record);

    Orderform selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderform record);

    int updateByPrimaryKey(Orderform record);

	/**
	 * @Title: selectOrderformInfoCount
	 * @Description:统计订单数
	 * @author: yxl
	 * @date 2019年9月26日
	 * @param @param userId
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	int selectOrderformInfoCount(Integer userId);

	/**
	 * @Title: selectOrderformInfo
	 * @Description:根据用户ID查询订单信息
	 * @author: yxl
	 * @date 2019年9月26日
	 * @param @param userId
	 * @param @param page
	 * @param @return 参数
	 * @return List<Orderform> 返回类型
	 * @throws
	 */
	List<Orderform> selectOrderformInfo(Integer userId, Page page);

	/**
	 * @Title: selectRecommendationTicket
	 * @Description:获取用户最多次数订单的出发地和目的地
	 * @author: yxl
	 * @date 2019年9月28日
	 * @param @return 参数
	 * @return RecommendationTicket 返回类型
	 * @throws
	 */
	RecommendationTicket selectRecommendationTicket(Integer userId);
}
package com.yuan.service;

import java.util.List;

import com.yuan.model.Orderform;
import com.yuan.model.Page;
import com.yuan.model.entity.RecommendationTicket;

/**
* @ClassName: OrderformService
* @Package com.yuan.service
* @Description: 订单接口实现类
* @author yxl
* @date 2019年9月23日 下午10:39:45
*
*/
public interface OrderformService {

	/**
	 * @Title: insertOrderform
	 * @Description:向订单列表添加数据
	 * @author: yxl
	 * @date 2019年9月23日
	 * @param @param orderform 参数
	 * @return void 返回类型
	 * @throws
	 */
	void insertOrderform(Orderform orderform);

	/**
	 * @Title: selectOrderformInfo
	 * @Description:根据订单ID查询订单信息
	 * @author: yxl
	 * @date 2019年9月26日
	 * @param @param orderformId
	 * @param @return 参数
	 * @return Orderform 返回类型
	 * @throws
	 */
	Orderform selectOrderformInfo(Integer orderformId);

	/**
	 * @Title: updateOrderformInfo
	 * @Description:更新订单信息
	 * @author: yxl
	 * @date 2019年9月26日
	 * @param @param orderform 参数
	 * @return void 返回类型
	 * @throws
	 */
	void updateOrderformInfo(Orderform orderform);

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
	 * @param userId 
	 * @Title: selectRecommendationTicket
	 * @Description:获取用户最多次数订单的出发地和目的地
	 * @author: yxl
	 * @date 2019年9月28日
	 * @param @return 参数
	 * @return RecommendationTicket 返回类型
	 * @throws
	 */
	RecommendationTicket selectRecommendationTicket(Integer userId);

	/**
	 * @Title: TicketChanges
	 * @Description:机票改签
	 * @author: yxl
	 * @date 2019年12月25日
	 * @param @param orderform 参数
	 * @return void 返回类型
	 * @throws
	 */
	void TicketChanges(Orderform orderform);

}

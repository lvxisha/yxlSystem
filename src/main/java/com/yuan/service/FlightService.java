package com.yuan.service;

import java.util.List;

import com.yuan.model.Flight;
import com.yuan.model.Page;
import com.yuan.model.entity.GetFlightInformation;
import com.yuan.model.entity.RecommendationTicket;
import com.yuan.model.entity.SearchConditions;

public interface FlightService {

	//查询航班信息
	List<GetFlightInformation>  selectFlightInformation(Page page);
	//根据条件查询航班信息
	List<GetFlightInformation> selectFlightInfo(SearchConditions searchConditions);
	//根据条件统计航班数
	int  selectFlightInfoCount(SearchConditions searchConditions);
	/**
	 * @Title: updateFirstclass
	 * @Description:更新头等舱座位信息
	 * @author: yxl
	 * @date 2019年9月21日
	 * @param @param airplaneId
	 * @param @param choice 参数
	 * @return void 返回类型
	 * @throws
	 */
	void updateFirstclass(Integer flightId,boolean choice);

	/**
	 * 
	 * @Title: updateEconomyclass
	 * @Description:更新经济舱座位信息
	 * @author: yxl
	 * @date 2019年9月21日
	 * @param @param airplaneId
	 * @param @param choice 参数
	 * @return void 返回类型
	 * @throws
	 */
	void updateEconomyclass(Integer flightId,boolean choice);
	/**
	 * @return 
	 * @Title: selectFlightInfo
	 * @Description:根据航班Id获取航班信息
	 * @author: yxl
	 * @date 2019年9月25日
	 * @param @param flightId 参数
	 * @return void 返回类型
	 * @throws
	 */
	Flight selectFlightInfo(Integer flightId);
	/**
	 * @param page 
	 * @Title: selectRecommendationTicket
	 * @Description:根据用户的最多次数订单的出发地和目的地获取航班信息
	 * @author: yxl
	 * @date 2019年9月28日
	 * @param @param recommendationTicket
	 * @param @return 参数
	 * @return List<GetFlightInformation> 返回类型
	 * @throws
	 */
	List<GetFlightInformation> selectRecommendationTicket(String startstation, String terminus, Page page);
	/**
	 * @Title: selectFlightCount
	 * @Description:统计航班数
	 * @author: yxl
	 * @date 2019年10月6日
	 * @param @return 参数
	 * @return Integer 返回类型
	 * @throws
	 */
	Integer selectFlightCount();
	/**
	 * @Title: FlightCount
	 * @Description:
	 * @author: yxl
	 * @date 2019年10月6日
	 * @param @param recommendationTicket
	 * @param @return 参数
	 * @return Integer 返回类型
	 * @throws
	 */
	Integer FlightCount(RecommendationTicket recommendationTicket);
}

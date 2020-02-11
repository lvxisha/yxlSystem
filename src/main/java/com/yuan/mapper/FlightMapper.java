package com.yuan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuan.model.Flight;
import com.yuan.model.Page;
import com.yuan.model.entity.GetFlightInformation;
import com.yuan.model.entity.RecommendationTicket;
import com.yuan.model.entity.SearchConditions;

public interface FlightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Flight record);

    int insertSelective(Flight record);

    Flight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Flight record);

    int updateByPrimaryKey(Flight record);
    /**
     * 
     * @Title: selectFlightInformation
     * @Description: 查询航班信息
     * @author: yxl
     * @date 2019年9月4日
     * @param @return 参数
     * @return List<GetFlightInformation> 返回类型
     * @throws
     */
    List<GetFlightInformation> selectFlightInformation(Page page);
    /**
     * 
     * @Title: selectFlightInfo
     * @Description: 根据条件查询航班信息
     * @author: yxl
     * @date 2019年9月4日
     * @param @param flight
     * @param @return 参数
     * @return List<GetFlightInformation> 返回类型
     * @throws
     */
    List<GetFlightInformation> selectFlightInfo(SearchConditions searchConditions);

	/**
	 * @Title: selectFlightInfoCount
	 * @Description:根据条件统计航班数量
	 * @author: yxl
	 * @date 2019年9月8日
	 * @param @param searchConditions
	 * @param @return 参数
	 * @return List<GetFlightInformation> 返回类型
	 * @throws
	 */
	int selectFlightInfoCount(SearchConditions searchConditions);
	/**
	 * @param airplaneId 
	 * @Title: updateFirstclass
	 * @Description:更新头等舱座位信息
	 * @author: yxl
	 * @date 2019年9月21日
	 * @param  参数
	 * @return void 返回类型
	 * @throws
	 */
	void updateFirstclass(Integer flightId,boolean choice);

	/**
	 * @Title: updateEconomyclass
	 * @Description:更新经济舱座位信息
	 * @author: yxl
	 * @date 2019年9月21日
	 * @param  参数
	 * @return void 返回类型
	 * @throws
	 */
	void updateEconomyclass(Integer flightId,boolean choice);

	/**
	 * @param page 
	 * @Title: selectRecommendationTicket
	 * @Description:
	 * @author: yxl
	 * @date 2019年9月28日
	 * @param @param recommendationTicket
	 * @param @return 参数
	 * @return List<GetFlightInformation> 返回类型
	 * @throws
	 */
	List<GetFlightInformation> selectRecommendationTicket(@Param("startstation")String startstation, @Param("terminus")String terminus,@Param("page")Page page);

	/**
	 * @Title: selectFlightCount
	 * @Description:统计航班信息
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
	 * @param @return 参数
	 * @return Integer 返回类型
	 * @throws
	 */
	Integer FlightCount(RecommendationTicket recommendationTicket);

	/**
	 * @Title: selectStartstation
	 * @Description:机票改签（查找出发站）
	 * @author: yxl
	 * @date 2019年12月25日
	 * @param @param flightId
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	String selectStartstation(Integer flightId);
	
}
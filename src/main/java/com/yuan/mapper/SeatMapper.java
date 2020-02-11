package com.yuan.mapper;

import java.util.List;

import com.yuan.model.Flight;
import com.yuan.model.Seat;

public interface SeatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Seat record);

    int insertSelective(Seat record);

    Seat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Seat record);

    int updateByPrimaryKey(Seat record);

	/**
	 * @Title: selectSeatInfo
	 * @Description:根据飞机id获取座位信息
	 * @author: yxl
	 * @date 2019年9月4日
	 * @param @param seat
	 * @param @return 参数
	 * @return List<Seat> 返回类型
	 * @throws
	 */
	List<Seat> selectSeatInfo(Integer airplaneId);

	/**
	 * @Title: updateSeatChoice
	 * @Description:根据座位id设置座位是否被选中
	 * @author: yxl
	 * @date 2019年9月4日
	 * @param @param seat 参数
	 * @return void 返回类型
	 * @throws
	 */
	void updateSeatChoice(Seat seat);

	/**
	 * @Title: selectSeatDetailInfo
	 * @Description:根据座位id获取座位详细信息
	 * @author: yxl
	 * @date 2019年9月8日
	 * @param @param id
	 * @param @return 参数
	 * @return List<Seat> 返回类型
	 * @throws
	 */
	Seat selectSeatDetailInfo(Integer seatId);

	/**
	 * @Title: selectSeatDetailInfoFlightId
	 * @Description:
	 * @author: yxl
	 * @date 2019年9月27日
	 * @param @return 参数
	 * @return Seat 返回类型
	 * @throws
	 */
	int selectSeatDetailInfoFlightId(Integer flightId,boolean rank);
}
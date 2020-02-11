/**  
* @Title: SeatService.java
* @Package com.yuan.service
* @Description: 
* @author yxl 
* @date 2019年9月4日 下午7:46:02
* @version V1.0  
*/
package com.yuan.service;

import java.util.List;

import com.yuan.model.Flight;
import com.yuan.model.Seat;

/**
* @ClassName: SeatService
* @Package com.yuan.service
* @Description: 座位信息管理业务层
* @author yxl
* @date 2019年9月4日 下午7:46:02
*
*/
public interface SeatService {
/**
 * 
 * @Title: selectSeatInfo
 * @Description:查询座位信息
 * @author: yxl
 * @date 2019年9月4日
 * @param @param seat
 * @param @return 参数
 * @return List<Seat> 返回类型
 * @throws
 */
	List<Seat> selectSeatInfo(Integer flightId);
/**
 * 
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
	 * @Title: updateSeatInfo
	 * @Description:更新座位信息
	 * @author: yxl
	 * @date 2019年9月4日
	 * @param @param seat 参数
	 * @return void 返回类型
	 * @throws
	 */
	void updateSeatInfo(Seat seat);
	/**
	 * @Title: selectSeatDetailInfoFlightId
	 * @Description:
	 * @author: yxl
	 * @date 2019年9月27日
	 * @param @param flightId
	 * @param @return 参数
	 * @return Seat 返回类型
	 * @throws
	 */
	int selectSeatDetailInfoFlightId(Integer flightId,boolean rank);

}

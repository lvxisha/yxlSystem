package com.yuan.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuan.model.Flight;
import com.yuan.model.Orderform;
import com.yuan.model.Page;
import com.yuan.model.PageResult;
import com.yuan.model.Result;
import com.yuan.model.Seat;
import com.yuan.model.User;
import com.yuan.model.entity.GetFlightInformation;
import com.yuan.model.entity.GetOrderForm;
import com.yuan.model.entity.RecommendationTicket;
import com.yuan.model.entity.SearchConditions;
import com.yuan.model.entity.UpdateJfTp;
import com.yuan.service.FlightService;
import com.yuan.service.OrderformService;
import com.yuan.service.SeatService;
import com.yuan.service.UserService;
import com.yuan.utils.SessionConsts;

/**
 * @ClassName: PlaneTicketController
 * @Package com.yuan.controller
 * @Description: 机票管理模块
 * @author yxl
 * @date 2019年9月4日 下午5:26:08
 *
 */
@RestController
public class PlaneTicketController {
	@Autowired
	private FlightService flightService;
	@Autowired
	private SeatService seatService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderformService orderformService;
	/**
	 * 
	 * @Title: selectFlightInfo 
	 * @Description:根据条件获取航班信息接口 
	 * @author: yxl 
	 * @date 2019年9月4日 
	 * @param @param searchConditions
	 * @param @return 参数
	 * @return Result 返回类型 
	 * @throws
	 */
	@RequestMapping("/selectFlightInfo")
	public PageResult selectFlightInfo(HttpSession session, SearchConditions searchConditions) {
		PageResult pageResult = new PageResult();
		int count = flightService.selectFlightInfoCount(searchConditions);
		if (count == 0) {
			pageResult.setCode("1111");
			pageResult.setMessage("暂无数据！");
		} else {
			List<GetFlightInformation> data = flightService.selectFlightInfo(searchConditions);
			 for(GetFlightInformation list : data){
					if(list.getFirstclassPrice()==null) {
						list.setFirstclassPrice(0);
					}
					if(list.getEconomyclassPrice()==null) {
						list.setEconomyclassPrice(0);
					}
		        }
			pageResult.setCount(count);
			pageResult.setData(data);
		}
		return pageResult;
	}

	/**
	 * 
	 * @Title: selectSeatInfo 
	 * @Description:根据航班的id获取该航班的座位信息
	 * @author: yxl 
	 * @date 2019年9月4日 
	 * @param @param seat 
	 * @param @return 参数 
	 * @return Result 返回类型 
	 * @throws
	 */
	@RequestMapping("/selectSeatInfo")
	public Result selectSeatInfo(HttpSession session, Integer flightId) {
		Result result = new Result();
		List<Seat> data = seatService.selectSeatInfo(flightId);
		result.setData(data);
		return result;
	}

	/**
	 * 
	 * @Title: selectSeatInfo 
	 * @Description:根据座位id获取座位的详细信息 
	 * @author: yxl 
	 * @date: 2019年9月8日
	 * @param @param session 
	 * @param @param airplaneId 
	 * @param @return 参数 
	 * @return Result 返回类型 
	 * @throws
	 */
	@RequestMapping("/selectSeatDetailInfo")
	public Result selectSeatDetailInfo(HttpSession session, Integer seatId) {
		Result result = new Result();
		Seat seat = seatService.selectSeatDetailInfo(seatId);
		result.setData(seat);
		// System.out.println(data);
		session.setAttribute(SessionConsts.SESSION_SEAT, seat);
		return result;
	}

	/**
	 * 
	 * @Title: updateSeatInfo
	 * @Description:飞机订票功能实现:1.更新座位信息是否被占用 2.更新用户信息（用户积分累计）3.插入航班订单信息
	 * @author: yxl
	 * @date 2019年9月25日
	 * @param @param session
	 * @param @param updateJfTp
	 * @param @param getOrderForm
	 * @param @return 参数
	 * @return Result 返回类型
	 * @throws
	 */
	@RequestMapping("/updateSeatInfo")
	public Result updateSeatInfo(HttpSession session, UpdateJfTp updateJfTp, GetOrderForm getOrderForm) {
		Result result = new Result();
		Integer seatId = getOrderForm.getSeatId();// 获取前端传的座位id
		Seat info = seatService.selectSeatDetailInfo(seatId);// 根据座位ID查找座位详细信息
		Integer flightId = info.getFlightId();// 获取航班id
		User user = (User) session.getAttribute(SessionConsts.SESSION_USER);// 获取 保存在session中的用户信息
		Integer seatJf = info.getJf();// 获取座位的积分
		Integer userId = user.getId();// 获取用户id
		Integer tp = user.getTp();// 获取用户的退票数
		Integer jf = user.getJf();// 获取用户积分
		boolean choice = info.getChoice();
		updateJfTp.setUserId(userId);
		updateJfTp.setSeatJf(seatJf);
		updateJfTp.setTp(tp);
		updateJfTp.setJf(jf + seatJf);
		updateJfTp.setChoice(choice);
		// System.out.println(jf);
		boolean rank = info.getRank();
		// 1==true==选择，0==false=未选择
		Seat seat=new Seat();
		if (info.getChoice() == true) {
			result.setCode("1111");
			result.setMessage("座位已被购买!!!");
			//seat.setChoice(false);
//			seat.setId(info.getId());
//			seatService.updateSeatInfo(seat);// 更新座位是否被占用
//			userService.updateUserTpJf(updateJfTp);// 更新用户积分和退票次数
//			if (rank == true) {
//				flightService.updateFirstclass(flightId, choice);// 更新头等舱座位数量
//			} else {
//				flightService.updateEconomyclass(flightId, choice);// 更新经济舱座位数量
//			}
		}
		if (info.getChoice() == false) {
			seat.setChoice(true);
			seat.setId(info.getId());
			seatService.updateSeatInfo(seat);// 更新座位为被占用
			userService.updateUserTpJf(updateJfTp);
			if (rank == true) {
				flightService.updateFirstclass(flightId, choice);
			} else {
				flightService.updateEconomyclass(flightId, choice);
			}
			Flight flight=flightService.selectFlightInfo(flightId);
			Integer airplaneId =flight.getAirplaneId();// 获取飞机id
			Orderform orderform=new Orderform();
			String identity=getOrderForm.getIdentity();//获取前端传递的订票者的身份证号
			String tel=getOrderForm.getTel();//获取前端传递的电话
			String name=getOrderForm.getName();//获取前端传递的订票者姓名
				orderform.setFlightId(flightId);
				orderform.setUserId(userId);
				orderform.setSeatId(seatId);
				orderform.setIftp(false);
				orderform.setAirplaneId(airplaneId);
				orderform.setIdentity(identity);
				orderform.setName(name);
				orderform.setTel(tel);
				orderformService.insertOrderform(orderform);
		}	
		return result;
	}
	/**
	 * 
	 * @Title: refundTicket
	 * @Description:飞机退票功能实现:1.更新座位信息为未被占用 2.更新用户信息（用户积分减去，用户退票数累加）3.更新退票的票价为当前活动价
	 * @author: yxl
	 * @date 2019年9月28日
	 * @param @param orderformId
	 * @param @return 参数
	 * @return Result 返回类型
	 * @throws
	 */
   @RequestMapping("/refundTicket")
	public Result refundTicket(Integer orderformId) {
	   Result result=new Result();
	   Orderform orderformInfo=orderformService.selectOrderformInfo(orderformId);
	   Integer flightId=orderformInfo.getFlightId();
	   Integer seatId=orderformInfo.getSeatId();
	   Seat seatInfo = seatService.selectSeatDetailInfo(seatId);// 根据座位ID查找座位详细信息
	   boolean rank=seatInfo.getRank();
	   int price = seatService.selectSeatDetailInfoFlightId(flightId,rank);//根据航班ID获取座位信息
	   Seat seat = new Seat();
	   seat.setId(orderformInfo.getSeatId());
	   seat.setChoice(false);
	   seat.setPrice(price);
	   seat.setJf(price/10);
	   seatService.updateSeatInfo(seat);// 更新座位为未被占用
	   Orderform orderform = new Orderform();
	   orderform.setIftp(true);
	   orderform.setId(orderformId);
	   orderformService.updateOrderformInfo(orderform);
	   result.setData(orderformInfo);
		return result;
		
	}
   /**
    * 
    * @Title: orderformInfo
    * @Description:用户订单的添加
    * @author: yxl
    * @date 2019年9月28日
    * @param @param userId
    * @param @param page
    * @param @return 参数
    * @return PageResult 返回类型
    * @throws
    */
   @RequestMapping("/orderformInfo")
	  public PageResult orderformInfo(Integer userId,Page page) {
		  PageResult pageResult = new PageResult();
		  int count = orderformService.selectOrderformInfoCount(userId);
		  if (count == 0) {
				pageResult.setCode("1111");
				pageResult.setMessage("暂无数据！");
			} else {
				List<Orderform> data = orderformService.selectOrderformInfo(userId,page);
				pageResult.setCount(count);
				pageResult.setData(data);
			}
	  return pageResult;
	  
	  }
   /**
    * 
    * @Title: recommendationTicket
    * @Description:机票推荐
    * @author: yxl
    * @date 2019年9月28日
    * @param @param session
    * @param @param page
    * @param @return 参数
    * @return PageResult 返回类型
    * @throws
    */
   @RequestMapping("/recommendationTicket")
	  public PageResult recommendationTicket(HttpSession session,Page page) {
		  PageResult pageResult = new PageResult();
		 User user = (User) session.getAttribute(SessionConsts.SESSION_USER);
		 Integer userId=user.getId();
		  RecommendationTicket recommendationTicket = orderformService.selectRecommendationTicket(userId);
		  if (recommendationTicket == null) {
			  Integer count = flightService.selectFlightCount();
		        List<GetFlightInformation> data = flightService.selectFlightInformation(page);
		        for(GetFlightInformation list : data){
					if(list.getFirstclassPrice()==null) {
						list.setFirstclassPrice(0);
					}
					if(list.getEconomyclassPrice()==null) {
						list.setEconomyclassPrice(0);
					}
		        }
		        pageResult.setCount(count);
		        pageResult.setData(data);
			} 
		  if (recommendationTicket != null) {
			  String startstation = recommendationTicket.getStartstation();
			  String terminus = recommendationTicket.getTerminus();
//			  page.setBegin(0);
//			  page.setPageSize(10);
//			  page.setPageNum(1);
				List<GetFlightInformation> data = flightService.selectRecommendationTicket(startstation,terminus,page);
				for(GetFlightInformation list : data){
					if(list.getFirstclassPrice()==null) {
						list.setFirstclassPrice(0);
					}
					if(list.getEconomyclassPrice()==null) {
						list.setEconomyclassPrice(0);
					}
		        }
				Integer count = flightService.FlightCount(recommendationTicket);
				pageResult.setCount(count);
		        pageResult.setData(data);
			}
	  return pageResult;
	  
	  }
/**
 * 
 * @Title: TicketChanges
 * @Description:机票改签
 * @author: yxl
 * @date 2019年12月25日
 * @param @return 参数
 * @return Result 返回类型
 * @throws
 */
 public Result TicketChanges(Orderform orderform){
	   Result result=new Result();
	   orderformService.TicketChanges(orderform);
	   return result;
   }
   
}

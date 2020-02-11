package com.yuan.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuan.mapper.FlightMapper;
import com.yuan.mapper.OrderformMapper;
import com.yuan.model.Orderform;
import com.yuan.model.Page;
import com.yuan.model.entity.RecommendationTicket;
import com.yuan.service.OrderformService;

/**
* @ClassName: OrderformServiceImpl
* @Package com.yuan.service.impl
* @Description: 订单接口实现类
* @author yxl
* @date 2019年9月23日 下午10:40:02
*
*/
@Service
public class OrderformServiceImpl implements OrderformService{
	@Autowired
	private OrderformMapper orderformMapper;
	@Autowired
	private FlightMapper flightMapper;
	@Override
	public void insertOrderform(Orderform orderform) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String newDate = sdf.format(new Date());
		String num = "";
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			num += random.nextInt(10);
		}
		String orderid = newDate + num;
		orderform.setOrderid(orderid);
		orderformMapper.insert(orderform);
		
	}
	@Override
	public Orderform selectOrderformInfo(Integer orderformId) {
		return orderformMapper.selectByPrimaryKey(orderformId);
	}
	@Override
	public void updateOrderformInfo(Orderform orderform) {
		orderformMapper.updateByPrimaryKeySelective(orderform);	
	}
	@Override
	public int selectOrderformInfoCount(Integer userId) {
		return orderformMapper.selectOrderformInfoCount(userId);
	}
	@Override
	public List<Orderform> selectOrderformInfo(Integer userId, Page page) {
		return orderformMapper.selectOrderformInfo(userId,page);
	}
	@Override
	public RecommendationTicket selectRecommendationTicket(Integer userId) {
		return orderformMapper.selectRecommendationTicket(userId);
	}
	/**
	 * 机票改签
	 */
	@Override
	public void TicketChanges(Orderform orderform) {
		Integer flightId=orderform.getFlightId();
		String startstation = flightMapper.selectStartstation(flightId);
		
	}

}

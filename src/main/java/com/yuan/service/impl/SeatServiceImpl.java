package com.yuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuan.mapper.SeatMapper;
import com.yuan.model.Seat;
import com.yuan.service.SeatService;

/**
* @ClassName: SeatServiceImpl
* @Package com.yuan.service.impl
* @Description: 座位接口实现类
* @author yxl
* @date 2019年9月4日 下午7:49:40
*
*/
@Service
public class SeatServiceImpl implements SeatService {
@Autowired
private SeatMapper seatMapper;
	
@Override 
public List<Seat> selectSeatInfo(Integer flightId) {
	  
	  return seatMapper.selectSeatInfo(flightId); }

@Override
public void updateSeatInfo(Seat seat) {
	seatMapper.updateByPrimaryKeySelective(seat);
	
}
@Override
public Seat selectSeatDetailInfo(Integer seatId) {
	return seatMapper.selectSeatDetailInfo(seatId);
}

@Override
public int selectSeatDetailInfoFlightId(Integer flightId,boolean rank) {
	return seatMapper.selectSeatDetailInfoFlightId(flightId,rank);
}


	 

	
	
}

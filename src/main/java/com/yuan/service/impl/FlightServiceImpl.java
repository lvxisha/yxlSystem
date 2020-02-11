package com.yuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuan.mapper.FlightMapper;
import com.yuan.model.Flight;
import com.yuan.model.Page;
import com.yuan.model.entity.GetFlightInformation;
import com.yuan.model.entity.RecommendationTicket;
import com.yuan.model.entity.SearchConditions;
import com.yuan.service.FlightService;



@Service
public class FlightServiceImpl implements FlightService{
	@Autowired
    private FlightMapper flightMapper;
	
	@Override
	public List<GetFlightInformation> selectFlightInformation(Page page){
		return flightMapper.selectFlightInformation(page);
	}

	@Override
	public List<GetFlightInformation> selectFlightInfo(SearchConditions searchConditions) {
		return flightMapper.selectFlightInfo(searchConditions);
	}

	@Override
	public int selectFlightInfoCount(SearchConditions searchConditions) {
		return flightMapper.selectFlightInfoCount(searchConditions);
	}
	
	@Override
	public void updateFirstclass(Integer airplaneId,boolean choice) {
		flightMapper.updateFirstclass(airplaneId,choice);		
	}
	@Override
	public void updateEconomyclass(Integer airplaneId,boolean choice) {
		flightMapper.updateEconomyclass(airplaneId,choice);		
	}

	@Override
	public Flight selectFlightInfo(Integer flightId) {
		return flightMapper.selectByPrimaryKey(flightId);		
	}

	@Override
	public List<GetFlightInformation> selectRecommendationTicket(String startstation, String terminus,Page page) {
		return flightMapper.selectRecommendationTicket(startstation,terminus,page);
	}

	@Override
	public Integer selectFlightCount() {
		return flightMapper.selectFlightCount();
	}

	@Override
	public Integer FlightCount(RecommendationTicket recommendationTicket) {
		return flightMapper.FlightCount(recommendationTicket);
	}
}

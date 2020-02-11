package com.yuan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuan.model.Page;
import com.yuan.model.Result;
import com.yuan.model.entity.GetFlightInformation;
import com.yuan.service.FlightService;


/**
 * 
* @ClassName: AfficheController
* @Package com.yxl.controller
* @Description: 公告管理控制层
* @author yxl
* @date 2019年8月21日 下午3:44:08
*
 */
@RestController
public class AfficheController {
	@Autowired
    private FlightService flightService;

	@RequestMapping("/selectFlightInformation")
    public Result selectFlightInformation(Page page) {
        Result result = new Result();
        List<GetFlightInformation> data = flightService.selectFlightInformation(page);
        result.setData(data);
        return result; 
    }
	
}

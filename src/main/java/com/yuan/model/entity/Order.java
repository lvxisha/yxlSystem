/**  
* @Title: Order.java
* @Package com.yuan.model.entity
* @Description: 
* @author yxl 
* @date 2019年12月25日 下午9:42:28
* @version V1.0  
*/
package com.yuan.model.entity;

import java.util.Date;

import lombok.Data;

/**
* @ClassName: Order
* @Package com.yuan.model.entity
* @Description: 订单数据接收实体类
* @author yxl
* @date 2019年12月25日 下午9:42:28
*
*/
@Data
public class Order {

	private String orderformId;
	private String identity;
	private String tel;
	private String NAME;
	private Integer userId;
	private String startstation;
	private String terminus;
	private Date deptime;
	private Date arrtime;
	private double rank;
	private Integer price;
	private String seatnum;
	private String aptype ;
}

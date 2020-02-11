/**  
* @Title: GetOrderForm.java
* @Package com.yuan.model.entity
* @Description: 
* @author yxl 
* @date 2019年9月25日 下午8:43:22
* @version V1.0  
*/
package com.yuan.model.entity;

import lombok.Data;

/**
* @ClassName: GetOrderForm
* @Package com.yuan.model.entity
* @Description: 飞机订单接口实体类
* @author yxl
* @date 2019年9月25日 下午8:43:22
*
*/
@Data
public class GetOrderForm {
	
	private Integer seatId;
	private String tel;
	private String name;
	private String identity;
	
}

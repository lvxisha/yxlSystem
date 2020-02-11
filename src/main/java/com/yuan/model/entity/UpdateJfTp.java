/**  
* @Title: UpdateJfTp.java
* @Package com.yuan.model.entity
* @Description: 
* @author yxl 
* @date 2019年9月21日 下午5:21:29
* @version V1.0  
*/
package com.yuan.model.entity;

import lombok.Data;

/**
* @ClassName: UpdateJfTp
* @Package com.yuan.model.entity
* @Description: 用户积分和退票次数实体类
* @author yxl
* @date 2019年9月21日 下午5:21:29
*
*/
@Data
public class UpdateJfTp {

	private Integer userId;
	private Integer seatJf;
	private Integer Jf;
	private Integer tp;
	private boolean choice;
	
}

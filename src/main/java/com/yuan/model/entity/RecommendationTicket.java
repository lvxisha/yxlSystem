package com.yuan.model.entity;

import lombok.Data;

/**
* @ClassName: RecommendationTicket
* @Package com.yuan.model.entity
* @Description: 获取用户最多次数订单的出发地和目的地的实体类
* @author yxl
* @date 2019年9月28日 下午7:14:24
*
*/
@Data
public class RecommendationTicket {
	/**
	 * 出发地
	 */
	private String startstation;
	/**
	 * 目的地
	 */
	private String terminus;
	/**
	 * 订单次数
	 */
	private Integer count;
	
	public String getStartstation() {
        return startstation;
    }

    public void setStartstation(String startstation) {
        this.startstation = startstation == null ? null : startstation.trim();
    }

    public String getTerminus() {
        return terminus;
    }

    public void setTerminus(String terminus) {
        this.terminus = terminus == null ? null : terminus.trim();
    }

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count == null ? null : count;
	}


}

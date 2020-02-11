package com.yuan.model.entity;

import java.util.Date;

import lombok.Data;

/**
 * 
* @ClassName: GetFlightInformation
* @Package com.yuan.model.entity
* @Description: 获取航班信息的实体
* @author yxl
* @date 2019年8月26日 下午2:30:03
*
 */
@Data
public class GetFlightInformation {
	 /**
     * 飞机id
     */
	private Integer airplane_id;
	/**
	 * 始发站
	 */
    private String startstation;
	/**
	 * 终点站
	 */
    private String terminus;
	/**
	 * 起飞时间
	 */
    private Date deptime;
	/**
	 * 到达时间
	 */
    private Date arrtime;
	/**
	 * 剩余头等舱座位数
	 */
    private Integer firstclass;
    /**
	 * 剩余经济舱座位数
	 */
    private Integer economyclass;
	/**
	 * 飞机类型
	 */
    private String aptype;
	/**
	 * 飞机编号
	 */
    private String airnumber;
    /**
     * 飞机所属公司
     */
    private String company;
    /**
     * 航班id
     */
    private Integer id;
    private Integer firstclassPrice;
    private Integer economyclassPrice;
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAirnumber() {
		return airnumber;
	}

	public void setAirnumber(String airnumber) {
		this.airnumber = airnumber;
	}

	public String getStartstation() {
		return startstation;
	}

	public void setStartstation(String startstation) {
		this.startstation = startstation;
	}

	public String getTerminus() {
		return terminus;
	}

	public void setTerminus(String terminus) {
		this.terminus = terminus;
	}

	public Date getDeptime() {
		return deptime;
	}

	public void setDeptime(Date deptime) {
		this.deptime = deptime;
	}

	public Date getArrtime() {
		return arrtime;
	}

	public void setArrtime(Date arrtime) {
		this.arrtime = arrtime;
	}

	public String getAptype() {
		return aptype;
	}

	public void setAptype(String aptype) {
		this.aptype = aptype;
	}

	public Integer getFirstclass() {
		return firstclass;
	}

	public void setFirstclass(Integer firstclass) {
		this.firstclass = firstclass;
	}

	public Integer getEconomyclass() {
		return economyclass;
	}

	public void setEconomyclass(Integer economyclass) {
		this.economyclass = economyclass;
	}
	


    
}

/**  
* @Title: SearchConditions.java
* @Package com.yuan.model.entity
* @Description: 
* @author yxl 
* @date 2019年9月4日 下午6:03:12
* @version V1.0  
*/
package com.yuan.model.entity;

import lombok.Data;

/**
* @ClassName: SearchConditions
* @Package com.yuan.model.entity
* @Description: 查询机票条件实体
* @author yxl
* @date 2019年9月4日 下午6:03:12
*
*/
@Data
public class SearchConditions {

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
    private String deptime;
    /**
     * 分页查询开始记录位置
     */
    private int begin;
    /**
     * 分页查看下结束位置
     */
    private int end;

    /**
     * 查询结果总记录数
     */
    private int count;
    /**
     * 当前页码
     */
    private int pageNum = 1;

    /**
     * 总共页数
     */
    private int total;

    /**
     * 每页显示条数
     */
    private int pageSize = 10;

    public int getBegin() {
        begin = (pageNum - 1) * pageSize;
        if (begin < 0) {
            begin = 0;
        }
        return begin;
    }

    public int getEnd() {
        if (end < 1) {
            end = getBegin() + pageSize;
        }
        return end;
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
	public String getDeptime() {
		return deptime;
	}
	public void setDeptime(String deptime) {
		this.deptime = deptime;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}

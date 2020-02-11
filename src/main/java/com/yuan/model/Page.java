package com.yuan.model;

import java.io.Serializable;

import lombok.Data;

/**
 * 
* @ClassName: Page
* @Package com.yuan.model
* @Description: 分页对象
* @author yxl
* @date 2019年9月21日 下午4:23:11
*
 */
 @Data
public class Page implements Serializable {


	/**
     * 序列化的版本号
     */
	private static final long serialVersionUID = 1L;

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public void setEnd(int end) {
		this.end = end;
	}
    
}

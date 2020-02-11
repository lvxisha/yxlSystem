package com.yuan.model;

import java.io.Serializable;

import com.yuan.utils.ResultConsts;

import lombok.Data;

/**
 * 
* @ClassName: PageResult
* @Package com.yuan.model
* @Description: 分页对象结果
* @author yxl
* @date 2019年9月21日 下午4:23:50
*
 */
@Data
public class PageResult implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @Fields serialVersionUID : 序列化的版本号
     */

    /**
     * 代码
     */
    private String code = ResultConsts.SUCCESS_CODE;

    /**
     * 消息
     */
    private String message = ResultConsts.SUCCESS_MSG;

    /**
     * 数据
     */
    private Object data;

    /**
     * 总数
     */
    private int count;
}

package com.yuan.model;

import java.io.Serializable;

import com.yuan.utils.ResultConsts;

import lombok.Data;



/**
 * 
* @ClassName: Result
* @Package com.yuan.model
* @Description: 普通结果对象实体类
* @author yxl
* @date 2019年8月27日 上午9:25:51
*
 */
@Data
public class Result implements Serializable {

    /**
     * @Fields serialVersionUID : 序列化的版本号
     */
	private static final long serialVersionUID = 1L;

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
  
}

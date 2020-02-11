package com.yuan.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.yuan.model.Result;


/**
 * 
 * @ClassName: MyControllerAdvice
 * @package com.yuan.utils
 * @description: controller增强器
 * @author: yxl
 * @date: 2019年8月26日 下午3:40:00
 */
@RestControllerAdvice
public class MyControllerAdvice {

    /**
     * 日志记录器
     */
    private Logger logger = LoggerFactory.getLogger(MyControllerAdvice.class);

    /**
     * 
     * @title: initBinder
     * @description: 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @author: yxl
     * @date: 2019年8月26日 上午11:37:20
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    /**
     * 
     * @title: addAttributes
     * @description: 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @author: yxl
     * @date: 2019年8月26日 上午11:37:20
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
    }

    /**
     * 
     * @title: errorHandler
     * @description: 全局异常捕捉处理
     * @author: yxl
     * @date: 2019年8月26日 上午11:37:20
     * @param exception
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception exception) {
        Result result = new Result();
        // 遗漏参数
        if (exception instanceof MissingServletRequestParameterException) {
            result.setCode(ResultConsts.MISSING_PARAMETER_CODE);
            result.setMessage(ResultConsts.MISSING_PARAMETER_MSG);
            return result;
        }
        // 键重复
        if (exception instanceof DuplicateKeyException) {
            result.setCode(ResultConsts.DUPLICATE_KEY_CODE);
            result.setMessage(ResultConsts.DUPLICATE_KEY_MSG);
            return result;
        }
        // 数据完整
        if (exception instanceof DataIntegrityViolationException) {
            result.setCode(ResultConsts.DATA_INTEGRITY_VIOLATION_CODE);
            result.setMessage(ResultConsts.DATA_INTEGRITY_VIOLATION_MSG);
            return result;
        }
        // Http请求方法不支持
        if (exception instanceof HttpRequestMethodNotSupportedException) {
            result.setCode(ResultConsts.HTTP_REQUEST_METHOD_NOT_SUPPORTED_CODE);
            result.setMessage(ResultConsts.HTTP_REQUEST_METHOD_NOT_SUPPORTED_MSG);
            return result;
        }
        result.setCode(ResultConsts.ERROR_CODE);
        result.setMessage(ResultConsts.ERROR_MSG);
        logger.error("全局异常捕捉处理", exception);
        return result;
    }

}
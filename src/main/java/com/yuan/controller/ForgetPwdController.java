package com.yuan.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuan.model.Result;
import com.yuan.model.User;
import com.yuan.service.UserService;

/**
* @ClassName: ForgetPwdController
* @Package com.yuan.controller
* @Description: 忘记密码模块控制层
* @author yxl
* @date 2019年8月31日 下午4:02:18
*
*/
@RestController
public class ForgetPwdController {
	@Autowired
	public UserService userService;
	/**
	 * 
	 * @Title: getUserName
	 * @Description: 根据用户名,身份证号，姓名获取用户信息，验证是否存在此用户
	 * @author: yxl
	 * @date 2019年8月31日
	 * @param @param username
	 * @param @return 参数
	 * @return Result 返回类型
	 * @throws
	 */
	 @RequestMapping("/forgetPwd") 
	 public Result forgetPwd(@RequestParam String username,@RequestParam String password,@RequestParam String idcard,@RequestParam String name) {
		  Result result = new Result();
		  User user = userService.getUserByIdcard(username);
		  if(StringUtils.isBlank(name)) {
	    		result.setCode("0001");
	            result.setMessage("账号不能为空");
	            return result;
	    	}
		  if(StringUtils.isBlank(idcard)) {
	    		result.setCode("0001");
	            result.setMessage("身份证号不能为空");
	            return result;
	    	}
		  if(StringUtils.isBlank(name)) {
	    		result.setCode("0001");
	            result.setMessage("姓名不能为空");
	            return result;
	    	}
		     if (user == null) {
		            result.setCode("0001");
		            result.setMessage("账号不存在");
		            return result;
		        }
		     String localIdcard = user.getIdcard();//获取数据库中的用户身份证号码
		     System.out.println(localIdcard);
		     System.out.println(idcard);
		     if (!idcard.equals(localIdcard)) {
		            result.setCode("0002");
		            result.setMessage("请核对身份证号");
		            return result;
		        }
		     String localName = user.getName();//获取数据库中的用户姓名
		     if (!name.equals(localName)) {
		            result.setCode("0002");
		            result.setMessage("请核对姓名");
		            return result;
		        }
		     String newPassword =DigestUtils.md5DigestAsHex(password.getBytes());
		     user.setPassword(newPassword);
		     userService.updataUser(user);
	  return result;
	  
	  }
	
	
}

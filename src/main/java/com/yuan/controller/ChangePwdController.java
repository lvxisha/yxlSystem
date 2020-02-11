package com.yuan.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuan.model.Result;
import com.yuan.model.User;
import com.yuan.service.UserService;
import com.yuan.utils.SessionConsts;

/**
* @ClassName: ChangePwdController
* @Package com.yuan.controller
* @Description: 修改密码模块
* @author yxl
* @date 2019年9月2日 下午10:57:19
*
*/
@RestController
public class ChangePwdController {
	@Autowired
	public UserService userService;
	/**
	 * 
	 * @Title: changePwd
	 * @Description: 密码变更，通过原来的老密码对比，如果正确就变更成新密码
	 * @author: yxl
	 * @date 2019年9月3日
	 * @param @param session
	 * @param @param password
	 * @param @param changePwd
	 * @param @return 参数
	 * @return Result 返回类型
	 * @throws
	 */
	 @RequestMapping("/changePwd") 
	 public Result changePwd(HttpSession session, @RequestParam String password,@RequestParam String changePwd) {
		  Result result = new Result();
	        User user = (User) session.getAttribute(SessionConsts.SESSION_USER);
	        String localPassword =DigestUtils.md5DigestAsHex(password.getBytes());
	       // System.out.println(user);
	        if(StringUtils.isBlank(password)) {
	    		result.setCode("0001");
	            result.setMessage("密码不能为空");
	            return result;
	    	}
	        if(StringUtils.isBlank(changePwd)) {
	    		result.setCode("0002");
	            result.setMessage("新密码不能为空");
	            return result;
	    	}
	        if(!user.getPassword().equals(localPassword)) {
	    		result.setCode("0003");
	            result.setMessage("密码不正确");
	            return result;
	    	}
	        String newPassword =DigestUtils.md5DigestAsHex(changePwd.getBytes());
		     user.setPassword(newPassword);
		     userService.updataUser(user);
	        return result;
	  
	  }
	
	
}

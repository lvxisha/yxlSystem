	package com.yuan.controller;
	
	import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
	
	import org.apache.commons.lang3.StringUtils;
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
	
	import com.yuan.model.Result;
	import com.yuan.model.User;
	import com.yuan.service.UserService;
	import com.yuan.utils.SessionConsts;
	
	/**
	* @ClassName: InformationController
	* @Package com.yuan.controller
	* @Description: 用户信息展示修改模块
	* @author yxl
	* @date 2019年9月3日 下午12:26:41
	*
	*/
	@RestController
	public class InformationController {
	
		@Autowired
		private UserService userService;
		@RequestMapping("/updateInfomation")
		public Result updateInfomation(HttpSession session, User user) {
			Result result = new Result();
			User info = (User) session.getAttribute(SessionConsts.SESSION_USER);
			if(!StringUtils.isBlank(user.getName())) {
				info.setName(user.getName());
			}
			if(!StringUtils.isBlank(user.getIdcard())) {
				info.setIdcard(user.getIdcard());
			}
			if(!StringUtils.isBlank(user.getTel())) {
				info.setTel(user.getTel());
			}
			if(!StringUtils.isBlank(user.getAddress())) {
				info.setAddress(user.getAddress());
			}
			 info.setSex(user.getSex());	
			 userService.updataUser(info);
			 System.out.println(info);
			 return result;
			
		}
		/**
		 * 
		 * @Title: info
		 * @Description: 获取用户信息的接口
		 * @author: yxl
		 * @param @param session
		 * @param @return 参数
		 * @return Result 返回类型
		 * @throws
		 */
		@RequestMapping(value = "/userInfo")
	    public Result info(HttpSession session) {
	        Result result = new Result();
	        Map<String, Object> data = new HashMap<String, Object>();
	        data.put("user", session.getAttribute(SessionConsts.SESSION_USER));
//	        data.put("roleList", session.getAttribute(SessionConsts.SESSION_ROLE));
//	        data.put("permissionList", session.getAttribute(SessionConsts.SESSION_PERMISSION));
	        result.setData(data);
	        return result; 
	    }
	}

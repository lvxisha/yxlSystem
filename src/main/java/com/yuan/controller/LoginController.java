package com.yuan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuan.model.LoginLog;
import com.yuan.model.Page;
import com.yuan.model.PageResult;
import com.yuan.model.Result;
import com.yuan.model.User;
import com.yuan.service.LoginLogService;
import com.yuan.service.UserService;
import com.yuan.utils.SessionConsts;
import com.yuan.utils.UserAgentUtils;

/**
 * 
* @ClassName: LoginController
* @Package com.yuan.controller
* @Description:用户登录模块控制层
* @author yxl
* @date 2019年8月31日 下午3:53:27
*
 */
@RestController
public class LoginController {

	@Autowired
	public UserService userService;
	@Autowired
	public LoginLogService loginLogService;
	
	/*
	 * @RequestMapping("/login") public String home(String name) { return
	 * "redirect:http://localhost:8080/yxl/views/firstPage.html";
	 * 
	 * }
	 */
	/**
	 * @throws Exception 
	 * 
	 * @Title: login
	 * @Description: 用户登录接口
	 * @author: yxl
	 * @param @param username
	 * @param @param password
	 * @param @return 参数
	 * @return Result 返回类型
	 * @throws
	 */
	@RequestMapping("/login")
	public Result login(HttpServletRequest request,HttpSession session,HttpServletResponse response,@RequestParam String username,@RequestParam String password,@RequestParam(defaultValue = "false") Boolean flag) throws Exception {
        Result result=new Result();
        Map<String, Object> data = new HashMap<String, Object>();
        User user = userService.getUserByUsername(username);
        if(StringUtils.isBlank(username)) {
    		result.setCode("0001");
            result.setMessage("账号不能为空");
            return result;
    	}
    	if(StringUtils.isBlank(password)) {
    		result.setCode("0002");
            result.setMessage("密码不能为空");
            return result;
    	}
        if (user == null) {
            result.setCode("0003");
            result.setMessage("该用户名不存在");
            return result;
        }
        String userPassword = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(userPassword)) {
            result.setCode("0004");
            result.setMessage("密码错误");
            return result;
        }
        Boolean enabled = user.getEnabled();
        if (enabled != true) {
            result.setCode("0005");
            result.setMessage("该账号已被冻结");
            return result;
        }  
        session.setAttribute(SessionConsts.SESSION_USER, user);
     // 记录用户登录日志
        LoginLog loginLog = UserAgentUtils.getLoginLog(request);
        loginLogService.insert(loginLog);
        Integer userId = user.getId();
        int logintimes = loginLogService.selectLoginLogCount(userId);
        session.setAttribute(SessionConsts.SESSION_LOGINLOG, logintimes);
        user.setLogintimes(logintimes);
        userService.updataUser(user);
     // 将用户密码设置为null，防止密码泄露。
        //user.setPassword(null);
        data.put("user", user);
        result.setData(data);
        return result;
    } 
	/**
	 * 
	 * @Title: logout
	 * @Description: 退出系统接口
	 * @author: yxl
	 * @param @param session
	 * @param @return 参数
	 * @return Result 返回类型
	 * @throws
	 */
	  @PostMapping("/logout") 
	  public Result logout(HttpSession session) {
		  Result result = new Result();
	  session.setAttribute(SessionConsts.SESSION_USER, null);
	  return result;
	  
	  }
	 /**
	  * 
	  * @Title: LoginLog
	  * @Description:登录日志实现接口
	  * @author: yxl
	  * @date 2019年9月26日
	  * @param @param session
	  * @param @param userId
	  * @param @param page
	  * @param @return 参数
	  * @return PageResult 返回类型
	  * @throws
	  */
	  @RequestMapping("/LoginLog")
	  public PageResult LoginLog(HttpSession session,Integer userId,Page page) {
		  PageResult pageResult = new PageResult();
		 // int count = loginLogService.selectLoginLogCount(userId);
		  int count = (int) session.getAttribute(SessionConsts.SESSION_LOGINLOG);
		  System.out.println(count);
		  if (count == 0) {
				pageResult.setCode("1111");
				pageResult.setMessage("暂无数据！");
			} else {
				List<LoginLog> data = loginLogService.selectLoginLogInfo(userId,page);
				pageResult.setCount(count);
				pageResult.setData(data);
			}
	  return pageResult;
	  
	  }
	
	
}

package com.yuan.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuan.model.Result;
import com.yuan.model.User;
import com.yuan.service.UserService;
import com.yuan.utils.ResultConsts;

/**
* @ClassName: RegisterController
* @Package register
* @Description: 用户注册模块控制层
* @author yxl
* @date 2019年8月31日 下午3:53:01
*		
*/
@RestController
public class RegisterController {
	@Autowired
	public UserService userService;
	/**
	 * 
	 * @Title: add
	 * @Description: 注册用户信息的接口
	 * @author: yxl
	 * @date 2019年8月31日
	 * @param @param user
	 * @param @return 参数
	 * @return Result 返回类型
	 * @throws
	 */
	@RequestMapping(value = "/user/add"/* , method = RequestMethod.POST */)
	    public Result add(@RequestBody User user) {
		 Result result = new Result();
	     //User user = userService.getUserByUsername(username);
	     //userName是从后台数据库中获取的
	     //String userName=user.getUsername()== null ? null : user.getUsername();
	     String userName = user.getUsername();
	     String passWord = user.getPassword();
	     //System.out.println(userName);
	     User localUserName = userService.getUserByUsername(userName);
		     if (localUserName != null) {
		            result.setCode("0001");
		            result.setMessage("账号已存在");
		            return result;
		        }
		     User localUserIdcard = userService.getUserByIdcard(user.getIdcard());
		     if (localUserIdcard != null) {
		            result.setCode("0002");
		            result.setMessage("身份证号已存在");
		            return result;
		        }
	    	if(StringUtils.isBlank(userName)) {
	    		result.setCode("0003");
	            result.setMessage("账号不能为空");
	            return result;
	    	}
	    	if(StringUtils.isBlank(passWord)) {
	    		result.setCode("0004");
	            result.setMessage("密码不能为空");
	            return result;
	    	}
//	    	//username是从前段页面获取的
//			 if(username.equals(userName)) {
//				result.setCode("0003");
//	            result.setMessage("该账号已存在");
//	            return result;
//			 }
			 try {
				 userService.insertUser(user);
	        } catch (Exception e) {
	            result.setCode(ResultConsts.ERROR_CODE);
	            result.setMessage(ResultConsts.ERROR_MSG);
	            //logger.error("添加用户信息", e);
	          System.out.print("添加用户信息"+e);
	        }
	        return result;
	    }
	 /**
	  * 
	  * @Title: localUserName
	  * @Description: 判断账号是否已经存在接口
	  * @author: yxl
	  * @date 2019年9月2日
	  * @param @param username
	  * @param @return 参数
	  * @return Result 返回类型
	  * @throws
	  */
	 @RequestMapping("/localUserName") 
	 public Result localUserName(@RequestParam String username) {
		  Result result = new Result();
		  User localUserName = userService.getUserByUsername(username);
		     if (localUserName != null) {
		            result.setCode("0001");
		            result.setMessage("账号已存在");
		            return result;
		        }
	  return result;
	  
	  }
	 /**
	  * 
	  * @Title: localUserIdcard
	  * @Description: 判断身份证是否重复接口
	  * @author: yxl
	  * @date 2019年9月2日
	  * @param @param idcard
	  * @param @return 参数
	  * @return Result 返回类型
	  * @throws
	  */
	 @RequestMapping("/localUserIdcard") 
	 public Result localUserIdcard(@RequestParam String idcard) {
		  Result result = new Result();
		  User localUserIdcard = userService.getUserByIdcard(idcard);
		     if (localUserIdcard != null) {
		            result.setCode("0002");
		            result.setMessage("身份证号已存在");
		            return result;
		        }
	  return result;
	  
	  }
}

package com.yuan.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.yuan.model.LoginLog;
import com.yuan.model.User;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

/**
 * 
* @ClassName: UserAgentUtils
* @Package com.yuan.utils
* @Description: 用户代理工具类
* @author yxl
* @date 2019年9月18日 下午4:26:08
*
 */
public class UserAgentUtils {

    /**
     * 
     * @title: getUserAgent
     * @description: 根据http获取userAgent信息
     * @author: yxl
     * @date: 2019年9月18日 下午8:25:41
     * @param request
     * @return
     */
    public static String getUserAgent(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        return userAgent;
    }

    /**
     * 
     * @title: getOsVersion
     * @description: 根据request获取userAgent，然后解析出osVersion
     * @author: yxl
     * @date: 2019年9月18日 下午8:25:50
     * @param request
     * @return
     */
    public static String getOsVersion(HttpServletRequest request) {
        String userAgent = getUserAgent(request);
        return getOsVersion(userAgent);
    }

    /**
     * 
     * @title: getOsVersion
     * @description: 根据userAgent解析出osVersion
     * @author: yxl
     * @date: 2019年9月18日 下午8:25:59
     * @param userAgent
     * @return
     */
    public static String getOsVersion(String userAgent) {
        String osVersion = "";
        /**
         * 判断userAgent的字符串是否为空或长度为0或由空白符(whitespace) 构成：
         * StringUtils.isBlank(null) = true
         */
        if (StringUtils.isBlank(userAgent)) {
            return osVersion;
        }
        String[] strArr = userAgent.substring(userAgent.indexOf("(") + 1, userAgent.indexOf(")")).split(";");
        if (null == strArr || strArr.length == 0) {
            return osVersion;
        }
        osVersion = strArr[1];
        return osVersion;
    }

    /**
     * 
     * @title: getOperatingSystem
     * @description: 获取操作系统对象
     * @author: yxl
     * @date: 2019年9月18日 下午8:26:09
     * @param userAgent
     * @return
     */
    private static OperatingSystem getOperatingSystem(String userAgent) {
        UserAgent agent = UserAgent.parseUserAgentString(userAgent);
        OperatingSystem operatingSystem = agent.getOperatingSystem();
        return operatingSystem;
    }

    /**
     * 
     * @title: getOs
     * @description: 获取os：Windows/ios/Android
     * @author: yxl
     * @date: 2019年9月18日 下午8:26:18
     * @param request
     * @return
     */
    public static String getOs(HttpServletRequest request) {
        String userAgent = getUserAgent(request);
        return getOs(userAgent);
    }

    /**
     * 
     * @title: getOs
     * @description: 获取os：Windows/ios/Android
     * @author: yxl
     * @date: 2019年9月18日 下午8:26:45
     * @param userAgent
     * @return
     */
    public static String getOs(String userAgent) {
        OperatingSystem operatingSystem = getOperatingSystem(userAgent);
        String os = operatingSystem.getGroup().getName();
        return os;
    }

    /**
     * 
     * @title: getDevicetype
     * @description: 获取deviceType
     * @author: yxl
     * @date: 2019年9月18日 下午8:26:54
     * @param request
     * @return
     */
    public static String getDevicetype(HttpServletRequest request) {
        String userAgent = getUserAgent(request);
        return getDevicetype(userAgent);
    }

    /**
     * 
     * @title: getDevicetype
     * @description: 获取deviceType
     * @author: yxl
     * @date: 2019年9月18日 下午8:27:05
     * @param userAgent
     * @return
     */
    public static String getDevicetype(String userAgent) {
        OperatingSystem operatingSystem = getOperatingSystem(userAgent);
        String deviceType = operatingSystem.getDeviceType().toString();
        return deviceType;
    }

    /**
     * 
     * @title: getOsName
     * @description: 获取操作系统的名字
     * @author: yxl
     * @date: 2019年9月18日 下午8:27:12
     * @param request
     * @return
     */
    public static String getOsName(HttpServletRequest request) {
        String userAgent = getUserAgent(request);
        return getOsName(userAgent);
    }

    /**
     * 
     * @title: getOsName
     * @description: 获取操作系统的名字
     * @author: yxl
     * @date: 2019年9月18日 下午8:27:20
     * @param userAgent
     * @return
     */
    public static String getOsName(String userAgent) {
        OperatingSystem operatingSystem = getOperatingSystem(userAgent);
        String osName = operatingSystem.getName();
        return osName;
    }

    /**
     * 
     * @title: getDeviceManufacturer
     * @description: 获取device的生产厂家
     * @author: yxl
     * @date: 2019年9月18日 下午8:27:29
     * @param request
     * @return
     */
    public static String getDeviceManufacturer(HttpServletRequest request) {
        String userAgent = getUserAgent(request);
        return getDeviceManufacturer(userAgent);
    }

    /**
     * 
     * @title: getDeviceManufacturer
     * @description: 获取device的生产厂家
     * @author: yxl
     * @date: 2019年9月18日 下午8:27:41
     * @param userAgent
     * @return
     */
    public static String getDeviceManufacturer(String userAgent) {
        OperatingSystem operatingSystem = getOperatingSystem(userAgent);
        String deviceManufacturer = operatingSystem.getManufacturer().toString();
        return deviceManufacturer;
    }

    /**
     * 
     * @title: getBrowser
     * @description: 获取浏览器对象
     * @author: yxl
     * @date: 2019年9月18日 下午8:27:50
     * @param agent
     * @return
     */
    public static Browser getBrowser(String agent) {
        UserAgent userAgent = UserAgent.parseUserAgentString(agent);
        Browser browser = userAgent.getBrowser();
        return browser;
    }

    /**
     * 
     * @title: getBorderName
     * @description: 获取browser name
     * @author: yxl
     * @date: 2019年9月18日 下午8:27:59
     * @param request
     * @return
     */
    public static String getBorderName(HttpServletRequest request) {
        String userAgent = getUserAgent(request);
        return getBorderName(userAgent);
    }

    /**
     * 
     * @title: getBorderName
     * @description: 获取browser name
     * @author: yxl
     * @date: 2019年9月18日 下午8:28:08
     * @param userAgent
     * @return
     */
    public static String getBorderName(String userAgent) {
        Browser browser = getBrowser(userAgent);
        String borderName = browser.getName();
        return borderName;
    }

    /**
     * 
     * @title: getBorderType
     * @description: 获取浏览器的类型
     * @author: yxl
     * @date: 2019年9月18日 下午8:28:17
     * @param request
     * @return
     */
    public static String getBorderType(HttpServletRequest request) {
        String userAgent = getUserAgent(request);
        return getBorderType(userAgent);
    }

    /**
     * 
     * @title: getBorderType
     * @description: 获取浏览器的类型
     * @author: yxl
     * @date: 2019年9月18日 下午8:28:25
     * @param userAgent
     * @return
     */
    public static String getBorderType(String userAgent) {
        Browser browser = getBrowser(userAgent);
        String borderType = browser.getBrowserType().getName();
        return borderType;
    }

    /**
     * 
     * @title: getBorderGroup
     * @description: 获取浏览器组： CHROME、IE
     * @author: yxl
     * @date: 2019年9月18日 下午8:28:34
     * @param request
     * @return
     */
    public static String getBorderGroup(HttpServletRequest request) {
        String userAgent = getUserAgent(request);
        return getBorderGroup(userAgent);
    }

    /**
     * 
     * @title: getBorderGroup
     * @description: 获取浏览器组： CHROME、IE
     * @author: yxl
     * @date: 2019年9月18日 下午8:28:44
     * @param userAgent
     * @return
     */
    public static String getBorderGroup(String userAgent) {
        Browser browser = getBrowser(userAgent);
        String browerGroup = browser.getGroup().getName();
        return browerGroup;
    }

    /**
     * 
     * @title: getBrowserManufacturer
     * @description: 获取浏览器的生产厂商
     * @author: yxl
     * @date: 2019年9月18日 下午8:28:59
     * @param request
     * @return
     */
    public static String getBrowserManufacturer(HttpServletRequest request) {
        String userAgent = getUserAgent(request);
        return getBrowserManufacturer(userAgent);
    }

    /**
     * 
     * @title: getBrowserManufacturer
     * @description: 获取浏览器的生产厂商
     * @author: yxl
     * @date: 2019年9月18日 下午8:29:16
     * @param userAgent
     * @return
     */
    public static String getBrowserManufacturer(String userAgent) {
        Browser browser = getBrowser(userAgent);
        String browserManufacturer = browser.getManufacturer().getName();
        return browserManufacturer;
    }

    /**
     * 
     * @title: getBorderRenderingEngine
     * @description: 获取浏览器使用的渲染引擎
     * @author: yxl
     * @date: 2019年9月18日 下午8:29:24
     * @param request
     * @return
     */
    public static String getBorderRenderingEngine(HttpServletRequest request) {
        String userAgent = getUserAgent(request);
        return getBorderRenderingEngine(userAgent);
    }

    /**
     * 
     * @title: getBorderRenderingEngine
     * @description: 获取浏览器使用的渲染引擎
     * @author: yxl
     * @date: 2019年9月18日 下午8:29:36
     * @param userAgent
     * @return
     */
    public static String getBorderRenderingEngine(String userAgent) {
        Browser browser = getBrowser(userAgent);
        String renderingEngine = browser.getRenderingEngine().name();
        return renderingEngine;
    }

    /**
     * 
     * @title: getBrowserVersion
     * @description: 获取浏览器版本
     * @author: yxl
     * @date: 2019年9月18日 下午8:29:47
     * @param request
     * @return
     */
    public static String getBrowserVersion(HttpServletRequest request) {
        String userAgent = getUserAgent(request);
        return getBrowserVersion(userAgent);
    }

    /**
     * 
     * @title: getBrowserVersion
     * @description: 获取浏览器版本
     * @author: yxl
     * @date: 2019年9月18日 下午8:29:58
     * @param userAgent
     * @return
     */
    public static String getBrowserVersion(String userAgent) {
        Browser browser = getBrowser(userAgent);
        String borderVersion = browser.getVersion(userAgent).toString();
        return borderVersion;
    }

    public static LoginLog getLoginLog(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        User sessionUser = (User) session.getAttribute(SessionConsts.SESSION_USER);
        String winUserAgent = request.getHeader("User-Agent");
        LoginLog loginLog = new LoginLog();
        String borderRenderingEngine = getBorderRenderingEngine(winUserAgent);
        String browserGroup = getBorderGroup(winUserAgent);
        String browserManufacturer = getBrowserManufacturer(winUserAgent);
        String browserName = getBorderName(winUserAgent);
        String browserType = getBorderType(winUserAgent);
        String browserVersion = getBrowserVersion(winUserAgent);
        String deviceManufacturer = getDeviceManufacturer(winUserAgent);
        String deviceType = getDevicetype(winUserAgent);
        String ip = getIpAddr(request);
        String os = getOs(winUserAgent);
        String osName = getOsName(winUserAgent);
        String osVersion = getOsVersion(winUserAgent);
        Integer userId = sessionUser.getId();
        Date createTime = getCreateTime(request);
        loginLog.setBorderRenderingEngine(borderRenderingEngine);
        loginLog.setBrowserGroup(browserGroup);
        loginLog.setBrowserManufacturer(browserManufacturer);
        loginLog.setBrowserName(browserName);
        loginLog.setBrowserType(browserType);
        loginLog.setBrowserVersion(browserVersion);
        loginLog.setDeviceManufacturer(deviceManufacturer);
        loginLog.setDeviceType(deviceType);
        loginLog.setIp(ip);
        loginLog.setOs(os);
        loginLog.setOsName(osName);
        loginLog.setOsVersion(osVersion);
        loginLog.setUserId(userId);
        loginLog.setCreateTime(createTime);
        return loginLog;
    }

    /**
     * 
     * @title: getIpAddr
     * @description: 获取用户真实IP地址，不使用request.getRemoteAddr()的原因是有可能用户使用了代理软件方式避免真实IP地址,
     *               可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值
     * @author: yxl
     * @date: 2019年9月18日 下午9:11:54
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.indexOf(",") != -1) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    public static Date getCreateTime(HttpServletRequest request) throws Exception {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    String dateStringParse =df.format(new Date());// new Date()为获取当前系统时间
    Date createTime = df.parse(dateStringParse );  
    return createTime;
    }
}

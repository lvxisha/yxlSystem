/**
 * 
 */
package com.yuan.utils;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
//@PropertySource("classpath:application.properties")
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

//    @Autowired
//    private LoginInterceptor loginInterceptor;
//
//    @Value("${attachment.path}")
//    private String attachmentPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        String attachmentPathPrefix = "file:";
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/views/**").addResourceLocations("classpath:/views/");
        registry.addResourceHandler("/public/**").addResourceLocations("classpath:/public/");
//        registry.addResourceHandler("/attachment/**")
//                .addResourceLocations(attachmentPathPrefix + attachmentPath + File.separator);
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/", "/public/views/index.html");
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 登录拦截的管理器
//        InterceptorRegistration registration = registry.addInterceptor(loginInterceptor); // 拦截的对象会进入这个类中进行判断
//        registration.addPathPatterns("/**"); // 所有路径都被拦截
//        registration.excludePathPatterns("/", "/login", "/public/login.html", "/public/aboutus.html",
//                "/public/chanpin.html", "/public/contactWe.html", "/public/error/**", "/static/**", "/attachment/**"); // 添加不拦截路径
//    }

}
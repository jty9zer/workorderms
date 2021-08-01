package com.jiker.workorderms.config;

import com.jiker.workorderms.Interceptor.WorkOrderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * 实现WebMvcConfigurer
 */
@Configuration
public class WorkOrderConfig implements WebMvcConfigurer {

    @Resource
    private WorkOrderInterceptor workOrderInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册自定义拦截器WorkOrderInterceptor，添加拦截路径（"/**"代表拦截所有请求）
        registry.addInterceptor(workOrderInterceptor).addPathPatterns("/**");
    }
}

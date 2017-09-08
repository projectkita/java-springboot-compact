package com.adrianaden.app.interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by adrianaden on 8/4/17.
 */

@Configuration
public class Interceptor extends WebMvcConfigurerAdapter {
	
	@Autowired
	private LogInterceptor logInterceptor;
	@Autowired
	private JwtInterceptor jwtInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor).addPathPatterns("/**");
        registry.addInterceptor(jwtInterceptor).addPathPatterns("/**").excludePathPatterns("/api/auth/login/**");
    }
    
}
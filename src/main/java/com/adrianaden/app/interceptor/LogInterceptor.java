package com.adrianaden.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LogInterceptor implements HandlerInterceptor {
	private Long millis;
    
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {
		millis = System.currentTimeMillis();
		
		MDC.put("Method", httpServletRequest.getMethod());
		log.info("---------------REQUEST---------------");
		log.info("Ticket    : " + millis);
		log.info("Path      : " + httpServletRequest.getRequestURI());
		log.info("Query     : " + httpServletRequest.getQueryString());
		log.info("-------------------------------------");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {
		Long duration = System.currentTimeMillis() - millis;
		log.info("---------------RESPOND---------------");
		log.info("Ticket    : " + millis);
		log.info("Duration  : " + duration + " ms");
		log.info("-------------------------------------");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}

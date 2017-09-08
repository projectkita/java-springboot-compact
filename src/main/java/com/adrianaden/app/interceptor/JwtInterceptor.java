package com.adrianaden.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.adrianaden.app.exception.JwtExceptionHandler;
import com.adrianaden.app.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor {

	@Autowired
	private JwtUtil jwtUtil;

	@Value("${http.header.auth}")
	private String headerAuth;
	
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {
		String token = httpServletRequest.getHeader(headerAuth);
		Boolean isValid = token == null ? false : jwtUtil.isValidJWT(token);
		log.info("Jwt Validation: " + isValid);
		if(!isValid) throw new JwtExceptionHandler("Unauthorization Token");
		return isValid;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}

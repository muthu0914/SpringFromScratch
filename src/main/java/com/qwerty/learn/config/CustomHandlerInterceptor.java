package com.qwerty.learn.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.qwerty.learn.util.JwtValidationUtil;

@Component
public class CustomHandlerInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	JwtValidationUtil jwtValidationUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)
			throws Exception {
		if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
			System.out.println("OPTIONS OK");
			response.setStatus(HttpServletResponse.SC_OK);
			return true;
		} else {
			// Verification token
			String header = request.getHeader("Authorization");
			String token = header.split(" ")[1].trim();
			Boolean isValid = jwtValidationUtil.validateAccessToken(token);
			if (Boolean.TRUE.equals(isValid)) {
				response.setStatus(HttpStatus.OK.value());
				return isValid;
			} else {
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
				return false;
			}
		}
	}
}

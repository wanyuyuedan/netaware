package com.unicom.config;

import com.unicom.model.ErrorJson;
import com.unicom.model.Json;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Value("${web.sessionName}")
	private String SESSION_KEY;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("---------preHandle-------------");
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		
		return true;
		/*HttpSession session = request.getSession();
		if (session.getAttribute(SESSION_KEY) == null) {
			System.out.println("用户未登录！");
			response.setStatus(403);
			returnErrorResponse(response,new ErrorJson("用户未登录"));
			return false;
		}
		return true;*/
	}

	public void returnErrorResponse(HttpServletResponse response, Json json)
			throws IOException, UnsupportedEncodingException {
		OutputStream out = null;
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/json");
			out = response.getOutputStream();
			JSON.writeJSONString(out, json);
			out.flush();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
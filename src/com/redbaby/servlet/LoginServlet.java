package com.redbaby.servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.redbaby.domain.LoginUserInfo;
import com.redbaby.domain.User;
import com.redbaby.util.CommonUtil;
import com.redbaby.util.Constant;


/**
 * 登录
 * POST	/login
 *
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 7813128092154329870L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username != null && password != null && RegisterServlet.contains(new User(username, password))) {
			
			/** Userid, session*/
 				LoginUserInfo loginUserInfo = new LoginUserInfo(1, req.getSession().getId() + "");
				req.getSession().setAttribute("user", loginUserInfo);
				
				Map<String, Object> outMap = new HashMap<String, Object>();
				outMap.put(Constant.RESPONSE, "login");
				
				LoginUserInfo infos = new LoginUserInfo(1000, "usersessionusersessionusersession");
				/** 保存userinfo信息 */
				outMap.put("userinfo", infos);
				CommonUtil.renderJson(resp, outMap);
		} else {
			Map<String, Object> outMap = new HashMap<String, Object>();
			outMap.put(Constant.RESPONSE, "error");
			CommonUtil.renderJson(resp, outMap);
		}
 		 
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}

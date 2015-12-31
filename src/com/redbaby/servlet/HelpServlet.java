package com.redbaby.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.redbaby.domain.Help;
import com.redbaby.util.CommonUtil;
import com.redbaby.util.Constant;


/**
 * 帮助列表
 * GET	/help
 *
 */
public class HelpServlet extends HttpServlet {

	
	private static final long serialVersionUID = 2524254235690334603L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "help");
		
		List<Help> helps = new ArrayList<Help>();
		helps.add(new Help(1, "购物指南", Constant.pic_url));
		helps.add(new Help(2, "配�?�方�?", Constant.pic_url));
		
  		outMap.put("help", helps);
		outMap.put("version", "1.1");
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}

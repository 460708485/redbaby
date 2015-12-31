package com.redbaby.servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.redbaby.util.CommonUtil;
import com.redbaby.util.Constant;


/**
 * 搜索热门关键词
 *
 */
public class SearchRecommend extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "searchrecommend");
		 
		String[] keywords = new String[] {"adidas", "361","nike"};
		
		outMap.put("search_keywords", keywords);
		CommonUtil.renderJson(resp, outMap);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doGet(req, resp);
	};
	
}

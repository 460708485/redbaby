package com.redbaby.servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.redbaby.domain.Version;
import com.redbaby.util.CommonUtil;
import com.redbaby.util.Constant;

/**
 * 版本�?�?
 * GET	/version
 *
 */
public class VersionServlet extends HttpServlet {

	private static final long serialVersionUID = -4451945248856962098L;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "version");
		Version version = new Version(false, "1.1", false, Constant.APK_URL);
		outMap.put("version", version);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}

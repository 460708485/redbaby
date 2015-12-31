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

import com.redbaby.domain.Brand;
import com.redbaby.domain.BrandCategory;
import com.redbaby.util.CommonUtil;
import com.redbaby.util.Constant;


/**
 * 推荐品牌
 * 
 * 
 */
public class BrandServlet extends HttpServlet {

	private static final long serialVersionUID = 1631932517414457194L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "brand");
		List<BrandCategory> creatgroys = new ArrayList<BrandCategory>();
		
		List<Brand> brands = new ArrayList<Brand>();
		for (int i = 0; i < 6; i++) {
			brands.add(new Brand(i + 1000, "奶粉", Constant.pic_url.concat(i + ".png")));
		}
		BrandCategory b1 = new BrandCategory("孕妈专区", brands);
 		creatgroys.add(b1);
		
		brands = new ArrayList<Brand>();
		for (int i = 0; i < 8; i++) {
			brands.add(new Brand(i + 1000, "面粉", Constant.pic_url.concat(i + ".png")));
		}
		b1 = new BrandCategory("营养食品", brands);
		creatgroys.add(b1);
		
		outMap.put("brand", creatgroys);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};

}

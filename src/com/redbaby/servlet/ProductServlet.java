package com.redbaby.servlet;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.redbaby.domain.Product;
import com.redbaby.domain.ProductDetail;
import com.redbaby.util.CommonUtil;
import com.redbaby.util.Constant;



/**
 * 商品详情
 * GET	/product
 *
 */
public class ProductServlet extends HttpServlet {

	 
	private static final long serialVersionUID = -5171023354363648380L;
	private static final String JSON = "application/json";
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
//		Map<String, Object> outMap = new HashMap<String, Object>();
//		outMap.put(Constant.RESPONSE, "product");
//		List<String> product_prom = new ArrayList<String>();
//		product_prom.add("促销信息1");
//		product_prom.add("促销信息2");
//		
//		List<String> pic = new ArrayList<String>();
//		pic.add(Constant.pic_url.concat("image1.png"));
//		pic.add(Constant.pic_url.concat("image2.png"));
//		
//		List<String> bigPic = new ArrayList<String>();
//		bigPic.add(Constant.pic_url.concat("image3.png"));
//		bigPic.add(Constant.pic_url.concat("image4.png"));
//		String id  = req.getParameter("id");
//		System.out.println(id);
//		Map<String, Product> prouducts = CartDataSessionServlet1.prouducts;
//		System.out.println(prouducts.size());
//		Product product = prouducts.get(id);
//		if (product == null) {
//			product = prouducts.get("101");
//		}
// 		ProductDetail productDetail = new ProductDetail(product.getId(), product.getName(), product.getMarketprice(), product.getPrice(), 0, 0, 100, "一般", "YES", 10, product_prom, "快递", pic, bigPic);
//		outMap.put("product", productDetail);
//		CommonUtil.renderJson(resp, outMap);
		String pId = req.getParameter("pId");
		pId = "0";
		String path;
		if (pId.equals("1")) {
			path = CartServlet1.class.getClassLoader().getResource("clothes.txt").getPath();
		} else {
			path = CartServlet1.class.getClassLoader().getResource("naifen.txt").getPath();
		}
		FileReader reader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(reader);
		StringWriter strWriter = new StringWriter();
		String str = null;
		while( (str = bufferedReader.readLine()) != null ) {
			strWriter.append(str);
		}
		
		String content = strWriter.toString();
		String encodeContent = new String(content.getBytes(), "UTF-8");
		
		CommonUtil.render(resp, JSON, encodeContent);
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doGet(req, resp);
	};
}

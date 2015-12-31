package com.redbaby.servlet;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.redbaby.domain.Cart;
import com.redbaby.util.CommonUtil;


/**
 * 进入购物车
 * GET	/cart
 * 
 *
 */
public class CartServlet1 extends HttpServlet {
 
	private static final long serialVersionUID = -6051980893463549109L;
	private static final String JSON = "application/json";
	public static Cart cart;
	static {
		cart = new Cart();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		

	 
//		Cart cart = (Cart) req.getSession().getAttribute("cart");
//		if (cart == null) {
//			cart = new Cart();
//			req.getSession().setAttribute("cart", cart);
//		}
//		System.out.println(cart.productlist.size());
//		outMap.put(Constant.RESPONSE, "cart");
//		outMap.put("cart", cart);
//		CommonUtil.renderJson(resp, outMap);
		String path = CartServlet1.class.getClassLoader().getResource("cart.txt").getPath();
		FileReader reader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(reader);
		StringWriter strWriter = new StringWriter();
		String str = null;
		while( (str = bufferedReader.readLine()) != null ) {
			strWriter.append(str);
		}
		
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html;charset="+"UTF-8");
		String content = strWriter.toString();
		String encodeContent = new String(content.getBytes(), "UTF-8");
		
		CommonUtil.render(resp, JSON, encodeContent);
//		PrintWriter writer = resp.getWriter();
//		writer.write(content);
//		resp.getWriter().flush();
//		writer.close();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}

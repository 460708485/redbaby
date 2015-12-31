package com.redbaby.servlet;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.redbaby.domain.Cart;
import com.redbaby.util.CommonUtil;
import com.redbaby.util.Constant;


/**
 * 进入购物车 
 * GET	/cart
 * 
 *
 */
public class CartServlet extends HttpServlet {
 
	private static final long serialVersionUID = -6051980893463549109L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		

	 
//		Cart cart = (Cart) req.getSession().getAttribute("cart");
//		if (cart == null) {
//			cart = new Cart();
//			req.getSession().setAttribute("cart", cart);
//		}
		ServletContext context = this.getServletContext();
		Cart cart = (Cart) context.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			context.setAttribute("cart", cart);
		}
		System.out.println(cart.productlist.size());
		outMap.put(Constant.RESPONSE, "cart");
		outMap.put("cart", cart);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
}

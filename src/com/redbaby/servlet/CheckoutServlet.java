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

import com.redbaby.domain.Address;
import com.redbaby.domain.Addup;
import com.redbaby.domain.Cart;
import com.redbaby.domain.CheckOut;
import com.redbaby.domain.CheckoutAddup;
import com.redbaby.domain.Delivery;
import com.redbaby.domain.InvoiceInfo;
import com.redbaby.domain.OrderDetail;
import com.redbaby.domain.Payment;
import com.redbaby.util.CommonUtil;
import com.redbaby.util.Constant;



/**
 * 结算中心信息
 * POST	/checkout
 * 
 */
public class CheckoutServlet extends HttpServlet {

	private static final long serialVersionUID = -347298763156672679L;
	private static final String JSON = "application/json";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Map<String, Object> outMap = new HashMap<String, Object>();
//		outMap.put(Constant.RESPONSE, "checkout");
//		
//		Address address_info = new Address(1001, "肖文", "北京市海淀区", "闵庄路");
//		
//		Payment payment_info = new Payment(1);
//		Delivery delivery_info = new Delivery(1);
//		InvoiceInfo invoice_info = new InvoiceInfo(132, "红孩子信息有限公司", "办公用品");
//		Cart cart = (Cart) req.getSession().getAttribute("cart");
//		List<OrderDetail> productlist = cart.getProductlist();
//		
//		List<String> checkout_prom = new ArrayList<String>();
//		checkout_prom.add("促销信息1");
//		checkout_prom.add("促销信息2");;
//		
//		Addup cart_addup = cart.getCart_addup();
//		CheckoutAddup checkout_addup = new CheckoutAddup(cart_addup.getTotal_count(), cart_addup.getTotal_price(), cart_addup.getTotal_point(), 10, 0);
//		CheckOut checkOut = new CheckOut(address_info, payment_info, delivery_info, invoice_info, productlist, checkout_prom, checkout_addup);
//		outMap.put("address_info", checkOut.getAddress_info());
//		outMap.put("payment_info", checkOut.getPayment_info());
//		outMap.put("delivery_info", checkOut.getDelivery_info());
//		outMap.put("invoice_info", checkOut.getInvoice_info());
//		outMap.put("productlist", checkOut.getProductlist());
//		outMap.put("checkout_prom", checkOut.getCheckout_prom());
//		outMap.put("checkout _addup", checkOut.getCheckout_addup());
//		
//		CommonUtil.renderJson(resp, outMap);
		
		
		String path = CartServlet1.class.getClassLoader().getResource("checkout1.txt").getPath();
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

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

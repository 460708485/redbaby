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

import com.redbaby.domain.Address;
import com.redbaby.domain.CheckOut;
import com.redbaby.domain.CheckoutAddup;
import com.redbaby.domain.Delivery;
import com.redbaby.domain.InvoiceInfo;
import com.redbaby.domain.OrderDetail;
import com.redbaby.domain.OrderInfo;
import com.redbaby.domain.Payment;
import com.redbaby.util.CommonUtil;
import com.redbaby.util.Constant;



/**
 * 订单详情
 * GET	/orderdetail
 *
 */
public class OrderDetailServlet extends HttpServlet {

	private static final long serialVersionUID = -7214362164707492245L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "orderdetail");

		Address address_info = new Address(1001, "肖文", "北京市海定区", "闵庄");

		Payment payment_info = new Payment(1);
		Delivery delivery_info = new Delivery(1);
		InvoiceInfo invoice_info = new InvoiceInfo(132, "红孩子信息有限公司", "办公用品");
		List<OrderDetail> productlist = new ArrayList<OrderDetail>();
 		OrderDetail cp = new OrderDetail(1001, "雅培金装", 100.00, Constant.pic_url.concat(1 + ".png"), 1, 100.00, 10, 10,
				false);
		OrderDetail cp1 = new OrderDetail(1002, "雅培金装", 200.00, Constant.pic_url.concat(2 + ".png"), 1, 200.00, 10, 10,
				false);
		OrderDetail cp2 = new OrderDetail(1003, "雅培金装", 300.00, Constant.pic_url.concat(3 + ".png"), 1, 300.00, 10, 10,
				false);
		productlist.add(cp);
		productlist.add(cp1);
		productlist.add(cp2);
		;

		List<String> checkout_prom = new ArrayList<String>();
		checkout_prom.add("促销信息1");
		checkout_prom.add("促销信息2");
		;

		CheckoutAddup checkout_addup = new CheckoutAddup(3, 610.00, 0, 10, 0);
		CheckOut checkOut = new CheckOut(address_info, payment_info, delivery_info, invoice_info, productlist,
				checkout_prom, checkout_addup);
		OrderInfo ords = new OrderInfo("2324244", "已完成", "2011/10/100 12:16:40", 1);
		
		
		outMap.put("order_info", ords);
		outMap.put("address_info", checkOut.getAddress_info());
		outMap.put("payment_info", checkOut.getPayment_info());
		outMap.put("delivery_info", checkOut.getDelivery_info());
		outMap.put("invoice_info", checkOut.getInvoice_info());
		outMap.put("productlist", checkOut.getProductlist());
		outMap.put("checkout_prom", checkOut.getCheckout_prom());
		outMap.put("checkout_addup", checkOut.getCheckout_addup());

 		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};

}

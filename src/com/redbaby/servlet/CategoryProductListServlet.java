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

import com.redbaby.domain.Filter;
import com.redbaby.domain.FilterCategory;
import com.redbaby.domain.ProductList;
import com.redbaby.util.CommonUtil;
import com.redbaby.util.Constant;



/**
 * 商品列表 ->商品详细列表
 * /productlist
 * 
 *
 */
public class CategoryProductListServlet extends HttpServlet {

	private static final long serialVersionUID = -6910542371182881368L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put(Constant.RESPONSE, "category_productlist");
		List<ProductList> productlist = new ArrayList<ProductList>();

		for (int i = 0; i < 10; i++) {
			//			ProductList vo = new ProductList(10000+i, "防辐�?" + i, 1000.00 + i, 800.00, Constant.pic_url.concat(i + ".png"), 100+ i);

			ProductList vo = new ProductList(101, "防辐服" + i, 1000.00 + i, 800.00, Constant.pic_url.concat(i + ".png"), 100+ i);
			productlist.add(vo);
		}
		List<FilterCategory> fcs = new ArrayList<FilterCategory>();
		
		List<Filter> value = new ArrayList<Filter>();
		value.add(new Filter("t1", "红色"));
		value.add(new Filter("t2", "绿色"));
		FilterCategory filterCategory = new FilterCategory("颜色", value); 
		fcs.add(filterCategory);

		value = new ArrayList<Filter>();
		value.add(new Filter("s1", "雅培"));
		value.add(new Filter("s2", "雅士力"));
		filterCategory = new FilterCategory("品牌", value); 
		fcs.add(filterCategory);
		
		
		outMap.put("productlist", productlist);
		outMap.put("category_productlist", fcs);
 		outMap.put("list_filter", fcs);
		CommonUtil.renderJson(resp, outMap);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	};
	
}

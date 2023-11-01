package com.ty.food_application_hibernate.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_application_hibernate.dao.FoodOrderDao;
import com.ty.food_application_hibernate.dao.ItemDao;
import com.ty.food_application_hibernate.dao.UserDao;
import com.ty.food_application_hibernate.dto.FoodOrder;
import com.ty.food_application_hibernate.dto.Item;
import com.ty.food_application_hibernate.dto.User;

@WebServlet(value = "/createorder")
public class AddItemsToOrder extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String itemIds = req.getParameter("item_id");
		String[] item = itemIds.split(",");
		long phone = Long.parseLong(req.getParameter("cname"));
		UserDao dao1 = new UserDao();
		User user = dao1.findUserByPhone(phone);
		List<Item> itemss = new ArrayList<Item>();
		ItemDao dao = new ItemDao();
		double totalprice = 0;
		for (String string : item) {
			int id = Integer.parseInt(string);
			Item itemsss = dao.findItemById(id);
			totalprice = totalprice + itemsss.getPrice();
			itemss.add(itemsss);
		}
		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setContactNumber(phone);
		foodOrder.setCustomerName(user.getName());
		foodOrder.setTotalPrice(totalprice);
		foodOrder.setStatus("Order Recived");
		
		FoodOrderDao foodOrderDao=new FoodOrderDao();
		foodOrderDao.saveFoodOrder(foodOrder);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("shome.jsp");
		dispatcher.forward(req, resp);

	}
}

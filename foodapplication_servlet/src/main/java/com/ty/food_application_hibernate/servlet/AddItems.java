package com.ty.food_application_hibernate.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_application_hibernate.dao.FoodProductDao;
import com.ty.food_application_hibernate.dao.ItemDao;
import com.ty.food_application_hibernate.dto.FoodProduct;
import com.ty.food_application_hibernate.dto.Item;

@WebServlet(value = "/additems")
public class AddItems extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pid=Integer.parseInt(req.getParameter("pid"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		ItemDao itemDao=new ItemDao();
		FoodProductDao dao=new FoodProductDao();
		
		FoodProduct fd=dao.findProductById(pid);
		
		Item item=new Item();
		item.setName(fd.getName());
		item.setPrice((fd.getPrice())*quantity);
		item.setProductId(pid);
		item.setQuantity(quantity);
		item.setType(fd.getType());
		
		itemDao.saveItem(item);
		RequestDispatcher dispatcher=req.getRequestDispatcher("order.jsp");
		dispatcher.forward(req, resp);
		
	}
}

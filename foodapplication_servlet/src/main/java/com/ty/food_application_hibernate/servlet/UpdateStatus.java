package com.ty.food_application_hibernate.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_application_hibernate.dao.FoodOrderDao;
import com.ty.food_application_hibernate.dto.FoodOrder;

@WebServlet(value = "/updatestatus")
public class UpdateStatus extends HttpServlet{
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	
	FoodOrderDao dao=new FoodOrderDao();
	FoodOrder foodOrder=dao.findFoodOrderById(id);
	
	dao.updateFood(foodOrder);
	
	RequestDispatcher dispatcher=req.getRequestDispatcher("shome.jsp");
	dispatcher.forward(req, resp);
}
}

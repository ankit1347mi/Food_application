package com.ty.food_application_hibernate.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_application_hibernate.dao.ItemDao;

@WebServlet(value = "/deleteitem")
public class RemoveItem extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		ItemDao dao=new ItemDao();
		dao.deleteItem(id);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("order.jsp");
		dispatcher.forward(req, resp);
	}
}

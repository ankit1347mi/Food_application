package com.ty.food_application_hibernate.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_application_hibernate.dao.UserDao;
import com.ty.food_application_hibernate.dto.User;

@WebServlet(value = "/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long phone = Long.parseLong(req.getParameter("username"));
		String password = req.getParameter("password");
		UserDao userDao = new UserDao();
		User user = userDao.findUserByPhone(phone);
		String role = "Manager";
		String role1 = "Staff";
		String role2 = "Customer";
		if (phone == user.getPhone() && password.equals(user.getPassword()) && role.equals(user.getRole())) {
			req.setAttribute("user", user);
			RequestDispatcher dispatcher = req.getRequestDispatcher("mhome.jsp");
			dispatcher.forward(req, resp);
		} else if (phone == user.getPhone() && password.equals(user.getPassword()) && role1.equals(user.getRole())) {
			req.setAttribute("user", user);
			RequestDispatcher dispatcher = req.getRequestDispatcher("shome.jsp");
			dispatcher.forward(req, resp);
		}else if(phone == user.getPhone() && password.equals(user.getPassword()) && role2.equals(user.getRole())) {
			req.setAttribute("user", user);
			RequestDispatcher dispatcher = req.getRequestDispatcher("chome.jsp");
			dispatcher.forward(req, resp);
		}
	}
}

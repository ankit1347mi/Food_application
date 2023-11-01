package com.ty.food_application_hibernate.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.food_application_hibernate.dao.UserDao;
import com.ty.food_application_hibernate.dto.User;

@WebServlet(value = "/csignup")
public class AddCustomer extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("full-name");
		long phone = Long.parseLong(req.getParameter("your-phone"));
		String password = req.getParameter("password");
		String cpassword = req.getParameter("comfirm-password");
		UserDao dao = new UserDao();
		User user = new User();
		user.setName(name);
		user.setPhone(phone);
		PrintWriter printWriter = resp.getWriter();
		if (password.equals(cpassword)) {
			user.setPassword(cpassword);
		} else {
			printWriter.print("<html><body><h1>Invalid Crendential</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("customer.jsp");
			dispatcher.include(req, resp);
		}
		try {
			User dbuser = dao.findUserByPhone(phone);
			printWriter.print("<html><body><h1>Already Exists</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("shome.jsp");
			dispatcher.include(req, resp);
		} catch (Exception e) {
			dao.saveUser(user);
			printWriter.print("<html><body><h1>Customer Added Successfully</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("shome.jsp");
			dispatcher.include(req, resp);
		}
		

	}
}

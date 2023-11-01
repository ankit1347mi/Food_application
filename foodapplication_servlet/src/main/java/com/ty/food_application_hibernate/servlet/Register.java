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

@WebServlet(value = "/signup")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("full-name");
		long phone = Long.parseLong(req.getParameter("your-phone"));
		String password=req.getParameter("password");
		String cpassword=req.getParameter("comfirm-password");
		
		User user=new User();
		user.setName(name);
		user.setPhone(phone);
		if (password.equals(cpassword)) {
			user.setPassword(cpassword);
		}else {
			//invalid credential
		}
		
		UserDao userDao=new UserDao();
		userDao.saveStaff(user);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("mhome.jsp");
		dispatcher.forward(req, resp);
		
		

	}
}

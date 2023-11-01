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
import com.ty.food_application_hibernate.dao.FoodProductDao;
import com.ty.food_application_hibernate.dao.MenuDao;
import com.ty.food_application_hibernate.dto.FoodProduct;
import com.ty.food_application_hibernate.dto.Menu;

@WebServlet(value = "/addmenu")
public class AddMenu extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String type = req.getParameter("type");
		String about = req.getParameter("about");
		String avail = req.getParameter("avail");
		double price = Double.parseDouble(req.getParameter("price"));
		FoodProductDao dao = new FoodProductDao();

		FoodProduct food = new FoodProduct();
		food.setName(name);
		food.setType(type);
		food.setAbout(about);
		food.setAvailability(avail);
		food.setPrice(price);
		MenuDao dao2 = new MenuDao();
		Menu menu = dao2.findMenuById(1);
		List<FoodProduct> foodProducts = menu.getFoodProducts();
		foodProducts.add(food);
		dao.saveFoodProduct(food);
		menu.setFoodProducts(foodProducts);
		dao2.saveMenu(menu);

		RequestDispatcher dispatcher = req.getRequestDispatcher("createmenu.jsp");
		dispatcher.forward(req, resp);

	}
}

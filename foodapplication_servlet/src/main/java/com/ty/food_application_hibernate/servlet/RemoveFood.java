package com.ty.food_application_hibernate.servlet;

import java.io.IOException;
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

@WebServlet(value = "/deletefood")
public class RemoveFood extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		MenuDao dao1 = new MenuDao();
		Menu menu = dao1.findMenuById(1);
		FoodProductDao dao=new FoodProductDao();
		FoodProduct food = null;
		List<FoodProduct> products = menu.getFoodProducts();
		for (FoodProduct foodProduct : products) {
			if (foodProduct.getId() == id) {
				food = foodProduct;
				products.remove(foodProduct);
			}
		}
		menu.setFoodProducts(products);
		dao1.saveMenu(menu);
		dao.deleteFoodProduct(id);
		
		RequestDispatcher  dispatcher=req.getRequestDispatcher("createmenu.jsp");
		dispatcher.forward(req, resp);
	}
}

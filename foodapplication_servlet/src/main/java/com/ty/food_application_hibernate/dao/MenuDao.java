package com.ty.food_application_hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_application_hibernate.dto.Branch;
import com.ty.food_application_hibernate.dto.Menu;

public class MenuDao {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ankit");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	public Menu saveMenu(Menu menu) {
		entityTransaction.begin();
		entityManager.merge(menu);
		entityTransaction.commit();
		return menu;
	}

	public boolean deleteMenu(Menu menu) {
		entityTransaction.begin();
		entityManager.remove(menu);
		entityTransaction.commit();
		return true;
	}

	public Menu updateMenu(Menu menu) {
		entityTransaction.begin();
		entityManager.merge(menu);
		entityTransaction.commit();
		return menu;
	}

	public Menu findMenuById(int id) {
		Menu menu = entityManager.find(Menu.class, id);

		if (menu != null) {
			return menu;
		}
		return null;
	}

	public List<Menu> findAllmenu() {
		Query query = entityManager.createQuery("Select m from Menu m");
		List<Menu> menus = query.getResultList();
		if (menus != null) {
			return menus;
		} else {
			return null;
		}
	}
}

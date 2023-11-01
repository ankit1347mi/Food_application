package com.ty.food_application_hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_application_hibernate.dto.FoodProduct;

public class FoodProductDao {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ankit");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	public FoodProduct saveFoodProduct(FoodProduct foodProduct) {
		entityTransaction.begin();
		entityManager.persist(foodProduct);
		entityTransaction.commit();
		return foodProduct;
	}

	public boolean deleteFoodProduct(int id) {
		FoodProduct foodProduct = entityManager.find(FoodProduct.class, id);
		entityTransaction.begin();
		entityManager.remove(foodProduct);
		entityTransaction.commit();
		return true;
	}

	public FoodProduct updateFoodProduct(FoodProduct foodProduct) {
		FoodProduct foodProduct1 = entityManager.find(FoodProduct.class, foodProduct.getId());
		if (foodProduct1 != null) {
			entityTransaction.begin();
			entityManager.merge(foodProduct);
			entityTransaction.commit();
			return foodProduct;
		}
		return null;

	}

	public FoodProduct findProductById(int id) {
		Query query = entityManager.createQuery("select u from FoodProduct u where u.id=?1");
		query.setParameter(1, id);
		FoodProduct foodProducts = (FoodProduct) query.getSingleResult();
		if (foodProducts != null) {
			return foodProducts;
		}
		return null;
	}

	public boolean checkProductById(int id) {
		Query query = entityManager.createQuery("select u from FoodProduct u where u.id=?1");
		query.setParameter(1, id);
		FoodProduct foodProducts = (FoodProduct) query.getSingleResult();
		if (foodProducts != null) {
			return true;
		}
		return false;
	}

	public List<FoodProduct> displayAll() {
		Query query = entityManager.createQuery("select f from FoodProduct f");
		List<FoodProduct> foodProducts = query.getResultList();
		if (foodProducts != null) {
			return foodProducts;
		} else {
			return new ArrayList<FoodProduct>();
		}
	}
}

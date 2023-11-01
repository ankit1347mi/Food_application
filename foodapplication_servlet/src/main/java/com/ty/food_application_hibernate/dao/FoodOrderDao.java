package com.ty.food_application_hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_application_hibernate.dto.FoodOrder;
import com.ty.food_application_hibernate.dto.Item;

public class FoodOrderDao {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ankit");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		entityTransaction.begin();
		entityManager.merge(foodOrder);
		entityTransaction.commit();
		return foodOrder;
	}

	public FoodOrder updateFoodorder(FoodOrder foodOrder, int id) {
		FoodOrder foodOrder1 = entityManager.find(FoodOrder.class, id);
		if (foodOrder1 != null) {
			foodOrder1.setStatus(foodOrder.getStatus());
			foodOrder1.setContactNumber(foodOrder.getContactNumber());
			foodOrder1.setCustomerName(foodOrder.getCustomerName());
			entityTransaction.begin();
			entityManager.merge(foodOrder1);
			entityTransaction.commit();
			return foodOrder;
		}
		return null;
	}

	public boolean removeFoodOreder(int id) {
		FoodOrder foodOrder1 = entityManager.find(FoodOrder.class, id);
		if (foodOrder1 != null) {
			foodOrder1.setUser(null);
			entityTransaction.begin();
			entityManager.remove(foodOrder1);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public FoodOrder findFoodOrderById(int id) {
		FoodOrder foodOrder1 = entityManager.find(FoodOrder.class, id);
		if (foodOrder1 != null) {
			return foodOrder1;
		} else {
			return null;
		}
	}

	public List<FoodOrder> displayAllFoodOrder() {
		Query query = entityManager.createQuery("select f from FoodOrder f");
		List<FoodOrder> foodOrders = query.getResultList();
		if (foodOrders != null) {
			return foodOrders;
		}
		return null;
	}

	public List<FoodOrder> findFoodOrderByPhone(long phone) {
		Query query = entityManager.createQuery("Select o from FoodOrder o where o.contactNumber=?1");
		query.setParameter(1, phone);
		List<FoodOrder> foodOrder1 = query.getResultList();
		if (foodOrder1 != null) {
			return foodOrder1;
		} else {
			return null;
		}
	}

	public FoodOrder updateFood(FoodOrder foodOrder) {
		FoodOrder foodOrder1 = entityManager.find(FoodOrder.class, foodOrder.getId());
		if (foodOrder1 != null) {
			entityTransaction.begin();
			foodOrder1.setStatus("Delivered");
			entityManager.merge(foodOrder1);
			entityTransaction.commit();
			return foodOrder;
		}
		return null;
	}
}

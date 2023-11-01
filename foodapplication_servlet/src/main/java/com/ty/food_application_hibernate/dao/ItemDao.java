package com.ty.food_application_hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_application_hibernate.dto.Item;

public class ItemDao {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ankit");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	public Item saveItem(Item item) {
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
		return item;
	}

	public boolean deleteItem(int itemId) {
		Item item = entityManager.find(Item.class, itemId);
		if (item != null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Item findItemById(int id) {
		Item item = entityManager.find(Item.class, id);
		if (item != null) {
			return item;
		} else {
			return null;
		}
	}

	public Item updateItem(Item item) {
		Item item1 = entityManager.find(Item.class, item.getId());
		if (item1 != null) {
			entityTransaction.begin();
			item.setProductId(item1.getProductId());
			item.setName(item1.getName());
			item.setId(item1.getId());
			item.setType(item1.getType());
			entityManager.merge(entityManager);
			entityTransaction.commit();
			return item;
		} else {
			return null;
		}
	}

	public List<Item> displayAllItem() {
		Query query = entityManager.createQuery("select i from Item i");
		List<Item> items = query.getResultList();
		if (items != null) {
			return items;
		} else {
			return null;
		}

	}
}

package com.ty.food_application_hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_application_hibernate.dto.FoodOrder;
import com.ty.food_application_hibernate.dto.User;

public class UserDao {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ankit");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	public User saveBranchManager(User user) {
		user.setRole("Manager");
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	public User saveStaff(User user) {
		user.setRole("Staff");
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	public boolean saveUser(User user) {
		user.setRole("Customer");
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return true;
	}

	public boolean deleteUser(int id) {
		User user2 = entityManager.find(User.class, id);
		if (user2 != null) {
			entityTransaction.begin();
			entityManager.remove(user2);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public User updateUser(User user) {
		User user2 = entityManager.find(User.class, user.getId());
		if (user2 != null) {
			user.setBranchs(user2.getBranchs());
			user.setId(user2.getId());
			user.setFoodOrders(user2.getFoodOrders());
			user.setRole(user2.getRole());
			user.setMenu(user2.getMenu());
			user.setPhone(user2.getPhone());
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();
			return user;
		}
		return null;
	}

	public List<User> findAllUser() {
		Query query = entityManager.createQuery("select u from User u where u.role=?1");
		query.setParameter(1, "Staff");	
		List<User> users = query.getResultList();
		if (users != null) {
			return users;
		}
		return null;
	}
	public List<User> findAllCustomer() {
		Query query = entityManager.createQuery("select u from User u where u.role=?1");
		query.setParameter(1, "Customer");	
		List<User> users = query.getResultList();
		if (users != null) {
			return users;
		}
		return null;
	}

	public User findUserById(int id) {
		User user = entityManager.find(User.class, id);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	public User findUserByPhone(long phone) {
		Query query = entityManager.createQuery("Select u from User u where u.phone=?1");
		query.setParameter(1, phone);
		User user = (User) query.getSingleResult();
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

}

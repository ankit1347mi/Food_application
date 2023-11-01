package com.ty.food_application_hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food_application_hibernate.dto.Branch;
import com.ty.food_application_hibernate.dto.User;

public class BranchDao {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ankit");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction = entityManager.getTransaction();

	public Branch saveBranch(Branch branch) {
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();
		return branch;
	}

	public boolean deleteBranch(Branch branch) {
		Branch branch2 = entityManager.find(Branch.class, branch.getId());
		if (branch2 != null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public Branch updateBranch(Branch branch) {
		Branch branch2 = entityManager.find(Branch.class, branch.getId());
		if (branch2 != null) {
			entityTransaction.begin();
			entityManager.merge(branch);
			entityTransaction.commit();
			return branch;
		} else {
			return null;
		}
	}

	public List<Branch> displayAllBranch() {
		Query query = entityManager.createQuery("select u from Branch u");
		List<Branch> branchs = query.getResultList();
		if (branchs != null) {
			return branchs;
		}
		return null;
	}

	public Branch findBranchById(int id) {
		Branch branch = entityManager.find(Branch.class, id);
		if (branch != null) {
			return branch;
		} else {
			return null;
		}
	}

}

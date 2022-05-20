package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Home;
import com.revature.utils.HibernateUtil;

public class HomeDAOHibImpl implements HomeDAO{

	@Override
	public List<Home> findAll() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("FROM Home").list();
	}

	@Override
	public Home findByName(String name) {
		Session session = HibernateUtil.getSession();
		return session.get(Home.class, name);
	}

	@Override
	public boolean updateHome(Home home) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.merge(home);
			tx.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		return false;
	}

	@Override
	public boolean deleteHome(String name) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(findByName(name));
			tx.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		return false;
	}

	@Override
	public boolean addHome(Home home) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(home);
			tx.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		return false;
	}

}

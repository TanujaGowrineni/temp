package com.revature.daos;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Avenger;
import com.revature.utils.HibernateUtil;

public class AvengerDAOHibImpl implements AvengerDAO{

	@Override
	public List<Avenger> findAll() {
		Session session = HibernateUtil.getSession();
		List<Avenger> list = session.createQuery("FROM Avenger").list();
		return list;
	}

	@Override
	public Avenger findById(int id) {
		Session session = HibernateUtil.getSession();
		Avenger a = session.get(Avenger.class, id);
		return a;
	}

	@Override
	public boolean addAvenger(Avenger avenger) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.save(avenger);
			tx.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		return false;
	}

	@Override
	public boolean updateAvenger(Avenger avenger) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.merge(avenger);
			tx.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		return false;
	}

	@Override
	public boolean deleteAvenger(int id) {
		Session session = HibernateUtil.getSession();
		try {
			Transaction tx = session.beginTransaction();
			session.delete(findById(id));
			tx.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession();
		}
		return false;
	}

}

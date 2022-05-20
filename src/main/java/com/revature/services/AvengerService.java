package com.revature.services;

import java.util.List;

import com.revature.daos.AvengerDAO;
import com.revature.daos.AvengerDAOHibImpl;
import com.revature.daos.HomeDAO;
import com.revature.daos.HomeDAOHibImpl;
import com.revature.models.Avenger;
import com.revature.models.Home;

public class AvengerService {
	
	AvengerDAO avengerDao = new AvengerDAOHibImpl();
	HomeDAO homeDao = new HomeDAOHibImpl();
	
	public List<Avenger> avengersAssemble(){
		return avengerDao.findAll();
	}

	public List<Avenger> getAllAvengers() {
		return avengersAssemble();
	}

	public boolean addNewAvenger(Avenger avenger) {
		if(avenger.getHome()!=null&&avenger.getHome().getHomeName()!=null) {
			Home home = homeDao.findByName(avenger.getHome().getHomeName());
			avenger.setHome(home);
		}
		return avengerDao.addAvenger(avenger);
	}

	public Avenger getSingleAvenger(int id) {
		return avengerDao.findById(id);
	}

}

package com.revature.services;

import java.util.List;

import com.revature.daos.HomeDAO;
import com.revature.daos.HomeDAOHibImpl;
import com.revature.daos.HomeDAOImpl;
import com.revature.models.Home;

public class HomeService {
	
	private HomeDAO homeDao = new HomeDAOHibImpl(); 
	
	public List<Home> getAllHomes(){
		return homeDao.findAll();
	}

	public Home getSingleHome(String homeName) {
		return homeDao.findByName(homeName);
	}
	
	public boolean addNewHome(String homeName, String streetNum, String streetName,
			String city, String region, String postCode, String country) {
		Home home = new Home(homeName, streetNum, streetName, city, region, postCode, country);
		if(homeDao.addHome(home)) {
			return true;
		}
		return false;
	}

	public boolean updateHome(Home home) {
		if(homeDao.updateHome(home)) {
			return true;
		}
		return false;
	}

	public boolean destroyHome(String homeName) {
		return homeDao.deleteHome(homeName);
	}

	public boolean addNewHome(Home home) {
		if(homeDao.addHome(home)) {
			return true;
		}
		return false;
	}
}

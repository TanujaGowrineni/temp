package com.revature.daos;

import java.util.List;

import com.revature.models.Home;

public interface HomeDAO {
	
	public List<Home> findAll();
	public Home findByName(String name);
	public boolean updateHome(Home home);
	public boolean deleteHome(String name);
	public boolean addHome(Home home);

}

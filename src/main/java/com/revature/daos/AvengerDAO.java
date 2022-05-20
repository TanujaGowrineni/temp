package com.revature.daos;

import java.util.List;

import com.revature.models.Avenger;

public interface AvengerDAO {
	
	public List<Avenger> findAll();
	public Avenger findById(int id);
	public boolean addAvenger(Avenger avenger);
	public boolean updateAvenger(Avenger avenger);
	public boolean deleteAvenger(int id);

}

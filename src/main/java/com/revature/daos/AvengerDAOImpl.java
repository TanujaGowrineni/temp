package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Avenger;
import com.revature.models.Home;
import com.revature.utils.ConnectionUtil;

public class AvengerDAOImpl implements AvengerDAO{
	
	private HomeDAO homeDAO = new HomeDAOImpl();

	@Override
	public List<Avenger> findAll() {
		try(Connection conn = ConnectionUtil.getInstance().getConnection()){
			String sql = "SELECT * FROM avengers;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Avenger> list = new ArrayList<>();
			
			while(result.next()) {
				Avenger avenger = new Avenger(
						result.getInt("hero_id"),
						result.getString("hero_name"),
						result.getString("hero_power"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getInt("power_level"),
						null
						);
				String homeName = result.getString("home_name_fk");
				if(homeName!=null) {
					Home home = homeDAO.findByName(homeName);
					avenger.setHome(home);
				}
				list.add(avenger);
			}
			
			return list;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Avenger findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAvenger(Avenger avenger) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAvenger(Avenger avenger) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAvenger(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}

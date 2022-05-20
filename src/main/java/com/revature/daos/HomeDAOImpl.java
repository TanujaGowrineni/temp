package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Home;
import com.revature.utils.ConnectionUtil;

public class HomeDAOImpl implements HomeDAO{

	@Override
	public List<Home> findAll() {
		try(Connection conn = ConnectionUtil.getInstance().getConnection()){
			String sql = "SELECT * FROM homes;";
			
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Home> list = new ArrayList<>();
			
			while(result.next()) {
				Home home = new Home();
				home.setHomeName(result.getString("home_name"));
				home.setAddrStreetName(result.getString("addr_street_name"));
				home.setAddrStreetNum(result.getString("addr_street_num"));
				home.setAddrCity(result.getString("addr_city"));
				home.setAddrRegion(result.getString("addr_region"));
				home.setAddrPostCode(result.getString("addr_post_code"));
				home.setAddrCountry(result.getString("addr_country"));
				list.add(home);
			}
			
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Home findByName(String name) {
		try(Connection conn = ConnectionUtil.getInstance().getConnection()){
			String sql = "SELECT * FROM homes WHERE home_name = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				Home home = new Home();
				home.setHomeName(result.getString("home_name"));
				home.setAddrStreetName(result.getString("addr_street_name"));
				home.setAddrStreetNum(result.getString("addr_street_num"));
				home.setAddrCity(result.getString("addr_city"));
				home.setAddrRegion(result.getString("addr_region"));
				home.setAddrPostCode(result.getString("addr_post_code"));
				home.setAddrCountry(result.getString("addr_country"));
				return home;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateHome(Home home) {
		try(Connection conn = ConnectionUtil.getInstance().getConnection()){
			String sql = "UPDATE homes SET home_name=?, addr_street_num=?, "
					+ "addr_street_name=?, addr_city=?, addr_region=?, addr_post_code=?, addr_country=? "
					+ "WHERE home_name = ?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0;
			
			statement.setString(++count, home.getHomeName());
			statement.setString(++count, home.getAddrStreetNum());
			statement.setString(++count, home.getAddrStreetName());
			statement.setString(++count, home.getAddrCity());
			statement.setString(++count, home.getAddrRegion());
			statement.setString(++count, home.getAddrPostCode());
			statement.setString(++count, home.getAddrCountry());
			statement.setString(++count, home.getHomeName());
			
			statement.execute();
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteHome(String name) {
		try(Connection conn = ConnectionUtil.getInstance().getConnection()){
			String sql = "DELETE FROM homes WHERE home_name = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, name);
			
			statement.execute();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addHome(Home home) {
		try(Connection conn = ConnectionUtil.getInstance().getConnection()){
			String sql = "INSERT INTO homes (home_name, addr_street_num, "
					+ "addr_street_name, addr_city, addr_region, addr_post_code, addr_country) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int count = 0;
			
			statement.setString(++count, home.getHomeName());
			statement.setString(++count, home.getAddrStreetNum());
			statement.setString(++count, home.getAddrStreetName());
			statement.setString(++count, home.getAddrCity());
			statement.setString(++count, home.getAddrRegion());
			statement.setString(++count, home.getAddrPostCode());
			statement.setString(++count, home.getAddrCountry());
			
			statement.execute();
			
			return true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

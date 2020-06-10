package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.veganFoods;

public class foodsDao {
	
	private Connection connection;
	private final String GET_VEGAN_FOOD_QUERY = "SELECT * FROM foods";
	private final String GET_VEGAN_FOOD_BY_TASTE_QUERY = "INSERT INTO foods(name, taste) VALUES(?,?)";
	private final String GET_VEGAN_FOOD_BY_TEXTURE_QUERY = "INSERT INTO foods(name, texture) VALUES(?,?)";
	private final String UPDATE_VEGAN_FOOD_QUERY = "UPDATE foods SET name = ?, taste = ?, texture = ? WHERE id = ?";
	private final String DELETE_VEGAN_FOOD_QUERY = "DELETE FROM foods WHERE id = ?";
	
	
	public foodsDao() {
		connection = DBconnection.getConnection();
	}
	
	public List<veganFoods> getVeganFoods() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_VEGAN_FOOD_QUERY).executeQuery();
		List<veganFoods> veganFoods = new ArrayList<veganFoods>();
		
		while(rs.next()) {
			veganFoods.add(populateVeganFoods(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4)));
		}
		
		return veganFoods;
	}
	
	public void getVeganFoodByTaste(String name, String taste) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_VEGAN_FOOD_BY_TASTE_QUERY);
		ps.setString(1, name);
		ps.setString(2, taste);
		ps.executeUpdate();
	}
	
	public void getVeganFoodByTexture(String name, String texture) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_VEGAN_FOOD_BY_TEXTURE_QUERY);
		ps.setString(1, name);
		ps.setString(2, texture);
		ps.executeUpdate();
	}
	
	public void updateVeganFood(String name, String taste, String texture, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_VEGAN_FOOD_QUERY);
		ps.setString(1, name);
		ps.setString(2, taste);
		ps.setString(3, texture);
		ps.setInt(4, id);
		ps.executeUpdate();
	}
	
	public void deleteVeganFood(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_VEGAN_FOOD_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	
	
	private veganFoods populateVeganFoods(int id, String name, String taste, String texture) {
		return new veganFoods(id, name, taste, texture);
	}
}
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Plant;

public class PlantDAO {

	private Connection connection;
	private final String GET_PLANTS_QUERY = "SELECT * FROM plants" ;
	private final String GET_PLANT_BY_ID_QUERY = "SELECT * FROM plants WHERE plant_id = ?";
	private final String CREATE_NEW_PLANT_QUERY = "INSERT INTO plants(plant_name) VALUES (?)";
	private final String DELETE_PLANT_BY_ID_QUERY = "DELETE FROM plants WHERE plant_id = ?";
	private final String UPDATE_PLANT_BY_ID_QUERY = "UPDATE plants SET plant_name = ? WHERE plant_id = ?";
	
	public PlantDAO() {
		connection = DBConnection.getConnection();
	}
	// creates a list of plants
	public List<Plant> getPlants() throws SQLException{
		ResultSet rs = connection.prepareStatement(GET_PLANTS_QUERY).executeQuery();
		List<Plant> plants = new ArrayList<Plant>();
		
		while (rs.next()) {
			plants.add(populatePlant(rs.getInt(1), rs.getString(2)));
		}
		
		return plants;
		
	}
	// gets plant from db by id
	public Plant getPlantById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_PLANT_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populatePlant(rs.getInt(1), rs.getString(2));
	}
	// returns plant list
	private Plant populatePlant(int plantId, String plantName) {
		return new Plant(plantId, plantName);
	}
	// creates new plant with user input 
	public void createNewPlant(String plantName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_PLANT_QUERY);
		ps.setString(1, plantName);
		ps.executeUpdate();
		 
	}
	// deletes plant by id
	public void deletePlantById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_PLANT_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();		
		
		
	}
	//updates plant by id with user input
	public void updatePlantById(int id, String plantName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_PLANT_BY_ID_QUERY);
		ps.setString(1, plantName);
		ps.setInt(2, id);
		ps.executeUpdate();
		
		
	}
}

package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.PlantDAO; 
import entity.Plant;

public class Menu {
	
	private PlantDAO plantDao = new PlantDAO();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display All Plants" , 
			"Display A Plant", 
			"Enter New plant",
			"Delete a Plant",
			"Update a Plant");
			
	
	// loop for selection menu
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			try {
				if (selection.equals("1")) {
				displayPlants();
			} else if (selection.equals("2")) {
				displayPlant();
			} else if (selection.equals("3")) {
				createPlant();
			}else if (selection.equals("4")) {
				deletePlant();
			}else if (selection.equals("5")) {
				updatePlant();
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			
			System.out.println("Press enter to continue ....");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}
	// update plant
	private void updatePlant() throws SQLException {
		System.out.print("Enter Plant ID you wish to update: ");
		int plantId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter New Plant Name: ");
		String plantName = scanner.nextLine();
		plantDao.updatePlantById(plantId,plantName);
		
	}
	//delete plant
	private void deletePlant() throws SQLException {
		System.out.print("Enter Plant ID you wish to delete: ");
		int plantId = scanner.nextInt();
		plantDao.deletePlantById(plantId);
		
	}
	//create plant
	private void createPlant() throws SQLException {
		System.out.print("Enter new Plant name: ");
		String plantName = scanner.nextLine();
		plantDao.createNewPlant(plantName);
		
	}
	//displays menu
	private void printMenu() {
		System.out.println("Select an Option: \n -----------------------------");
		
		for(int i= 0; i< options.size(); i++) {
			System.out.println(i+1 + ") " + options.get(i));
		}
		
	
	}
	//display all plants
	private void displayPlants() throws SQLException {
		List<Plant> plants = plantDao.getPlants();
		for (Plant plant : plants) {
			System.out.println(plant.getPlantId() + ": " + plant.getPlantName() );
		}
	}
	// display one plant
	private void displayPlant() throws SQLException {
		System.out.print("Enter plant id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Plant plant = plantDao.getPlantById(id);
		System.out.println(plant.getPlantId()+ " : " + plant.getPlantName());
		
	}
	
	
} 

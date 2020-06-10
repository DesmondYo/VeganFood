package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.foodsDao;
import entity.veganFoods;

public class Menu {
	
	private foodsDao foodsDao = new foodsDao();
	private Scanner sc = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display Vegan Foods",
			"Vegan Food Taste",
			"Vegan Food Textures",
			"Update a Vegan Food",
			"Delete a Vegan Food");

	public void start() {
		String selection = "";
		  
		do {
			printMenu();
			selection = sc.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayVeganFoods();
				} else if (selection.equals("2")) {
					veganFoodTaste();
				} else if (selection.equals("3")) {
					veganFoodTexture();
				} else if (selection.equals("4")) {
					updateAVeganFood();
				} else if (selection.equals("5")) {
					deleteAVeganFood();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
			System.out.println("Vegan's please press enter to continue...");
			sc.nextLine();
		} while (!selection.equals("-1"));
	}
	
	private void printMenu() {
		System.out.println("Select your favorite Vegan choice: \n------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayVeganFoods() throws SQLException {
		List<veganFoods> veganFoods = foodsDao.getVeganFoods();
		for(veganFoods veganFood : veganFoods) {
			System.out.println(veganFood.getFoodId() + ": " + veganFood.getName() + ", " + veganFood.getTaste() + ", " + veganFood.getTexture());
		}
	}
	
	public void veganFoodTaste() throws SQLException {
		System.out.println("Enter your favorite vegan food: ");
		String name = sc.nextLine();
		System.out.println("Describe the foods taste: ");
		String taste = sc.nextLine();
		foodsDao.getVeganFoodByTaste(name, taste);
	}
	
	public void veganFoodTexture() throws SQLException {
		System.out.println("Enter your favorite vegan food: ");
		String name = sc.nextLine();
		System.out.println("Describe the foods texture: ");
		String texture = sc.nextLine();
		foodsDao.getVeganFoodByTaste(name, texture);
	}
	
	public void updateAVeganFood() throws SQLException {
		System.out.println("Select what you want to update: ");
		String name = sc.nextLine();
		System.out.println("Update the foods taste: ");
		String taste = sc.nextLine();
		System.out.println("Update the texture: ");
		String texture = sc.nextLine();
		System.out.println("Enter Id: ");
		int id = Integer.parseInt(sc.nextLine());
		foodsDao.updateVeganFood(name, taste, texture, id);
	}
	
	public void deleteAVeganFood() throws SQLException {
		System.out.println("Enter the Food ID you want to delete: ");
		int id = Integer.parseInt(sc.nextLine());
		foodsDao.deleteVeganFood(id);
	}
}
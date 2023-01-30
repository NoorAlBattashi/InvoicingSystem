/**
 * 
 */
package com.invo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.Inflater;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.KebabCaseStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author LAP-9
 *
 */
public class App {
	public static String filePath = "data/Items.json";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GroceryShop myShop = new GroceryShop("Grocery Shop");

		// Sub Menu for Shop Settings
		Menu subMenuShopSettings = new Menu();
		subMenuShopSettings.addMenuItem(new MenuItem(1, "Load Data"));
		subMenuShopSettings.addMenuItem(new MenuItem(2, "Set Shop Name"));
		subMenuShopSettings.addMenuItem(new MenuItem(3, "Set Invoice Header"));
		subMenuShopSettings.addMenuItem(new MenuItem(4, "Go Back"));

		// Items for Sub Menu, Shop Settings
		MenuItem ShopSettingsMenuItem = new MenuItem(1, "Shop Settings");
		ShopSettingsMenuItem.markTheItemAsMenu(subMenuShopSettings);

		// Sub Menu for Manage Shop Items
		Menu subMenuManageShopItems = new Menu();
		subMenuManageShopItems.addMenuItem(new MenuItem(1, "Add Items"));
		subMenuManageShopItems.addMenuItem(new MenuItem(2, "Delete Items"));
		subMenuManageShopItems.addMenuItem(new MenuItem(3, "Change Item Price"));
		subMenuManageShopItems.addMenuItem(new MenuItem(4, "Report All Items"));
		subMenuManageShopItems.addMenuItem(new MenuItem(5, "Go Back"));

		// Items for Sub Menu, Shop Settings
		MenuItem ManageShopItemsMenuItem = new MenuItem(2, "Manage Shop Items");
		ManageShopItemsMenuItem.markTheItemAsMenu(subMenuManageShopItems);

		// Create the main menu
		Menu mainMenu = new Menu();
		mainMenu.addMenuItem(ShopSettingsMenuItem);
		mainMenu.addMenuItem(ManageShopItemsMenuItem);
		mainMenu.addMenuItem(new MenuItem(3, "Create New Invoice"));
		mainMenu.addMenuItem(new MenuItem(4, "Report: Statistics (No Of Items, No of Invoices, Total Sales)"));
		mainMenu.addMenuItem(new MenuItem(5, "Report: All Invoices"));
		mainMenu.addMenuItem(new MenuItem(6, "Search (1) Invoice"));
		mainMenu.addMenuItem(new MenuItem(7, "Program Statistics"));
		mainMenu.addMenuItem(new MenuItem(8, "Exit"));

		// print the menu
		mainMenu.printMenuItems();

		// let the user select from the menu
		System.out.print("Enter your choice: ");
		int choice = intScanner();
		try {
			switch (choice) {
			case 1: {
				// Shop Settings
				MenuItem currMenuItem = mainMenu.getMenuItem(1);
				currMenuItem.menu.printMenuItems();
				System.out.println();

				// let the user select from the sub menu
				System.out.print("Enter your choice: ");
				int choiceShopSettingsSubMenu = intScanner();

				try {
					switch (choiceShopSettingsSubMenu) {
					case 1: {

					}
					}
				} catch (IllegalArgumentException ex) {
					System.out.println("Error: " + ex.getMessage());
				}

			}
			case 2: {
				// Manage Shop Items
				MenuItem currMenuItem = mainMenu.getMenuItem(2);
				currMenuItem.menu.printMenuItems();
				System.out.println();

				// let the user select from the sub menu
				System.out.print("Enter your choice: ");
				int choiceManageShopItemsSubMenu = intScanner();
				try {
					switch (choiceManageShopItemsSubMenu) {
					case 1: {
						// Add Items
						System.out.println("Please write the details of the item:");
						// ask the user to enter the itemID
						System.out.print("Write the item id: ");
						int theItemID = intScanner();

						// ask the user to enter the item name
						System.out.print("Write the item name: ");
						String name = stringScanner();

						// ask the user to enter the unit Price
						System.out.print("Write the unit price: ");
						double unitPrice = doubleScanner();

						// ask the user to enter the quantity
						System.out.print("Write the quantity: ");
						int quantity = intScanner();

						// Store the data
						Item addNewItem = new Item(theItemID, name, unitPrice, quantity);
						myShop.addItem(addNewItem);
						myShop.storeItem(myShop.itemsArrayList);

					}
					case 2: {}
					case 3: {}
					case 4: {
						//Show Items
						myShop.showItem();
					}
					case 5: {}
					}
				} catch (IllegalArgumentException ex) {
					System.out.println("Error: " + ex.getMessage());
				}

			}

			case 3: {
				// Create New Invoice
				System.out.println();
			}
			case 4: {
				// Report: Statistics
				System.out.println();
			}
			case 5: {
				// Report: All Invoices
				System.out.println();
			}
			case 6: {
				// Search (1) Invoice
				System.out.println();
			}
			case 7: {
				// Program Statistics
				System.out.println();
			}
			case 8: {
				// Exit
				System.out.println();
			}
			}
		} catch (IllegalArgumentException ex) {
			System.out.println("Error: " + ex.getMessage());

		}

	}

	public static int intScanner() {
		try {
			Scanner inputScanner = new Scanner(System.in);
			int outputValue = inputScanner.nextInt();
			return outputValue;
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. It must be an integer.");
			System.out.print("Enter again here: ");
			return intScanner();
		}
	}

	public static String stringScanner() {
		try {
			Scanner inputScanner = new Scanner(System.in);
			String outputValue = inputScanner.nextLine();
			return outputValue;
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. It must be a string.");
			System.out.print("Enter again here: ");
			return stringScanner();
		}
	}

	public static double doubleScanner() {
		try {
			Scanner inputScanner = new Scanner(System.in);
			double outputValue = inputScanner.nextDouble();
			return outputValue;
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. It must be a double.");
			System.out.print("Enter again here: ");
			return doubleScanner();
		}
	}

}

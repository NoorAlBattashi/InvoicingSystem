/**
 * 
 */
package com.invo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
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
		Scanner menuScanner = new Scanner(System.in);
		Integer choice = Integer.parseInt(menuScanner.nextLine());

		switch (choice) {
		case 1: {
			// Shop Settings
			MenuItem currMenuItem = mainMenu.getMenuItem(1);
			currMenuItem.menu.printMenuItems();
			System.out.println();

			// let the user select from the sub menu
			System.out.print("Enter your choice: ");
			Scanner ShopSettingsSubMenuScanner = new Scanner(System.in);
			Integer choiceShopSettingsSubMenu = Integer.parseInt(ShopSettingsSubMenuScanner.nextLine());

			if (choiceShopSettingsSubMenu == 1) {

			}
		}
		case 2: {
			// Manage Shop Items
			MenuItem currMenuItem = mainMenu.getMenuItem(2);
			currMenuItem.menu.printMenuItems();
			System.out.println();
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
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}

	}

	public static int itemId() {
		// ask the user to enter the itemID
		System.out.print("Write the item id: ");
		Scanner itemIdScanner = new Scanner(System.in);
		int itemID = itemIdScanner.nextInt();
		return itemID;
	}
}

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

		Menu parentMenu = new Menu();
		parentMenu.addMenuItem(ShopSettingsMenuItem);
		parentMenu.addMenuItem(ManageShopItemsMenuItem);
		parentMenu.addMenuItem(new MenuItem(3, "Create New Invoice"));
		parentMenu.addMenuItem(new MenuItem(4, "Report: Statistics"));
		parentMenu.addMenuItem(new MenuItem(5, "Report: All Invoices"));
		parentMenu.addMenuItem(new MenuItem(6, "Search"));
		parentMenu.addMenuItem(new MenuItem(7, "Program Statistics"));
		parentMenu.addMenuItem(new MenuItem(8, "Exit"));
		parentMenu.printMenuItems();

		// Get the data from the user
		System.out.print("Enter your choice: ");
		Scanner menuScanner = new Scanner(System.in);
		Integer choice = Integer.parseInt(menuScanner.nextLine());

		if (choice == 1) {
			MenuItem currMenuItem = parentMenu.getMenuItem(1);
			currMenuItem.menu.printMenuItems();
			System.out.println();

			// Get the data from the user
			System.out.print("Enter your choice: ");
			Scanner ShopSettingsSubMenuScanner = new Scanner(System.in);
			Integer choiceShopSettingsSubMenu = Integer.parseInt(ShopSettingsSubMenuScanner.nextLine());

			if (choiceShopSettingsSubMenu == 1) {

			}
		} else if (choice == 2) {
			MenuItem currMenuItem = parentMenu.getMenuItem(2);
			currMenuItem.menu.printMenuItems();
			System.out.println();

			// Get the data from the user
			System.out.print("Enter your choice: ");
			Scanner ManageShopItemsSubMenuScanner = new Scanner(System.in);
			Integer choiceManageShopItemsSubMenu = Integer.parseInt(ManageShopItemsSubMenuScanner.nextLine());

			if (choiceManageShopItemsSubMenu == 1) {
				System.out.println("Please write the details of the item:");
				//ask the user to enter the itemID
				int theItemID = itemId();
				
				//ask the user to enter the item name
				System.out.print("Write the item name: ");
				Scanner itemNameScanner = new Scanner(System.in);
				String name = itemNameScanner.nextLine();
				
				//ask the user to enter the unit Price
				System.out.print("Write the unit price: "); 
				Scanner unitPriceScanner = new Scanner(System.in);
				double unitPrice = itemNameScanner.nextDouble();
				
				//ask the user to enter the quantity
				System.out.print("Write the quantity: "); 
				Scanner quantityScanner = new Scanner(System.in);
				int quantity = quantityScanner.nextInt();
				
				//Store the data
				Item addItem = new Item(theItemID, name, unitPrice, quantity);
				GroceryShop newItem = new GroceryShop();
				newItem.addItem(addItem);
			}
			else if (choiceManageShopItemsSubMenu == 2) {
				// Read json file
				try {
					Scanner fileScanner = new Scanner(filePath);
					//HashMap<Integer, ArrayList<Item>> storeData = new HashMap<Integer, ArrayList<Item>>();
					while (fileScanner.hasNextLine()) {
						// read from json file, convert json to hash map
						Gson gson = new GsonBuilder().create();
						Type type = new TypeToken<ArrayList<Item>>() {
						}.getType();
						ArrayList<Item> myMap = gson.fromJson(fileScanner.nextLine(), type);

						//ArrayList<Item> items = myMap.get("1");
				        for (Item item : myMap) {
				            System.out.println(item.itemID + " " + item.name + " " + item.unitPrice + " " + item.quantity);
				        }
					}

					fileScanner.close();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		// System.out.println("[INFO] Exiting.");

	}

	public  static int itemId () {
		//ask the user to enter the itemID
		System.out.print("Write the item id: ");
		Scanner itemIdScanner = new Scanner(System.in);
		int itemID = itemIdScanner.nextInt();
		return itemID;
	}
}

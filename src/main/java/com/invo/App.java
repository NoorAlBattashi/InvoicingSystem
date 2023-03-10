/**
 * 
 */
package com.invo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
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
	public static String itemFilePath = "data/Items.json";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GroceryShop myShop = new GroceryShop();
		Report generateReport = new Report();
		boolean again = true;
		int option1 = 0;
		int option2 = 0;
		int option3 = 0;
		int option4 = 0;
		int option5 = 0;
		int option6 = 0;
		while (again) {
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
			switch (choice) {
			case 1: {
				// Shop Settings
				MenuItem currMenuItem = mainMenu.getMenuItem(1);
				currMenuItem.menu.printMenuItems();
				System.out.println();

				// let the user select from the sub menu
				System.out.print("Enter your choice: ");
				int choiceShopSettingsSubMenu = intScanner();
				option1++;
				try {
					switch (choiceShopSettingsSubMenu) {
					case 1: {// Load Data
						System.out.print("The Items: ");
						System.out.println();
						myShop.showItem();
						System.out.println();
						System.out.println("==============================");
						System.out.print("The Invoices: ");
						System.out.println();
						generateReport.allInvoice();
						System.out.println();
						break;
					}
					case 2: {// Set Shop Name
						System.out.print("Set the Shop Name: ");
						String shopName = stringScanner();
						myShop.SetGroceryShopName(shopName);
						System.out.println();
						break;
					}

					case 3: {// Set Invoice Header
						System.out.print("Set the Shop telephone: ");
						String tel = stringScanner();
						System.out.print("Set the Shop fax: ");
						String fax = stringScanner();
						System.out.print("Set the Shop email: ");
						String email = stringScanner();
						System.out.print("Set the Shop website: ");
						String website = stringScanner();
						myShop.SetinvoiceHeader(tel, fax, email, website);
						System.out.println();
						break;
					}
					case 4: {// Go Back
						again = true;
						System.out.println();
						break;

					}
					}
				} catch (IllegalArgumentException ex) {
					System.out.println("Error: " + ex.getMessage());
				}
				break;
			}
			case 2: {
				// Manage Shop Items
				MenuItem currMenuItem = mainMenu.getMenuItem(2);
				currMenuItem.menu.printMenuItems();
				System.out.println();

				// let the user select from the sub menu
				System.out.print("Enter your choice: ");
				int choiceManageShopItemsSubMenu = intScanner();
				option2++;
				try {
					switch (choiceManageShopItemsSubMenu) {
					case 1: {
						// Add Items
						System.out.println("You want to add this item in the customer cart or the shop?");
						System.out.println("1- The customer cart ");
						System.out.println("2- The shop");
						System.out.print("Here: ");
						int userChoice = intScanner();
						if (userChoice == 1) {
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
							myShop.addItemInCart(addNewItem);
							System.out.println();
						} else if (userChoice == 2) {
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
							myShop.storeItem(addNewItem);
							System.out.println();
						}

						break;

					}
					case 2: {
						// Delete Items
						System.out.print("Write the item id: ");
						int itemId = intScanner();
						myShop.deleteItem(itemId);
						System.out.println();
						break;
					}
					case 3: {
						// Change Item Price
						System.out.print("Write the item id: ");
						int itemId = intScanner();
						// ask the user to enter the unit Price
						System.out.print("Write the unit price: ");
						double unitPrice = doubleScanner();

						myShop.updatePrice(itemId, unitPrice);

						System.out.println();
						break;
					}
					case 4: {
						// Show Items (Report All Items)
						myShop.showItem();
						System.out.println();
						break;
					}
					case 5: {
						// Go Back
						again = true;
						System.out.println();
						break;
					}
					}
				} catch (IllegalArgumentException ex) {
					System.out.println("Error: " + ex.getMessage());
				}
				System.out.println();
				break;
			}

			case 3: {
				// Create New Invoice
				// String invoiceNo,String invoiceDate, String customerName,
				System.out.print("Enter the invoice number: ");
				String invoiceNo = stringScanner();

				System.out.print("Enter the invoice Date (dd-mm-yyyy): ");
				String invoiceDate = stringScanner();

				System.out.print("Enter the customer name: ");
				String customerName = stringScanner();

				System.out.print("Enter the customer paid amount: ");
				double paidAmount = doubleScanner();

				myShop.createInvoice(invoiceNo, invoiceDate, customerName, paidAmount);
				System.out.println();
				option3++;
				break;
			}
			case 4: {
				// Report: Statistics
				generateReport.getReportStatistic();
				System.out.println();
				option4++;
				break;
			}
			case 5: {
				// Report: All Invoices
				generateReport.allInvoice();
				System.out.println();
				option5++;
				break;
			}
			case 6: {
				// Search (1) Invoice
				System.out.print("Write the invoice id: ");
				int id = intScanner();
				generateReport.detailedInvoice(id);
				System.out.println();
				option6++;
				break;
			}
			case 7: {
				// Program Statistics
				System.out.println("1: Shop Settings = " + option1);
				System.out.println("2: Manage Shop Items = " + option2);
				System.out.println("3: Create New Invoice = " + option3);
				System.out.println("4: Report: Statistics (No Of Items, No of Invoices, Total Sales) = " + option4);
				System.out.println("5: Report: All Invoices = " + option5);
				System.out.println("6: Search (1) Invoice = " + option6);
				System.out.println();
				break;
			}
			case 8: {
				// Exit
				System.out.println(
						"Are you sure you want to exit? If yes, program ends, if No , then main menu reprinted again");
				System.out.println("1-Yes");
				System.out.println("2-No");
				System.out.println("Here: ");
				int exitOrNot = intScanner();

				if (exitOrNot == 1) {
					System.out.println("EXIT");
					again = false;
				}
				System.out.println();
				break;
			}
			}

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

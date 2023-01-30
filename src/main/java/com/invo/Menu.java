/**
 * 
 */
package com.invo;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author LAP-9
 *
 */
public class Menu {
	 private String title = null;
	    private ArrayList<MenuItem> listOfMenuItems = new ArrayList<MenuItem>();
	    public Menu() {}
	    public  void displayMenu() {
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
	    }
	    
	    public Menu(String title) {
	        this.title = title;
	    }
	    
	    public void addMenuItem(MenuItem menuItem) {
	        listOfMenuItems.add(menuItem);
	    }
	    
	    public MenuItem getMenuItem(int id) {        
	        return listOfMenuItems.get(id-1);
	    }
	    
	    public void printMenuItems() {
	        if(title != null) {
	            System.out.println(this.title);
	        }
	        
	        for(MenuItem currItem: listOfMenuItems) {
	            currItem.printItem();
	        }
	    }
}

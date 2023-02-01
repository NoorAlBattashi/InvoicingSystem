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

	public Menu() {

	}

	public void addMenuItem(MenuItem menuItem) {
		listOfMenuItems.add(menuItem);
	}

	public MenuItem getMenuItem(int id) {
		return listOfMenuItems.get(id - 1);
	}

	public void printMenuItems() {
		if (title != null) {
			System.out.println(this.title);
		}

		for (MenuItem currItem : listOfMenuItems) {
			currItem.printItem();
		}
	}
}

/**
 * 
 */
package com.invo;

/**
 * @author LAP-9
 *
 */
public class MenuItem {
	int id;
	String desc;
	Menu menu = null;

	public MenuItem(int identity, String description) {
		id = identity;
		desc = description;
	}

	public void markTheItemAsMenu(Menu menu) {
		this.menu = menu;
	}

	public boolean isAMenu() {
		return menu != null;
	}

	public void printItem() {
		System.out.println(this.id + ": " + this.desc);
	}
}

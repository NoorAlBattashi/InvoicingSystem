/**
 * 
 */
package com.invo;

/**
 * @author LAP-9 
 * This class has fields for an item's ID, name, unit price, and
 * quantity, along with getters for each field. The getQtyAmountPrice
 * method returns the total price of the item based on the unit price
 * and quantity
 */
public class Item {

	public int itemID;
	public String name;
	public double unitPrice;
	public int quantity;

	public Item(int itemID, String name, double unitPrice, int quantity) {
		this.itemID = itemID;
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
				
	}

	public int getItemID() {
		return itemID;
	}

	public String getName() {
		return name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getQtyAmountPrice() {
		return unitPrice * quantity;
	}

}

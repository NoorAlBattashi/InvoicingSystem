/**
 * 
 */
package com.invo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author LAP-9 
 * 
 */
public class Item {
	public static String CartFilePath = "data/Cart.json";
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

	

}

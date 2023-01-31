/**
 * 
 */
package com.invo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//add package used for json file
import javax.swing.plaf.synth.SynthFormattedTextFieldUI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author LAP-9
 */

public class GroceryShop {
	public static String itemFilePath = "data/Items.json";
	public static String shopFilePath = "data/ShopDetails.json";
	public static String updatedItemsFilePath = "data/UpdatedItems.json";
	ArrayList<Item> itemsArrayList = new ArrayList<Item>();
	ArrayList<Item> update = new ArrayList<Item>();
	//ArrayList<Invoice> InvoiceHeaderArrayList = new ArrayList<Invoice>();
	Item addItem = null;
	Invoice invoice = new Invoice();
	String shopName;
public GroceryShop() {
	
}
	public void SetGroceryShopName(String shopName) {
		this.shopName = shopName;
		// Serialize the arraylist to a json string
				Gson gson = new Gson();
				String json = gson.toJson(shopName);

				// Write the json string to a file
				try (FileWriter writer = new FileWriter(shopFilePath)) {
					writer.write(json);
					writer.write("\n");
					//System.out.println("Serialization Done");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	public void addItem(Item addItem) {
		this.itemsArrayList.add(addItem);
	}

	public void storeItem(ArrayList<Item> itemsArrayList) {
		// Serialize the arraylist to a json string
		Gson gson = new Gson();
		String json = gson.toJson(itemsArrayList);

		// Write the json string to a file
		try (FileWriter writer = new FileWriter(itemFilePath, true)) {
			writer.write(json);
			writer.write("\n");
			//System.out.println("Serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showItem() {
		// Deserialize the json string and recreate arraylist
		Gson gson = new Gson();
		int counter =1;
		try (BufferedReader reader = new BufferedReader(new FileReader(itemFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Type type = new TypeToken<List<Item>>() {
				}.getType();
				ArrayList<Item> deserializedItems = gson.fromJson(line, type);
				
				for (Item currItem : deserializedItems) {
					System.out.println("("+counter+")");
					System.out.println("Item ID: "+currItem.getItemID());
					System.out.println("Item Name: "+currItem.getName());
					System.out.println("Unit Price: "+currItem.getUnitPrice());
					System.out.println("Quantity: "+currItem.getQuantity());
					counter++;
				}
			}
			//System.out.println("Deserialization Done");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void deleteItem(int itemId) {
		// Deserialize the json string and recreate arraylist
				Gson gson = new Gson();
				try (BufferedReader reader = new BufferedReader(new FileReader(itemFilePath))) {
					String line;
					while ((line = reader.readLine()) != null) {
						Type type = new TypeToken<List<Item>>() {
						}.getType();
						ArrayList<Item> deserializedItems = gson.fromJson(line, type);
						
						for (Item currItem : deserializedItems) {
							if(currItem.getItemID() != itemId) {
								
								update.add(currItem);
								String json = gson.toJson(update);
								// Write the json string to the updated file
								try (FileWriter writer = new FileWriter(updatedItemsFilePath, true)) {
									writer.write(json);
									writer.write("\n");
									//System.out.println("Serialization Done");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}		
						}
						
					}
					// Write the json string from the updated file to the original file
					String json = gson.toJson(update);
					try (FileWriter writer = new FileWriter(itemFilePath)) {
						writer.write(json);
						writer.write("\n");
						//System.out.println("Serialization Done");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	public void SetinvoiceHeader(String tel, String fax,
			String email, String website) {
		
		invoice.SetinvoiceHeader(tel,fax, email, website);
	}

}

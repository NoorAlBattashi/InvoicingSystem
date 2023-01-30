/**
 * 
 */
package com.invo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//add package used for json file
import javax.swing.plaf.synth.SynthFormattedTextFieldUI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author LAP-9 1-Shop Settings 1- Load Data (Items and invoices) 2- Set Shop
 *         Name (data should be saved) 3- Set Invoice Header (Tel / Fax / Email
 *         / Website) (Data should be saved) 4- Go Back
 */

public class GroceryShop {
	public static String filePath = "data/Items.json";
	ArrayList<Item> itemsArrayList = new ArrayList<Item>();
	Item addItem = null;
	String shopName;

	
	public  GroceryShop(String shopName) {
		this.shopName = shopName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addItem(Item addItem) {
		this.itemsArrayList.add(addItem);

//		HashMap<Integer, ArrayList<Item>> gatherItemInfo = new HashMap<Integer, ArrayList<Item>>();
//		gatherItemInfo.put(addItem.getItemID(), itemsArrayList);

		// store the student details on a json file
		try (FileWriter storeFileWriter = new FileWriter(filePath, true)) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(itemsArrayList, storeFileWriter);
			storeFileWriter.write("\n");
			System.out.println("Added Successfuly!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteItem(int itemid) {
		// Read json file
		try {
			Scanner fileScanner = new Scanner(filePath);
			HashMap<Integer, ArrayList<Item>> storeData = new HashMap<Integer, ArrayList<Item>>();
			while (fileScanner.hasNextLine()) {
				// read from json file, convert json to hash map
				Gson gson = new GsonBuilder().create();
				Type type = new TypeToken<Map<Integer, ArrayList<Item>>>() {
				}.getType();
				Map<Integer, ArrayList<Item>> myMap = gson.fromJson(fileScanner.nextLine(), type);

				for (Integer i : myMap.keySet()) {
					// store the data in hashmap
					//storeData.put(i, myMap.get(i));
					System.out.println(i);

				}
			}
//			// display the previous data
//			HashMap<Integer, ArrayList<Item>> storeHashMap = new HashMap<Integer, ArrayList<Item>>();
//			storeHashMap.put(itemid, null);
//			for (Integer a : storeData.keySet()) {
//
//				if (storeHashMap.containsKey(a)) {
//					//storeData.remove(a);
//					System.out.println(a);
//
//				}
//			}
//			// re-write in a file
//			try (FileWriter filrWriter = new FileWriter(filePath)) {
//				Gson gson = new GsonBuilder().create();
//				gson.toJson(storeData, filrWriter);
//				System.out.println("Done Successfuly!");
//				filrWriter.write("\n");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			fileScanner.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
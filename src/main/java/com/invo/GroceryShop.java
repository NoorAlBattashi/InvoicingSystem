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
	public static String filePath = "data/Items.json";
	ArrayList<Item> itemsArrayList = new ArrayList<Item>();
	Item addItem = null;
	String shopName;

	public GroceryShop(String shopName) {
		this.shopName = shopName;
	}

	public void addItem(Item addItem) {
		this.itemsArrayList.add(addItem);
	}

	public void storeItem(ArrayList<Item>itemsArrayList) {
		//Serialize the arraylist to a json string
		Gson gson = new Gson();
		String json = gson.toJson(itemsArrayList);
		
		//Write the json string to a file
		try(FileWriter writer = new FileWriter(filePath, true)){
			writer.write(json);
			writer.write("\n");
			System.out.println("Serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	public void showItem() {
		//Deserialize the json string and recreate arraylist
		Gson gson = new Gson();
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Type type = new TypeToken<List<Item>>() {}.getType();
				ArrayList<Item> deserializedItems = gson.fromJson(line, type);
				
				for (Item currItem : deserializedItems) {
					System.out.println(currItem.getItemID());
					System.out.println(currItem.getName());
					System.out.println(currItem.getUnitPrice());
					System.out.println(currItem.getQuantity());
				}
			}
			System.out.println("Deserialization Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public void addItem(Item addItem) {
//		this.itemsArrayList.add(addItem);
//
////		HashMap<Integer, ArrayList<Item>> gatherItemInfo = new HashMap<Integer, ArrayList<Item>>();
////		gatherItemInfo.put(addItem.getItemID(), itemsArrayList);
//
//		// store the student details on a json file
//		try (FileWriter storeFileWriter = new FileWriter(filePath, true)) {
//			Gson gson = new GsonBuilder().create();
//			gson.toJson(itemsArrayList, storeFileWriter);
//			storeFileWriter.write("\n");
//			System.out.println("Added Successfuly!");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void deleteItem(int itemid) {
//		// Read json file
//		try {
//			Scanner fileScanner = new Scanner(filePath);
//			HashMap<Integer, ArrayList<Item>> storeData = new HashMap<Integer, ArrayList<Item>>();
//			while (fileScanner.hasNextLine()) {
//				// read from json file, convert json to hash map
//				Gson gson = new GsonBuilder().create();
//				Type type = new TypeToken<Map<Integer, ArrayList<Item>>>() {
//				}.getType();
//				Map<Integer, ArrayList<Item>> myMap = gson.fromJson(fileScanner.nextLine(), type);
//
//				for (Integer i : myMap.keySet()) {
//					// store the data in hashmap
//					//storeData.put(i, myMap.get(i));
//					System.out.println(i);
//
//				}
//			}
////			// display the previous data
////			HashMap<Integer, ArrayList<Item>> storeHashMap = new HashMap<Integer, ArrayList<Item>>();
////			storeHashMap.put(itemid, null);
////			for (Integer a : storeData.keySet()) {
////
////				if (storeHashMap.containsKey(a)) {
////					//storeData.remove(a);
////					System.out.println(a);
////
////				}
////			}
////			// re-write in a file
////			try (FileWriter filrWriter = new FileWriter(filePath)) {
////				Gson gson = new GsonBuilder().create();
////				gson.toJson(storeData, filrWriter);
////				System.out.println("Done Successfuly!");
////				filrWriter.write("\n");
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//
//			fileScanner.close();
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
}

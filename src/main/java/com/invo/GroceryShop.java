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
	public static String updatedAfterDeleteFilePath = "data/UpdateItemsAfterDeletion.json";
	public static String updatedPriceFilePath = "data/UpdatePrice.json";
	public static String invoiceFilePath = "data/Invoice.json";
	public static String cartFilePath = "data/Cart.json";
	public static String detailedInvoiceFilePath = "data/DetailedInvoice.json";
	ArrayList<Item> itemsArrayList = new ArrayList<Item>();
	ArrayList<Item> update = new ArrayList<Item>();
	ArrayList<Item> itemsOfCustomerArrayList = new ArrayList<Item>();
	// ArrayList<Invoice> InvoiceHeaderArrayList = new ArrayList<Invoice>();
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
			// System.out.println("Serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addItem(Item addItem) {
		this.itemsArrayList.add(addItem);
	}

	public void storeItem(Item item) {
		// Serialize the arraylist to a json string
		Gson gson = new Gson();
		ArrayList<Item> itemsStor = new ArrayList<Item>();
		itemsStor.add(item);
		String json = gson.toJson(itemsStor);

		// Write the json string to a file
		try (FileWriter writer = new FileWriter(itemFilePath, true)) {
			writer.write(json);
			writer.write("\n");
			// System.out.println("Serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showItem() {
		// Deserialize the json string and recreate arraylist
		Gson gson = new Gson();
		int counter = 1;
		try (BufferedReader reader = new BufferedReader(new FileReader(itemFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Type type = new TypeToken<List<Item>>() {
				}.getType();
				ArrayList<Item> deserializedItems = gson.fromJson(line, type);

				for (Item currItem : deserializedItems) {
					System.out.println("(" + counter + ")");
					System.out.println("Item ID: " + currItem.getItemID());
					System.out.println("Item Name: " + currItem.getName());
					System.out.println("Unit Price: " + currItem.getUnitPrice());
					System.out.println("Quantity: " + currItem.getQuantity());
					counter++;
				}
			}
			// System.out.println("Deserialization Done");
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
					if (currItem.getItemID() != itemId) {
						update.add(currItem);
						// add the item after deletion in a file
						String json = gson.toJson(update);
						try (FileWriter writer = new FileWriter(updatedAfterDeleteFilePath)) {
							writer.write(json);
							writer.write("\n");
							// System.out.println("Serialization Done");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			}
			// Delete the content of item file

			try (FileWriter writer = new FileWriter(itemFilePath)) {
				writer.write("");
				// System.out.println("Serialization Done");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// update the item file with the new values
			String json = gson.toJson(update);
			try (FileWriter writer = new FileWriter(itemFilePath)) {
				writer.write(json);
				writer.write("\n");
				// System.out.println("Serialization Done");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updatePrice(int itemId, double price) {
		// Deserialize the json string and recreate arraylist
		Gson gson = new Gson();
		try (BufferedReader reader = new BufferedReader(new FileReader(itemFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Type type = new TypeToken<List<Item>>() {
				}.getType();
				ArrayList<Item> deserializedItems = gson.fromJson(line, type);

				for (Item currItem : deserializedItems) {
					if (currItem.getItemID() != itemId) {

						update.add(currItem);

					} else if (currItem.getItemID() == itemId) {
						Item updateItem = new Item(currItem.getItemID(), currItem.getName(), price,
								currItem.getQuantity());
						update.add(updateItem);
					}
				}

			}

			// Write the json string from the updated file to the original file
			String json = gson.toJson(update);
			try (FileWriter writer = new FileWriter(itemFilePath)) {
				writer.write(json);
				writer.write("\n");
				// System.out.println("Serialization Done");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void SetinvoiceHeader(String tel, String fax, String email, String website) {

		invoice.SetinvoiceHeader(tel, fax, email, website);
	}

	public void addItemInCart(Item addItem) {

		// Serialize the arraylist to a json string
		Gson gson = new Gson();
		ArrayList<Item> itemsStor = new ArrayList<Item>();
		itemsStor.add(addItem);
		String json = gson.toJson(itemsStor);

		// Write the json string to a file
		try (FileWriter writer = new FileWriter(cartFilePath, true)) {
			writer.write(json);
			writer.write("\n");
			// System.out.println("Serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public double getQtyAmountPrice() {
		// Deserialize the json string and recreate arraylist
		Gson gson = new Gson();
		int counter = 1;
		double sum = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(cartFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Type type = new TypeToken<List<Item>>() {
				}.getType();
				ArrayList<Item> deserializedItems = gson.fromJson(line, type);

				for (Item currItem : deserializedItems) {
					double unitPrice = currItem.getUnitPrice();
					int quantity = currItem.getQuantity();
					double total = unitPrice * quantity;
					sum += total;

					counter++;
				}
			}
			// System.out.println("Deserialization Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sum;
	}

	public int getQty() {
		// Deserialize the json string and recreate arraylist
		Gson gson = new Gson();
		int Qty = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(cartFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Type type = new TypeToken<List<Item>>() {
				}.getType();
				ArrayList<Item> deserializedItems = gson.fromJson(line, type);

				for (Item currItem : deserializedItems) {

					int quantity = currItem.getQuantity();
					Qty += quantity;
				}
			}
			// System.out.println("Deserialization Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Qty;
	}

	public void createInvoice(String invoiceNo, String invoiceDate, String customerName, double paidAmount) {
		int quantity = getQty();
		double totalAmount = getQtyAmountPrice();
		double balance = paidAmount - totalAmount;
		invoice.InvoiceInfo(invoiceNo, invoiceDate, customerName, quantity, totalAmount, paidAmount, balance);
		ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		invoices.add(invoice);
		// Serialize the arraylist to a json string
		Gson gson = new Gson();
		String json = gson.toJson(invoices);

		// Write the json string to a file
		try (FileWriter writer = new FileWriter(invoiceFilePath)) {
			writer.write(json);
			writer.write("\n");
			// System.out.println("Serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// read and store data from cart to detailedInvoice file
		ArrayList<Item> itemArrayList = new ArrayList<Item>();
		try (BufferedReader reader = new BufferedReader(new FileReader(cartFilePath))) {
			String line;

			while ((line = reader.readLine()) != null) {
				Type type = new TypeToken<List<Item>>() {
				}.getType();
				ArrayList<Item> deserializedItems = gson.fromJson(line, type);

				for (Item currItem : deserializedItems) {
					itemArrayList.add(currItem);
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// collect data of invoices and cart in hashmap
		List<Object> invoicesAndItems = new ArrayList<Object>();
		invoicesAndItems.add(invoices);
		invoicesAndItems.add(itemArrayList);
		String jsonsString = gson.toJson(invoicesAndItems);
		try (FileWriter writer = new FileWriter(detailedInvoiceFilePath)) {
			writer.write(jsonsString);
			writer.write("\n");
			// System.out.println("Serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Delete the content of cart file
		try (FileWriter writer = new FileWriter(cartFilePath)) {
			writer.write("");
			// System.out.println("Serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

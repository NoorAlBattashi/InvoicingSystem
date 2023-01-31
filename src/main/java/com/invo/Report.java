/**
 * 
 */
package com.invo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author LAP-9 4- Report: Statistics (No Of Items, No of Invoices, Total
 *         Sales) 5- Report: All Invoices ( Invoice No, Invoice Date, Customer
 *         Name, No of items, Total, Balance) 6- Search (1) Invoice (Search by
 *         Invoice No and Report All Invoice details with items)
 */
public class Report {
	public static String itemFilePath = "data/Items.json";
	public static String invoiceFilePath = "data/Invoice.json";
	public static String detailedInvoiceFilePath = "data/DetailedInvoice.json";
	String reportName;

	public Report() {

	}

	// (No Of Items, No of Invoices, Total Sales)
	public void getReportStatistic() {
		// calculate the number of items in the shop
		Gson gson = new Gson();
		int itemsCounter = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(itemFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Type type = new TypeToken<List<Item>>() {
				}.getType();
				ArrayList<Item> deserializedItems = gson.fromJson(line, type);

				for (Item currItem : deserializedItems) {
					itemsCounter++;
				}
			}
			System.out.println("Number of Items: " + itemsCounter);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// calculate the number of invoices in the shop
		int invoiceCounter = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(invoiceFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Type type = new TypeToken<List<Invoice>>() {
				}.getType();
				ArrayList<Invoice> deserializedItems = gson.fromJson(line, type);

				for (Invoice currItem : deserializedItems) {
					invoiceCounter++;
				}
			}
			System.out.println("Number of Invoices: " + invoiceCounter);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// calculate the total sale
		double sum = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(invoiceFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Type type = new TypeToken<List<Invoice>>() {
				}.getType();
				ArrayList<Invoice> deserializedItems = gson.fromJson(line, type);

				for (Invoice currItem : deserializedItems) {
					invoiceCounter++;
					double totalAmount = currItem.getTotalAmount();
					sum += totalAmount;
				}
			}
			System.out.println("Number of total sale: " + sum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// All Invoices ( Invoice No, Invoice Date, Customer Name, No of items, Total,
	// Balance)
	public void allInvoice() {
		Gson gson = new Gson();
		Integer counter = 1;
		try (BufferedReader reader = new BufferedReader(new FileReader(invoiceFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Type type = new TypeToken<List<Invoice>>() {
				}.getType();
				ArrayList<Invoice> deserializedItems = gson.fromJson(line, type);

				for (Invoice currItem : deserializedItems) {
					System.out.println("(" + counter + ")");
					System.out.println("Invoice No: " + currItem.getinvoiceNo());
					System.out.println("Invoice Date: " + currItem.getInvoiceDate());
					System.out.println("CustomerName: " + currItem.getcustomerName());
					System.out.println("Number Of Items: " + currItem.getNumberOfItems());
					System.out.println("Total Amount: " + currItem.getTotalAmount());
					System.out.println("Paid Amount: " + currItem.getPaidAmount());
					System.out.println("Balance: " + currItem.getbalance());
					System.out.println("==============================");
					counter++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void detailedInvoice(int index) {
		Gson gson = new Gson();
		// Integer counter = 1;
		Item item = null;
		Invoice invoice = new Invoice();
		List<Object> collectList = new ArrayList<Object>();
		try (BufferedReader reader = new BufferedReader(new FileReader(detailedInvoiceFilePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				Type type = new TypeToken<List<Object>>() {
				}.getType();
				List<Object> deserializedItems = gson.fromJson(line, type);
				collectList.add(deserializedItems);
//				System.out.println(deserializedItems);
//				for (Object iObject : deserializedItems) {
//					// System.out.println("(" + counter + ")");

				// counter++;
//				}
//				for (int i = 0; i < deserializedItems.size(); i++) {
//					   Object element = deserializedItems.get(i);
//					   if (element instanceof ArrayList) {
//					      ArrayList arrayList = (ArrayList) element;
//					      for (Object item1 : arrayList) {
//					    	  System.out.println(item1);
//					    	 
//					      }
//					   }
//					}

//				ArrayList<Invoice> invoices = null;
//				ArrayList<Item> itemArrayList = null;
//				for (Object object : deserializedItems) {
//				  if (object instanceof ArrayList) {
//				    ArrayList<Object> list = (ArrayList<Object>) object;
//				    for (Object item1 : list) {
//				      if (item1 instanceof Invoice && invoices == null) {
//				        invoices = new ArrayList<Invoice>();
//				        invoices.add((Invoice) item1);
//				      } else if (item1 instanceof Item && itemArrayList == null) {
//				        itemArrayList = new ArrayList<Item>();
//				        itemArrayList.add((Item) item1);
//				      }
//				    }
//				  }
//				}
//
//				if (invoices != null) {
//				  for (Invoice invoice1 : invoices) {
//					  System.out.println(invoices.get(0));
//				  }
//				}
//
//				if (itemArrayList != null) {
//				  for (Item item1 : itemArrayList) {
//					  System.out.println(itemArrayList.get(0));
//				  }
//				}
//
//				System.out.println(invoices);
//				

			}
			System.out.println();
			System.out.println("The invoice with the item");
			System.out.println(collectList.get(index - 1).toString());
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private char[] item1(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}

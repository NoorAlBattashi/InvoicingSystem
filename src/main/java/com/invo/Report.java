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
 * @author LAP-9 4- Report: Statistics (No Of Items, No of Invoices, Total
 *         Sales) 5- Report: All Invoices ( Invoice No, Invoice Date, Customer
 *         Name, No of items, Total, Balance) 6- Search (1) Invoice (Search by
 *         Invoice No and Report All Invoice details with items)
 */
public class Report {
	public static String itemFilePath = "data/Items.json";
	public static String invoiceFilePath = "data/Invoice.json";
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
		double sum =0;
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
	//All Invoices ( Invoice No, Invoice Date, Customer Name, No of items, Total, Balance)
	public void allInvoice() {
		Gson gson = new Gson();
		Integer counter =1;
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
}

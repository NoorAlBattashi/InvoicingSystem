/**
 * 
 */
package com.invo;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 * @author LAP-9
 */
public class Invoice {
	public static String invoiceHeaderFilePath = "data/InvoiceHeader.json";
	private String invoiceNo;
	private String invoiceDate;
	private String customerName;
	private int numberOfItems;
	private double totalAmount;
	private double paidAmount;
	private double balance;
	private String tel;
	private String fax;
	private String email;
	private String website;
	ArrayList<Item> itemsArrayList = new ArrayList<Item>();
	Item item = null;

	public Invoice() {

	}

	public void InvoiceInfo(String invoiceNo, String invoiceDate, String customerName, int numberOfItems,
			double totalAmount, double paidAmount, double balance) {
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		this.customerName = customerName;
		this.numberOfItems = numberOfItems;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.balance = balance;

	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public String getinvoiceNo() {
		return invoiceNo;
	}

	public String getcustomerName() {
		return customerName;
	}

	public double getbalance() {
		return balance;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public void SetinvoiceHeader(String tel, String fax, String email, String website) {
		this.tel = tel;
		this.fax = fax;
		this.email = email;
		this.website = website;
		ArrayList<String> invoiceHeadeArrayList = new ArrayList<String>();
		invoiceHeadeArrayList.add(tel);
		invoiceHeadeArrayList.add(fax);
		invoiceHeadeArrayList.add(email);
		invoiceHeadeArrayList.add(website);

		// Serialize the arraylist to a json string
		Gson gson = new Gson();
		String json = gson.toJson(invoiceHeadeArrayList);

		// Write the json string to a file
		try (FileWriter writer = new FileWriter(invoiceHeaderFilePath)) {
			writer.write(json);
			writer.write("\n");
			// System.out.println("Serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//
//	public List<Item> getItems() {
//		return items;
//	}
//
//	public void setItems(List<Item> items) {
//		this.items = items;
//	}
}

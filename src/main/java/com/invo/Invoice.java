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
	private String invoiceDate;
	private int numberOfItems;
	private double totalAmount;
	private double paidAmount;
	private String tel;
	private String fax;
	private String email;
	private String website;
	private List<Item> items;

	public  Invoice() {
		
	}
	public void InvoiceInfo(String invoiceDate, int numberOfItems, double totalAmount, double paidAmount) {
		
		this.invoiceDate = invoiceDate;
		this.numberOfItems = numberOfItems;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
		this.items = new ArrayList<Item>();
	}

	public String getInvoiceDate() {
		return invoiceDate;
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

	public void SetinvoiceHeader(String tel, String fax,
			String email, String website) {
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
			//System.out.println("Serialization Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}

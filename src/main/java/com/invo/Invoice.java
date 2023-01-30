/**
 * 
 */
package com.invo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LAP-9
 */
public class Invoice {
	private String invoiceDate;
	private int numberOfItems;
	private double totalAmount;
	private double paidAmount;
	private int tel;
	private String fax;
	private String email;
	private String website;
	private List<Item> items;

	public Invoice(String invoiceDate, int numberOfItems, double totalAmount, double paidAmount, int tel, String fax,
			String email, String website) {
		this.tel = tel;
		this.fax = fax;
		this.email = email;
		this.website = website;
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

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
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

	public void invoiceHeader() {
		System.out.println("Tel: " + tel);
		System.out.println("Fax: " + fax);
		System.out.println("Email: " + email);
		System.out.println("Website: " + website);
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}

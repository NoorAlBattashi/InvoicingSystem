/**
 * 
 */
package com.invo;

import java.time.LocalDate;

/**
 * @author LAP-9 This class has fields for a customer's full name, phone number,
 *         invoice date, number of items, total amount, paid amount, and a
 *         method getBalance that returns the remaining balance to be paid.
 */
public class Invoice {

	private String customerFullName;
	private String phoneNumber;
	private LocalDate invoiceDate;
	private int numberOfItems;
	private double totalAmount;
	private double paidAmount;

	public Invoice(String customerFullName, String phoneNumber, LocalDate invoiceDate, int numberOfItems,
			double totalAmount, double paidAmount) {
		this.customerFullName = customerFullName;
		this.phoneNumber = phoneNumber;
		this.invoiceDate = invoiceDate;
		this.numberOfItems = numberOfItems;
		this.totalAmount = totalAmount;
		this.paidAmount = paidAmount;
	}

	public String getCustomerFullName() {
		return customerFullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public double getBalance() {
		return totalAmount - paidAmount;
	}

}

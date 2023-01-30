/**
 * 
 */
package com.invo;

/**
 * @author LAP-9
 *
 */
public class Customer {
	private int customerId;
	private String customerFullName;
	private String phoneNumber;

	public Customer(int customerId, String customerFullName, String phoneNumber) {
		this.customerId = customerId;
		this.customerFullName = customerFullName;
		this.phoneNumber = phoneNumber;
	}

	public String getCustomerFullName() {
		return customerFullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}

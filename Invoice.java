package test;

import java.util.ArrayList;

public class Invoice {
	private int invoiceID, quantity;
	private String address;
	public Customer cust;
	public Salesperson sales;
	private ArrayList<PurchasedProduct> products;
	private Boolean isOpen = true;
	private Double cost;
	
	public Invoice(int inv, Salesperson sp, Customer c, ArrayList<PurchasedProduct> itemNames, int q) {
		invoiceID = inv;
		sales = sp;
		cust = c;
		products = itemNames;
		quantity = q;
	}
	public Customer getCustomer() {
		return cust;
	}
	public Salesperson getSalesperson() {
		return sales;
	}
	public int getInvoiceID() {
		return invoiceID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int q) {
		this.quantity = q;
	}
	public void setStatus(Boolean b) {
		this.isOpen = b;
	}
	public Boolean getStatus() {
		return isOpen;
	}
}

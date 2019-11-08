package test;

import java.util.ArrayList;

public class Invoice {
	private int invoiceID;
	private String address;
	public Customer cust;
	public Salesperson sales;
	private ArrayList<PurchasedProduct> products;
	private Boolean isOpen = true;
	private Double totalCost;
	
	public Invoice(int invID, Salesperson sp, Customer c, ArrayList<PurchasedProduct> itemNames, double cost) {
		invoiceID = invID;
		sales = sp;
		cust = c;
		products = itemNames;
		totalCost = cost; 
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
	public ArrayList<PurchasedProduct> getProducts(){
		return products;
	}
	public void setStatus(Boolean b) {
		this.isOpen = b;
	}
	public Boolean getStatus() {
		return isOpen;
	}
	public double getCost() {
		return totalCost;
	}
	public void setCost(double c) {
		this.totalCost = c;
	}
	public void editInvoice(Boolean status, Double cost) {
		this.setStatus(status);
		this.setCost(cost);
	}
}

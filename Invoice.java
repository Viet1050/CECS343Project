package test;

import java.util.ArrayList;

public class Invoice {
	private int invoiceID;
	private String address;
	public Customer cust;
	public Salesperson sales;
	private ArrayList<Product> products;
	private Boolean isOpen;
	private Double totalCost;
	
	
	//Load in ID, Salesperson, Customer, ArrayList of Products, cost per product
	public Invoice(int invID, Salesperson sp, Customer c, ArrayList<Product> products, double cost, String address) {
		invoiceID = invID;
		sales = sp;
		cust = c;
		this.products = products;
		totalCost = cost;
		this.address = address;
		isOpen = true;
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	public void removeProduct(Product p) {
		products.remove(p);
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
	public ArrayList<Product> getProducts(){
		return products;
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
	
	
	public void setStatus(Boolean b) {
		this.isOpen = b;
	}
	
	public void editInvoice(Boolean status, Double cost) {
		this.setStatus(status);
		this.setCost(cost);
	}
}

package test;

public class Invoice {
	private int invoiceNum, quantity;
	private String item;
	public Customer cust;
	public Salesperson sales;
	
	public Invoice(int inv, Salesperson sp, Customer c, String itemName, int q) {
		invoiceNum = inv;
		sales = sp;
		cust = c;
		item = itemName;
		quantity = q;
	}
	public Customer getCustomer() {
		return cust;
	}
	public Salesperson getSalesperson() {
		return sales;
	}
	public int getInvoiceNum() {
		return invoiceNum;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getItem() {
		return item;
	}
	public void setQuantity(int q) {
		this.quantity = q;
	}
}

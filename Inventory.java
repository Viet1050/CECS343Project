package test;
public class Inventory {
	private String productName;
	private double productCost;
	private double salePrice;
	private int itemQty;
	
	public Inventory(String product, double cost, double sale, int quantity) {
		productName = product;
		productCost = cost;
		salePrice = sale;
		itemQty = quantity;
	}
	public String getProdName() {
		return productName;
	}
	public double getCost() {
		return productCost;
	}
	public void setCost(double cost) {
		this.productCost = cost;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double price) {
		this.salePrice = price;
	}
	public int getQuantity() {
		return itemQty;
	}
	public void setQuantity(int quant) {
		this.itemQty = quant;
	}
	public void editInventory(double cost, double sale, int quantity) {
		this.setCost(cost);
		this.setSalePrice(sale);
		this.setQuantity(quantity);
	}
}

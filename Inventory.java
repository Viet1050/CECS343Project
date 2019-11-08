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
	
}

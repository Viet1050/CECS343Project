package test;

public class Product {
	
	private String productName;
	private int quantity;
	private double productCost;
	private double salePrice;
	
		//Constructors (Default to full) //
	/*public Product() {
		productName = "null";
		quantity = 0;
		productCost = 0.0;
		salePrice = 0.0;
	}
	public Product(String productName) {
		this.productName = productName;
		quantity = 0;
		productCost = 0.0;
		salePrice = 0.0;
	}
	public Product(String productName, int quantity) {
		this.productName = productName;
		this.quantity = quantity;
		productCost = 0.0;
		salePrice = 0.0;
	}
	public Product(String productName, int quantity, double productCost) {
		this.productName = productName;
		this.quantity = quantity;
		this.productCost = productCost;
		salePrice = 0.0;
	} */
	
	public Product(String productName, int quantity, double productCost, double salePrice) {
		this.productName = productName;
		this.quantity = quantity;
		this.productCost = productCost;
		this.salePrice = salePrice;
	}
	
	//Copy Constructor
	public Product(Product toCopy){
		this.productName = toCopy.getName();
		this.quantity = toCopy.getQuantity();
		this.productCost = toCopy.getCost();
		this.salePrice = toCopy.getPrice();
	}
	
	
		// Getters //
	
	public String getName() {
		return productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public double getCost() {
		return productCost;
	}
	public double getPrice() {
		return salePrice;
	}
	
		// Setters //
	
	public void setName(String productName) {
		this.productName = productName;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setCost(double productCost) {
		this.productCost = productCost;
	}
	public void setPrice(double salePrice) {
		this.salePrice = salePrice;
	}
	
	
}
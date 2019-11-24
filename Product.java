package test;

public class Product {
	
	private String productName;
	private int quantity;
	private double productCost;
	private double salePrice;
	private int quantitySold;
	
	//total of sales made
	private double totalSales;
	
	//total of costs made 
	private double totalCost;
	
	//total of sales & cost
	private double totalProfit;
	
	//perentage of profit value
	private double totalProfitPercent;
	
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
		
		this.totalCost = quantity * productCost;
		this.totalProfit = -(this.totalCost);
		this.totalProfitPercent = this.totalProfit / 100;
		
		this.quantitySold = 0;
		this.totalSales = 0.0;
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
	public int getQtySold(){
		return quantitySold;
	}
	public double getTotalSales(){
		return totalSales;
	}
	public double getTotalCost(){
		return totalCost;
	}
	public double getTotalProfit(){
		return totalProfit;
	}
	public double getTotalProfitPercent(){
		return totalProfitPercent;
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
	
	
	
	// Methods //
	
	
	//load how much of product to purchase
	public void sellProduct(int qty) {
		//Set new amount sold and current stock
		quantitySold += qty;
		quantity -= qty;
		
		//Add to total sales
		totalSales += (qty * salePrice);
		
		//Modify total Profits
		totalProfit += (qty * salePrice);
		
		//Modify Proft percent
		totalProfitPercent += (totalProfit / 100);
	}
	
	
	//Use for restocking Product
	public void restock(int restockValue){
		//Restock
		quantity += restockValue;
		
		//Add to total Costs
		totalCost += (restockValue * productCost);
		
		//Add to overall Profit
		totalProfit += -(restockValue * productCost);
		
		//Modify Profit Percent
		totalProfitPercent += (totalProfit / 100);
	}
	
}
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
	
		this.quantitySold = 0;
		this.totalSales = 0.0;
		
		this.totalProfit = -(this.totalCost) + totalSales;
		this.totalProfitPercent = this.totalProfit / 100;
	}
	
	//Copy Constructor
	public Product(Product toCopy){
		this.productName = toCopy.getName();
		this.quantity = toCopy.getQuantity();
		this.productCost = toCopy.getCost();
		this.salePrice = toCopy.getSalePrice();
		this.totalCost = toCopy.getTotalCost();
		this.quantitySold = toCopy.getQtySold();
		this.totalSales = toCopy.getTotalSales();
		this.totalProfit = toCopy.getTotalProfit();
		this.totalProfitPercent = toCopy.getTotalProfitPercent();
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
	public double getSalePrice() {
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
	
	/* Should not be used
	 * 
	 * 
	public void setName(String productName) {
		this.productName = productName;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	*
	*
	*/
	
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
		totalProfitPercent = (totalProfit / 100);
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
		totalProfitPercent = (totalProfit / 100);
	}
	
}
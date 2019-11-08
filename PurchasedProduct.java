package test;

public class PurchasedProduct {
	private String productName;
	private int quantity;
	
	public PurchasedProduct(String name, int quant) {
		productName = name;
		quantity = quant;
	}
	
	public String getName() {
		return productName;
	}
	public int getQuanitity() {
		return quantity;
	}
	public void setQuantity(int quant) {
		quantity = quant;
		
	}
}

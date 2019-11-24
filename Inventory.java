package test;


import java.util.ArrayList;
import java.util.List;


public class Inventory {

	private ArrayList<Product> currentInventory;
	
	//Default Constructor
	public Inventory(){
		currentInventory = new ArrayList<Product>();
	}
	//Loaded Constructor or Setter
	public Inventory(ArrayList<Product> copyInventory){
		currentInventory = inventoryCopy(copyInventory);
	}
	
	//Makes deep copy of Inventory
	public static ArrayList<Product> inventoryCopy(ArrayList<Product> toCopy){
		ArrayList<Product> copy = new ArrayList<Product>();
		for (Product item : toCopy){
			copy.add(new Product(item));
		}
		return copy;
	}
	
	//Getter
	public ArrayList<Product> getInventory(){
		return currentInventory;
	}
	
	// Add product to inventory list
	public void addProductToInventory(String productName, int quantity, double productCost, double salePrice) {
		currentInventory.add(new Product(productName, quantity, productCost, salePrice));
	}
	
	//Edit a product - But not name
	public void editProductInInventory(Product productToEdit, int newQty, double newProdCost, double newSalePrice) {
		//Set new product values
		productToEdit.setQuantity(newQty);
		productToEdit.setCost(newProdCost);
		productToEdit.setPrice(newSalePrice);

	}
	
	
	
	/*
	//Searches Inventory for the Item to edit.
		//If it exists then allow for edit then break loop
		//If not then display that product does not exist
	public void verifyProductExists(String productToEdit) {
		
		//Parse through Inventory
		for (int i = 0; i < currentInventory.size() ; ++i) {
			
			//Verify Names match
			if (productToEdit.equals(currentInventory.get(i).getName())){
				
				//Edit the product values
				editProductInInventory(currentInventory.get(i));
				
				break;
			}
		}
	}
	
	*/
	
	
	
		// INPUT CHECKS //
	
	//Checks if edit input has good values
		//If values are less than zero then return false, else true
	public boolean verifyEditInput(double cost, double sale, int quantity){
		if (cost < 0.0 || sale < 0.0 || quantity < 0){
			return false;
		}
		return true;
	}
	
	//Checks if new input has good values
			//If name is empty or other values are less than zero then return false, else true
		public boolean verifyNewInput(String name, double cost, double sale, int quantity){
			if (name.isEmpty() || cost < 0.0 || sale < 0.0 || quantity < 0){
				return false;
			}
			return true;
		}
	
		
		
		
		// INVENTORY PRINT METHODS //
		
	//Prints out all Products
	public void printFullInventory() {
		//print the info
		for(int i = 0; i < currentInventory.size(); ++i) {
			Product prod = currentInventory.get(i);
			
			System.out.println("Name: " + prod.getName());
			System.out.println("Product Cost Price: " + prod.getCost());
			System.out.println("Product Sale Price: " + prod.getPrice());
			System.out.println("Product Quantity on Hand: " + prod.getQuantity());
			System.out.println();
		}
	}
	
	//Print Out Products with 5 or less qty (ascending order)
	public void printLowQtyProducts() {
		
		//Make a copy by value
		ArrayList<Product> sortedInventory = inventoryCopy(this.getInventory());
				
		//Sort the array
		sortedInventory = sortQtyByAscending(sortedInventory);
		
		//print info
		for(int i = 0; i < sortedInventory.size(); ++i) {
			Product prod = sortedInventory.get(i);
			
			System.out.println("Name: " + prod.getName());
			System.out.println("Product Cost Price: " + prod.getCost());
			System.out.println("Product Sale Price: " + prod.getPrice());
			System.out.println("Product Quantity on Hand: " + prod.getQuantity());
			System.out.println();
		}
	}
	
	
		// SORTER METHODS //
	
	//Ascends the order inventory by qty
	public ArrayList<Product> sortQtyByAscending(ArrayList<Product> lessThanSixProds){
		
		//List of products to delete
		List<Product> toDelete = new ArrayList<Product>();
		
		//Remove Products of greather than 5 
		//by finding and adding to list toDelete
		for(Product prod : lessThanSixProds) {
			if(prod.getQuantity() > 5){
				toDelete.add(prod);
			}
		}
		//Remove all matching arguments
		lessThanSixProds.removeAll(toDelete);
		
		//Sort in ascending order by QTY
		for(int i = 0; i < lessThanSixProds.size(); ++i) {
			for(int j = i+1; j < lessThanSixProds.size(); ++j) {
				if(lessThanSixProds.get(i).getQuantity() > lessThanSixProds.get(j).getQuantity()) {
					Product temp = lessThanSixProds.get(i);
					lessThanSixProds.set(i, lessThanSixProds.get(j));
					lessThanSixProds.set(j, temp);
				}
			}
		}
		return lessThanSixProds;
	}
}


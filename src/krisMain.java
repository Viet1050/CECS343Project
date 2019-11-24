
/*
import java.util.Scanner;

//Main test
public class krisMain {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Inventory inventory = new Inventory();
		
		
		while(true) {
			System.out.println("---Enter a value---\n\n1. Add to Inventory\n2. Edit a Product\n3. Print Inventory\n4. "
					+ "Print Inventory of 5 or less quantity\n5. Exit");
			int path = input.nextInt();
			input.nextLine();
			System.out.println("You Entered '" + path + "'");
			System.out.println();
			
			//Add to the Inventory
			if(path == 1) {
				
				String name = "";
				double cost = -1.0;
				double sale = -1.0;
				int qty = -1;
				boolean isVerified = false;
				
				
				//While items are not Verified values ask for input
				while (!isVerified) {
					
					
					System.out.println("Valid input actual name & 0 or greater values");
					System.out.println();
					
					// Ask User for new Input for product values
					
					System.out.println("Enter valid name");
					name = input.nextLine();
					System.out.println("You entered '" + name + "'");
					
					System.out.println();
					
					System.out.println("Enter valid Product Quantity");
					qty = input.nextInt();
					System.out.println("You entered '" + qty + "'");
					
					System.out.println();
					
					System.out.println("Enter valid Product Cost");
					cost = input.nextDouble();
					System.out.println("You entered '" + cost + "'");
					
					System.out.println();
					
					System.out.println("Enter valid Product Sale Price");
					sale = input.nextDouble();
					System.out.println("You entered '" + sale + "'");
					
					//Verify for good input
					isVerified = inventory.verifyNewInput(name, cost, sale, qty);
					
					System.out.println();
					input.nextLine();
				}
				
				//Add to inventory
				inventory.addProductToInventory(name, qty, cost, sale);
			}
			//Edit the Product
			else if(path == 2){
				
				boolean isEdited = false;
				
				double cost = -1.0;
				double sale = -1.0;
				int qty = -1;
				boolean isVerified = false;
				
				System.out.println("Enter the name of the Product to edit");
				String prodToEditName = input.nextLine();
				System.out.println();
				
				//Search for match
				for(int i = 0; i < inventory.getInventory().size(); ++i){
					Product prod = inventory.getInventory().get(i);
					//If match
					if(prodToEditName.equals(prod.getName())){
						
						//While items are not Verified values ask for input
						while (!isVerified){
							
							System.out.println("Valid input is 0 or greater");
							System.out.println();
							
							// Ask User for new Input for product values
							System.out.println("Enter valid Product Quantity");
							qty = input.nextInt();
							System.out.println("You entered '" + qty + "'");
							
							System.out.println();
							
							System.out.println("Enter valid Product Cost");
							cost = input.nextDouble();
							System.out.println("You entered '" + cost + "'");
							
							System.out.println();
							
							System.out.println("Enter valid Product Sale Price");
							sale = input.nextDouble();
							System.out.println("You entered '" + sale + "'");
							
							//Verify input
							isVerified = inventory.verifyEditInput(cost, sale, qty);
							
							System.out.println();
							input.nextLine();
						}
						
						//Then allow edit of fields other than name
						inventory.editProductInInventory(prod, qty, cost, sale);
						isEdited = true;
						break;
					}
				}
				if(!isEdited){
					System.out.println("No such product");
					System.out.println();
				}
			}
			//Print Full Inventory
			else if(path == 3){
				System.out.println("Printing Inventory...");
				System.out.println();
				inventory.printFullInventory();
				System.out.println();
			}
			//Print LowQtyProducts
			else if(path == 4){
				System.out.println("Printing Inventory sorted by 5 or less items...");
				System.out.println();
				inventory.printLowQtyProducts();
				System.out.println();
			}
			//Exit
			else if(path == 5){
				System.out.println("Exiting...");
				System.out.println();
				break;
			}
		}
		input.close();
	}
}
*/
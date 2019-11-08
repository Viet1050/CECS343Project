package test;

public class Customer extends Person {
	private double slsTax;
	private int custID;
	
	public Customer(int id,String fN,String lN,double tax) {
		super(fN, lN);
		slsTax = tax;
		custID= id;
	}
	public void setSalesTax(double tax) {
		this.slsTax =tax;
	}
	public double getSalesTax() {
		return slsTax;
	}
	public int getCustID() {
		return custID;
	}	
	public void  editCustomer(String f, String l, double t) {	
		this.setFirstName(f);
		this.setLastName(l);
		this.setSalesTax(t);
	}

}
package test;

public class Salesperson extends Person{
	private double commission;
	private int salesID;
	
	public Salesperson(String fN, String ln, double com, int slsPersonID) {
		super(fN,ln);
		commission = com;
		salesID = slsPersonID;
	}
	public void setComissionRate(double comm) {
		this.commission = comm;
	}
	public double getComissionRate() {
		return commission;
	}
	public void setSalesID(int id) {
		this.salesID = id;
	}
	public int getSalesID() {
		return salesID;
	}
	public void editSalesPerson(String f, String l, double c) {	
		this.setFirstName(f);
		this.setLastName(l);
		this.setComissionRate(c);
	}


}

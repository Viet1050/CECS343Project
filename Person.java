package test;

import java.util.ArrayList;

public class Person {
	private String firstName;
	private String lastName;
	private int SSN;
	
	//constructor
	public  Person(String fN, String lN) {
		firstName= fN;
		lastName = lN;
	}
	
	//set first name method
	public void setFirstName(String n) {
		this.firstName =n;
	}
	//set last name method
	public void setLastName(String n) {
		this.lastName =n;
		//return lastName;
	}
	
	//get first name method
	public String getFirstName() {
		//firstName =n;
		return firstName;
	}
	
	//get last name method
	public String getLastName() {
		//lastName =n;
		return lastName;
	}	

}


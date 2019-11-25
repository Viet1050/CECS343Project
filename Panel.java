package test;
import java.awt.event.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.function.UnaryOperator;
import java.awt.*;
import javax.swing.*;

/**
 * Panel Class - representation Panel in Window
 * 
 * @authors Wilfredo Mendivil, Viet Nguyen
 */
//@SuppressWarnings("serial")
public class Panel extends JPanel implements ActionListener, MouseListener {
	/** Label in Panel */
	private JTextField tfCustFName,tfCustLName,tfCustID,tfCustSlsTax;
	private JTextField tfSlsPersonFName,tfSlsPersonLName,tfSlsPersonID,tfSlsPersonCommission;
	private JLabel menuLbl;

	// labels for add customer
 	private JLabel custFNameLbl, custLNameLbl, custSlsTaxLbl, custIDLbl;
 	private JLabel slsPersonFNameLbl, slsPersonLNameLbl, slsPersonComissionLbl, slsPersonIDLbl;
	/** Buttons in Panel */
	private JButton  inventoryBtn, invoiceBtn,mainMenuBtn,
	addInvoiceBtn, addInventoryBtn,editInvoiceBtn, editInventoryBtn,
	openInvoiceBtn,closedInvoiceBtn,deleteInvoiceBtn, cancelSlsPersonBtn;
	//salesperson buttons
	private JButton salesPersonBtn, addSalesPersonBtn, editSalesPersonBtn,acceptSlsPersonBtn,deleteSlsPersonBtn,updateSlsPersonBtn;
	//customer buttons
	private JButton updateCustBtn,customerBtn,  deleteCustBtn, editCustomerBtn, cancelCustomerBtn,acceptCustBtn, addCustomerBtn;
		/** List in panel */
	private JList<String> customerList, salesPersonList, inventoryList, invoiceList;

	//arrayLists of all objects
	ArrayList<Person> people = new ArrayList<Person>();		
	ArrayList<Customer> cust = new ArrayList<Customer>();
	ArrayList<Salesperson> sales = new ArrayList<Salesperson>();
	ArrayList<Invoice> inv = new ArrayList<Invoice>();
	ArrayList<PurchasedProduct> prods = new ArrayList<PurchasedProduct>();
	ArrayList<Inventory> Inventory = new ArrayList<Inventory>();

	private DefaultListModel<String> tasks = new DefaultListModel<>();
	private DefaultListModel<String> customerTasks = new DefaultListModel<>();
	private DefaultListModel<String> salesPersonTasks = new DefaultListModel<>();
	private DefaultListModel<String> inventoryTasks = new DefaultListModel<>();
	private DefaultListModel<String> invoiceTasks = new DefaultListModel<>();

	/**
	 * Constructor - sets up Panel and format to be used in window
	 */
	public Panel() {

		
		// add vectorTasklist into lstList
		customerList= new JList<>(customerTasks);
		salesPersonList= new JList<>(salesPersonTasks);
		invoiceList= new JList<>(invoiceTasks);
		inventoryList= new JList<>(inventoryTasks);

		//Testing Invoice
		//add
		makeInvoice();
		System.out.println("Pre: "+inv.get(0).getInvoiceID()+" "+inv.get(0).getSalesperson().getFirstName()+" "+inv.get(0).getSalesperson().getLastName()+" "
				+inv.get(0).getCustomer().getFirstName()+" "+inv.get(0).getCustomer().getLastName()+" "+inv.get(0).getCost()+" "+inv.get(0).getStatus());
		//edit
		inv.get(0).editInvoice(false, 34.7);
		System.out.println("Post: "+inv.get(0).getInvoiceID()+" "+inv.get(0).getSalesperson().getFirstName()+" "+inv.get(0).getSalesperson().getLastName()+" "
				+inv.get(0).getCustomer().getFirstName()+" "+inv.get(0).getCustomer().getLastName()+" "+inv.get(0).getCost()+" "+inv.get(0).getStatus());
		//remove
		System.out.println("\nSize: "+inv.size());
		inv.remove(0);
		System.out.println("Size: "+inv.size());
		//display open
		//dislpay closed
		
		
//		addCustomer();
//		addSalesperson();
//		boughtProduct();
//		makeInvoice();
		//System.out.println(cust.size());
//		System.out.println("Customer");
//		System.out.println("Pre-edit: "+cust.get(0).getCustID()+" "+cust.get(0).getFirstName()+" "+ cust.get(0).getLastName()+" " + cust.get(0).getSalesTax());
//		cust.get(0).editCustomer( "f", "l", 100);
//		System.out.println("Post-edit: "+cust.get(0).getCustID()+" "+cust.get(0).getFirstName()+" "+ cust.get(0).getLastName()+" " + cust.get(0).getSalesTax());
		
//		System.out.println("\nSalesperson");
//		System.out.println("Pre-edit: "+sales.get(0).getSalesID()+" "+sales.get(0).getFirstName()+" "+ sales.get(0).getLastName()+" " + sales.get(0).getComissionRate());
//		sales.get(0).editSalesPerson("A", "La Verga", 22.4);
//		System.out.println("Post-edit: "+sales.get(0).getSalesID()+" "+sales.get(0).getFirstName()+" "+ sales.get(0).getLastName()+" " + sales.get(0).getComissionRate());
		
//		System.out.println("\nPurchased Product");
//		System.out.println(prods.get(0).getName()+" "+prods.get(0).getQuanitity());
		
//		System.out.println("\nInvoice");
//		System.out.println("pre-edit: "+" "+inv.get(0).getInvoiceID()+" "+inv.get(0).getSalesperson()+" "+inv.get(0).getCustomer()+" "+inv.get(0).getProducts()+" "+inv.get(0).getCost());
//		inv.get(0).editInvoice(false, 45.99);
//		System.out.println("post-edit: "+" "+inv.get(0).getInvoiceID()+" "+inv.get(0).getSalesperson()+" "+inv.get(0).getCustomer()+" "+inv.get(0).getProducts()+" "+inv.get(0).getCost());
//		customerTasks.addElement(cust.get(0).getCustID()+"  " +cust.get(0).getFirstName()+" "+ cust.get(0).getLastName()+" " +cust.get(0).getSalesTax());
		// ***************************LABEL GROUP***********************************************
		// CUSTOMER GROUP
		custFNameLbl = new JLabel("CUSTOMER FIRST NAME");
		custLNameLbl = new JLabel("CUSTOMER LAST NAME");
		custSlsTaxLbl = new JLabel("CUSTOMER SALES TAX");
		custIDLbl = new JLabel("CUSTOMER ID");
		//SALESPERSON GROUP
		slsPersonFNameLbl = new JLabel("SALESPERSON FIRST NAME");
		slsPersonLNameLbl = new JLabel("SALESPERSON LAST NAME");
		slsPersonComissionLbl = new JLabel("SALESPERSON COMMISSION");
		slsPersonIDLbl = new JLabel("SALESPERSON ID");
		
		menuLbl = new JLabel("MENU");
		// ***************************TEXT FIELD GROUP******************************************		
		//CUSTOMER GROUP
		tfCustFName = new JTextField("");
		tfCustLName = new JTextField("");
		tfCustID = new JTextField("");
		tfCustSlsTax = new JTextField("");

		tfCustFName.addMouseListener(this);	
		tfCustLName.addMouseListener(this);
		tfCustID.addMouseListener(this);
		tfCustSlsTax.addMouseListener(this);
		
		
		
		
		//SALESPERSON GROUP
		tfSlsPersonFName = new JTextField("");
		tfSlsPersonLName = new JTextField("");
		tfSlsPersonID = new JTextField("");
		tfSlsPersonCommission = new JTextField("");

		tfSlsPersonFName.addMouseListener(this);
		tfSlsPersonLName.addMouseListener(this);
		tfSlsPersonID.addMouseListener(this);
		tfSlsPersonCommission.addMouseListener(this);
		
		
		// ***************************BUTTON GROUP*********************************************
		openInvoiceBtn = new JButton("open Invoices");
		openInvoiceBtn.addActionListener(this);
		
		closedInvoiceBtn = new JButton("Closed Invoices");
		closedInvoiceBtn.addActionListener(this);
		
		deleteInvoiceBtn = new JButton("Delete Invoice");
		deleteInvoiceBtn.addActionListener(this);
		
		addCustomerBtn = new JButton("add Customer");
		addCustomerBtn.addActionListener(this);
		
		addSalesPersonBtn = new JButton("add SalesPerson");
		addSalesPersonBtn.addActionListener(this);
		
		addInvoiceBtn = new JButton ("Creat Invoice");
		addInvoiceBtn.addActionListener(this);
		
		addInventoryBtn = new JButton("add Product");
		addInventoryBtn.addActionListener(this);
		
		editCustomerBtn = new JButton("edit Customer");
		editCustomerBtn.addActionListener(this);
		
		editSalesPersonBtn = new JButton("edit SalesPerson");
		editSalesPersonBtn.addActionListener(this);
		
		editInvoiceBtn = new JButton("Edit Invoice");
		editInvoiceBtn.addActionListener(this);
		
		editInventoryBtn = new JButton("Edit Inventory");
		editInventoryBtn.addActionListener(this);
		
		//Main Menu Button
		mainMenuBtn= new JButton("MAIN MENU");
		mainMenuBtn.addActionListener(this);
		
		//customerBtn function
		customerBtn = new JButton("Customer");
	    customerBtn.addActionListener(this);
	    //SalesPerson function
	    salesPersonBtn = new JButton("SalesPerson");
		salesPersonBtn.addActionListener(this);
		
		// submit button function
		invoiceBtn = new JButton("Invoice");
		invoiceBtn.addActionListener(this);

		// complete button function
		inventoryBtn = new JButton("Inventory");
		inventoryBtn.addActionListener(this);


		acceptCustBtn = new JButton("Submit");
		acceptCustBtn.addActionListener(this);
		
		cancelCustomerBtn = new JButton("Cancel");
		cancelCustomerBtn.addActionListener(this);

		acceptSlsPersonBtn = new JButton("Submit");
		acceptSlsPersonBtn.addActionListener(this);
		
		cancelSlsPersonBtn = new JButton("Cancel");
		cancelSlsPersonBtn.addActionListener(this);
		
		updateCustBtn = new JButton("Update");
		updateCustBtn.addActionListener(this);
		
		deleteCustBtn = new JButton("Delete Cust");
		deleteCustBtn.addActionListener(this);
		
		deleteSlsPersonBtn = new JButton("Delete SalesPerson");
		deleteSlsPersonBtn.addActionListener(this);

		updateSlsPersonBtn= new JButton("Update SalesPerson");
		updateSlsPersonBtn.addActionListener(this);
		
		
		// ***************************ADD LABEL GROUP*******************************************
		add(menuLbl);
		// ***************************ADD TEXT FIELD GROUP***************************************

	
		// ***************************ADD BUTTON GROUP******************************************
		add(customerBtn);
		add(salesPersonBtn);
		add(invoiceBtn);
		add(inventoryBtn);
		// ***************************ADD LIST GROUP*********************************************
		// ***************************SET LAYOUT STYLE FOR PANEL**********************************		
		
		setLayout(null);
		// menu screen load outs
		Insets insets = getInsets();
		Dimension size = customerBtn.getPreferredSize();
		
		mainMenuDisplays();
		//******************************************************************************************
		//**********************SALES PERSON LOCATION***********************************************
		//******************************************************************************************
		size = salesPersonList.getPreferredSize();
		salesPersonList.setBounds(65 + insets.left, 100 + insets.top, size.width + 300, 100 + size.height);
		
		size = addSalesPersonBtn.getPreferredSize();
		addSalesPersonBtn.setBounds(250 + insets.left, 10 + insets.top, size.width + 25, size.height);
		
		size = editSalesPersonBtn.getPreferredSize();
		editSalesPersonBtn.setBounds(25 + insets.left, 10 + insets.top, size.width + 25, size.height);		
		
		//*******************ADD SALESPERSON LOCATION *************************************************
		//******************************************************************************************
		size = slsPersonIDLbl.getPreferredSize();
		slsPersonIDLbl.setBounds(25 + insets.left, 10 + insets.top, size.width + 25, size.height);
		
		size = tfSlsPersonID.getPreferredSize();
		tfSlsPersonID.setBounds(25 + insets.left, 30 + insets.top, size.width + 60, size.height);
		
		size = slsPersonFNameLbl.getPreferredSize();
		slsPersonFNameLbl.setBounds(25 + insets.left, 60 + insets.top, size.width + 25, size.height);
		
		size = tfSlsPersonFName.getPreferredSize();
		tfSlsPersonFName.setBounds(25 + insets.left, 80 + insets.top, size.width + 60, size.height);
		
		size = slsPersonLNameLbl.getPreferredSize();
		slsPersonLNameLbl.setBounds(25 + insets.left, 100 + insets.top, size.width + 25, size.height);
		
		size = tfSlsPersonLName.getPreferredSize();
		tfSlsPersonLName.setBounds(25 + insets.left, 120 + insets.top, size.width + 60, size.height);
		
		size = slsPersonComissionLbl.getPreferredSize();
		slsPersonComissionLbl.setBounds(25 + insets.left, 150 + insets.top, size.width + 25, size.height);

		size = tfSlsPersonCommission.getPreferredSize();
		tfSlsPersonCommission.setBounds(25 + insets.left, 180 + insets.top, size.width + 60, size.height);
		//***************************BUTTON LOCATIONS**********************************************
		
		size = acceptSlsPersonBtn.getPreferredSize();
		acceptSlsPersonBtn.setBounds(25 + insets.left, 250 + insets.top, size.width + 25, size.height);
		
		size = cancelSlsPersonBtn.getPreferredSize();
		cancelSlsPersonBtn.setBounds(250 + insets.left, 250 + insets.top, size.width + 25, size.height);
		
		size = deleteSlsPersonBtn.getPreferredSize();
		deleteSlsPersonBtn.setBounds(250 + insets.left, 50 + insets.top, size.width + 25, size.height);
		
		size = updateSlsPersonBtn.getPreferredSize();
		updateSlsPersonBtn.setBounds(25 + insets.left, 250 + insets.top, size.width + 60, size.height);

		//*******************************************************************************************
		//*********************CUSTOMER LOCATION*****************************************************
		//*******************************************************************************************


		size = customerList.getPreferredSize();
		customerList.setBounds(65 + insets.left, 100 + insets.top, size.width + 300, 100 + size.height);
		
		size = addCustomerBtn.getPreferredSize();
		addCustomerBtn.setBounds(250 + insets.left, 10 + insets.top, size.width + 25, size.height);
		
		size = deleteCustBtn.getPreferredSize();
		deleteCustBtn.setBounds(250 + insets.left, 50 + insets.top, size.width + 25, size.height);
	
		
		size = editCustomerBtn.getPreferredSize();
		editCustomerBtn.setBounds(25 + insets.left, 10 + insets.top, size.width + 25, size.height);
		//*******************ADD CUSTOMER LOCATION *************************************************
		//******************************************************************************************
		
		size = custIDLbl.getPreferredSize();
		custIDLbl.setBounds(25 + insets.left, 10 + insets.top, size.width + 25, size.height);
		
		size = tfCustID.getPreferredSize();
		tfCustID.setBounds(25 + insets.left, 30 + insets.top, size.width + 60, size.height);
		
		size = custFNameLbl.getPreferredSize();
		custFNameLbl.setBounds(25 + insets.left, 60 + insets.top, size.width + 25, size.height);
		
		size = tfCustFName.getPreferredSize();
		tfCustFName.setBounds(25 + insets.left, 80 + insets.top, size.width + 60, size.height);
		
		size = custLNameLbl.getPreferredSize();
		custLNameLbl.setBounds(25 + insets.left, 100 + insets.top, size.width + 25, size.height);
		
		size = tfCustLName.getPreferredSize();
		tfCustLName.setBounds(25 + insets.left, 120 + insets.top, size.width + 60, size.height);
		
		size = custSlsTaxLbl.getPreferredSize();
		custSlsTaxLbl.setBounds(25 + insets.left, 150 + insets.top, size.width + 25, size.height);

		size = tfCustSlsTax.getPreferredSize();
		tfCustSlsTax.setBounds(25 + insets.left, 180 + insets.top, size.width + 60, size.height);
		//***************************BUTTON LOCATIONS**********************************************
		
		size = updateCustBtn.getPreferredSize();
		updateCustBtn.setBounds(25 + insets.left, 250 + insets.top, size.width + 60, size.height);
		
		size = acceptCustBtn.getPreferredSize();
		acceptCustBtn.setBounds(25 + insets.left, 250 + insets.top, size.width + 25, size.height);
		
		size = cancelCustomerBtn.getPreferredSize();
		cancelCustomerBtn.setBounds(250 + insets.left, 250 + insets.top, size.width + 25, size.height);

		//*******************************************************************************************
		//*********************INVOICE LOCATION******************************************************
		//*******************************************************************************************
		size = invoiceList.getPreferredSize();
		invoiceList.setBounds(65 + insets.left, 50 + insets.top, size.width + 300, 100 + size.height);
		
		size = addInvoiceBtn.getPreferredSize();
		addInvoiceBtn.setBounds(250 + insets.left, 10 + insets.top, size.width + 25, size.height);
		
		size = editInvoiceBtn.getPreferredSize();
		editInvoiceBtn.setBounds(25 + insets.left, 10 + insets.top, size.width + 25, size.height);

		size = deleteInvoiceBtn.getPreferredSize();
		deleteInvoiceBtn.setBounds(300 + insets.left, 200 + insets.top, size.width + 25, size.height);
		
		size = openInvoiceBtn.getPreferredSize();
		openInvoiceBtn.setBounds(300 + insets.left, 250 + insets.top, size.width + 25, size.height);
		
		size = closedInvoiceBtn.getPreferredSize();
		closedInvoiceBtn.setBounds(300 + insets.left, 300 + insets.top, size.width + 25, size.height);			
		//*******************************************************************************************
		//*********************INVENTORY LIST********************************************************
		//*******************************************************************************************
		size = inventoryList.getPreferredSize();
		inventoryList.setBounds(65 + insets.left, 50 + insets.top, size.width + 300, 100 + size.height);

		size = mainMenuBtn.getPreferredSize();
		mainMenuBtn.setBounds(65 + insets.left, 250 + insets.top, size.width + 30, 20 + size.height);
		
		size = addInventoryBtn.getPreferredSize();
		addInventoryBtn.setBounds(250 + insets.left, 10 + insets.top, size.width + 25, size.height);
		
		size = editInventoryBtn.getPreferredSize();
		editInventoryBtn.setBounds(25 + insets.left, 10 + insets.top, size.width + 25, size.height);
	}
	

	/**
	 * Overrides action listener to be able to use functionality of the buttons
	 * @param a ActionEvent if button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent a) {
		
		int currentCustIndex= customerList.getSelectedIndex();
		int currentSlsPersonIndex= salesPersonList.getSelectedIndex();		

		//********************************Customer********************************	
		if (a.getSource() == customerBtn) {
				
			for (int i = 0; i < cust.size(); i++) {
				customerTasks.addElement(cust.get(i).getCustID()+"    "+ cust.get(i).getFirstName()+"    "+ cust.get(i).getLastName()+"    "+  cust.get(i).getSalesTax());
			}
			remove(menuLbl);remove(customerBtn);remove(salesPersonBtn);remove(invoiceBtn);remove(inventoryBtn);
			add(customerList);add(mainMenuBtn);add(addCustomerBtn);add(editCustomerBtn);
			add(deleteCustBtn);
			repaint();
			
		}else if (a.getSource() ==  addCustomerBtn) {
			remove(customerList);remove(mainMenuBtn);remove(addCustomerBtn);remove(editCustomerBtn);remove(deleteCustBtn);
			add(custFNameLbl);add(custLNameLbl);add(custSlsTaxLbl);add(custIDLbl);add(tfCustFName);add(tfCustLName);add(tfCustID);add(tfCustSlsTax);
			add(acceptCustBtn);	add(cancelCustomerBtn);
			repaint();
			
			
		}else if ( a.getSource() == acceptCustBtn) {
			addCustomer();
			add(menuLbl);add(customerBtn);add(salesPersonBtn);add(invoiceBtn);add(inventoryBtn);
			remove(custFNameLbl);remove(custLNameLbl);remove(custSlsTaxLbl);remove(custIDLbl);remove(tfCustFName);remove(tfCustLName);
			remove(tfCustID);remove(tfCustSlsTax);remove(acceptCustBtn);remove(cancelCustomerBtn);
			repaint();
		}else if ( a.getSource() == cancelCustomerBtn) {
			add(customerList);add(mainMenuBtn);add(addCustomerBtn);add(editCustomerBtn);add(deleteCustBtn);
			remove(custFNameLbl);remove(custLNameLbl);remove(custSlsTaxLbl);remove(custIDLbl);remove(tfCustFName);remove(tfCustLName);remove(tfCustID);
			remove(tfCustSlsTax);remove(acceptCustBtn);remove(cancelCustomerBtn);remove(updateCustBtn);
			repaint();
			
		}
		else if (a.getSource()== editCustomerBtn){
            try {    
                remove(customerList);remove(mainMenuBtn);remove(addCustomerBtn);remove(editCustomerBtn);remove(deleteCustBtn);
                add(cancelCustomerBtn);add(custFNameLbl);add(custLNameLbl);add(custSlsTaxLbl);add(custIDLbl);add(tfCustFName);
                add(tfCustLName);add(tfCustID);add(tfCustSlsTax);add(updateCustBtn);
                
                
                
                    tfCustFName.setText(cust.get(currentCustIndex).getFirstName());
                    tfCustLName.setText(cust.get(currentCustIndex).getLastName());
                    tfCustID.setText(String.valueOf(cust.get(currentCustIndex).getCustID()));
                    tfCustSlsTax.setText(String.valueOf(cust.get(currentCustIndex).getSalesTax()) );
                    repaint();
                }

                catch (IndexOutOfBoundsException i) {
                    JOptionPane.showMessageDialog(this, "There is no customer to edit");
                    remove(cancelCustomerBtn);remove(custFNameLbl);remove(custLNameLbl);remove(custSlsTaxLbl);remove(custIDLbl);remove(tfCustFName);
                    remove(tfCustLName);remove(tfCustID);remove(tfCustSlsTax);remove(updateCustBtn);
                    add(customerList);add(mainMenuBtn);add(addCustomerBtn);add(editCustomerBtn);
                    add(deleteCustBtn);
                    repaint();
                }
                        
        
		}else if (a.getSource() ==deleteCustBtn) {
			try {
				customerTasks.remove(currentCustIndex);
				removeCustomer(currentCustIndex);
				repaint();

			} catch (ArrayIndexOutOfBoundsException ab) {
				JOptionPane.showMessageDialog(this, "There is no customer to Delete");
			}

		//********************************SalesPerson********************************	
		}else if (a.getSource() == salesPersonBtn) {			
			for (int i = 0; i < sales.size(); i++) {
				salesPersonTasks.addElement(sales.get(i).getSalesID()+"    "+ sales.get(i).getFirstName()+"    "+ sales.get(i).getLastName()+"    "+  sales.get(i).getComissionRate());
			}
			
			remove(menuLbl);remove(customerBtn);remove(salesPersonBtn);remove(invoiceBtn);remove(inventoryBtn);
			add(salesPersonList);add(mainMenuBtn);add(addSalesPersonBtn);add(editSalesPersonBtn);add(deleteSlsPersonBtn);
			repaint();
			
		}else if (a.getSource() == addSalesPersonBtn){
			
			remove(salesPersonList);remove(mainMenuBtn);remove(addSalesPersonBtn);remove(editSalesPersonBtn);remove(deleteSlsPersonBtn);
			add(slsPersonFNameLbl);add(slsPersonLNameLbl);add(slsPersonComissionLbl);add(slsPersonIDLbl);add(tfSlsPersonFName);
			add(tfSlsPersonLName);add(tfSlsPersonID);add(tfSlsPersonCommission);add(acceptSlsPersonBtn);add(cancelSlsPersonBtn);
			repaint();
			
		}else if (a.getSource()==acceptSlsPersonBtn) {
			
			addSalesperson();
			add(menuLbl);add(customerBtn);add(salesPersonBtn);add(invoiceBtn);add(inventoryBtn);
			remove(slsPersonFNameLbl);remove(slsPersonLNameLbl);remove(slsPersonComissionLbl);remove(slsPersonIDLbl);remove(tfSlsPersonFName);remove(tfSlsPersonLName);
			remove(tfSlsPersonID);remove(tfSlsPersonCommission);remove(acceptSlsPersonBtn);remove(cancelSlsPersonBtn);
			repaint();	
		}else if (a.getSource() == cancelSlsPersonBtn) {

			remove(slsPersonFNameLbl);remove(slsPersonLNameLbl);remove(slsPersonComissionLbl);remove(slsPersonIDLbl);remove(tfSlsPersonFName);
			remove(tfSlsPersonLName);remove(tfSlsPersonID);remove(tfSlsPersonCommission);remove(acceptSlsPersonBtn);remove(cancelSlsPersonBtn);			
			remove(menuLbl);remove(customerBtn);remove(salesPersonBtn);remove(invoiceBtn);remove(inventoryBtn);
			add(salesPersonList);add(mainMenuBtn);add(addSalesPersonBtn);add(editSalesPersonBtn);add(deleteSlsPersonBtn);
			repaint();
		}else if (a.getSource() == editSalesPersonBtn) {
            try {
                remove(salesPersonList);remove(mainMenuBtn);remove(addSalesPersonBtn);remove(editSalesPersonBtn);remove(deleteSlsPersonBtn);
                add(slsPersonFNameLbl);add(slsPersonLNameLbl);add(slsPersonComissionLbl);add(slsPersonIDLbl);add(tfSlsPersonFName);
                add(tfSlsPersonLName);add(tfSlsPersonID);add(tfSlsPersonCommission);add(updateSlsPersonBtn);add(cancelSlsPersonBtn);
                tfSlsPersonFName.setText(sales.get(currentCustIndex).getFirstName());
                tfSlsPersonLName.setText(sales.get(currentCustIndex).getLastName());
                tfSlsPersonID.setText(String.valueOf(sales.get(currentCustIndex).getSalesID()));
                tfSlsPersonCommission.setText(String.valueOf(sales.get(currentCustIndex).getComissionRate()) );
                repaint();
            }catch (IndexOutOfBoundsException i) {
                JOptionPane.showMessageDialog(this, "There is no salesperson to edit");
                add(salesPersonList);add(mainMenuBtn);add(addSalesPersonBtn);add(editSalesPersonBtn);add(deleteSlsPersonBtn);
                remove(slsPersonFNameLbl);remove(slsPersonLNameLbl);remove(slsPersonComissionLbl);remove(slsPersonIDLbl);remove(tfSlsPersonFName);
                remove(tfSlsPersonLName);remove(tfSlsPersonID);remove(tfSlsPersonCommission);remove(updateSlsPersonBtn);remove(cancelSlsPersonBtn);
                repaint();
            }
        }
		else if(a.getSource() == deleteSlsPersonBtn) {
			try {
				salesPersonTasks.remove(currentSlsPersonIndex);
				removeCustomer(currentSlsPersonIndex);
				repaint();

			} catch (ArrayIndexOutOfBoundsException ab) {
				JOptionPane.showMessageDialog(this, "There is no SalesPerson to Delete");
			}
		}

		//********************************Invoice********************************	
		else if (a.getSource() == invoiceBtn) {
			remove(menuLbl);remove(customerBtn);remove(salesPersonBtn);remove(invoiceBtn);remove(inventoryBtn);
			add(invoiceList);add(addInvoiceBtn);add(mainMenuBtn);add(editInvoiceBtn);add(deleteInvoiceBtn);add(openInvoiceBtn);add(closedInvoiceBtn);
			repaint();
		}
		else if (a.getSource() == addInvoiceBtn) {
			remove(invoiceList);remove(addInvoiceBtn);remove(mainMenuBtn);remove(editInvoiceBtn);remove(deleteInvoiceBtn);remove(openInvoiceBtn);remove(closedInvoiceBtn);
			makeInvoice();
		}
		else if (a.getSource() == closedInvoiceBtn) {
			remove(invoiceList);remove(addInvoiceBtn);remove(mainMenuBtn);remove(editInvoiceBtn);remove(deleteInvoiceBtn);remove(openInvoiceBtn);
			remove(closedInvoiceBtn);
			repaint();
			
			
			
		}else if (a.getSource() == openInvoiceBtn) {
			remove(invoiceList);remove(addInvoiceBtn);remove(mainMenuBtn);remove(editInvoiceBtn);remove(deleteInvoiceBtn);
			remove(openInvoiceBtn);
			remove(closedInvoiceBtn);
			repaint();
			
			
		}
		
		//********************************Inventory********************************	
		else if (a.getSource() == inventoryBtn) {
			remove(menuLbl);
			remove(customerBtn);
			remove(salesPersonBtn);
			remove(invoiceBtn);
			remove(inventoryBtn);
			add(inventoryList);
			add(mainMenuBtn);
			add(addInventoryBtn);
			add(editInventoryBtn);
			repaint();
		}
		else if (a.getSource() == mainMenuBtn) {
				remove(addCustomerBtn);remove(addSalesPersonBtn);remove(addInvoiceBtn);remove(addInventoryBtn);remove(editCustomerBtn);remove(editSalesPersonBtn);
				remove(editInvoiceBtn);remove(editInventoryBtn);remove(customerList);remove(mainMenuBtn);remove(invoiceList);remove(inventoryList);
				remove(salesPersonList);remove(deleteInvoiceBtn);remove(openInvoiceBtn);remove(closedInvoiceBtn);remove(deleteCustBtn);remove(deleteSlsPersonBtn);
				add(menuLbl);add(customerBtn);add(salesPersonBtn);add(invoiceBtn);add(inventoryBtn);
				repaint();
			
		
		}
	
	}// end actionListner
	
	
	/** monitors when mouse is pressed
	 * @param e mouse event
	*/
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	/** monitors when mouse is released
	 * @param e mouse event
	*/
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	/** monitors when mouse enters a field
	 * @param e mouse event
	*/
	@Override
	public void mouseEntered(MouseEvent e) {		
	}
	
	/** monitors when mouse exits an area
	 * @param e mouse event
	*/
	@Override
	public void mouseExited(MouseEvent e) {
	}

	/** monitors when mouse is clicked
	 * @param e mouse event
	*/
	@Override
	public void mouseClicked(MouseEvent e) {
		addMouseListener(this);
		// TODO Auto-generated method stub
		
		
	}
	
	public void addCustomer() {
		double tax = Double.parseDouble(tfCustSlsTax.getText());
		cust.add(new Customer(Integer.parseInt(tfCustID.getText()),tfCustFName.getText(),tfCustLName.getText(), tax ));
		//cust.add(new Customer(1,"poop","caca",23.5));
	}
	public void editCustomer(int index) {
		String fName = tfCustFName.getText();
		String lName = tfCustLName.getText();
		double slsTax = Double.parseDouble(tfCustSlsTax.getText());
		cust.get(index).editCustomer(fName,lName, slsTax);	
	
	}
	public void removeCustomer(int index ) {
		cust.remove(index);
	}
	
	public void removeSalesperson(int index) {
		sales.remove(index);
	}
	public void editSalesPerson(int index) {
		String fName = tfSlsPersonFName.getText();
		String lName =tfSlsPersonLName.getText();
		double comission = Double.parseDouble(tfSlsPersonCommission.getText());
		int id = Integer.parseInt(tfSlsPersonID.getText());
		sales.get(index).editSalesPerson(fName, lName, comission);
	}
	
	public void addSalesperson() {
		String fName = tfSlsPersonFName.getText();
		String lName =tfSlsPersonLName.getText();
		double comission = Double.parseDouble(tfSlsPersonCommission.getText());
		int id = Integer.parseInt(tfSlsPersonID.getText());
		sales.add(new Salesperson(fName,lName,comission,id));
		//sales.add(new Salesperson("Mas","Puta", 12.2, 123));
	}
	
	public void boughtProduct() {
		prods.add(new PurchasedProduct("Cookies", 5));
	}
	public void makeInvoice() {
		//Salesperson s = sales.get(0);
		//Customer c = cust.get(0);
		sales.add(new Salesperson("Viet","Nguyen",2.35,123));
		cust.add(new Customer(222,"Wil","Mendy",12.9));
//		System.out.println(s);
//		System.out.println(c);
		inv.add(new Invoice(345, sales.get(0), cust.get(0),12.67));
	}
	
	public void mainMenuDisplays() {
		Insets insets = getInsets();
		Dimension size = customerBtn.getPreferredSize();
		//main menu items
		size = customerBtn.getPreferredSize();
		customerBtn.setBounds(65 + insets.left, 100 + insets.top, size.width + 10, size.height);
		
		size = salesPersonBtn.getPreferredSize();
		salesPersonBtn.setBounds(65 + insets.left, 150 + insets.top, size.width + 10, size.height);
		
		size = invoiceBtn.getPreferredSize();
		invoiceBtn.setBounds(65 + insets.left, 200 + insets.top, size.width + 10, size.height);
		
		size = inventoryBtn.getPreferredSize();
		inventoryBtn.setBounds(65 + insets.left, 250 + insets.top, size.width + 10, size.height);		
		//tf loadout
		size = menuLbl.getPreferredSize();
		menuLbl.setBounds(150 + insets.left, 20 + insets.top, size.width + 10, size.height);

	}

}// end panel
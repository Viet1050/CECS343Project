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
	private JButton btnSubmit, btnCompleted, btnPostpone, btnQuit, btnAddTask, btnAddTaskSubmit;
	private JButton salesPersonBtn, customerBtn, inventoryBtn, invoiceBtn,mainMenuBtn, addCustomerBtn, addSalesPersonBtn,
	addInvoiceBtn, addInventoryBtn, editCustomerBtn, editSalesPersonBtn,editInvoiceBtn, editInventoryBtn,
	openInvoiceBtn,closedInvoiceBtn,deleteInvoiceBtn,acceptCustBtn, cancelCustomerBtn,acceptSlsPersonBtn, cancelSlsPersonBtn;

	/** List in panel */
	private JList<String> lstList;
	private JList<String> customerList, salesPersonList, inventoryList, invoiceList;
	/** vector to save Task objects into */
	private Vector<String> vectorTaskList = new Vector<String>();

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
		lstList = new JList<>(tasks);
		customerList= new JList<>(customerTasks);
		salesPersonList= new JList<>(salesPersonTasks);
		invoiceList= new JList<>(invoiceTasks);
		inventoryList= new JList<>(inventoryTasks);
		addCustomer();
		addSalesperson();
		boughtProduct();
		makeInvoice();
		//System.out.println(cust.size());
		System.out.println("Customer");
		System.out.println("Pre-edit: "+cust.get(0).getCustID()+" "+cust.get(0).getFirstName()+" "+ cust.get(0).getLastName()+" " + cust.get(0).getSalesTax());
		cust.get(0).editCustomer( "f", "l", 100);
		System.out.println("Post-edit: "+cust.get(0).getCustID()+" "+cust.get(0).getFirstName()+" "+ cust.get(0).getLastName()+" " + cust.get(0).getSalesTax());
		
		System.out.println("\nSalesperson");
		System.out.println("Pre-edit: "+sales.get(0).getSalesID()+" "+sales.get(0).getFirstName()+" "+ sales.get(0).getLastName()+" " + sales.get(0).getComissionRate());
		sales.get(0).editSalesPerson("A", "La Verga", 22.4);
		System.out.println("Post-edit: "+sales.get(0).getSalesID()+" "+sales.get(0).getFirstName()+" "+ sales.get(0).getLastName()+" " + sales.get(0).getComissionRate());
		
		System.out.println("\nPurchased Product");
		System.out.println(prods.get(0).getName()+" "+prods.get(0).getQuanitity());
		
		System.out.println("\nInvoice");
		System.out.println("pre-edit: "+" "+inv.get(0).getInvoiceID()+" "+inv.get(0).getSalesperson()+" "+inv.get(0).getCustomer()+" "+inv.get(0).getProducts()+" "+inv.get(0).getCost());
		inv.get(0).editInvoice(false, 45.99);
		System.out.println("post-edit: "+" "+inv.get(0).getInvoiceID()+" "+inv.get(0).getSalesperson()+" "+inv.get(0).getCustomer()+" "+inv.get(0).getProducts()+" "+inv.get(0).getCost());
		customerTasks.addElement(cust.get(0).getCustID()+"  " +cust.get(0).getFirstName()+" "+ cust.get(0).getLastName()+" " +cust.get(0).getSalesTax());
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
		tfCustFName.addMouseListener(this);
		
		tfCustLName = new JTextField("");
		tfCustLName.addMouseListener(this);
		
		tfCustID = new JTextField("");
		tfCustID.addMouseListener(this);

		tfCustSlsTax = new JTextField("");
		tfCustSlsTax.addMouseListener(this);
		
		//SALESPERSON GROUP
		tfSlsPersonFName = new JTextField("");
		tfSlsPersonFName.addMouseListener(this);
		
		tfSlsPersonLName = new JTextField("");
		tfSlsPersonLName.addMouseListener(this);
		
		tfSlsPersonID = new JTextField("");
		tfSlsPersonID.addMouseListener(this);

		tfSlsPersonCommission = new JTextField("");
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

		// postpone button function
		btnPostpone = new JButton("Postpone");
		btnPostpone.addActionListener(this);

		// quit button function
		btnQuit = new JButton("QUIT");
		btnQuit.addActionListener(this);

		// add Task button function
		btnAddTask = new JButton("ADD Task");
		btnAddTask.addActionListener(this);

		// add AddTaskSubmit Button
		btnAddTaskSubmit = new JButton("Submit");
		btnAddTaskSubmit.addActionListener(this);
		
		acceptCustBtn = new JButton("Submit");
		acceptCustBtn.addActionListener(this);
		
		cancelCustomerBtn = new JButton("Cancel");
		cancelCustomerBtn.addActionListener(this);

		acceptSlsPersonBtn = new JButton("Submit");
		acceptSlsPersonBtn.addActionListener(this);
		
		cancelSlsPersonBtn = new JButton("Cancel");
		cancelSlsPersonBtn.addActionListener(this);
		// ***************************ADD LABEL GROUP*******************************************
		add(menuLbl);
		// ***************************ADD TEXT FIELD GROUP***************************************

		
		// ***************************ADD BUTTON GROUP******************************************
		add(customerBtn);
		add(salesPersonBtn);
		add(invoiceBtn);
		add(inventoryBtn);
		// ***************************ADD LIST GROUP*********************************************
		add(lstList);
		// ***************************SET LAYOUT STYLE FOR PANEL**********************************		
		
		setLayout(null);
		// menu screen loadouts
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

		//*******************************************************************************************
		//*********************CUSTOMER LOCATION*****************************************************
		//*******************************************************************************************
		//size = customerList.getPreferredSize();
		//customerList.setBounds(65 + insets.left, 50 + insets.top, size.width + 300, 100 + size.height);
		size = customerList.getPreferredSize();
		customerList.setBounds(65 + insets.left, 100 + insets.top, size.width + 300, 100 + size.height);
		
		size = addCustomerBtn.getPreferredSize();
		addCustomerBtn.setBounds(250 + insets.left, 10 + insets.top, size.width + 25, size.height);
		
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
		
		int currentIndex= lstList.getSelectedIndex();		
		int currentCustIndex= customerList.getSelectedIndex();		

		if (a.getSource() == customerBtn) {
			
			remove(customerBtn);
			remove(salesPersonBtn);
			remove(invoiceBtn);
			remove(inventoryBtn);			
			remove(menuLbl);
			add(customerList);
			add(mainMenuBtn);
			add(addCustomerBtn);
			add(editCustomerBtn);
			repaint();
			
		}else if (a.getSource() ==  addCustomerBtn) {
			remove(customerList);
			remove(mainMenuBtn);
			remove(addCustomerBtn);
			remove(editCustomerBtn);
			add(custFNameLbl);
			add(custLNameLbl);
			add(custSlsTaxLbl);
			add(custIDLbl);
			add(tfCustFName);
			add(tfCustLName);
			add(tfCustID);
			add(tfCustSlsTax);
			add(acceptCustBtn);
			add(cancelCustomerBtn);
			repaint();
			
			
		}else if ( a.getSource() == cancelCustomerBtn) {
			add(customerList);
			add(mainMenuBtn);
			add(addCustomerBtn);
			add(editCustomerBtn);
			remove(custFNameLbl);
			remove(custLNameLbl);
			remove(custSlsTaxLbl);
			remove(custIDLbl);
			remove(tfCustFName);
			remove(tfCustLName);
			remove(tfCustID);
			remove(tfCustSlsTax);
			remove(acceptCustBtn);
			remove(cancelCustomerBtn);
			repaint();
			
		}else if (a.getSource()== editCustomerBtn){
			remove(customerList);
			remove(mainMenuBtn);
			remove(addCustomerBtn);
			remove(editCustomerBtn);

			add(custFNameLbl);
			add(custLNameLbl);
			add(custSlsTaxLbl);
			add(custIDLbl);
			add(tfCustFName);
			add(tfCustLName);
			add(tfCustID);
			add(tfCustSlsTax);
			tfCustFName.setText(cust.get(currentCustIndex).getFirstName());
			tfCustLName.setText(cust.get(currentCustIndex).getLastName());
			tfCustID.setText(String.valueOf(cust.get(currentCustIndex).getCustID()));
			tfCustSlsTax.setText(String.valueOf(cust.get(currentCustIndex).getFirstName()) );
			repaint();
			
		}else if (a.getSource() == salesPersonBtn) {			
		
		
			remove(menuLbl);
			remove(customerBtn);
			remove(salesPersonBtn);
			remove(invoiceBtn);
			remove(inventoryBtn);
			add(salesPersonList);
			add(mainMenuBtn);
			add(addSalesPersonBtn);
			add(editSalesPersonBtn);
			repaint();
			
		}else if (a.getSource() == addSalesPersonBtn){
			
			remove(salesPersonList);
			remove(mainMenuBtn);
			remove(addSalesPersonBtn);
			remove(editSalesPersonBtn);
			add(slsPersonFNameLbl);
			add(slsPersonLNameLbl);
			add(slsPersonComissionLbl);
			add(slsPersonIDLbl);
			add(tfSlsPersonFName);
			add(tfSlsPersonLName);
			add(tfSlsPersonID);
			add(tfSlsPersonCommission);
			add(acceptSlsPersonBtn);
			add(cancelSlsPersonBtn);
			repaint();
			
			
		}else if (a.getSource() == invoiceBtn) {
		
			remove(menuLbl);
			remove(customerBtn);
			remove(salesPersonBtn);
			remove(invoiceBtn);
			remove(inventoryBtn);
			add(invoiceList);
			add(addInvoiceBtn);
			add(mainMenuBtn);
			add(editInvoiceBtn);
			add(deleteInvoiceBtn);
			add(openInvoiceBtn);
			add(closedInvoiceBtn);
			repaint();
		}else if (a.getSource() == closedInvoiceBtn) {
			remove(invoiceList);
			remove(addInvoiceBtn);
			remove(mainMenuBtn);
			remove(editInvoiceBtn);
			remove(deleteInvoiceBtn);
			remove(openInvoiceBtn);
			remove(closedInvoiceBtn);
			repaint();
			
			
			
		}else if (a.getSource() == openInvoiceBtn) {
			remove(invoiceList);
			remove(addInvoiceBtn);
			remove(mainMenuBtn);
			remove(editInvoiceBtn);
			remove(deleteInvoiceBtn);
			remove(openInvoiceBtn);
			remove(closedInvoiceBtn);
			repaint();
			
			
		}
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
		}else if (a.getSource() == btnCompleted) {
			
				try {
					Insets insets = getInsets();
					Dimension size;
					lstList.getSelectedIndex();
					//change layout of panels
					remove(lstList);
					//remove(lblTaskPostponed);
					add(lstList);
					//set taskCompleted to green
					//lblTaskCompleted.setForeground(Color.green);
					//add TaskCompleted label when user presses completed
					//add(lblTaskCompleted);
					
					//remove item from heap and vector
//					vectorTaskList.remove(0);
//					heap.removeItem();
					//remove first item from taskList
					System.out.println(currentIndex);
				//	vectorTaskList.remove(currentIndex);

					tasks.remove(lstList.getSelectedIndex());
					System.out.println("before removal");
					for(int i=0; i<vectorTaskList.size();i++) {
						System.out.println(vectorTaskList.get(i));
					}
					vectorTaskList.remove(currentIndex);
					System.out.println("");
					System.out.println("After Removal");
					for(int i=0; i<vectorTaskList.size();i++) {
						System.out.println(vectorTaskList.get(i));
					}
					//change completedBy and current task to new index 0
//					tfCompletedBy.setText(vectorTaskList.get(0).getDueDate());
//					tfCurrentTask.setText(vectorTaskList.get(0).getTask());
					
					//size = lblTaskCompleted.getPreferredSize();
					//lblTaskCompleted.setBounds(200 + insets.left, 23 + insets.top, size.width + 5, size.height);
					repaint();

				} catch (ArrayIndexOutOfBoundsException ab) {
					JOptionPane.showMessageDialog(this, "there is nothing else to complete");
				}
		}
		else if (a.getSource() == mainMenuBtn) {
				remove(addCustomerBtn);
				remove(addSalesPersonBtn);
				remove(addInvoiceBtn);
				remove(addInventoryBtn);
				remove(editCustomerBtn);
				remove(editSalesPersonBtn);
				remove(editInvoiceBtn);
				remove(editInventoryBtn);
				remove(customerList);
				remove(mainMenuBtn);
				remove(invoiceList);
				remove(inventoryList);
				remove(salesPersonList);
				remove(deleteInvoiceBtn);
				remove(openInvoiceBtn);
				remove(closedInvoiceBtn);
				add(menuLbl);
				add(customerBtn);
				add(salesPersonBtn);
				add(invoiceBtn);
				add(inventoryBtn);
				repaint();
			
		
		}else if (a.getSource() == btnAddTaskSubmit) {
			try {
				
			} catch (ArrayIndexOutOfBoundsException ab) {
				JOptionPane.showMessageDialog(this, "Please dont mash submit button");
			} catch (NumberFormatException exception) {
				JOptionPane.showMessageDialog(this, "input must only be integers");
			} catch (StringIndexOutOfBoundsException siobe) {
				JOptionPane.showMessageDialog(this, "Out of Bounds Error");
			}

		} // end btnAddTaskSubmit
		else if (a.getSource() == btnSubmit) {
		} // end button submit
	
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
		
		//make it so each is cleared as you click
		//if( e.getSource()==tfMonth) {
		//	tfMonth.setText("");			
		//	}
		
	}
	
	public void addCustomer() {
		cust.add(new Customer(1,"poop","caca",23.5));
	}
	
	public void removeCustomer(int index ) {
		cust.remove(index);
	}
	
	public void addSalesperson() {
		sales.add(new Salesperson("Mas","Puta", 12.2, 123));
	}
	
	public void boughtProduct() {
		prods.add(new PurchasedProduct("Cookies", 5));
	}
	public void makeInvoice() {
		Salesperson s = sales.get(0);
		Customer c = cust.get(0);
		System.out.println(s);
		System.out.println(c);
		inv.add(new Invoice(345, s, c, prods, 12.67));
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
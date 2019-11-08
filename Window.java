package test;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
* Window Class - Create a window
* @author Wilfredo Mendivil, Viet Nguyen
*/
public class Window extends JFrame {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		
		

		
		
		Window w = new Window();	
	}
	
	/**
	*  Constructor  Window sets window parameter 
	*/
	public Window() {
		setBounds(250, 200, 500, 500);// x,y,w,h of window
		setTitle("TaskList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new Panel());
		setVisible(true);
	}

}
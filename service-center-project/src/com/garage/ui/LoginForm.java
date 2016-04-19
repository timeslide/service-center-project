package com.garage.ui;
   
import com.garage.beans.User;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/**
 *  
 * This class represents login form
 *
 */
public class LoginForm extends JFrame implements ActionListener
{
     
 private JButton submitButton;
 private JButton cancelButton;
 private JPanel userNamePanel;
 private JPanel passwordPanel;
 private	JPanel		buttonPanel;
 private	JPanel		mainPanel;
 private JLabel userLabel,passwordLabel;
 private CustomerHome customerHome;
 private StockManagerHome stockManagerHome;
 private ManagerHome managerHome;
 private  MechanicHome mechanicHome;
 
 final JTextField  userText,passwordText;
  LoginForm(CustomerHome customerHome,StockManagerHome stockManagerHome,ManagerHome managerHome, MechanicHome mechanicHome)
  { 
  this.customerHome =customerHome;
  this.stockManagerHome=stockManagerHome;
  this.managerHome = managerHome;
  this.mechanicHome=mechanicHome;
  userLabel = new JLabel();
  userLabel.setText("Username:");
  
  userText = new JTextField(20);
  passwordLabel = new JLabel();
  passwordLabel.setText("Password:");
  passwordText = new JPasswordField(20);
 
  submitButton=new JButton("Login");

  cancelButton=new JButton("Cancel");
  
  userNamePanel=new JPanel() ;
  userNamePanel.add(userLabel);
  userNamePanel.add(userText);
    
  passwordPanel=new JPanel();
  passwordPanel.add(passwordLabel);
  passwordPanel.add(passwordText); 
  
  
  buttonPanel = new JPanel();
 
  buttonPanel.add(submitButton);
  buttonPanel.add(cancelButton);

  mainPanel = new JPanel();
   
  mainPanel.setLayout(new GridLayout(3,1));
  mainPanel.add(userNamePanel);
  mainPanel.add(passwordPanel);
  mainPanel.add(buttonPanel);
  
  add(mainPanel,BorderLayout.NORTH);
  submitButton.setActionCommand("submit");
  submitButton.addActionListener(this);

  cancelButton.setActionCommand("cancel");
  cancelButton.addActionListener(this);
  setTitle("LOGIN FORM");
  }
 public void actionPerformed(ActionEvent ae)
  {
   if("submit".equalsIgnoreCase(ae.getActionCommand())){
	   String userName=userText.getText();
	   String password=passwordText.getText();
	     User user = new User();
	     user.setUserName(userName);
	     user.setPassword(password);
	    if (user.validateUser(userName, password) ) {
	        this.setVisible(false);
	        if("customer".equalsIgnoreCase(userName)){
	         this.customerHome.setVisible(true);
	         
	        }else if("stockmanager".equalsIgnoreCase(userName)){
	          this.stockManagerHome.setVisible(true);
	          
	        }else if("manager".equalsIgnoreCase(userName)){
	          this.managerHome.getRepairJobsScreen().loadData();
	            this.managerHome.setVisible(true);
	          }else if("mechanic".equalsIgnoreCase(userName)){
	            this.mechanicHome.getPendingRepairJobsScreen().loadData();
	            this.mechanicHome.setVisible(true);
	          }
	       
	        //this.customerRequestForm.setVisible(true);
	    }
	   else{
	   System.out.println("enter the valid username and password");
	   JOptionPane.showMessageDialog(this,"Incorrect login or password",
	   "Error",JOptionPane.ERROR_MESSAGE);
	   }   
   }else{
	   System.exit(0);
   }
  
}
}

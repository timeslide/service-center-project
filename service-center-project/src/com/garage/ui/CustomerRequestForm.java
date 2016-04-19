
package com.garage.ui;
  
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.garage.beans.CustomerRequest;
import com.garage.beans.RepairJob;
import com.garage.dao.RepairJobDAO;
/**
 * This class represents UI for customer home screen 
 * 
 *
 */
public class CustomerRequestForm extends JFrame implements ActionListener
{
	private RepairJobsScreen repairJobsScreen;
	private PendingRepairJobsScreen pendingRepairJobsScreen;
	private JButton submitButton;
	private JPanel panel;
	
	private JLabel vehicleTypeLabel,requestTypeLabel,vehicleNumberLabel;
	private final JComboBox<String>  vehicleTypeCombo,requestTypeCombo;
	private final JTextField vehicleNumberText;
    private RepairJobDAO repairJobDAO;
 
  public CustomerRequestForm(RepairJobDAO repairJobDAO)
  {
	  
  final JFrame currentObject = this;	  
  this.repairJobDAO = repairJobDAO;
	  
  
  JPanel vehicleTypePanel = new JPanel();
  vehicleTypeLabel = new JLabel();
  vehicleTypeLabel.setText("Vehicle Type:");
  vehicleTypePanel.add(vehicleTypeLabel);
  
  vehicleTypeCombo = new JComboBox<String>();
  vehicleTypeCombo.addItem(" Ford ");
  vehicleTypeCombo.addItem(" Rover ");
  vehicleTypeCombo.setSelectedIndex(0);
  vehicleTypeCombo.setPreferredSize(new Dimension(100,20));
  vehicleTypePanel.add(vehicleTypeCombo);
  

  JPanel requestTypePanel = new JPanel();
  
  requestTypeLabel = new JLabel();
  requestTypeLabel.setText("Request Type:");
  requestTypePanel.add(requestTypeLabel);
  
  requestTypeCombo = new JComboBox<String>();
  requestTypeCombo.addItem("New Exhaust");
  requestTypeCombo.addItem("New Tyres");
  requestTypeCombo.addItem("New Engine"); 
  requestTypeCombo.setSelectedIndex(0);
   
  requestTypePanel.add(requestTypeCombo);
  

  JPanel vehicleNumberPanel = new JPanel();
  
   vehicleNumberLabel = new JLabel("Vehicle Number:");
   vehicleNumberPanel.add(vehicleNumberLabel);
   vehicleNumberText = new JTextField(10);
   vehicleNumberPanel.add(vehicleNumberText);
  
  
  JPanel buttonPanel = new JPanel();
  submitButton=new JButton("Submit");
  JLabel space = new JLabel();
  space.setPreferredSize(new Dimension(50,5));
  buttonPanel.add(space);
  buttonPanel.add(submitButton);
	 JButton backButton = new JButton("Back");   
		//panel.add(btnUpdate); 
     backButton.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent e) {
         	currentObject.setVisible(false);
         	  
         }
		});
    
	buttonPanel.add(backButton);
	
  //
  panel=new JPanel(new GridLayout(4,1));
  panel.add(vehicleTypePanel); 
  panel.add(requestTypePanel);
  panel.add(vehicleNumberPanel);
  panel.add(buttonPanel);
  
  add(panel,BorderLayout.NORTH);
  submitButton.addActionListener(this);
  setTitle("CUSTOMER REQUEST FORM");
  }
 public void actionPerformed(ActionEvent ae)
  {
	 
	 String vehicleNumber=(String)vehicleNumberText.getText();
	if(vehicleNumber == null || vehicleNumber.trim().length()==0){
		JOptionPane.showMessageDialog(this,"Please enter vehicle number.",
				  "Error",JOptionPane.WARNING_MESSAGE);
		return;
	}
  vehicleNumber = vehicleNumber.trim();
	 
  String vehicleType=(String)vehicleTypeCombo.getSelectedItem();
  String requestType=(String)requestTypeCombo.getSelectedItem();
     
  repairJobDAO.addNewPendingRepairJob(vehicleType, requestType, vehicleNumber); 
       		
  System.out.println("Your Request has been submited successfully");
  JOptionPane.showMessageDialog(this,"Your Request has been submited successfully.",
  "Success",JOptionPane.INFORMATION_MESSAGE);
  
}
 public RepairJobsScreen getRepairJobsScreen() {
	return repairJobsScreen;
} 
 public void setRepairJobsScreen(RepairJobsScreen repairJobsScreen) {
	this.repairJobsScreen = repairJobsScreen;
}
 public PendingRepairJobsScreen getPendingRepairJobsScreen() {
	return pendingRepairJobsScreen;
}
 public void setPendingRepairJobsScreen(
		PendingRepairJobsScreen pendingRepairJobsScreen) {
	this.pendingRepairJobsScreen = pendingRepairJobsScreen;
}
 
}

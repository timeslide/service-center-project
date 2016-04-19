package com.garage.ui;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.garage.beans.RepairJob;
import com.garage.dao.RepairJobDAO;

/**
 * 
 * This class represents the UI for all repair jobs
 *
 */
class RepairJobsScreen
		extends 	JFrame
 {
	// Instance attributes used in this example
	private	JPanel		topPanel;
	private	JPanel		buttonPanel;
	private	JTable		table;
	private	JScrollPane scrollPane;
	final DefaultTableModel model ;
	final RepairJobDAO repairJobDAO;

	// Constructor of main frame
	public RepairJobsScreen(final RepairJobDAO repairJobDAO)
	{
		
		final JFrame currentObject = this;
		model = new DefaultTableModel() {
		      public boolean isCellEditable(int rowIndex, int colIndex) {
		    	  if(colIndex!=4){

			          return false;  
		    	  }else{
			          return true;
		    	  }
		        }
		      };
		 

		      
		this.repairJobDAO=repairJobDAO;
		// Set the frame characteristics
		setTitle( "Repair Jobs" );
		setSize( 600, 300 );
		setBackground( Color.gray );

		// Create a panel to hold all other components
		topPanel = new JPanel();
		buttonPanel = new JPanel();
		topPanel.setLayout( new GridLayout(2,1));
		getContentPane().add( topPanel );

		// Create columns names
		String columnNames[] = { "Customer Name", "Car Type", "Request Type", "Car Number","Status" };

		 model.setColumnIdentifiers(columnNames);		 
         
		 loadData();
 
		// Create a new table instance
		table = new JTable(model);  
		table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black); 
        
        // set the model to the table
        table.setModel(model);
        JComboBox<String> statusCombo = new JComboBox<String>();
        statusCombo.addItem("Pending");
        statusCombo.addItem("In-Progress");
        statusCombo.addItem("Completed");
          
        TableColumnModel columnModel = table.getColumnModel();
        TableColumn statusColumn = columnModel.getColumn(4);
        statusColumn.setCellEditor(new DefaultCellEditor(statusCombo));
              
		// Add the table to a scrolling pane
		scrollPane = new JScrollPane(table);
		  
		 JButton backButton = new JButton("Back");   
			//panel.add(btnUpdate); 
	        backButton.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	currentObject.setVisible(false);
	            	  
	            }
			});
	        
		JButton btnUpdate = new JButton("Update");  
		
		btnUpdate.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
             	int index = table.getSelectedRow();
                  // i = the index of the selected row
            	  if (index<0){
            		  JOptionPane.showMessageDialog(table,
                    		  "Please select record to update.",
                    		  "Warning",JOptionPane.WARNING_MESSAGE); 
            	  }else{
            		  
                      String status ="";
                      try{
                    	  status=model.getValueAt(index, 4).toString();
                      }catch(Exception ex){
                    	  status ="";
                      }
                        
                      repairJobDAO.updateJobStatus(index, status); 
                      JOptionPane.showMessageDialog(table,
                    		  "Job Status updated successfully.",
                    		  "Success",JOptionPane.INFORMATION_MESSAGE); 
            	  } 
                   
                                 
            }
        });
		
		buttonPanel.add(btnUpdate);
		buttonPanel.add(backButton);
		topPanel.add(scrollPane);
		topPanel.add(buttonPanel);
	}
	public void loadData(){
		if(model.getRowCount()>0){
			for(int row=0; row<model.getRowCount();row++){
				 model.removeRow(row);
			   
			}	
		}
         
		
      for(int i=0; i<repairJobDAO.getAllRepairJobs().size();i++){
			
			RepairJob repairJob = repairJobDAO.getAllRepairJobs().get(i);
			addRow(repairJob);
		   
		}
	}

	public void addRow(RepairJob repairJob){
		Object dataValues[] = new Object[5];
		dataValues[0] = repairJob.getCustomerName();
		dataValues[1] = repairJob.getVehicleType();
		dataValues[2] = repairJob.getRequestType();
		dataValues[3] = repairJob.getVehicleNumber();
		dataValues[4] = repairJob.getStatus(); 
		model.addRow(dataValues);
	}
} 
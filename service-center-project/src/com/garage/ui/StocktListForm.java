package com.garage.ui;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.garage.beans.RepairJob;
import com.garage.beans.StockItem;
import com.garage.dao.StockItemDAO;

class StocktListForm
		extends 	JFrame
 {
	// Instance attributes used in this example
	private	JPanel		topPanel;
	private	JPanel		buttonPanel;
	private	JTable		table;
	private	JScrollPane scrollPane;
	private final DefaultTableModel model;
	 

	// Constructor of main frame
	public StocktListForm(final StockItemDAO stockItemDAO)
	{
	  final JFrame currentObject = this;
		// Set the frame characteristics
		model =  new DefaultTableModel() {
		      public boolean isCellEditable(int rowIndex, int colIndex) {
		    	  if(colIndex==0){

			          return false;  
		    	  }else{
 			          return true;
		    	  }
		        }
		      };
		 
		setTitle( "Stock List" );
		setSize( 600, 300 );
		setBackground( Color.gray );

		// Create a panel to hold all other components
		topPanel = new JPanel();
		buttonPanel = new JPanel();
		topPanel.setLayout( new GridLayout(2, 1) );
		getContentPane().add( topPanel );

		// Create columns names
		String columnNames[] = { "Item", "Available stock" };
		
	    model.setColumnIdentifiers(columnNames);
	     
        for(StockItem stockItem:stockItemDAO.getAllStockItems()){
    	    Object dataValues[] = new Object[2];
	     	dataValues[0] = stockItem.getItemName();
		    dataValues[1] = Integer.toString(stockItem.getAvailableQty());		 
		    model.addRow(dataValues);
		}

		// Create a new table instance
		table = new JTable(model);
		table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
          
        JButton backButton = new JButton("Back");   
		//panel.add(btnUpdate); 
        backButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	currentObject.setVisible(false);
            	  
            }
		});
        JButton btnUpdate = new JButton("Update");   
		//panel.add(btnUpdate); 
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
            		  
                      int qty=0;
                      try{
                    	  qty= Integer.valueOf(model.getValueAt(index, 1).toString());
                      }catch(Exception ex){
                    	  JOptionPane.showMessageDialog(table,"Please enter valid quantity.",
                    					  "Error",JOptionPane.WARNING_MESSAGE);
                    	  model.setValueAt("0",index, 1);	
                    	  return;
                    			
                      }
                        
                      stockItemDAO.updateStockItem(index, qty); 
                      JOptionPane.showMessageDialog(table,
                    		  "Stock updated successfully.",
                    		  "Success",JOptionPane.INFORMATION_MESSAGE); 
            	  } 
                   
                                 
            }
        });
        
 	
		
		// Add the table to a scrolling pane
		scrollPane = new JScrollPane(table);
		buttonPanel.add(btnUpdate);
		buttonPanel.add(backButton);
		topPanel.add( scrollPane);
		topPanel.add( buttonPanel);
		 
		
	}
 
} 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garage.ui;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.garage.dao.RepairJobDAO;
 
/**
 *
 * This class represents UI for customer home screen
 */
public class CustomerHome extends JFrame{

	 private CustomerRequestForm customerRequestForm;
	 private LoginForm login;
    
    //Create the menu bar.
    public CustomerHome(RepairJobDAO repairJobDAO) {
         this.customerRequestForm = new CustomerRequestForm(repairJobDAO);
     	 this.customerRequestForm.setSize(600,250);
          
       
      final JMenuBar menuBar = new JMenuBar();
      
 
      JMenu newRequestMenu = new JMenu("Request");
      
      JMenuItem newMenuItem = new JMenuItem("New");
      newMenuItem.setMnemonic(KeyEvent.VK_N);
      newRequestMenu.add(newMenuItem); 
      newMenuItem.setActionCommand("New");
       
        
      menuBar.add(newRequestMenu);
      
      
      JMenu userMenu = new JMenu("User");
      
      JMenuItem logoutMenuItem = new JMenuItem("Logout");
      logoutMenuItem.setMnemonic(KeyEvent.VK_N);
      userMenu.add(logoutMenuItem); 
      userMenu.setActionCommand("Logout");
      menuBar.add(userMenu);
    
      
      MenuItemListener menuItemListener = new MenuItemListener();

      newMenuItem.addActionListener(menuItemListener);
      logoutMenuItem.addActionListener(menuItemListener);
      this.setJMenuBar(menuBar); 
       
  
    }
    class MenuItemListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {            
          if ("New".equalsIgnoreCase(e.getActionCommand()) ) {
               login.setVisible(false);
               customerRequestForm.setVisible(true);
          }else if ("Logout".equalsIgnoreCase(e.getActionCommand()) ) {
               login.setVisible(true);
               customerRequestForm.setVisible(false);
                 
          }
      
      }      
}

    public void setLogin(LoginForm login) {
        this.login = login;
    }
    public CustomerRequestForm getCustomerRequestForm() {
		return customerRequestForm;
	}
    
}


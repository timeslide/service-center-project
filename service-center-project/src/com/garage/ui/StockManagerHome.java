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

import com.garage.dao.StockItemDAO;
 
/**
 *
 * This class represents the home screen for stock manager.
 */
public class StockManagerHome extends JFrame{
 
    private StocktListForm stockList;
    private LoginForm login;
    
    //Create the menu bar.
    public StockManagerHome(StockItemDAO stockItemDAO) {
       
       this.stockList = new StocktListForm(stockItemDAO);
       this.stockList.setSize(600,250);
       
      final JMenuBar menuBar = new JMenuBar();
      
 
      JMenu newRequestMenu = new JMenu("Stock");
      
       
      JMenuItem previousMenuItem = new JMenuItem("view");
      previousMenuItem.setMnemonic(KeyEvent.VK_N);
      newRequestMenu.add(previousMenuItem); 
      previousMenuItem.setActionCommand("view");
       
      menuBar.add(newRequestMenu);
      
      
      JMenu userMenu = new JMenu("User");
      
      JMenuItem logoutMenuItem = new JMenuItem("Logout");
      logoutMenuItem.setMnemonic(KeyEvent.VK_N);
      userMenu.add(logoutMenuItem); 
      userMenu.setActionCommand("Logout");
      menuBar.add(userMenu);
    
      
      MenuItemListener menuItemListener = new MenuItemListener();
 
      previousMenuItem.addActionListener(menuItemListener);
      logoutMenuItem.addActionListener(menuItemListener);
      this.setJMenuBar(menuBar); 
      //customerRequestForm.setJMenuBar(menuBar);       
      //customerRequestList.setJMenuBar(menuBar); 
      
  
    }
    class MenuItemListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {            
          if ("view".equalsIgnoreCase(e.getActionCommand()) ) {
               login.setVisible(false); 
               stockList.setVisible(true);
               
          }else if ("Logout".equalsIgnoreCase(e.getActionCommand()) ) {
               login.setVisible(true);
               stockList.setVisible(false); 
               
          }
      
      }      
}

    public void setLogin(LoginForm login) {
        this.login = login;
    }
    
}


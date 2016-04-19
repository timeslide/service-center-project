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
* This class represents Home screen for manager
*/
public class MechanicHome extends JFrame{
 
    private PendingRepairJobsScreen pendingRepairJobsScreen;
    private LoginForm login;
    
    //Create the menu bar.
    public MechanicHome(RepairJobDAO repairJobDAO) {
      
      this.pendingRepairJobsScreen = new PendingRepairJobsScreen(repairJobDAO);
      this.pendingRepairJobsScreen.setSize(600,250);
          
      final JMenuBar menuBar = new JMenuBar();
      
 
      JMenu newRequestMenu = new JMenu("Repair Jobs");
       
      JMenuItem previousMenuItem = new JMenuItem("Pending repair jobs");
      previousMenuItem.setMnemonic(KeyEvent.VK_N);
      newRequestMenu.add(previousMenuItem); 
      previousMenuItem.setActionCommand("Pending");
       
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
          if ("Pending".equalsIgnoreCase(e.getActionCommand()) ) {
               login.setVisible(false); 
               pendingRepairJobsScreen.setVisible(true);
               
          }else if ("Logout".equalsIgnoreCase(e.getActionCommand()) ) {
               login.setVisible(true); 
               pendingRepairJobsScreen.setVisible(false);
               
          }
      
      }      
}

    public void setLogin(LoginForm login) {
        this.login = login;
    }
    public PendingRepairJobsScreen getPendingRepairJobsScreen() {
		return pendingRepairJobsScreen;
	}
    public void setPendingRepairJobsScreen(
			PendingRepairJobsScreen pendingRepairJobsScreen) {
		this.pendingRepairJobsScreen = pendingRepairJobsScreen;
	}
     
}


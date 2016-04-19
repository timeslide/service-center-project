package com.garage.ui;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.garage.dao.RepairJobDAO;

import sun.security.util.PendingException;
 
/**
 *
 * This class represents Home screen for manager
 */
public class ManagerHome extends JFrame{
 
    private RepairJobsScreen repairJobsScreen;
    private LoginForm login; 
    
    //Create the menu bar.
    public ManagerHome(final RepairJobDAO repairJobDAO) {
      
      this.repairJobsScreen = new RepairJobsScreen(repairJobDAO);
      this.repairJobsScreen.setSize(600,250);
        
      final JMenuBar menuBar = new JMenuBar();
      
 
      JMenu newRequestMenu = new JMenu("Repair Jobs");
       
      JMenuItem allRepairJobMenuItem = new JMenuItem("All repair jobs");
      allRepairJobMenuItem.setMnemonic(KeyEvent.VK_N);
      newRequestMenu.add(allRepairJobMenuItem); 
      allRepairJobMenuItem.setActionCommand("All");
       
      menuBar.add(newRequestMenu);
      
      
      JMenu userMenu = new JMenu("User");
      
      JMenuItem logoutMenuItem = new JMenuItem("Logout");
      logoutMenuItem.setMnemonic(KeyEvent.VK_N);
      userMenu.add(logoutMenuItem); 
      userMenu.setActionCommand("Logout");
      menuBar.add(userMenu);
    
      
      MenuItemListener menuItemListener = new MenuItemListener();
 
      allRepairJobMenuItem.addActionListener(menuItemListener);
      logoutMenuItem.addActionListener(menuItemListener);
      this.setJMenuBar(menuBar); 
      //customerRequestForm.setJMenuBar(menuBar);       
      //customerRequestList.setJMenuBar(menuBar); 
      
  
    }
    class MenuItemListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {            
          if ("All".equalsIgnoreCase(e.getActionCommand()) ) {
               login.setVisible(false); 
               repairJobsScreen.setVisible(true);
               
          }else if ("Logout".equalsIgnoreCase(e.getActionCommand()) ) {
               login.setVisible(true); 
               repairJobsScreen.setVisible(false);
               
          }
      
      }      
}

    public void setLogin(LoginForm login) {
        this.login = login;
    }
    public RepairJobsScreen getRepairJobsScreen() {
		return repairJobsScreen;
	}
    public void setRepairJobsScreen(RepairJobsScreen repairJobsScreen) {
		this.repairJobsScreen = repairJobsScreen;
	}
    
}


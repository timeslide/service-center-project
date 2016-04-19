package com.garage.ui; 
 

import com.garage.dao.RepairJobDAO;
import com.garage.dao.StockItemDAO;
 
/**
 * To run this project execute main method of this class.
 *
 */
public class Garage{
 
     
    private LoginForm login; 
    private CustomerHome customerHome;  
    private StockManagerHome stockManagerHome;
    private ManagerHome managerHome; 
    private MechanicHome mechanicHome;
    private RepairJobDAO repairJobDAO;
    private StockItemDAO stockItemDAO;
    
      public  void start(){ 
      repairJobDAO = new RepairJobDAO();
      stockItemDAO = new StockItemDAO();
      customerHome = new CustomerHome(repairJobDAO); 
      stockManagerHome = new StockManagerHome(stockItemDAO);
      managerHome = new ManagerHome(repairJobDAO);
       

      customerHome.getCustomerRequestForm().setRepairJobsScreen(managerHome.getRepairJobsScreen());
      mechanicHome = new MechanicHome(repairJobDAO);
      customerHome.getCustomerRequestForm().setPendingRepairJobsScreen(mechanicHome.getPendingRepairJobsScreen());
 
      login = new LoginForm(customerHome,stockManagerHome,managerHome,mechanicHome);
      customerHome.setLogin(login);
      stockManagerHome.setLogin(login);
      managerHome.setLogin(login);
      mechanicHome.setLogin(login);
      login.setSize(600,300);
      
      customerHome.setSize(600,300);
      stockManagerHome.setSize(600,300);
      managerHome.setSize(600,300);
      mechanicHome.setSize(600,300);
      
      login.setVisible(true);
      
      }
    public static void main(String[] args){
      Garage garage = new Garage();
      garage.start();
    } 
     
}
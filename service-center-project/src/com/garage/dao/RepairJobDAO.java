/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garage.dao;

import com.garage.beans.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Instance of this class will hold list of  all repair jobs
 */
public class RepairJobDAO {
  private List<RepairJob> allRepairJobs;

    public RepairJobDAO() {
    	allRepairJobs = new ArrayList<RepairJob>(); 
    	RepairJob repairJob = new RepairJob();
    	repairJob.setCustomerName("customer");
    	repairJob.setVehicleType("Ford");
    	repairJob.setRequestType("New Exhust");
    	repairJob.setVehicleNumber("FK-1212");
    	repairJob.setStatus("Pending");
    	allRepairJobs.add(repairJob);
    	    
    }

    public List<RepairJob> getAllRepairJobs() {
        return allRepairJobs;
    }
    public List<RepairJob> getAllPendingRepairJobs() {
    	List<RepairJob> pendingJobs = new ArrayList<RepairJob>();
    	for(RepairJob repairJob :allRepairJobs){
    		if("Pending".equalsIgnoreCase(repairJob.getStatus())){
    			pendingJobs.add(repairJob);
    		}
    		
    	}
        return pendingJobs;
    }
    
    public boolean addNewPendingRepairJob(String vehicleType, String requestType, String vehicleNumber){
    	RepairJob repairJob = new RepairJob();
      	repairJob.setCustomerName("customer");
      	repairJob.setVehicleType(vehicleType);
      	repairJob.setRequestType(requestType);
      	repairJob.setVehicleNumber(vehicleNumber);
      	repairJob.setStatus("Pending");
      	this.getAllRepairJobs().add(repairJob);
      	return true;
      	
    }
    public boolean updateJobStatus(int index, String status){
    	allRepairJobs.get(index).setStatus(status);
    	return true;
    }
       
}

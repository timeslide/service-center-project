package com.garage.beans;

/**
 *
 * This class Repair job initiated from  customer request made by manager
 */
public class RepairJob extends CustomerRequest{
    private String customerName;
    private String assignedMechanic;
    private String status;
    public String getCustomerName() {
		return customerName;
	}
    public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
    public String getAssignedMechanic() {
		return assignedMechanic;
	}
    public void setAssignedMechanic(String assignedMechanic) {
		this.assignedMechanic = assignedMechanic;
	}
    public String getStatus() {
		return status;
	}
    public void setStatus(String status) {
		this.status = status;
	}
 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garage.beans;

/**
 * 
 * This class represents customer request sent by customer
 *
 */
public class CustomerRequest {
    private User user;
    private String vehicleType;
    private String vehicleNumber;
    private String requestType;

    public User getUser() {
		return user;
	}
    public void setUser(User user) {
		this.user = user;
	}
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    public String getVehicleNumber() {
		return vehicleNumber;
	}
    public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

    
    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
     
      
}

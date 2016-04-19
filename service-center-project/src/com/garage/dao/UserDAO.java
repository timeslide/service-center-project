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
 * Instance of this class will hold list of  all users.
 */
public class UserDAO {
  private List<User> allUsers;

    public UserDAO() {

    	allUsers = new ArrayList<User>();
        User user = new User();
        user.setUserName("customer");
        user.setPassword("customer");
        user.setType("customer");
        allUsers.add(user);
         
        user = new User();
        user.setUserName("stockmanager");
        user.setPassword("stockmanager");
        user.setType("stockmanager");
        allUsers.add(user); 
        
        user = new User();
        user.setUserName("mechanic");
        user.setPassword("mechanic");
        user.setType("mechanic");
        allUsers.add(user); 
        
        user = new User();
        user.setUserName("manager");
        user.setPassword("manager");
        user.setType("manager");
        allUsers.add(user); 
           
    }      
    public List<User> getAllUsers() {
		return allUsers;
	}
    public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}
}

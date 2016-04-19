/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garage.beans;


import com.garage.dao.UserDAO;

/**
 *
 * This class represents various kind of user like manager,customer etc.
 */
public class User {
    private String userName;
    private String password;
    private String type;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    } 
   public boolean validateUser(String userName , String password){
        
        boolean result =false;
        UserDAO userDAO = new UserDAO();
        for (User user:userDAO.getAllUsers()) {
             if(user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equalsIgnoreCase(password)){
                 result =true;
                 break;
             }
            
        } 
                
        return result;
         
    } 
}

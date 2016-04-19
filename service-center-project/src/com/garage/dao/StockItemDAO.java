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
 * Instance of this class will hold list of  all stock items.
 */
public class StockItemDAO {
  private List<StockItem> allStockItems;

    public StockItemDAO() {
        allStockItems = new ArrayList<>();
        StockItem si = new StockItem();
        si.setItemName("Exhust");
        si.setAvailableQty(10);
        allStockItems.add(si);
        si = new StockItem();
        si.setItemName("Engine");
        si.setAvailableQty(5);
        allStockItems.add(si);
        si = new StockItem();
        si.setItemName("Type");
        si.setAvailableQty(20);
        allStockItems.add(si);
        
         
         
    }

    public List<StockItem> getAllStockItems() {
        return allStockItems;
    }
    
    public void updateStockItem(int index, int qty){
    	allStockItems.get(index).setAvailableQty(qty);
    }
       
}

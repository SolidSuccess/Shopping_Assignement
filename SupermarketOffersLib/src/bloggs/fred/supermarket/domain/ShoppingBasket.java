/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloggs.fred.supermarket.domain;

import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class ShoppingBasket {
    HashMap<Long,Item> myBasket = new HashMap<>();
    
    
    public void addItem(Item item){
        myBasket.put(item.getId(), item);
    }
   
}

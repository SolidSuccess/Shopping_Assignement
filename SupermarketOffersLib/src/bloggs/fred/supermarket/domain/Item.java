/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloggs.fred.supermarket.domain;

/**
 *
 * @author Administrator
 */
public class Item {

    private String name;
    private long id;
    private double price;

    //
    public Item(String name, long id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    
    public long getId(){
        return id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

/**
 * Gruppe 03
 * @author lushaj
 * U05
 */
package com.mymart;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<CartItem> arrCartItem = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();
    
    /**
     * Initialization
     */
    public ShoppingCart() {
       
    }
    
    /**
     * return receipt of all products and total cost
     */
    public String toString() {
        for (CartItem i : arrCartItem) {
            sb.append(i.toString());
        }
        sb.append(String.format("\nSumme: %54.2f%n", this.getTotalCost()));
        return sb.toString();
    }
    
    /**
     * adds a product in the shopping Arraylist arrCartItem
     * @param item
     */
    public void addItem(CartItem item) {
        arrCartItem.add(item);
    }
    
    /**
     * 
     * @return sum of total cost of all products
     */
    public double getTotalCost() {
        double sum = 0;
        for (CartItem i : arrCartItem) {
            sum += i.getCost();
        }
        return sum;
    }
}

/**
 * Gruppe 03
 * @author lushaj
 * U05
 */
package com.mymart;

public class CartItem {
    private String name;
    private int quantity;
    private double pricePerUnit;
    private StringBuilder sb = new StringBuilder();
    
    /**
     * Initialization of class objects
     * @param name
     * @param quantity
     * @param pricePerUnit
     */
    public CartItem(String name, int quantity, double pricePerUnit) {
        this.setQuantity(quantity);
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }
    
    /**
     * return 1 line for the details of a product in the receipt
     */
    public String toString() {
        sb.append(String.format("  " + quantity + " x " + name + "%35.2f %11.2f%n", pricePerUnit, getCost()));
        return sb.toString();
    }
    
    /**
     * 
     * @returns cost of product * quantity
     */
    public double getCost() {
        return quantity * pricePerUnit;
    }
    
    /**
     * set amount of buys of a product 
     * @param quantity
     * @throws IllegalArgumentException if quantity <= 0
     */
    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Anzahl der K�ufe eines Produktes m�ssen > 0 sein");
        }
        this.quantity = quantity;
    }
}

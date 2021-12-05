package com.example.project5cs213;

import java.util.ArrayList;
/**
 * @author Kevan Patel
 * @author Manav Patel
 */

/**
 * class that creates and holds order information
 */

public class Order {
    /**
     * Creating variables
     */
    protected ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    protected String phoneNumber;
    protected double taxRate = 0.0625;
    public int orderNumber;


    /**
     * method to set phoneNumber
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * alternate constructor
     */
    public Order() {
    }

    public boolean isEmpty(){
        if(pizzas.size() <= 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * method to remove pizza using index
     *
     * @param index of pizza to be removed
     */
    public void remove(int index) {
        this.pizzas.remove(index);
    }

    /**
     * method to add pizza
     *
     * @param tempPizza to be added
     */
    public void add(Pizza tempPizza) {
        pizzas.add(tempPizza);
    }


    /**
     * method to get total price of order
     *
     * @return Order price double
     */
    public double getOrderTotal() {
        return getTotal() + getSalesTax();

    }

    /**
     * method to calculate sales tax
     *
     * @return sales tax
     */
    public double getSalesTax() {

        return getTotal() * taxRate;
    }

    /**
     * method to getTotal price of order
     *
     * @return price of order
     */
    public double getTotal() {
        double price = 0;
        for (Pizza pizza : pizzas
        ) {
            price += pizza.price();
        }
        return price;
    }

    /**
     * get phone number
     * @return phone Number
     */

   public String getPhoneNumber(){
        return phoneNumber;
   }

    /**
     * toString method to display
     *
     * @return the string formatted
     */
    @Override
    public String toString() {
        return "Phone Order Number: " + phoneNumber + "\n" + pizzas.toString();
    }
}


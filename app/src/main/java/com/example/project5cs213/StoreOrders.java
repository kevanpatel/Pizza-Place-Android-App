package com.example.project5cs213;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Kevan Patel
 * @author Manav Patel
 */

/**
 * class to store orders
 */

public class StoreOrders implements Serializable {
    /**
     * Creating arraylist
     */
    protected ArrayList<Order> orders = new ArrayList<Order>();

    /**
     * method to add and order to the arraylist
     * @param order to be added
     */
    public void addOrder(Order order) {
        orders.add(order);
        order.orderNumber=orders.indexOf(order);

    }

    /**
     * method to remove phonenumber
     * @param phoneNumber to be removed
     */

    public void remove(String phoneNumber){
        for(int i = 0; i < orders.size(); i++){
            if(String.valueOf(orders.get(i).getPhoneNumber()).equals(phoneNumber)){
                orders.remove(i);
                return;
            }
        }
    }

    /**
     * getter method for orders
     * @return orders
     */

    public ArrayList<Order> getOrders(){
        return orders;
    }

    /**
     * method to check if number in list
     * @param phoneNumb to check
     * @return true if in or false if not
     */

    public boolean isin(String phoneNumb){
        for(int i = 0; i < orders.size(); i++){
            if(String.valueOf(orders.get(i).getPhoneNumber()).equals(phoneNumb)){
                return true;
            }
        }
        return false;
    }

    /**
     * return index for phonenumber
     * @param phoneNumb to be found
     * @return int of phonenumber
     */
    public int returnIndex(String phoneNumb){
        for(int i = 0; i < orders.size(); i++){
            if(String.valueOf(orders.get(i).getPhoneNumber()).equals(phoneNumb)){
                return i;
            }
        }
        return -1;
    }

    /**
     * method to get size of orders
     * @return size of orders
     */
    public int size(){
        return orders.size();
    }


    /**
     * method
     * @param path of the
     * @throws IOException if unable to find the file
     */

    public void export(File path) throws IOException {
        FileWriter writer = new FileWriter(path);
        for(int i = 0; i < orders.size(); i++){
            writer.write(orders.get(i).toString() + "\n");
        }
        writer.close();
    }




}

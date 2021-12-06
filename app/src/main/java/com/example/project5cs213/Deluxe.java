package com.example.project5cs213;
/**
 * @author Kevan Patel
 * @author Manav Patel
 */

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Deluxe pizza that extends the pizza class
 */
public class Deluxe extends Pizza implements Serializable {
    /**
     * Creating variables
     */
    private static final double deluxePrice = 12.99;
    private static final String name = "Deluxe";
    private static final int toppingnumber = 5;

    /**
     * Constructor for a Deluxe Pizza
     *
     * @param sizePizza size of the pizza
     */

    public Deluxe(Size sizePizza) {
        size = sizePizza;

    }

    /**
     * Getter for size
     * @return
     */
    public Size getSize() {

        return this.size;
    }

    /**
     * toString method that displays pizza and toppings
     *
     * @return
     */
    @Override
    public String toString() {
        return this.name + toppings.toString() +size.toString() + " Price: $" + Math.round(price() * roundHundred) / roundHundred + "\n";
    }

    /**
     * method to calculate the price of a pizza
     *
     * @return if added successfully
     */
    @Override
    public double price() {
        int topNum = 0;
        if(toppings.size() > toppingnumber){
            topNum = toppings.size() - toppingnumber;
        }
        if (size == Size.medium) {
            return deluxePrice + topNum * toppingPrice + increaseMedium;
        } else if (size == Size.large) {
            return deluxePrice + topNum * toppingPrice + increaseLarge;

        } else {
            return deluxePrice + topNum * toppingPrice;

        }

    }

}
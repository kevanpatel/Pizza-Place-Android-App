package com.example.project5cs213;
/**
 * @author Kevan Patel
 * @author Manav Patel
 */

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Pepperoni pizza that extends the pizza class
 */

public class Pepperoni extends Pizza implements Serializable {
    /**
     * Creating variables
     */

    private static final double pepperoniPrice = 8.99;
    private static final String name = "Pepperoni";
    private static final int toppingnumber = 1;

    /**
     * Constructor for a Pepperoni Pizza
     *
     * @param sizePizza size of the pizza
     */
    public Pepperoni(Size sizePizza) {
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
            return pepperoniPrice + topNum * toppingPrice + increaseMedium;
        } else if (size == Size.large) {
            return pepperoniPrice + topNum * toppingPrice + increaseLarge;

        } else {
            return pepperoniPrice + topNum * toppingPrice;

        }
    }

}

package com.example.project5cs213;

import java.util.ArrayList;
/**
 * @author Kevan Patel
 * @author Manav Patel
 */

/**
 * Defines what a Pizza is
 */

public abstract class Pizza {
    /**
     * initialize variables
     */
    protected ArrayList<Topping> toppings = new ArrayList<Topping>();
    protected Size size;
    static final double toppingPrice = 1.49;
    static final int increaseMedium = 2;
    static final int increaseLarge = 4;
    static final double roundHundred=100.0;

    /**
     * setter method for pizza
     *
     * @param size to set
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * price method to be overwritten
     *
     * @return price
     */

    public abstract double price();
}


package com.example.project5cs213;
/**
 * @author Kevan Patel
 * @author Manav Patel
 */

/**
 * Hawaiian pizza that extends the pizza class
 */

public class Hawaiian extends Pizza {
    /**
     * Creating variables
     */
    private static final double hawaiianPrice = 10.99;
    private static final String name = "Hawaiian";
    private static final int toppingnumber = 2;

    /**
     * Constructor for a Hawaiian Pizza
     *
     * @param sizePizza size of the pizza
     */
    /**
     * Getter for size
     * @return
     */
    public Size getSize() {

        return this.size;
    }


    public Hawaiian(Size sizePizza) {
        size = sizePizza;
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
     * method to create toppings onto the pizza
     *
     * @param topping to be created
     * @return True/False it was succesful or not
     */



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
            return hawaiianPrice + topNum * toppingPrice + increaseMedium;
        } else if (size == Size.large) {
            return hawaiianPrice + topNum * toppingPrice + increaseLarge;

        } else {
            return hawaiianPrice + topNum * toppingPrice;

        }
    }


}

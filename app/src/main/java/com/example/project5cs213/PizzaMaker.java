package com.example.project5cs213;
/**
 * @author Kevan Patel
 * @author Manav Patel
 */

/**
 * class that creates Pizza
 */
public class PizzaMaker {
    /**
     * method to create pizza depending on string given
     *
     * @param flavor of pizza (deluxe,pepperoni,hawaiian)
     * @return the added pizza
     */
    public static Pizza createPizza(String flavor) {
        Pizza addedPizza = null;
        if (flavor.equals("Hawaiian")) {
            addedPizza = new Hawaiian(Size.small);
        } else if (flavor.equals("Pepperoni")) {
            addedPizza = new Pepperoni(Size.small);
        } else if (flavor.equals("Deluxe")) {
            addedPizza = new Deluxe(Size.small);
        }
        return addedPizza;
    }
}
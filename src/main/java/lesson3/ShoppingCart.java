package lesson3;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    // Item name is key and price is the value, e.g. { "chips" -> 2.5, "milk" -> 0.9 }
    private Map<String, Double> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    // Gets the price of the given item
    public Double getPrice(String itemName) {
        // TODO
        return null;
    }

    /*
     * Adds an item to the cart without replacing the current item.
     * If the item already exists in the cart, this method does nothing.
     * Returns true if the item didn't already exist in the cart and false
     * otherwise.
     */
    public boolean addItem(String itemName, double price) {
        // TODO
        return false;
    }

    /*
     * Calculates the total price of the cart.
     * Buying more than 3 items comes with 50% discount of the total price.
     */
    public double calculateTotal() {
        // TODO
        return -1;
    }
}

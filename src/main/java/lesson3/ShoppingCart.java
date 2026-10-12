package lesson3;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    // Item name is key and price is the value, e.g. { "chips" -> 2.5, "milk" -> 0.9 }
    private Map<String, Double> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    // Gets the price of the given item
    public Double getPrice(String itemName) {
        return items.get(itemName);
    }

    /*
     * Adds an item to the cart without replacing the current item.
     * If the item already exists in the cart, this method does nothing.
     * Returns true if the item didn't already exist in the cart and false
     * otherwise.
     */
    public boolean addItem(String itemName, double price) {
        return items.putIfAbsent(itemName, price) == null;
    }

    /*
     * Calculates the total price of the cart.
     * Buying more than 3 items comes with 50% discount of the total price.
     */
    public double calculateTotal() {
        double total = 0;
        for (Double price : items.values()) {
            total += price;
        }
        return items.size() > 3 ? total / 2 : total;
    }
}

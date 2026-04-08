package lesson3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    // Item name is key and price is the value, e.g. ("chips", 2.5)
    private Map<String, Double> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    // Gets the price of the given item
    public double getPrice(String itemName) {
        return this.items.get(itemName);
    }

    /*
     * Adds an item to the cart without replacing the current item.
     * If the item already exists in the cart, this method does nothing.
     * Returns true if the item didn't already exist in the cart and false
     * otherwise.
     */
    public boolean addItem(String itemName, double price) {
        if (this.items.containsKey(itemName)) {
            return false;
        }

        this.items.put(itemName, price);
        return true;
    }

    /*
     * Calculates the total price of the cart.
     * Buying more than 3 items comes with 50% discount of the total price.
     */
    public double calculateTotal() {
        Collection<Double> prices = this.items.values();
        
        double total = 0;

        for (Double price : prices) {
            total += price;
        }

        if (this.items.size() > 3) {
            return total * 0.5;
        }
  
        return total;
    }
}

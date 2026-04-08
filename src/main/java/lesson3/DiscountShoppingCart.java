package lesson3;

import java.util.HashMap;
import java.util.Map;

public class DiscountShoppingCart {
    // Item name is key and price is the value, e.g. ("chips", 2.5)
    private Map<String, Double> items;
    private DiscountService discountService;

    public DiscountShoppingCart(DiscountService discountService) {
        this.items = new HashMap<>();
        this.discountService = discountService;
    }

    public void addItem(String itemName, double price) {
        items.put(itemName, price);
    }

    public double calculateTotal() {
        double totalBeforeDiscount = items.values().stream().mapToDouble(Double::doubleValue).sum();
        double discount = discountService.calculateDiscount(totalBeforeDiscount);
        return totalBeforeDiscount - discount;
    }

    //You can also inject the DiscountService with setter
    public void setDiscountService(DiscountService discountService) {
        this.discountService = discountService;
    }
}

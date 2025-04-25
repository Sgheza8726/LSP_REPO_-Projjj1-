package org.howard.edu.lspfinal.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a simple shopping cart that allows adding items,
 * removing items, applying discount codes, and calculating the total cost.
 */
public class ShoppingCart {
    protected Map<String, Double> items = new HashMap<>();
    private double discountPercentage = 0.0;

    /**
     * Adds an item to the shopping cart.
     *
     * @param itemName  the name of the item
     * @param price     the price of the item (must be greater than 0)
     * @throws IllegalArgumentException if price is less than or equal to 0
     */
    public void addItem(String itemName, double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero.");
        }
        items.put(itemName, price);
    }

    /**
     * Removes an item from the cart by its name.
     *
     * @param itemName the item to remove
     */
    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    /**
     * Calculates and returns the total cost after applying any discount.
     *
     * @return total cost after discount
     */
    public double getTotalCost() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        double discountAmount = total * (discountPercentage / 100.0);
        return total - discountAmount;
    }

    /**
     * Applies a valid discount code. Throws an exception for invalid codes.
     *
     * @param code the discount code
     * @throws IllegalArgumentException if code is invalid
     */
    public void applyDiscountCode(String code) {
        switch (code) {
            case "SAVE10":
                discountPercentage = 10.0;
                break;
            case "SAVE20":
                discountPercentage = 20.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid discount code.");
        }
    }

    /**
     * Returns the current discount percentage.
     *
     * @return discount percentage
     */
    public double getDiscountPercentage() {
        return discountPercentage;
    }
}


package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    @Test
    @DisplayName("Test adding a valid item")
    public void testAddValidItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Book", 19.99);
        assertEquals(19.99, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test adding item with 0 price (expect exception)")
    public void testAddZeroPrice() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Notebook", 0.0));
    }

    @Test
    @DisplayName("Test adding item with negative price (expect exception)")
    public void testAddNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.addItem("Laptop", -100.0));
    }

    @Test
    @DisplayName("Test applying SAVE10 discount code")
    public void testApplySave10() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying SAVE20 discount code")
    public void testApplySave20() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying invalid discount code (expect exception)")
    public void testApplyInvalidCode() {
        ShoppingCart cart = new ShoppingCart();
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode("SAVE50"));
        assertThrows(IllegalArgumentException.class, () -> cart.applyDiscountCode(""));
    }

    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Pen", 2.0);
        cart.addItem("Notebook", 3.0);
        assertEquals(5.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Shoes", 100.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(90.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalCostWithEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost());
    }

    @Test
    @DisplayName("Test cart size updates correctly after adding and removing")
    public void testCartSizeUpdate() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Bag", 30.0);
        cart.addItem("Watch", 50.0);
        cart.removeItem("Watch");
        assertEquals(30.0, cart.getTotalCost());
    }
}


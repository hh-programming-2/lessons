package lesson3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void testAddItemAddsNonExistingItem() {
        assertTrue(cart.addItem("chips", 2.5));
        assertEquals(2.5, cart.getPrice("chips"));
    }

    @Test
    void testAddItemDoesNotAddExistingItem() {
        cart.addItem("chips", 2.5);
        assertFalse(cart.addItem("chips", 3.0));
        assertEquals(2.5, cart.getPrice("chips"));
    }

    @Test
    void testCalculateTotalReturnsTotalWithoutDiscountWithThreeItems() {
        cart.addItem("chips", 2.5);
        cart.addItem("milk", 0.9);
        cart.addItem("bread", 1.6);

        assertEquals(5.0, cart.calculateTotal(), 0.001);
    }

    @Test
    void testCalculateTotalReturnsZeroWhenCartHasNoItems() {
        assertEquals(0.0, cart.calculateTotal(), 0.001);
    }

    @Test
    void testCalculateTotalReturnsDiscountTotalWhenCartHasFourItems() {
        cart.addItem("chips", 2.5);
        cart.addItem("milk", 0.9);
        cart.addItem("bread", 1.6);
        cart.addItem("juice", 2.0);

        assertEquals(3.5, cart.calculateTotal(), 0.001);
    }
}

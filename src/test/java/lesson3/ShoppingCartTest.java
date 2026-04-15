package lesson3;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        // TODO: adding a NON-EXISTING item should return true
    }

    @Test
    void testAddItemDoesNotAddExistingItem() {
        // TODO: adding a EXISTING item should return false
    }

    @Test
    void testCalculateTotalReturnsTotalWithoutDiscountWithThreeItems() {
        /*
         * TODO: calculating the total of a card with three items returns the price
         * WITHOUT discount
         */
    }

    @Test
    void testCalculateTotalReturnsZeroWhenCartHasNoItems() {
        // TODO: calculating the total of a card WITHOUT items should yield zero
    }

    @Test
    void testCalculateTotalReturnsDiscountTotalWhenCartHasFourItems() {
        /*
         * TODO: calculating the total of a card with four items returns the price
         * WITH discount
         */
    }
}

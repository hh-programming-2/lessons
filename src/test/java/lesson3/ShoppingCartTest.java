package lesson3;

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
        // TODO
	}

    @Test
	void testAddItemDoesNotAddExistingItem() {
        // TODO
	}

	@Test
	void testCalculateTotalReturnsTotalWhenCartHasItems() {
        // TODO
	}

    @Test
	void testCalculateTotalReturnsZeroWhenCartHasNoItems() {
        // TODO
	}

    @Test
	void testCalculateTotalReturnsDiscountTotalWhenCartHasFourItems() {
        // TODO
	}
}

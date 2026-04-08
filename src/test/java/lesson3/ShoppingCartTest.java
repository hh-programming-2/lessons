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
        assertEquals(true, this.cart.addItem("milk", 1.5));
	}

    @Test
	void testAddItemDoesNotAddExistingItem() {
        this.cart.addItem("milk", 1.5);
        assertEquals(false, this.cart.addItem("milk", 1.5));
	}

	@Test
	void testCalculateTotalReturnsTotalWhenCartHasItems() {
        this.cart.addItem("milk", 1.5);
        this.cart.addItem("beer", 10);
        this.cart.addItem("chips", 2.5);

        assertEquals(14, this.cart.calculateTotal());
	}

    @Test
	void testCalculateTotalReturnsZeroWhenCartHasNoItems() {
        assertEquals(0, this.cart.calculateTotal());
	}

    @Test
	void testCalculateTotalReturnsDiscountTotalWhenCartHasFourItems() {
        this.cart.addItem("milk", 1.5);
        this.cart.addItem("beer", 10);
        this.cart.addItem("chips", 2.5);
        this.cart.addItem("candy", 1);

        assertEquals(7.5, this.cart.calculateTotal());
	}
}

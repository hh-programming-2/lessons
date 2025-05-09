package lesson3;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdditionBasic() {
        assertEquals(5, calculator.add(2, 3));
    }
    
    @Test
    void testAdditionWithNegative() {
        assertEquals(-1, calculator.add(-2, 1));
    }
    
    @Test
    void testAdditionWithZero() {
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    void testAdditionWithCurrency() {
        assertEquals("5 €", calculator.addWithCurrency(2,3));
    }

    @Test
    void testSubtractionBasic() {
        assertEquals(1, calculator.subtract(4, 3));
    }
    
    @Test
    void testSubtractionWhenResultNegative() {
        assertEquals(-2, calculator.subtract(1, 3));
    }

    @Test
    void testMultiplicationBasic() {
        assertEquals(6, calculator.multiply(2, 3));
    }
    
    @Test
    void testMultiplicationWithNegative() {
        assertEquals(-15, calculator.multiply(3, -5));
    }
    
    @Test
    void testMultiplicationWithZero() {
        assertEquals(0, calculator.multiply(0, 10));
    }

    @Test
    void testDivisionBasic() {
    	assertEquals(3, calculator.divide(6, 2), 0.001);
    }
    
    @Test
    void testDivisionWithNegative() {
        assertEquals(-2.0, calculator.divide(10, -5), 0.001);
    }
    
    @Test
    void testDivisionWhenResultIsNotInteger() {
    	assertEquals(2.5, calculator.divide(5, 2), 0.001);
    }

    @Test
    void testDivisionByZero() {
        //NOTE: () -> calculator.divide(6, 0) -syntax is a lambda expression representing a Runnable
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0));
    }
    
    //Examples on different asserting methods
    @Test
    void testAdditionToShowAllAssertions() {
    	
        // assertEquals
        assertEquals(5, calculator.add(2, 3));

        // assertNotEquals
        assertNotEquals(11, calculator.add(5, 5));

        // assertTrue / assertFalse
        assertTrue(calculator.add(1, 1) == 2);
        assertFalse(calculator.add(0, 0) == 1);

        // assertNull / assertNotNull
        assertNotNull(calculator);

        // assertSame / assertNotSame
        String resultString = "5";
        assertSame(calculator, calculator); //assert that they are the same object, a bit artificial example here with calculator compared to itself
        assertNotSame(calculator, resultString);

        // assertArrayEquals
        int[] expectedArray = {1, 2, 3};
        // Construct resultArray by calling the calculator for the values in the array
        int[] resultArray = {calculator.add(0, 1), calculator.add(1, 1), calculator.add(1, 2)};

        assertArrayEquals(expectedArray, resultArray);
    }
}


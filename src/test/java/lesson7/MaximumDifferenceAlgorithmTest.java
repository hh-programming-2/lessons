package lesson7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MaximumDifferenceAlgorithmTest {
    @Test
    void bothAlgorithmsFindDifferenceWithoutChangingInput() {
        List<Integer> numbers = new ArrayList<>(List.of(4, 24, 1, 9, 5));

        assertEquals(23, MaximumDifferenceAlgorithm.getMaximumDifferenceA(numbers));
        assertEquals(23, MaximumDifferenceAlgorithm.getMaximumDifferenceB(numbers));
        assertEquals(List.of(4, 24, 1, 9, 5), numbers);
    }

    @Test
    void handlesEmptyAndSingleElementLists() {
        assertEquals(-1, MaximumDifferenceAlgorithm.getMaximumDifferenceA(List.of()));
        assertEquals(-1, MaximumDifferenceAlgorithm.getMaximumDifferenceB(List.of()));
        assertEquals(0, MaximumDifferenceAlgorithm.getMaximumDifferenceA(List.of(7)));
        assertEquals(0, MaximumDifferenceAlgorithm.getMaximumDifferenceB(List.of(7)));
    }
}
